-- -----------------------------------------------------
-- Table `paintingshop`.`shops`
-- -----------------------------------------------------
DROP TABLE IF EXISTS shops;
CREATE TABLE shops(
  shop_id INT AUTO_INCREMENT PRIMARY KEY,
  shop_name VARCHAR(250) NOT NULL,
  shop_capacity INT NOT NULL);

-- -----------------------------------------------------
-- Table `paintingshop`.`paintings`
-- -----------------------------------------------------
DROP TABLE IF EXISTS paintings;
CREATE TABLE paintings(
  painting_id INT AUTO_INCREMENT PRIMARY KEY,
  painting_name VARCHAR(250) NOT NULL,
  painting_price DECIMAL(2,0) NOT NULL,
  date_arrival DATE NOT NULL,
  author VARCHAR(45) NULL DEFAULT NULL,
  id_shop INT NOT NULL,
  FOREIGN KEY (id_shop) REFERENCES shops(shop_id);

