--liquibase formatted sql

--changeset brunoestrai:1

CREATE TABLE IF NOT EXISTS cliente (
    idcliente SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    nomeempresa VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    cnpj VARCHAR(14) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    dhcriacao TIMESTAMP default CURRENT_TIMESTAMP
);