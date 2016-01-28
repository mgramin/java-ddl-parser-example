CREATE TABLE Persons
(
  PersonID int primary key not null,
  LastName varchar(255) not null,
  FirstName varchar(255) not null,
  Address varchar(255) not null,
  City varchar(255)
);

CREATE TABLE PersonsNotNull
(
  P_Id int NOT NULL,
  LastName varchar(255) NOT NULL,
  FirstName varchar(255),
  Address varchar(255),
  City varchar(255)
)