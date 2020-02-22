DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS rooms;
DROP TABLE IF EXISTS meetings;

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

CREATE TABLE meetings (
  id VARCHAR(60)  PRIMARY KEY,
  subject VARCHAR(250) NOT NULL,
  notes VARCHAR(250),
  meeting_date VARCHAR(250) NOT NULL,
  start_time VARCHAR(250) NOT NULL,
  end_time VARCHAR(250) NOT NULL,
  room_id VARCHAR(60) NOT NULL
);

INSERT INTO meetings (id, subject, notes, meeting_date, start_time, end_time, room_id) VALUES
  ('1', 'Meeting 1', 'Meeting note 1', '2019-09-20', '10:00', '11:00', '1'),
  ('2', 'Meeting 2', 'Meeting note 2', '2019-09-20', '12:00', '13:00', '1'),
  ('3', 'Meeting 3', 'Meeting note 3', '2019-09-20', '14:00', '15:00', '2');