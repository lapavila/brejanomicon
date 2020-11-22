CREATE TABLE state (
	id INT(20) PRIMARY KEY AUTO_INCREMENT,
	abbreviation CHAR(2) NOT NULL,
	name VARCHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO STATE (abbreviation, name) VALUES('AC', 'Acre');
INSERT INTO STATE (abbreviation, name) VALUES('AL', 'Alagoas');
INSERT INTO STATE (abbreviation, name) VALUES('AP', 'Amapá');
INSERT INTO STATE (abbreviation, name) VALUES('AM', 'Amazonas');
INSERT INTO STATE (abbreviation, name) VALUES('BA', 'Bahia');
INSERT INTO STATE (abbreviation, name) VALUES('CE', 'Ceará');
INSERT INTO STATE (abbreviation, name) VALUES('DF', 'Distrito Federal');
INSERT INTO STATE (abbreviation, name) VALUES('ES', 'Espírito Santo');
INSERT INTO STATE (abbreviation, name) VALUES('GO', 'Goiás');
INSERT INTO STATE (abbreviation, name) VALUES('MA', 'Maranhão');
INSERT INTO STATE (abbreviation, name) VALUES('MT', 'Mato Grosso');
INSERT INTO STATE (abbreviation, name) VALUES('MS', 'Mato Grosso do Sul');
INSERT INTO STATE (abbreviation, name) VALUES('MG', 'Minas Gerais');
INSERT INTO STATE (abbreviation, name) VALUES('PA', 'Pará');
INSERT INTO STATE (abbreviation, name) VALUES('PB', 'Paraíba');
INSERT INTO STATE (abbreviation, name) VALUES('PR', 'Paraná');
INSERT INTO STATE (abbreviation, name) VALUES('PE', 'Pernambuco');
INSERT INTO STATE (abbreviation, name) VALUES('PI', 'Piauí');
INSERT INTO STATE (abbreviation, name) VALUES('RJ', 'Rio de Janeiro');
INSERT INTO STATE (abbreviation, name) VALUES('RN', 'Rio Grande do Norte');
INSERT INTO STATE (abbreviation, name) VALUES('RS', 'Rio Grande do Sul');
INSERT INTO STATE (abbreviation, name) VALUES('RO', 'Rondônia');
INSERT INTO STATE (abbreviation, name) VALUES('RR', 'Roraima');
INSERT INTO STATE (abbreviation, name) VALUES('SC', 'Santa Catarina');
INSERT INTO STATE (abbreviation, name) VALUES('SP', 'São Paulo');
INSERT INTO STATE (abbreviation, name) VALUES('SE', 'Sergipe');
INSERT INTO STATE (abbreviation, name) VALUES('TO', 'Tocantins');