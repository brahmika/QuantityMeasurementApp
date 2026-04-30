CREATE TABLE IF NOT EXISTS quantity_measurement (
    id INT AUTO_INCREMENT PRIMARY KEY,
    operation VARCHAR(50),
    value1 DOUBLE,
    unit1 VARCHAR(50),
    value2 DOUBLE,
    unit2 VARCHAR(50),
    result DOUBLE,
    result_unit VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );