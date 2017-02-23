package NetClientGet;

import Products.ProductSpecification;
import Transaction.Transaction;
import Transaction.TransactionItem;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class NetClientGet {
    
    public static int lastTransactionId = 0;

    public static List<ProductSpecification> getProducts()
            throws ParserConfigurationException, SAXException {
        List<ProductSpecification> products = new ArrayList<>();

        try {

            /*
             GET
             */
            URL urlProducts = new URL("http://localhost:8080/POST2_Server/webresources/com.post2entity.products");
            HttpURLConnection getConnProducts = (HttpURLConnection) urlProducts.openConnection();
            getConnProducts.setRequestMethod("GET");
            getConnProducts.setRequestProperty("Accept", "application/xml");

            if (getConnProducts.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + getConnProducts.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (getConnProducts.getInputStream())));

            String output, msg = "";
            while ((output = br.readLine()) != null) {
                msg += output;
            }

            /*
             Following are 2 alternatives for accessing values in XML tree nodes
             */
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(msg.getBytes()));

            String upc, description;
            double unitPrice;

            /*
             getElementsByTagName is guaranteed to retrieve nodes in the XML tree order
             so the following 3 NodeLists are in sync
             */
            NodeList upcs = doc.getElementsByTagName("upc");
            NodeList descriptions = doc.getElementsByTagName("description");
            NodeList unitPrices = doc.getElementsByTagName("unitPrice");
            for (int i = 0; i < upcs.getLength(); i++) {
                upc = upcs.item(i).getTextContent();
                description = descriptions.item(i).getTextContent();
                unitPrice = Double.parseDouble(unitPrices.item(i).getTextContent());
                products.add(new ProductSpecification(description, unitPrice, upc));
            }

            getConnProducts.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }

    public static void postTransaction(Transaction t)
            throws ParserConfigurationException, SAXException {
        
        try {
            /*
             POST
             */
            URL urlSale = new URL("http://localhost:8080/POST2_Server/webresources/com.post2entity.transactions");

            HttpURLConnection postConnSale = (HttpURLConnection) urlSale.openConnection();

            postConnSale.setDoOutput(true);
            postConnSale.setRequestMethod("POST");
            postConnSale.setRequestProperty("Content-Type", "application/xml");

            String customerName = t.getTransactionHeader().getCustomerName();
            Date datetime = t.getTransactionHeader().getTransactionDate();
            String paymentType = t.getPayment().getClass().getName().replace("Transaction.", "").replace("Payment", "");
            double total = t.getPayment().getPaymentTotal();
            int transactionId = ++lastTransactionId;
            
            String newSaleString
                    = "     <transactions> \n"
                    + "          <customerName>" + customerName + "</customerName> \n"
                    + "          <datetime>" + datetime + "</datetime> \n"
                    + "          <paymentType>" + paymentType + "</paymentType> \n"
                    + "          <total>" + total + "</total> \n"
                    + "           <transactionId>" + transactionId + "</transactionId> \n"
                    + "     </transactions> ";
            
            OutputStream postOutputStream = postConnSale.getOutputStream();
            postOutputStream.write(newSaleString.getBytes());
            postOutputStream.flush();

            if (postConnSale.getResponseCode() >= 400) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + postConnSale.getResponseCode());
            }

            postConnSale.disconnect();

            URL urlSaleItem = new URL("http://localhost:8080/POST2_Server/webresources/com.post2entity.transactionitems");

            HttpURLConnection postConnSaleItem = (HttpURLConnection) urlSaleItem.openConnection();
            postConnSaleItem.setDoOutput(true);
            postConnSaleItem.setRequestMethod("POST");
            postConnSaleItem.setRequestProperty("Content-Type", "application/xml");

            TransactionItem[] transItems = t.getTransactionItems();

            OutputStream postOutputStream2 = postConnSaleItem.getOutputStream();
            
            int offset = 0;
            for (int i = 0; i < t.getNumTransItems(); i++) {
                
                TransactionItem transItem = transItems[i];

                String upc = transItem.getProductUPC();
                int quantity = transItem.getProdQuantity();
                String description = "";
                double unitPrice = 0.0;

                List<ProductSpecification> prods = getProducts();
                for (ProductSpecification prod : prods) {
                    if (prod.getProductUPC().equals(upc)) {
                        description = prod.getProductDesc();
                        unitPrice = prod.getProductPrice();
                    }
                }

                String newSaleItemString
                        = "<transactionitems>  \n"
                        + "          <products>  \n"
                        + "              <description>" + description + "</description>  \n"
                        + "              <unitPrice>" + unitPrice + "</unitPrice>  \n"
                        + "              <upc>" + upc + "</upc>  \n"
                        + "          </products>  \n"
                        + "          <quantity>" + quantity + "</quantity>  \n"
                        + "          <transactionitemsPK>  \n"
                        + "              <transactionId>" + transactionId + "</transactionId>  \n"
                        + "              <upc>" + upc + "</upc>  \n"
                        + "          </transactionitemsPK>  \n"
                        + "          <transactions>  \n"
                        + "              <customerName>" + customerName + "</customerName> \n"
                        + "              <datetime>" + datetime + "</datetime> \n"
                        + "              <paymentType>" + paymentType + "</paymentType> \n"
                        + "              <total>" + total + "</total> \n"
                        + "              <transactionId>" + transactionId + "</transactionId> \n"
                        + "          </transactions>  \n"
                        + "      </transactionitems>";

                
                int numBytes = newSaleItemString.getBytes().length; 
                postOutputStream2.write(newSaleItemString.getBytes(), offset, numBytes);

                if (postConnSaleItem.getResponseCode() >= 400) {
                    throw new RuntimeException("Failed : HTTP error code : "
                            + postConnSaleItem.getResponseCode());
                }
                
                offset += numBytes;
            }

            
            postOutputStream2.flush();
            
            postConnSaleItem.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
