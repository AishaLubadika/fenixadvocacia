SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema fenixadvocacia
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fenixadvocacia` DEFAULT CHARACTER SET latin1 ;
USE `fenixadvocacia` ;

-- -----------------------------------------------------
-- Table `fenixadvocacia`.`provincia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixadvocacia`.`provincia` (
  `id_provincia` INT NOT NULL,
  `nome_provincia` VARCHAR(45) NULL,
  PRIMARY KEY (`id_provincia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fenixadvocacia`.`municicpio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixadvocacia`.`municicpio` (
  `id_municicpio` INT NOT NULL,
  `nome_municicpio` VARCHAR(45) NULL,
  `provincia_id_provincia` INT NOT NULL,
  PRIMARY KEY (`id_municicpio`),
  INDEX `fk_municicpio_provincia1_idx` (`provincia_id_provincia` ASC),
  CONSTRAINT `fk_municicpio_provincia1`
    FOREIGN KEY (`provincia_id_provincia`)
    REFERENCES `fenixadvocacia`.`provincia` (`id_provincia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fenixadvocacia`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixadvocacia`.`cliente` (
  `id_cliente` INT NOT NULL,
  `constituente` VARCHAR(45) NULL,
  `bi_cliente` VARCHAR(45) NULL,
  `bairro_cliente` VARCHAR(45) NULL,
  `nacionalidade` VARCHAR(45) NULL,
  `local_de_trabalho` VARCHAR(45) NULL,
  `telefone` VARCHAR(45) NULL,
  `telefone_alternativo` VARCHAR(45) NULL,
  `id_municicpio` INT NOT NULL,
  PRIMARY KEY (`id_cliente`),
  INDEX `fk_cliente_municicpio1_idx` (`id_municicpio` ASC),
  CONSTRAINT `fk_cliente_municicpio1`
    FOREIGN KEY (`id_municicpio`)
    REFERENCES `fenixadvocacia`.`municicpio` (`id_municicpio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fenixadvocacia`.`advogado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixadvocacia`.`advogado` (
  `id_advogado` INT NOT NULL,
  `nome_advogado` VARCHAR(45) NULL,
  `sobrenome_advogado` VARCHAR(45) NULL,
  `data_nascimento` DATE NULL,
  `data_inicio_funcoes` DATE NULL,
  PRIMARY KEY (`id_advogado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fenixadvocacia`.`tipo_decisao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixadvocacia`.`tipo_decisao` (
  `id_tipo_decisao` INT NOT NULL,
  `tipo_decisao` VARCHAR(45) NULL,
  PRIMARY KEY (`id_tipo_decisao`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fenixadvocacia`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixadvocacia`.`usuario` (
  `id_usuario` INT NOT NULL,
  `login` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fenixadvocacia`.`tipo_processo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixadvocacia`.`tipo_processo` (
  `id_tipo_processo` INT NOT NULL,
  `tipo_processo` VARCHAR(45) NULL,
  PRIMARY KEY (`id_tipo_processo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fenixadvocacia`.`estado_processo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixadvocacia`.`estado_processo` (
  `id_estado_processo` INT NOT NULL,
  `estado_processo` VARCHAR(45) NULL,
  PRIMARY KEY (`id_estado_processo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fenixadvocacia`.`processo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fenixadvocacia`.`processo` (
  `id_processo` INT NOT NULL,
  `numero_processo` VARCHAR(45) NULL,
  `data_entrada` DATE NULL,
  `data_conclusao` DATE NULL,
  `resumo` VARCHAR(255) NULL,
  `id_advogado` INT NOT NULL,
  `id_cliente` INT NOT NULL,
  `id_tipo_processo` INT NOT NULL,
  `id_tipo_decisao` INT NOT NULL,
  `id_estado_processo` INT NOT NULL,
  PRIMARY KEY (`id_processo`),
  INDEX `fk_processo_advogado1_idx` (`id_advogado` ASC),
  INDEX `fk_processo_cliente1_idx` (`id_cliente` ASC),
  INDEX `fk_processo_tipo_processo1_idx` (`id_tipo_processo` ASC),
  INDEX `fk_processo_tipo_decisao1_idx` (`id_tipo_decisao` ASC),
  INDEX `fk_processo_estado_processo1_idx` (`id_estado_processo` ASC),
  CONSTRAINT `fk_processo_advogado1`
    FOREIGN KEY (`id_advogado`)
    REFERENCES `fenixadvocacia`.`advogado` (`id_advogado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_processo_cliente1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `fenixadvocacia`.`cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_processo_tipo_processo1`
    FOREIGN KEY (`id_tipo_processo`)
    REFERENCES `fenixadvocacia`.`tipo_processo` (`id_tipo_processo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_processo_tipo_decisao1`
    FOREIGN KEY (`id_tipo_decisao`)
    REFERENCES `fenixadvocacia`.`tipo_decisao` (`id_tipo_decisao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_processo_estado_processo1`
    FOREIGN KEY (`id_estado_processo`)
    REFERENCES `fenixadvocacia`.`estado_processo` (`id_estado_processo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
