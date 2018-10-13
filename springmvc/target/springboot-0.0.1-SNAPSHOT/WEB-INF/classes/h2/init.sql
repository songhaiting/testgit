CREATE TABLE IF NOT EXISTS user (
  user_id INT  UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  user_name VARCHAR(50) not null,
  sex VARCHAR(1) NOT NULL,
  age INT UNSIGNED,
  remarks VARCHAR (255),
  is_useable BOOLEAN,
  create_time DATETIME,
  last_edit_time DATETIME,
);