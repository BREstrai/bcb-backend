--liquibase formatted sql

--changeset brunoestrai:1

CREATE TABLE IF NOT EXISTS usuario (
    idusuario SERIAL PRIMARY KEY,
    usuario VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    clienteid INTEGER REFERENCES cliente
);

--changeset brunoestrai:2
INSERT INTO cliente(
    idcliente,
    nome,
    nomeempresa,
    email,
    cpf,
    cnpj,
    telefone
) values (
    1,
    'Adm',
    'BCB',
    'bcb@bcb.com',
    '00000000000',
    '00000000000000',
    '46988275899'
);

ALTER SEQUENCE cliente_idcliente_seq RESTART WITH 2;

INSERT INTO usuario (
    usuario,
    senha,
    clienteid
) values (
    'admin',
    'admin',
    1
);

ALTER SEQUENCE usuario_idusuario_seq RESTART WITH 2;
