CREATE TABLE adresses (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  street VARCHAR(255),
  number VARCHAR(255),
  complement VARCHAR(255),
  neighborhood VARCHAR(255),
  city VARCHAR(255),
  uf VARCHAR(255)
);

CREATE TABLE doctors (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255),
  email VARCHAR(255),
  crm VARCHAR(255),
  specialty VARCHAR(255),
  address_id BIGINT,
  FOREIGN KEY (address_id) REFERENCES adresses(id)
);