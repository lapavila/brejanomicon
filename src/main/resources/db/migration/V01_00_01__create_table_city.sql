CREATE TABLE city (
	id INT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
	capital BOOLEAN,
	state_id INT(20),
	FOREIGN KEY (state_id) REFERENCES state(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO city (state_id, name, capital) SELECT id, 'Rio Branco', true FROM state WHERE abbreviation = 'AC';
INSERT INTO city (state_id, name, capital) SELECT id, 'Maceió', true FROM state WHERE abbreviation = 'AL';
INSERT INTO city (state_id, name, capital) SELECT id, 'Macapá', true FROM state WHERE abbreviation = 'AP';
INSERT INTO city (state_id, name, capital) SELECT id, 'Manaus', true FROM state WHERE abbreviation = 'AM';
INSERT INTO city (state_id, name, capital) SELECT id, 'Salvador', true FROM state WHERE abbreviation = 'BA';
INSERT INTO city (state_id, name, capital) SELECT id, 'Fortaleza', true FROM state WHERE abbreviation = 'CE';
INSERT INTO city (state_id, name, capital) SELECT id, 'Brasília', true FROM state WHERE abbreviation = 'DF';
INSERT INTO city (state_id, name, capital) SELECT id, 'Vitória', true FROM state WHERE abbreviation = 'ES';
INSERT INTO city (state_id, name, capital) SELECT id, 'Goiânia', true FROM state WHERE abbreviation = 'GO';
INSERT INTO city (state_id, name, capital) SELECT id, 'São Luís', true FROM state WHERE abbreviation = 'MA';
INSERT INTO city (state_id, name, capital) SELECT id, 'Cuiabá', true FROM state WHERE abbreviation = 'MT';
INSERT INTO city (state_id, name, capital) SELECT id, 'Campo Grande', true FROM state WHERE abbreviation = 'MS';
INSERT INTO city (state_id, name, capital) SELECT id, 'Belo Horizonte', true FROM state WHERE abbreviation = 'MG';
INSERT INTO city (state_id, name, capital) SELECT id, 'Belém', true FROM state WHERE abbreviation = 'PA';
INSERT INTO city (state_id, name, capital) SELECT id, 'João Pessoa', true FROM state WHERE abbreviation = 'PB';
INSERT INTO city (state_id, name, capital) SELECT id, 'Curitiba', true FROM state WHERE abbreviation = 'PR';
INSERT INTO city (state_id, name, capital) SELECT id, 'Recife', true FROM state WHERE abbreviation = 'PE';
INSERT INTO city (state_id, name, capital) SELECT id, 'Teresina', true FROM state WHERE abbreviation = 'PI';
INSERT INTO city (state_id, name, capital) SELECT id, 'Rio de Janeiro', true FROM state WHERE abbreviation = 'RJ';
INSERT INTO city (state_id, name, capital) SELECT id, 'Natal', true FROM state WHERE abbreviation = 'RN';
INSERT INTO city (state_id, name, capital) SELECT id, 'Porto Alegre', true FROM state WHERE abbreviation = 'RS';
INSERT INTO city (state_id, name, capital) SELECT id, 'Porto Velho', true FROM state WHERE abbreviation = 'RO';
INSERT INTO city (state_id, name, capital) SELECT id, 'Boa Vista', true FROM state WHERE abbreviation = 'RR';
INSERT INTO city (state_id, name, capital) SELECT id, 'Florianópolis', true FROM state WHERE abbreviation = 'SC';
INSERT INTO city (state_id, name, capital) SELECT id, 'São Paulo', true FROM state WHERE abbreviation = 'SP';
INSERT INTO city (state_id, name, capital) SELECT id, 'Aracaju', true FROM state WHERE abbreviation = 'SE';
INSERT INTO city (state_id, name, capital) SELECT id, 'Palmas', true FROM state WHERE abbreviation = 'TO';
