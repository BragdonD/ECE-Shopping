CREATE TABLE `Users` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`email` varchar(100) NOT NULL UNIQUE,
	`password` varchar(255) NOT NULL,
	`name` varchar(50) NOT NULL,
	`admin` BOOLEAN NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Products` (
	`id` INT NOT NULL AUTO_INCREMENT UNIQUE,
	`name` varchar(100) NOT NULL,
	`price` FLOAT NOT NULL,
	`bulk_price` FLOAT,
	`image` blob NOT NULL,
	`product_type` varchar(255) NOT NULL,
	`marque` varchar(255) NOT NULL,
	`stock` INT NOT NULL,
	`description` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Purchases` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`user_id` INT NOT NULL,
	`purchase_date` DATETIME NOT NULL,
	`amountPayed` FLOAT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Purchase_Items` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`purchase_id` INT NOT NULL,
	`product_id` INT NOT NULL,
	`quantity` INT NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `Purchases` ADD CONSTRAINT `Purchases_fk0` FOREIGN KEY (`user_id`) REFERENCES `Users`(`id`);

ALTER TABLE `Purchase_Items` ADD CONSTRAINT `Purchase_Items_fk0` FOREIGN KEY (`purchase_id`) REFERENCES `Purchases`(`id`);

ALTER TABLE `Purchase_Items` ADD CONSTRAINT `Purchase_Items_fk1` FOREIGN KEY (`product_id`) REFERENCES `Products`(`id`);