-- V1__create_user_table.sql

CREATE TABLE user (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255),
    user_password VARCHAR(255),
    address VARCHAR(255),
    city VARCHAR(100)
);
