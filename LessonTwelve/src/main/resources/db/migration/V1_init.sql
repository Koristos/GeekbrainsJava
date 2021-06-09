CREATE TABLE roles (
    id_roles INTEGER PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(48) NOT NULL);

CREATE TABLE user_profiles (
    id_user_profiles INTEGER PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(48) NOT NULL UNIQUE,
    user_password VARCHAR(150) NOT NULL,
    user_phone INTEGER NOT NULL);

CREATE TABLE user_profiles_roles (
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES user_profiles (id_user_profiles),
    FOREIGN KEY (role_id) REFERENCES roles (id_roles));

CREATE TABLE products (
    id_products INTEGER PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(48) NOT NULL,
    product_price INTEGER NOT NULL,
    creation_date DATETIME NOT NULL,
    update_date DATETIME NOT NULL);

CREATE TABLE orders (
    id_orders INTEGER PRIMARY KEY AUTO_INCREMENT,
    user_id INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user_profiles (id_user_profiles));

CREATE TABLE order_items (
    id_order_items INTEGER PRIMARY KEY AUTO_INCREMENT,
    order_id INTEGER NOT NULL,
    product_id INTEGER NOT NULL,
    purchase_price INTEGER NOT NULL,
    item_number INTEGER NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders (id_orders),
    FOREIGN KEY (product_id) REFERENCES products (id_products));


INSERT INTO roles (role_name) VALUES ('ROLE_USER'), ('ROLE_ADMIN');

INSERT INTO user_profiles (user_name, user_password, user_phone) VALUES
    ('petrov', '$2y$10$8lrLtZHnR2eB6eLgIhWnwuHByx1CfAgvu5i4xZyuQZbt.WzyRXz3C', 2222222),
    ('ivanova', '$2y$10$8lrLtZHnR2eB6eLgIhWnwuHByx1CfAgvu5i4xZyuQZbt.WzyRXz3C', 5555555),
    ('admin', '$2y$10$8lrLtZHnR2eB6eLgIhWnwuHByx1CfAgvu5i4xZyuQZbt.WzyRXz3C', 7777777);

INSERT INTO user_profiles_roles (user_id, role_id) VALUES
    (1,1),
    (2,1),
    (3,1),
    (3,2);

INSERT INTO products (product_name, product_price, creation_date, update_date) VALUES
    ('apple', 50, curdate(), curdate()),
    ('banana', 80, curdate(), curdate()),
    ('peach', 120, curdate(), curdate()),
    ('pineapple', 140, curdate(), curdate()),
    ('mango', 150, curdate(), curdate()),
    ('cherry', 90, curdate(), curdate()),
    ('plum', 60, curdate(), curdate()),
    ('potato', 30, curdate(), curdate()),
    ('tomato', 80, curdate(), curdate()),
    ('carrot', 45, curdate(), curdate()),
    ('grape', 97, curdate(), curdate()),
    ('strawberry', 132, curdate(), curdate()),
    ('cabbage', 20, curdate(), curdate()),
    ('mushrooms', 71, curdate(), curdate()),
    ('pear', 79, curdate(), curdate()),
    ('coconut', 96, curdate(), curdate()),
    ('turnip', 31, curdate(), curdate()),
    ('dill', 190, curdate(), curdate());





