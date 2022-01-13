CREATE SCHEMA IF NOT EXISTS testdb;

DROP TABLE IF EXISTS testdb.PERSONAL_INFORMATION;
CREATE TABLE testdb.PERSONAL_INFORMATION (id int PRIMARY KEY AUTO_INCREMENT,real_name varchar(50),idol_name varchar(60),address varchar(255),idol_status varchar(25));
DROP TABLE IF EXISTS testdb.SCHEDULE;
CREATE TABLE testdb.SCHEDULE (id int PRIMARY KEY AUTO_INCREMENT,venue varchar(50),event_name varchar(60),date_time varchar(50));
DROP TABLE IF EXISTS testdb.REVENUE;
CREATE TABLE testdb.REVENUE (id int PRIMARY KEY AUTO_INCREMENT,monthly_rate varchar(50),date_time varchar(50));
DROP TABLE IF EXISTS testdb.TODO;
CREATE TABLE testdb.TODO (id int PRIMARY KEY AUTO_INCREMENT, user_id int, title varchar(50), completed boolean);