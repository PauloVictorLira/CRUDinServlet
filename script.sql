CREATE DATABASE mydb;
USE mydb;
CREATE TABLE produtos (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(45),
  unidadeCompra INT(11),
  descricao VARCHAR(45),
  qtdPrevistoMes DECIMAL(9,2),
  precoMaxComprado DECIMAL(9,2)
)