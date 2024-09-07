--liquibase formatted sql

--changeset brunoestrai:4

CREATE TABLE IF NOT EXISTS recarga (
    idrecarga SERIAL PRIMARY KEY,
    contaid INTEGER NOT NULL REFERENCES conta,
    clienteid INTEGER NOT NULL REFERENCES cliente,
    valor DECIMAL(15, 2) NOT NULL DEFAULT 0,
    dhregistro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);