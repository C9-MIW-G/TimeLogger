DROP SCHEMA IF EXISTS `TimeLogger`;
CREATE SCHEMA `TimeLogger`;

USE `TimeLogger`;

CREATE TABLE `project`(
    `projectid`   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `projectname` TEXT,
    `projectcode` TEXT
);

CREATE TABLE `timeLog` (
	`timeLogId` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `event` TEXT,
    `projectid` INT,
    `startTime` DATETIME,
    `endTime` DATETIME,
    FOREIGN KEY (projectid) REFERENCES project(projectid)
);

CREATE USER IF NOT EXISTS 'userTimeLogger'@'localhost' IDENTIFIED BY 'pwTimeLogger';
GRANT ALL PRIVILEGES ON TimeLogger . * TO 'TimeLogger'@'localhost';