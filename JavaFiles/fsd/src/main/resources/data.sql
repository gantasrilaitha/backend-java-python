
insert into users(id,email,name) values(1,'a.com','aa');
insert into users(id,email,name) values(2,'b.com','bb');

INSERT INTO user_group(id, name, address, city, state_Or_Province, country, postal_Code, user_id)
VALUES
(100, 'g1', NULL, NULL, NULL, NULL, NULL, 1),
(200, 'g2', NULL, NULL, NULL, NULL, NULL, 2),
(300, 'g3', NULL, NULL, NULL, NULL, NULL, 1),
(400, 'g4', NULL, NULL, NULL, NULL, NULL, NULL),
(500, 'g5', NULL, NULL, NULL, NULL, NULL, NULL);

-- Insert data into Events table
INSERT INTO `event`(id, date, title, description, group_id,user_id)
VALUES
(10, '2022-09-13 17:00:00', 'e1', 'ee1', 100,NULL),
(20, '2022-09-13 17:00:00', 'e2', 'ee2', 300,1),
(30, '2022-09-13 17:00:00', 'e3', 'ee3', 200,2);

