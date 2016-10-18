CREATE TABLE Customer (
  id         INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(60) NOT NULL,
  last_name  VARCHAR(40) NOT NULL,
  birth_date DATE,

  UNIQUE (first_name, last_name)
);

INSERT INTO Customer (first_name, last_name, birth_date) VALUES ('Chris', 'Schaefer', '1981-05-03');
INSERT INTO Customer (first_name, last_name, birth_date) VALUES ('Scott', 'Tiger', '1990-11-02');
INSERT INTO Customer (first_name, last_name, birth_date) VALUES ('John', 'Smith', '1964-02-28');
INSERT INTO Customer (first_name, last_name, birth_date) VALUES ('Ivan', 'Ivanov', '2000-01-01');