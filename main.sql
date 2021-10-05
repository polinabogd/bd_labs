-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bogdanovska
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bogdanovska
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bogdanovska` DEFAULT CHARACTER SET utf8 ;
USE `bogdanovska` ;

-- -----------------------------------------------------
-- Table `bogdanovska`.`Security`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bogdanovska`.`Security` (
  `login` VARCHAR(25) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`login`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bogdanovska`.`AccommodationOwner`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bogdanovska`.`AccommodationOwner` (
  `idOwner` INT NOT NULL AUTO_INCREMENT,
  `NameSurname` VARCHAR(45) NOT NULL,
  `Security_login` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`idOwner`, `Security_login`),
  INDEX `fk_AccommodationOwner_Security1_idx` (`Security_login` ASC) VISIBLE,
  CONSTRAINT `fk_AccommodationOwner_Security1`
    FOREIGN KEY (`Security_login`)
    REFERENCES `bogdanovska`.`Security` (`login`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bogdanovska`.`Adress`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bogdanovska`.`Adress` (
  `idAdress` INT NOT NULL AUTO_INCREMENT,
  `Country` VARCHAR(45) NOT NULL,
  `Region` VARCHAR(45) NULL,
  `Settlement` VARCHAR(45) NOT NULL,
  `Street` VARCHAR(45) NOT NULL,
  `House` INT NOT NULL,
  PRIMARY KEY (`idAdress`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bogdanovska`.`TripsRating`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bogdanovska`.`TripsRating` (
  `idTripsRating` INT NOT NULL AUTO_INCREMENT,
  `RatingName` VARCHAR(45) NULL,
  PRIMARY KEY (`idTripsRating`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bogdanovska`.`TripAccommodation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bogdanovska`.`TripAccommodation` (
  `idTripAccommodation` INT NOT NULL AUTO_INCREMENT,
  `PriceForPerson` FLOAT NOT NULL,
  `PriceForOneOfFamily` FLOAT NULL,
  `BreakfastIncluded` TINYINT NOT NULL DEFAULT -1,
  `FullRefundDueDate` DATE NULL,
  `AccommodationOwner_idOwner` INT NOT NULL,
  `Adress_idAdress` INT NOT NULL,
  `TripsRating_idTripsRating1` INT NOT NULL,
  PRIMARY KEY (`idTripAccommodation`, `AccommodationOwner_idOwner`, `Adress_idAdress`),
  INDEX `fk_TripAccommodation_AccommodationOwner1_idx` (`AccommodationOwner_idOwner` ASC) VISIBLE,
  INDEX `fk_TripAccommodation_Adress1_idx` (`Adress_idAdress` ASC) VISIBLE,
  INDEX `fk_TripAccommodation_TripsRating1_idx` (`TripsRating_idTripsRating1` ASC) VISIBLE,
  CONSTRAINT `fk_TripAccommodation_AccommodationOwner1`
    FOREIGN KEY (`AccommodationOwner_idOwner`)
    REFERENCES `bogdanovska`.`AccommodationOwner` (`idOwner`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TripAccommodation_Adress1`
    FOREIGN KEY (`Adress_idAdress`)
    REFERENCES `bogdanovska`.`Adress` (`idAdress`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TripAccommodation_TripsRating1`
    FOREIGN KEY (`TripsRating_idTripsRating1`)
    REFERENCES `bogdanovska`.`TripsRating` (`idTripsRating`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bogdanovska`.`TripAdvisorUser`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bogdanovska`.`TripAdvisorUser` (
  `idTripAdvisorUser` INT NOT NULL AUTO_INCREMENT,
  `NameSurname` VARCHAR(45) NOT NULL,
  `BirthDate` DATE NULL,
  `Adress_idAdress` INT NOT NULL,
  `Security_login` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`idTripAdvisorUser`, `Adress_idAdress`, `Security_login`),
  INDEX `fk_TripAdvisorUser_Adress1_idx` (`Adress_idAdress` ASC) VISIBLE,
  INDEX `fk_TripAdvisorUser_Security1_idx` (`Security_login` ASC) VISIBLE,
  CONSTRAINT `fk_TripAdvisorUser_Adress1`
    FOREIGN KEY (`Adress_idAdress`)
    REFERENCES `bogdanovska`.`Adress` (`idAdress`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TripAdvisorUser_Security1`
    FOREIGN KEY (`Security_login`)
    REFERENCES `bogdanovska`.`Security` (`login`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bogdanovska`.`TripReview`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bogdanovska`.`TripReview` (
  `idTripReview` INT NOT NULL AUTO_INCREMENT,
  `CommentText` VARCHAR(150) NULL,
  `AmountOfStarsOutOfFive` INT(5) NOT NULL,
  `TripAccommodation_idTripAccommodation` INT NOT NULL,
  `TripAdvisorUser_idTripAdvisorUser` INT NOT NULL,
  PRIMARY KEY (`idTripReview`, `TripAccommodation_idTripAccommodation`),
  INDEX `fk_TripReview_TripAccommodation1_idx` (`TripAccommodation_idTripAccommodation` ASC) VISIBLE,
  INDEX `fk_TripReview_TripAdvisorUser1_idx` (`TripAdvisorUser_idTripAdvisorUser` ASC) VISIBLE,
  CONSTRAINT `fk_TripReview_TripAccommodation1`
    FOREIGN KEY (`TripAccommodation_idTripAccommodation`)
    REFERENCES `bogdanovska`.`TripAccommodation` (`idTripAccommodation`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TripReview_TripAdvisorUser1`
    FOREIGN KEY (`TripAdvisorUser_idTripAdvisorUser`)
    REFERENCES `bogdanovska`.`TripAdvisorUser` (`idTripAdvisorUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
