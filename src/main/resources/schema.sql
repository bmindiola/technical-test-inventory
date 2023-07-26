CREATE TABLE Equipment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    serial_number VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    purchase_date DATE NOT NULL,
    purchase_value DECIMAL(10, 2) NOT NULL
);
