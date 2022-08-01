DROP SCHEMA IF EXISTS `TimeLogger`;
CREATE SCHEMA `TimeLogger`;

USE `TimeLogger`;

CREATE TABLE `timeLog` (
	`timeLogId` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `event` TEXT,
    `startTime` DATETIME,
    `endTime` DATETIME
);

CREATE USER IF NOT EXISTS 'userTimeLogger'@'localhost' IDENTIFIED BY 'pwTimeLogger';
GRANT ALL PRIVILEGES ON Pensioen . * TO 'TimeLogger'@'localhost';