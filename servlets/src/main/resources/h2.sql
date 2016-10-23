CREATE TABLE Person (
  id         INT PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(255) NOT NULL,
  last_name  VARCHAR(255) NOT NULL,
  email      VARCHAR(255) NOT NULL,
  password   VARCHAR(255) NOT NULL,
);
INSERT INTO Person (first_name, last_name, email, password)
VALUES ('Ivan', 'Ivanov','ivan@mail.ru', 'qwerty');
INSERT INTO Person (first_name, last_name, email, password)
VALUES ('Petr', 'Petrov','peter@mail.ru', 'qwerty');
INSERT INTO Person (first_name, last_name, email, password)
VALUES ('Alexander', 'Alexandrov','alex@mail.ru', 'qwerty');
INSERT INTO Person (first_name, last_name, email, password)
VALUES ('Vladimir', 'Vladimirov','vladimir@mail.ru', 'qwerty');
INSERT INTO Person (first_name, last_name, email, password)
VALUES ('Anna', 'Ivanova','anna@mail.ru', 'qwerty');

CREATE TABLE Roles (
  email VARCHAR(255) NOT NULL,
  role  VARCHAR(15)  NOT NULL,
  PRIMARY KEY (email, role),
  FOREIGN KEY (email) REFERENCES Person (email)
);

INSERT INTO Roles (email, role) VALUES ('ivan@mail.ru', 'admin');
INSERT INTO Roles (email, role) VALUES ('ivan@mail.ru', 'moderator');
INSERT INTO Roles (email, role) VALUES ('ivan@mail.ru', 'user');
INSERT INTO Roles (email, role) VALUES ('peter@mail.ru', 'moderator');
INSERT INTO Roles (email, role) VALUES ('peter@mail.ru', 'user');
INSERT INTO Roles (email, role) VALUES ('alex@mail.ru', 'user');
INSERT INTO Roles (email, role) VALUES ('vladimir@mail.ru', 'user');
INSERT INTO Roles (email, role) VALUES ('anna@mail.ru', 'user');