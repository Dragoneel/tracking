CREATE TABLE `tracking`.`client` ( `id` INT NOT NULL AUTO_INCREMENT , `username` TEXT NOT NULL , `password` TEXT NOT NULL , `nom` TEXT NOT NULL , `adresse` TEXT NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;


CREATE TABLE `tracking`.`colis` ( `id` INT NOT NULL AUTO_INCREMENT , `id_client` INT NOT NULL , `label` TEXT NOT NULL , `poids` INT NOT NULL , `valeur` INT NOT NULL , `origine` TEXT NOT NULL , `destination` TEXT NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;


CREATE TABLE `tracking`.`suivi` ( `id` INT NOT NULL AUTO_INCREMENT , `latitude` DECIMAL NOT NULL , `longitude` DECIMAL NOT NULL , `emplacement` TEXT NOT NULL , `etat` TEXT NOT NULL , PRIMARY KEY (` id`)) ENGINE = InnoDB;