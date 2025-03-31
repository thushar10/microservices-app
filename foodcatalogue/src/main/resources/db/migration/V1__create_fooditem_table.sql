-- V1__create_fooditem_table.sql

CREATE TABLE food_item (
    id INT AUTO_INCREMENT PRIMARY KEY,
    item_name VARCHAR(255),
    item_description VARCHAR(255),
    is_veg BOOLEAN,
    price DECIMAL(10, 2),
    restaurant_id INT,
    quantity INT NOT NULL DEFAULT 0
);

