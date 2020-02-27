CREATE USER 'student'@'localhost' IDENTIFIED BY 'Student123!';

GRANT ALL PRIVILEGES ON * . * TO 'student'@'localhost';

ALTER USER 'student'@'localhost' IDENTIFIED WITH mysql_native_password BY 'Student123!';