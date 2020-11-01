-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


CREATE SCHEMA IF NOT EXISTS `paintingshop` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `paintingshop` ;

-- -----------------------------------------------------
-- Table `paintingshop`.`shops`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `paintingshop`.`shops` (
  `id` INT NOT NULL,
  `shop_name` VARCHAR(45) NOT NULL,
  `shop_capacity` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `paintingshop`.`paintings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `paintingshop`.`paintings` (
  `idpaintings` INT NOT NULL,
  `painting_name` VARCHAR(45) NOT NULL,
  `painting_price` DECIMAL(2,0) NOT NULL,
  `date_arrival` DATE NULL DEFAULT NULL,
  `author` VARCHAR(45) NULL DEFAULT NULL,
  `shops_id` INT NOT NULL,
  PRIMARY KEY (`idpaintings`),
  INDEX `fk_paintings_shops_idx` (`shops_id` ASC) VISIBLE,
  CONSTRAINT `fk_paintings_shops`
    FOREIGN KEY (`shops_id`)
    REFERENCES `paintingshop`.`shops` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
