CREATE TABLE products(
  upc INTEGER NOT NULL,
  description VARCHAR(25),
  unit_price DECIMAL(5,2) NOT NULL,
  PRIMARY KEY (upc)
);
  
INSERT INTO products VALUES
(1234, 'Tomato', 2.50);

INSERT INTO products VALUES
(13, 'Baked beans', 1.78);

INSERT INTO products VALUES
(203, 'Paper towels eight-pack', 7.99);