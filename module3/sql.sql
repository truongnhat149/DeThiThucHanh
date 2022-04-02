create database `test3`;
use test3;
CREATE TABLE `test3`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `price` FLOAT NULL,
  `quantity` INT NULL,
  `color` VARCHAR(255) NULL,
  `description` VARCHAR(255) NULL,
  `name_category` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `test3`.`category` (
  id INT PRIMARY KEY,
  `name_category` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`id`));
