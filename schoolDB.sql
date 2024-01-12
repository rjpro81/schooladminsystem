
/**
 * Author:  Ralph Julsaint
 * Created: Feb 11, 2019
 */

DROP TABLE classroom;
DROP TABLE faculty;
DROP TABLE grades;
DROP TABLE tasks;
DROP TABLE calendar;
DROP TABLE users;
DROP TABLE school;
DROP TABLE students;

CREATE SCHEMA JULSAINT;

SET SCHEMA JULSAINT;


CREATE TABLE users (
  username varchar (255) NOT NULL,
  password varchar (255) NOT NULL,
  firstName varchar(70) NOT NULL,
  lastName varchar (70) NOT NULL,
  PRIMARY KEY (username, password)
);

CREATE TABLE school (
  schoolID int NOT NULL GENERATED ALWAYS AS IDENTITY,
  schoolName varchar (50) NOT NULL,
  schoolPrincipal varchar (70) NOT NULL,
  schoolGradeLevel varchar (20),
  schoolType varchar (20),
  schoolDistrict varchar (40),
  schoolAddress varchar (60) NOT NULL,
  schoolCity varchar (30) NOT NULL,
  schoolState varchar (30) NOT NULL,
  schoolZip varchar (20) NOT NULL,
  schoolPhoneNumber varchar (20) NOT NULL,
  schoolEmail varchar (50),
  PRIMARY KEY (schoolID)
);

CREATE TABLE students(
  studentID int NOT NULL GENERATED ALWAYS AS IDENTITY,
  studentFirstName varchar(60) NOT NULL,
  studentLastName varchar(60) NOT NULL,
  studentAge varchar(3),
  studentBirthDate varchar (15) NOT NULL,
  studentAddress varchar (60) NOT NULL,
  studentCity varchar (30) NOT NULL,
  studentState varchar (30) NOT NULL,
  studentZip varchar (15) NOT NULL,
  studentPhoneNumber varchar (20) NOT NULL,
  studentGrade varchar (10) NOT NULL,
  ethnicity varchar (20),
  gender varchar (20),
  PRIMARY KEY (studentID)
);

CREATE TABLE calendar(
  eventID int NOT NULL GENERATED ALWAYS AS IDENTITY,
  event varchar (255) NOT NULL,
  eventDate varchar (20) NOT NULL
);

CREATE TABLE tasks(
  taskID int NOT NULL GENERATED ALWAYS AS IDENTITY,
  taskName varchar (255) NOT NULL,
  taskDate varchar (25) NOT NULL,
  taskTime varchar (25) NOT NULL,
  PRIMARY KEY (taskID)
);

CREATE TABLE grades(
  readingAverage DECIMAL (5, 2),
  mathAverage DECIMAL (5, 2),
  scienceAverage DECIMAL (5, 2),
  socialStudiesAverage DECIMAL (5, 2),
  studentID int NOT NULL,
  FOREIGN KEY (studentID) REFERENCES students(studentID)
);

CREATE TABLE faculty(
  employeeID int NOT NULL GENERATED ALWAYS AS IDENTITY,
  empFirstName varchar (60) NOT NULL,
  empLastName varchar (60) NOT NULL,
  empAge varchar (3),
  empBirthDate varchar (20) NOT NULL,
  empAddress varchar (60),
  empCity varchar (40),
  empState varchar (30),
  empZip varchar (20),
  empPhoneNumber varchar (20) NOT NULL,
  credentials varchar (20),
  empGrade varchar (20),
  PRIMARY KEY (employeeID)
);

CREATE TABLE classroom(
  studentID int NOT NULL,
  employeeID int NOT NULL,
  FOREIGN KEY (studentID) REFERENCES students,
  FOREIGN KEY (employeeID) REFERENCES faculty
);


INSERT INTO users(
username, password, firstName, lastName) VALUES 
('julsaint', 'julsaint', 'Ralph', 'Julsaint');

INSERT INTO school (
schoolName, schoolPrincipal, schoolGradeLevel, schoolType, schoolDistrict, schoolAddress,
schoolCity, schoolState, schoolZip, schoolPhoneNumber, schoolEmail) VALUES 
('Sample Elementary School', 'Jerry Hughes', 'Elementary', 'Public', 'Sample School District', 
'7500 Broadway Street', 'Altamonte Springs', 'Florida', '85458', '864-382-8433', 'sampleelem@mail.com'),
('Sample Middle School', 'Allen Burches', 'Middle', 'Public', 'Sample School District', 
'5742 Wilkos Drive', 'Lake Mary', 'Florida', '24844', '684-682-9645', 'samplemiddle@mail.com'),
('Sample High School', 'Janet Kluber', 'High', 'Public', 'Sample School District', '4839 Hollow Drive',
'Orlando', 'Florida', '84342', '565-857-2388', 'samplehigh@mail.com');

