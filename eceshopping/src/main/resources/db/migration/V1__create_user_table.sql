-- migrate up
CREATE TABLE user (
  id INT PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(255) NOT NULL,
  email VARCHAR(100) NOT NULL,
  created_at DATETIME NOT NULL
);

-- migrate down
DROP TABLE user;