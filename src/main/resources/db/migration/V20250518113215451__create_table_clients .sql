CREATE TABLE clients (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    phone CHAR(11) NOT NULL,
    status VARCHAR(50) NOT NULL,
    observation VARCHAR(255),
    numberOfEntities INTEGER NOT NULL,
    timeOfReservation VARCHAR(150) NOT NULL,
    dayOfReservation DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    
);