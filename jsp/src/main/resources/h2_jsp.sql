CREATE TABLE Gun (
  id         INT PRIMARY KEY AUTO_INCREMENT,
  name       VARCHAR(255) NOT NULL,
  caliber    DOUBLE NOT NULL,
  price      DOUBLE NOT NULL

);


INSERT INTO Gun(name, caliber, price) VALUES ('AKM', 7.62, 30000);
INSERT INTO Gun(name, caliber, price) VALUES ('M1911', 11.43, 15000);
INSERT INTO Gun(name, caliber, price) VALUES ('МП5', 9, 20000);
INSERT INTO Gun(name, caliber, price) VALUES ('ГЗ', 7.62, 40000);
INSERT INTO Gun(name, caliber, price) VALUES ('М16', 5.56, 45000);
INSERT INTO Gun(name, caliber, price) VALUES ('РПГ', 40, 65000);
INSERT INTO Gun(name, caliber, price) VALUES ('UZI', 9, 20000);
INSERT INTO Gun(name, caliber, price) VALUES ('АК-47', 7.62, 10000);
