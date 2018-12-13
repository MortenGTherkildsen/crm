drop schema if exists crmsystemdb;
CREATE SCHEMA `crmsystemdb` DEFAULT CHARACTER SET utf8;

use crmsystemdb;

drop table if exists customer;
CREATE TABLE `customer` (
`id` int not null auto_increment,
`firstName` varchar(100) NULL,
`lastName` varchar(100) NULL,
`nickName` varchar(100) NULL,
`email` varchar(100) NULL,
`phone` varchar(100) NULL,
`cvr` varchar(100) NULL,
`dob` varchar(100) NULL,
`adress1` varchar(100) NULL,
`adress2` varchar(100) NULL,
`city` varchar(100) NULL,
`postalCode` varchar(100) NULL,
`country` varchar(100) NULL,
`website` varchar(100) NULL,
`facebook` varchar(100) NULL,
`trello` varchar(100) NULL,
`gitHub` varchar(100) NULL,
`gmail` varchar(100) NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists notes;
CREATE TABLE `notes` (
`id` INT NOT NULL AUTO_INCREMENT,
`subject` VARCHAR(255) NULL ,
`content` VARCHAR(1023) NULL ,
`owner` INT NOT NULL ,
`timestamp` VARCHAR(255) NULL ,
`status` INT(1) NULL ,
PRIMARY KEY (`id`),
KEY `owner_idx` (`owner`),
CONSTRAINT `owner` FOREIGN KEY (`owner`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB;

insert into `crmsystemdb`.`customer` (`firstName`, `lastName`, `email`, `phone`, `dob`, `postalCode`, `country`, `facebook`, `trello`, `gitHub`) values ('Adil', 'Hussain', 'adhus91@gmail.com', '', '150891', '', 'Danmark', 'https://www.facebook.com/profile.php?id=100001484700711', '@adhus911', 'adil0049');
insert into `crmsystemdb`.`customer` (`firstName`, `lastName`, `email`, `phone`, `dob`, `postalCode`, `country`, `facebook`, `trello`, `gitHub`) values ('Jack', 'Zhong', 'bakagami007@gmail.com', '', '070397', '', 'Danmark', 'https://www.facebook.com/jack.zhong.758', '@chimichanga3', 'managerjack');
insert into `crmsystemdb`.`customer` (`firstName`, `lastName`, `email`, `phone`, `dob`, `postalCode`, `country`, `facebook`, `trello`, `gitHub`) values ('Jonas', 'Sørensen', 'adhus91@gmail.com', '', '070793', '3520', 'Danmark', 'https://www.facebook.com/jonas.aka.bjarne', '@j0nas7', 'J0nas7');
insert into `crmsystemdb`.`customer` (`firstName`, `lastName`, `email`, `phone`, `dob`, `postalCode`, `country`, `facebook`, `trello`, `gitHub`) values ('Morten', 'Therkildsen', 'morten@therkildsen.com', '28408191', '291074', '2880', 'Danmark', 'https://www.facebook.com/morten.therkildsen.7', '@mortentherkildsen', 'MortenGTherkildsen');



