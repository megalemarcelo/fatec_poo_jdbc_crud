CREATE DATABASE 20221_fatec_ipi_poo_pessoas;

USE 20221_fatec_ipi_poo_pessoas;

CREATE TABLE tb_pessoa(
	cod_pessoa INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(200) NOT NULL,
    fone VARCHAR(200) NULL,
    email VARCHAR(200) NULL    
);



-- CRUD

-- C 
INSERT INTO tb_pessoa (nome, fone, email) 
VALUES('José', '12345678', 'jose@email.com');

INSERT INTO tb_pessoa (nome, fone, email)
VALUES ('João', '98765432', 'joao@email.com'), 
('Ana', '77447744', 'ana@email.com');

-- R
SELECT * FROM tb_pessoa;
-- projeção
SELECT nome, email FROM tb_pessoa;

-- U
UPDATE 
	tb_pessoa 
SET 
nome = 'José da Silva' WHERE cod_pessoa = 1;

-- D
DELETE FROM tb_pessoa WHERE cod_pessoa = 2;



