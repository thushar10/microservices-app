-- V1__create_restaurant_table.sql

CREATE TABLE restaurant (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255),
    city VARCHAR(100),
    restaurant_description VARCHAR(500)
);
