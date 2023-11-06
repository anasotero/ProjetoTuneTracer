CREATE DATABASE tunetracer;
USE tunetracer;
DROP TABLE IF EXISTS cadastro;
DROP TABLE IF EXISTS favoritos;

CREATE TABLE cadastro (
nome VARCHAR(150) NOT NULL,
email VARCHAR(100) NOT NULL,
senha VARCHAR(50) NOT NULL,
palavra_chave VARCHAR(50) NOT NULL,
PRIMARY KEY (email, palavra_chave)
);

CREATE TABLE favoritos (
nota VARCHAR(2) NOT NULL,
instrumento VARCHAR(7) NOT NULL,
estado_botao BOOLEAN
);

CREATE TABLE manterSessão (
id INT AUTO_INCREMENT NOT NULL,
nomesessao VARCHAR(50),
nomeusuario varchar(100),
verificador INT,
PRIMARY KEY (id)
);

UPDATE manterSessão
SET verificador = 0
WHERE id = 1;

INSERT INTO manterSessão (nomesessao, nomeusuario, verificador)
VALUES (null, null, 0);

SELECT * FROM manterSessão;

DROP TABLE manterSessão;
TRUNCATE cadastro;
TRUNCATE favoritos;
SELECT * FROM cadastro;
SELECT * FROM favoritos;