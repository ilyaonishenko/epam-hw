CREATE TABLE Book (
  id        INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name      VARCHAR(60) NOT NULL,
  author    VARCHAR(60) NOT NULL,
  publisher VARCHAR(60) NOT NULL,

);

INSERT INTO Book (name,author,publisher) VALUES ('1984','George Orwell','AST');
INSERT INTO Book (name,author,publisher) VALUES ('Brave New World','Aldous Huxley','EKSMO');
INSERT INTO Book (name,author,publisher) VALUES ('WE','Yevgeny Zamyatin','Piter');