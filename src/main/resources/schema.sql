CREATE TABLE IF NOT EXISTS chat (
  id INT NOT NULL,
  name VARCHAR(30) NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS message (
  id CHAR(49) NOT NULL,
  chat_id INT NOT NULL,
  text TEXT NOT NULL,
  timestamp TIMESTAMP NOT NULL,
  PRIMARY KEY(id),
  CONSTRAINT fk_department_id
  FOREIGN KEY (chat_id)
  REFERENCES chat (id)
  ON DELETE CASCADE
);