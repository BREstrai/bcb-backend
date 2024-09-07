--liquibase formatted sql

--changeset brunoestrai:3

CREATE TABLE IF NOT EXISTS conta (
    idconta SERIAL PRIMARY KEY,
    clienteid INTEGER NOT NULL REFERENCES cliente,
    tipoplano INTEGER NOT NULL,
    limite DECIMAL(15, 2) NOT NULL DEFAULT 0,
    saldo DECIMAL(15, 2) NOT NULL DEFAULT 0
);