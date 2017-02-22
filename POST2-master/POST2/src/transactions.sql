CREATE TABLE transactions(
  transaction_id INTEGER NOT NULL,
  datetime VARCHAR(30) NOT NULL,
  customer_name VARCHAR(50),
  payment_type VARCHAR(5),
  total DECIMAL(5, 2),
  PRIMARY KEY (transaction_id)
);

CREATE TABLE transactionItems(
  transaction_id INTEGER NOT NULL,
  upc INTEGER NOT NULL,
  quantity INTEGER DEFAULT 1, 
  PRIMARY KEY (transaction_id, upc),
  FOREIGN KEY (transaction_id) REFERENCES transactions (transaction_id),
  FOREIGN KEY (upc) REFERENCES products (upc)
);