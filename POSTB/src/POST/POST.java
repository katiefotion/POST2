package POST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import Products.ProductReader;

public class POST {

    // Main method 
    public static void main(String[] args) {
        
        // Define filepaths to product and transaction files 
        String productPath = "TextFiles/products.txt";
        String transactionPath = "TextFiles/transaction.txt";
        
        // Construct ProductReader and TransactionReader
        try {
            String productFile = readFile(productPath);
            ProductReader pr = new ProductReader(productFile);
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }
    
    
    
    private static String readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }
}

