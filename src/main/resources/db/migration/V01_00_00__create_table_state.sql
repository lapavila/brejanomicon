CREATE TABLE state (
	id INT(20) PRIMARY KEY AUTO_INCREMENT,
	abbreviation CHAR(2) NOT NULL,
	name VARCHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO state (abbreviation, name) VALUES('AC', 'Acre');
INSERT INTO state (abbreviation, name) VALUES('AL', 'Alagoas');
INSERT INTO state (abbreviation, name) VALUES('AP', 'Amapá');
INSERT INTO state (abbreviation, name) VALUES('AM', 'Amazonas');
INSERT INTO state (abbreviation, name) VALUES('BA', 'Bahia');
INSERT INTO state (abbreviation, name) VALUES('CE', 'Ceará');
INSERT INTO state (abbreviation, name) VALUES('DF', 'Distrito Federal');
INSERT INTO state (abbreviation, name) VALUES('ES', 'Espírito Santo');
INSERT INTO state (abbreviation, name) VALUES('GO', 'Goiás');
INSERT INTO state (abbreviation, name) VALUES('MA', 'Maranhão');
INSERT INTO state (abbreviation, name) VALUES('MT', 'Mato Grosso');
INSERT INTO state (abbreviation, name) VALUES('MS', 'Mato Grosso do Sul');
INSERT INTO state (abbreviation, name) VALUES('MG', 'Minas Gerais');
INSERT INTO state (abbreviation, name) VALUES('PA', 'Pará');
INSERT INTO state (abbreviation, name) VALUES('PB', 'Paraíba');
INSERT INTO state (abbreviation, name) VALUES('PR', 'Paraná');
INSERT INTO state (abbreviation, name) VALUES('PE', 'Pernambuco');
INSERT INTO state (abbreviation, name) VALUES('PI', 'Piauí');
INSERT INTO state (abbreviation, name) VALUES('RJ', 'Rio de Janeiro');
INSERT INTO state (abbreviation, name) VALUES('RN', 'Rio Grande do Norte');
INSERT INTO state (abbreviation, name) VALUES('RS', 'Rio Grande do Sul');
INSERT INTO state (abbreviation, name) VALUES('RO', 'Rondônia');
INSERT INTO state (abbreviation, name) VALUES('RR', 'Roraima');
INSERT INTO state (abbreviation, name) VALUES('SC', 'Santa Catarina');
INSERT INTO state (abbreviation, name) VALUES('SP', 'São Paulo');
INSERT INTO state (abbreviation, name) VALUES('SE', 'Sergipe');
INSERT INTO state (abbreviation, name) VALUES('TO', 'Tocantins');