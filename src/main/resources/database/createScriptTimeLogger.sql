DROP SCHEMA IF EXISTS `TimeLogger`;
CREATE SCHEMA `TimeLogger`;

USE `TimeLogger`;

CREATE TABLE `timeLog` (
	`timeLogId` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `event` TEXT,
    `startTime` DATETIME,
    `endTime` DATETIME
);

CREATE TABLE `project`(
    `projectid`   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `projectname` TEXT,
    `projectcode` TEXT
);

CREATE USER IF NOT EXISTS 'userTimeLogger'@'localhost' IDENTIFIED BY 'pwTimeLogger';
GRANT ALL PRIVILEGES ON TimeLogger . * TO 'TimeLogger'@'localhost';