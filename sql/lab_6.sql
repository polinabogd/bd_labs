-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema student_project
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema student_project
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `student_project` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `student_project` ;

-- -----------------------------------------------------
-- Table `student_project`.`item_adress`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_project`.`item_adress` (
  `id_adress` BIGINT NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(50) NOT NULL,
  `region` VARCHAR(50) NOT NULL,
  `settlement` VARCHAR(50) NOT NULL,
  `street` VARCHAR(50) NOT NULL,
  `house` INT NOT NULL,
  PRIMARY KEY (`id_adress`))
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `student_project`.`security`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_project`.`security` (
  `login` VARCHAR(50) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`login`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `student_project`.`trip_advisor_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_project`.`trip_advisor_user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `surname` VARCHAR(50) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `security_login` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`, `security_login`),
  INDEX `FK_trip_advisor_user_security` (`security_login` ASC) VISIBLE,
  CONSTRAINT `FK_trip_advisor_user_security`
    FOREIGN KEY (`security_login`)
    REFERENCES `student_project`.`security` (`login`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `student_project`.`trip_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_project`.`trip_item` (
  `id_item` BIGINT NOT NULL AUTO_INCREMENT,
  `item_category` VARCHAR(50) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `id_adress` BIGINT NOT NULL,
  PRIMARY KEY (`id_item`, `id_adress`),
  INDEX `idx_name` (`name` ASC) VISIBLE,
  INDEX `FK_trip_item_item_adress` (`id_adress` ASC) VISIBLE,
  CONSTRAINT `FK_trip_item_item_adress`
    FOREIGN KEY (`id_adress`)
    REFERENCES `student_project`.`item_adress` (`id_adress`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `student_project`.`trip_item_rating`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_project`.`trip_item_rating` (
  `id_trip_item_rating` BIGINT NOT NULL AUTO_INCREMENT,
  `stars_for_placement` INT NULL DEFAULT NULL,
  `stars_for_prices` INT NULL DEFAULT NULL,
  `stars_in_general` INT NULL DEFAULT NULL,
  `id_item` BIGINT NOT NULL,
  PRIMARY KEY (`id_trip_item_rating`, `id_item`),
  INDEX `FK_trip_item_rating_trip_item` (`id_item` ASC) VISIBLE,
  CONSTRAINT `FK_trip_item_rating_trip_item`
    FOREIGN KEY (`id_item`)
    REFERENCES `student_project`.`trip_item` (`id_item`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `student_project`.`trip_item_review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student_project`.`trip_item_review` (
  `id_item_review` BIGINT NOT NULL AUTO_INCREMENT,
  `review_text` VARCHAR(50) NULL DEFAULT NULL,
  `id_item` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY (`id_item_review`, `id_item`),
  INDEX `FK_trip_item_review_trip_item` (`id_item` ASC) VISIBLE,
  INDEX `FK_trip_item_review_trip_advisor_user` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FK_trip_item_review_trip_advisor_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `student_project`.`trip_advisor_user` (`id`),
  CONSTRAINT `FK_trip_item_review_trip_item`
    FOREIGN KEY (`id_item`)
    REFERENCES `student_project`.`trip_item` (`id_item`))
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
