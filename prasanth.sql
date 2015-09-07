DROP TABLE STUDENTS;

Create table students
(studentName Varchar2(30),
 Password Varchar2(10)
);

INSERT INTO students(studentName,Password) 
VALUES('prasanth','abc123');

INSERT INTO students(studentName,Password) 
VALUES('sruthi','bbb223');

INSERT INTO students(studentName,Password) 
VALUES('rajesh','aaa111');

INSERT INTO students(studentName,Password) 
VALUES('Anil','vvv444');

INSERT INTO students(studentName,Password) 
VALUES('anirudh','fff666');

commit;