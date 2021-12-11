CREATE TABLE students (id_students INT PRIMARY KEY AUTO_INCREMENT,
                       first_name VARCHAR (45) NOT NULL,
                       last_name VARCHAR (45) NOT NULL,
                       age INT NOT NULL);

INSERT INTO students (first_name, last_name, age) VALUES
	                                                   ('Иван', 'Иванов', 20),
	                                                   ('Петр', 'Петров', 20),
	                                                   ('Сидор', 'Сидоров', 22),
	                                                   ('Василий', 'Васечкин', 23);