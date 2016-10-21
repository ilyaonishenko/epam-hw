CREATE TABLE Book (
  id        INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name      VARCHAR(60) NOT NULL,
  author    VARCHAR(60) NOT NULL,
  publisher VARCHAR(60) NOT NULL,

  UNIQUE (name,author)
);

INSERT INTO Book ("1984","George Orwell","AST");
INSERT INTO Book ("Brave New World","Aldous Huxley","EKSMO");
INSERT INTO Book ("WE","Yevgeny Zamyatin","Piter");