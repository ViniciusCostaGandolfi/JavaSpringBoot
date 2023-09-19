CREATE TABLE patient (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(255),
  email VARCHAR(255),
  address_id BIGINT,
  FOREIGN KEY (address_id) REFERENCES adresses(id)
);