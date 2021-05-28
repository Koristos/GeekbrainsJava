CREATE TABLE products
(
    id_products   INT PRIMARY KEY AUTO_INCREMENT,
    product_name  VARCHAR(45) NOT NULL,
    product_price INT         NOT NULL,
    category_id   INT         NOT NULL
);

CREATE TABLE categories
(
    id_categories INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(45) NOT NULL
);

ALTER TABLE products
    ADD FOREIGN KEY (category_id)
        REFERENCES categories (id_categories);

INSERT INTO categories (category_name)
VALUES ('fruits'),
       ('vegetables'),
       ('beverage');

INSERT INTO products (product_name, product_price, category_id)
VALUES ('tomato', 45, 2),
       ('potato', 25, 2),
       ('cabbage', 18, 2),
       ('orange', 86, 1),
       ('plum', 55, 1),
       ('peach', 78, 1),
       ('grape', 52, 1),
       ('coffee', 34, 3),
       ('tea', 11, 3),
       ('water', 5, 3),
       ('beer', 30, 3),
       ('pumpkin', 32, 2);