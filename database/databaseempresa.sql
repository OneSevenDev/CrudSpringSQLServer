CREATE DATABASE company;
USE company;
CREATE TABLE Position(
	PositionID int IDENTITY(1,1) PRIMARY KEY,
    PositionName varchar(45)
);
CREATE TABLE Employee(
	EmployeeId int IDENTITY(1,1) PRIMARY KEY,
    Name varchar(45),
    LastName varchar(45),
    Age int,
    Position_Id int REFERENCES Position
);
INSERT INTO position(PositionName) VALUES
('Administrador'),
('Secretaria'),
('Operador'),
('Analista');
INSERT INTO Employee(Name,LastName,Age,Position_Id) VALUES
('Manuel','Guarniz',21,1),
('Juan','Aguilar',22,1),
('Lucho','Perez',24,1),
('Rafael','Gonzales',19,1),
('Iris','Loyola',20,1);