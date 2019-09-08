DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS rooms;

CREATE TABLE users (
  id VARCHAR(60)  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL
);

INSERT INTO users (id, first_name, last_name, email) VALUES
  ('1', 'Manjula', 'Jayawardana', 'manjula121@gmail.com'),
  ('2', 'Jon', 'Snow', 'jon.snow@agmail.com');

CREATE TABLE rooms (
  id VARCHAR(60)  PRIMARY KEY,
  room_name VARCHAR(250) NOT NULL
);

INSERT INTO rooms (id, room_name) VALUES
  ('1', 'Room 1'),
  ('2', 'Room 2'),
  ('3', 'Room 3');