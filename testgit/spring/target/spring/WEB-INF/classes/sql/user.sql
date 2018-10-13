CREATE TABLE IF NOT EXISTS users  (
  id  INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30) NOT NULL,
  age int NOT NULL,
  email VARCHAR(30) NOT NULL,
  gender CHAR(3) NOT NULL,
  remark VARCHAR(100) NOT NULL,
  phone varchar(20) NOT NULL ,
  useable INT(11) NOT NULL DEFAULT 1 ,
  create_time TIMESTAMP NOT NULL ,
  last_modified_time TIMESTAMP NOT NULL
);