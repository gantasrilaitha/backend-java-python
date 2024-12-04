/*CREATE TABLE person (
    id INT  PRIMARY KEY, -- Primary key with auto-increment
    name VARCHAR(255) NOT NULL,        -- Name field as a variable-length string
    location VARCHAR(255) NOT NULL    -- Location field as a variable-length string
);*/
INSERT INTO person (name, location) VALUES 
('Alice', 'New York'),
('Bob', 'San Francisco'),
('Charlie', 'Los Angeles');


insert into course(id, name,is_deleted) 
values(10001,'JPA in 50 Steps',false);
insert into course(id, name, is_deleted) 
values(10002,'Spring in 50 Steps', false);
insert into course(id, name, is_deleted) 
values(10003,'Spring Boot in 100 Steps',false);

insert into passport(id,number)
values(40001,'E123456');
insert into passport(id,number)
values(40002,'N123457');
insert into passport(id,number)
values(40003,'L123890');

insert into student(id,name,passport_id)
values(20001,'Ranga',40001);
insert into student(id,name,passport_id)
values(20002,'Adam',40002);
insert into student(id,name,passport_id)
values(20003,'Jane',40003);


insert into review(id,rating,description,course_id)
values(50001,'5', 'Great Course',10001);
insert into review(id,rating,description,course_id)
values(50002,'4', 'Wonderful Course',10001);
insert into review(id,rating,description,course_id)
values(50003,'5', 'Awesome Course',10003);


insert into student_course(student_id,course_id)
values(20001,10001);
insert into student_course(student_id,course_id)
values(20002,10001);
insert into student_course(student_id,course_id)
values(20003,10001);
insert into student_course(student_id,course_id)
values(20001,10003);