INSERT INTO students (
studentFirstName, studentLastName, studentAge, studentBirthDate, studentAddress, studentCity,
studentState, studentZip, studentPhoneNumber, studentGrade, ethnicity, gender) VALUES
('Sarah', 'Harris', '5', '04/25/2013', '77 Liberty Way', 'Orlando', 'Florida', '84231', 
'923-457-8472', 'K', 'Caucasian', 'Female'),
('Kimberly', 'Washburn', '5', '07/13/2013', '384 Reed Parkway', 'Orlando', 'Florida', '38412',
'734-682-1945', 'K', 'African American', 'Female'),
('Miquel', 'Hernandez', '6', '11/29/2012', '1015 Mangrove Court', 'Orlando', 'Florida', '68392',
'582-819-9433', '1', 'Hispanic', 'Male'),
('Michelle', 'Thomas', '6', '10/17/2012', '948 Wilson Parkway', 'Orlando', 'Florida', '94327',
'728-965-2294', '1', 'Caucasian', 'Female'),
('Dewayne', 'Allen', '7', '12/03/2011', '3921 Sampson Street', 'Orlando', 'Florida', '89324',
'933-174-7362', '2', 'African Amerian', 'Male'),
('Jocelyn', 'Gonzales', '7', '08/08/2011', '8434 Holly Park Lane', 'Orlando', 'Florida', '93340',
'733-865-1843', '2', 'Hispanic', 'Female'),
('Jimmy', 'Chang', '8', '02/26/2011', '94595 Valley Street', 'Orlando', 'Florida', '58453', 
'954-684-2486', '3', 'Asian', 'Male'),
('Janet', 'Bailey', '8', '06/13/2010', '5835 Marchum Road', 'Orlando', 'Florida', '84483',
'348-624-3854', '3', 'Native American', 'Female'),
('John', 'Samfort', '9', '05/30/2009', '863 Garden Hill Road', 'Orlando', 'Florida', '37395',
'753-975-0359', '4', 'Caucasian', 'Male'),
('Victoria', 'Wilson', '9', '09/24/2009', '8353 Simpson Street', 'Orlando', 'Florida', '68499',
'182-549-6648', '4', 'Caucasian', 'Female'),
('Patricia', 'Peters', '10', '10/09/2008', '458 Rhode Island Way', 'Orlando', 'Florida', '96845',
'384-929-5838', '5', 'African American', 'Female'),
('Sam', 'Bagley', '10', '12/18/2008', '6262 Tapper Road', 'Orlando', 'Florida', '68320', 
'682-598-1845', '5', 'Caucasian', 'Male');

INSERT INTO calendar(
event, eventDate) VALUES 
('First Day of School', '08/22/2018'),
('Labor Day', '09/07/2018'),
('Thanksgiving Break Begins', '11/22/2018'),
('Christmas Break Begins', '12/18/2018'),
('New Years Day', '01/01/2019'),
('Martin Luther King Day', '01/15/2019'),
('Presidents Day', '02/18/2019'),
('St. Patricks Day', '03/17/2019'),
('Spring Break Begins', '04/10/2019'),
('Memorial Day', '05/31/2019'),
('Last Day of School', '06/06/2019');

INSERT INTO tasks(
taskName, taskDate, taskTime) VALUES 
('Staff Meeting', '08/22/2018', '03:30 pm'),
('Mr.Thomas Observation', '09/04/2018', '10:30 am'),
('Ms.Vickers Observation', '10/18/2018', '12:45 pm'),
('PTA Meeting', '11/04/2018', '05:00 pm'),
('Superintendents Video Conference', '12/03/2018', '09:45 am');

INSERT INTO faculty(
empFirstName, empLastName, empAge, empBirthDate, empAddress, 
empCity, empState, empZip, empPhoneNumber, credentials, empGrade) VALUES
('Samantha', 'Vickers', '28', '09/30/1992', '548 Victory Parkway', 'Orlando',
'Florida', '83069', '345-683-3581', 'B.A.', 'K'), 
('Heather', 'Baker', '35', '02/10/1984', '9584 Geronimo Lane', 'Sanford', 
'Florida', '56803', '293-975-0349', 'B.A.', '1'),
('Larry', 'Keller', '51', '01/17/1968', '9409 Waverley Street', 'Winter Park',
'Florida', '32839', '609-742-4380', 'M.A.T', '2'),
('Valarie', 'Smith', '48', '08/29/1970', '38531 Garden Homes Road', 'Orlando',
'Florida', '28439', '743-069-3485', 'M.Ed.', '3'),
('Michael', 'Thomas', '38', '02/19/1981', '4054 Umatilla Road', 'Orlando', 
'Florida', '58331', '293-864-9094', 'B.A.', '4'),
('Mary', 'Harris', '42', '04/25/1976', '283 Wilson Parkway', 'Orlando', 
'Florida', '94842', '284-692-0638', 'B.A.', '5');