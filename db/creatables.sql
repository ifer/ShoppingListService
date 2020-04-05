-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema shopping
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema shopping
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `shopping` DEFAULT CHARACTER SET utf8 ;
USE `shopping` ;

-- -----------------------------------------------------
-- Table `shopping`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopping`.`category` (
  `catid` INT NOT NULL AUTO_INCREMENT,
  `descr` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`catid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shopping`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopping`.`product` (
  `prodid` INT NOT NULL AUTO_INCREMENT,
  `descr` VARCHAR(120) CHARACTER SET 'DEFAULT' NOT NULL,
  `catid` INT NOT NULL,
  PRIMARY KEY (`prodid`, `descr`),
  INDEX `fk_product_category_idx` (`catid` ASC) VISIBLE,
  CONSTRAINT `fk_product_category`
    FOREIGN KEY (`catid`)
    REFERENCES `shopping`.`category` (`catid`)
    ON DELETE RESTRICT
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shopping`.`list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopping`.`list` (
  `lid` INT NOT NULL AUTO_INCREMENT,
  `comment` VARCHAR(200) NULL,
  `amount` INT NOT NULL,
  `prodid` INT NOT NULL,
  PRIMARY KEY (`lid`),
  INDEX `fk_list_product1_idx` (`prodid` ASC) VISIBLE,
  CONSTRAINT `fk_list_product1`
    FOREIGN KEY (`prodid`)
    REFERENCES `shopping`.`product` (`prodid`)
    ON DELETE RESTRICT
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
