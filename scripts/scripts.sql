CREATE DATABASE  IF NOT EXISTS `spring_jdbc`;

USE `spring_jdbc`;

CREATE USER 'springjdbc'@'localhost' IDENTIFIED BY 'springjdbc';

GRANT ALL PRIVILEGES ON * . * TO 'springjdbc'@'localhost';

ALTER USER 'springjdbc'@'localhost' IDENTIFIED WITH mysql_native_password BY 'springjdbc';

DROP TABLE IF EXISTS `passenger`;

CREATE TABLE `passenger` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `source` varchar(45) DEFAULT NULL,
  `destination` varchar(45) DEFAULT NULL,
  `booking_date` DATE NULL,
  `journey_date` DATE NULL,
  `departure_time` DATETIME NULL,
  `booking_status` varchar(3) NULL,
  `cost` FLOAT(7,3) NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;