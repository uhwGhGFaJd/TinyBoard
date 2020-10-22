-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE=''ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION'';

-- -----------------------------------------------------
-- Schema tinyboard
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tinyboard
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tinyboard` DEFAULT CHARACTER SET utf8 ;
USE `tinyboard` ;

-- -----------------------------------------------------
-- Table `tinyboard`.`threads`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tinyboard`.`threads` (
  `thread_id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `thread_nickname` VARCHAR(50) NOT NULL,
  `thread_password` VARCHAR(60) NOT NULL,
  `thread_content` TEXT NOT NULL,
  `thread_create_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`thread_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tinyboard`.`config`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tinyboard`.`config` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `config_name` VARCHAR(255) NOT NULL,
  `config_value` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tinyboard`.`thread_reply`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tinyboard`.`thread_reply` (
  `reply_id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `thread_id` INT(11) UNSIGNED NOT NULL,
  `reply_nickname` VARCHAR(50) NOT NULL,
  `reply_password` VARCHAR(60) NOT NULL,
  `reply_content` TEXT NOT NULL,
  `reply_create_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`reply_id`),
  INDEX `thread_reply_id_idx` (`thread_id` ASC) VISIBLE,
  CONSTRAINT `thread_reply_id`
    FOREIGN KEY (`thread_id`)
    REFERENCES `tinyboard`.`threads` (`thread_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `tinyboard`.`config`
-- -----------------------------------------------------
START TRANSACTION;
USE `tinyboard`;
INSERT INTO `tinyboard`.`config` (`id`, `config_name`, `config_value`) VALUES (1, ''server_disabled'', ''false'');
INSERT INTO `tinyboard`.`config` (`id`, `config_name`, `config_value`) VALUES (2, ''server_posting_disabled'', ''false'');
INSERT INTO `tinyboard`.`config` (`id`, `config_name`, `config_value`) VALUES (3, ''server_manage_password'', ''$2a$10$VFgfzLUd1rtDGeyKL31MqOcyhk77uV.7fDMUraFqhL/W.Deejgaxi'');

COMMIT;

