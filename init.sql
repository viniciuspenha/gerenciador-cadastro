CREATE TABLE automovel (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  modelo_id INT NOT NULL,
  valor decimal(10, 2) NOT NULL,
  data_cadastro datetime NOT NULL,
  data_atualizacao datetime NOT NULL
);

CREATE TABLE marca (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL
);

CREATE TABLE modelo (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  marca_id INT NOT NULL
);

ALTER TABLE automovel
    ADD FOREIGN KEY (modelo_id) REFERENCES modelo (id);

ALTER TABLE modelo
    ADD FOREIGN KEY (marca_id) REFERENCES marca (id);

INSERT INTO marca (nome) values
    ('Audi'),
    ('BMW'),
    ('Chevrolet'),
    ('Volkswagem');

INSERT INTO modelo (marca_id, nome) values
    (1, 'A1'),
    (1, 'A4'),
    (2, 'X1'),
    (2, 'M3'),
    (3, 'Camaro'),
    (3, 'Captiva'),
    (4, 'Gol'),
    (4, 'Golf');