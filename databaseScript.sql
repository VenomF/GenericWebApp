CREATE SCHEMA `GenericWebApp` ;
CREATE TABLE `GenericWebApp`.`users` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(40) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` BLOB NOT NULL,
  `salt` BLOB NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));
