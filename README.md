springboot + spring security
---
#### Run the Application 
with maven

##### 1st
create two table and insert data
```mysql
CREATE TABLE `authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `authority` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(256) NOT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `newtable_un` (`username`)
);

INSERT INTO user (username, password, created_at) 
VALUES ('user','$2a$10$3D5Wj.OxXaXi6QXKSM001OTHjBYzA9x1rQtRxait3XDU8.Y3vtvxW',now());

INSERT INTO user (username, password, created_at) 
VALUES ('admin','$2a$10$30skjyxvCW9/Lc1uoW27JOzsNQw.8JLgCgc5M/QH3V3SotTDEm9KW',now());

INSERT INTO authority (username,authority) 
VALUES ('user','user');

INSERT INTO authority (username,authority) 
VALUES ('admin','admin');

```
##### 2nd 
your database config setup in `application.yml`
##### 3rd
```sbtshell
mvn spring-boot:run
```
##### 4th
open the browser and enter the localhost:8080
