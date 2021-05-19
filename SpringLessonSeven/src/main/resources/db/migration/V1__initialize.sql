CREATE TABLE products (id_products INT PRIMARY KEY AUTO_INCREMENT,
        product_name VARCHAR (45) NOT NULL,
        product_price INT NOT NULL);

INSERT INTO products (product_name, product_price) VALUES
    ('tomato', 45),
    ('potato', 25),
    ('cabbage', 18),
    ('pumpkin', 32);