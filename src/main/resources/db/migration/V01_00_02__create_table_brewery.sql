CREATE TABLE brewery (
    id INT(20) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    story TEXT,
    email VARCHAR(100),
    phone VARCHAR(20),
    website VARCHAR(100),
    address VARCHAR(200),
    postal_code VARCHAR(10),
	city_id INT(20) NOT NULL,
	FOREIGN KEY (city_id) REFERENCES city(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
