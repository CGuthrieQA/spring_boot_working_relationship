DROP table IF EXISTS `barn` CASCADE;
DROP table IF EXISTS `animal` CASCADE;

CREATE table IF NOT EXISTS `barn` (
	`id` INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`area` DECIMAL(10,2) NOT NULL,
	`colour` VARCHAR(255) NOT NULL,
	`name` VARCHAR(255) NOT NULL
);

CREATE table IF NOT EXISTS `animal` (
	`id` INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`age` integer NOT NULL,
	`name` VARCHAR(255) NOT NULL,
	`type` VARCHAR(255) NOT NULL,
	`barn_id` INT(11)
);