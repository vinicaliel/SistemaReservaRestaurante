CREATE TABLE clients (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    numberOfEntities INT NOT NULL,
    observations VARCHAR(255),
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    phone CHAR(11) NOT NULL,
    CONSTRAINT uk_phone UNIQUE (phone)
);