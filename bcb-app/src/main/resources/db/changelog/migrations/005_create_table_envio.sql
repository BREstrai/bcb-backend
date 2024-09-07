--liquibase formatted sql

--changeset brunoestrai:5

CREATE TABLE IF NOT EXISTS envio (
    idenvio SERIAL PRIMARY KEY,
    clienteid INTEGER NOT NULL REFERENCES cliente,
    destino VARCHAR(20) NOT NULL,
    mensagem TEXT NOT NULL,
    dhenvio TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);