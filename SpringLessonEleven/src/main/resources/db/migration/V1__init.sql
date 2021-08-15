CREATE TABLE users (
    id_users INTEGER PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(48) UNIQUE NOT NULL ,
    user_password VARCHAR(150) NOT NULL);

CREATE TABLE roles (
    id_roles INTEGER PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(48) UNIQUE NOT NULL);

CREATE TABLE score (
    id_score INTEGER PRIMARY KEY AUTO_INCREMENT,
    user_id INTEGER UNIQUE NOT NULL,
    score_count INTEGER,
    FOREIGN KEY (user_id)REFERENCES users (id_users));

CREATE TABLE users_roles (
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users (id_users),
    FOREIGN KEY (role_id) REFERENCES roles (id_roles));

INSERT INTO users (user_name, user_password) VALUES
    ('user1', '$2y$10$8lrLtZHnR2eB6eLgIhWnwuHByx1CfAgvu5i4xZyuQZbt.WzyRXz3C'),
    ('user2', '$2y$10$8lrLtZHnR2eB6eLgIhWnwuHByx1CfAgvu5i4xZyuQZbt.WzyRXz3C'),
    ('user3', '$2y$10$8lrLtZHnR2eB6eLgIhWnwuHByx1CfAgvu5i4xZyuQZbt.WzyRXz3C'),
    ('admin', '$2y$10$8lrLtZHnR2eB6eLgIhWnwuHByx1CfAgvu5i4xZyuQZbt.WzyRXz3C');

INSERT INTO roles (role_name) VALUES
('ROLE_USER'),
('ROLE_ADMIN');

INSERT INTO score (user_id, score_count) VALUES
(1, 0),
(2, 5),
(3, 25),
(4, 10);

INSERT INTO users_roles (user_id, role_id) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(4, 2);






