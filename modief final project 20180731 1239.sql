-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.41-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema final_project
--

CREATE DATABASE IF NOT EXISTS final_project;
USE final_project;

--
-- Definition of table `booking`
--

DROP TABLE IF EXISTS `booking`;
CREATE TABLE `booking` (
  `book_id` int(10) unsigned NOT NULL auto_increment,
  `book_date` date NOT NULL,
  `book_status` varchar(45) NOT NULL,
  `t_booked_seat` int(10) unsigned NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  `schedule_id` int(10) unsigned NOT NULL,
  `payment_status` varchar(50) NOT NULL,
  `total_price` double NOT NULL,
  `ticket_number` int(10) unsigned NOT NULL,
  `coach_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`book_id`),
  KEY `FK_booking_2_schedule_id` (`schedule_id`),
  KEY `FK_booking_1_pass_id` USING BTREE (`user_id`),
  KEY `FK_booking_3_coach_id` (`coach_id`),
  CONSTRAINT `FK_booking_3_coach_id` FOREIGN KEY (`coach_id`) REFERENCES `coach_info` (`coach_id`),
  CONSTRAINT `FK_booking_1_pass_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_booking_2_schedule_id` FOREIGN KEY (`schedule_id`) REFERENCES `train_schedule` (`schedule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booking`
--

/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` (`book_id`,`book_date`,`book_status`,`t_booked_seat`,`user_id`,`schedule_id`,`payment_status`,`total_price`,`ticket_number`,`coach_id`) VALUES 
 (1,'2018-07-07','UNPAID',4,1,1,'PAID',2000,4,1),
 (2,'2018-07-16','booked',2,1,2,'Unpaid',1500,3,1),
 (3,'2018-07-25','booked',3,3,4,'PAID',1500,11,1);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;


--
-- Definition of table `booking_seat`
--

DROP TABLE IF EXISTS `booking_seat`;
CREATE TABLE `booking_seat` (
  `bo_seat_id` int(10) unsigned NOT NULL auto_increment,
  `seat_no` int(10) unsigned NOT NULL,
  `book_id` int(10) unsigned NOT NULL,
  `coach_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`bo_seat_id`),
  KEY `FK_booking_seat_1_book_id` (`book_id`),
  KEY `FK_booking_seat_2_coach_id` (`coach_id`),
  CONSTRAINT `FK_booking_seat_1_book_id` FOREIGN KEY (`book_id`) REFERENCES `booking` (`book_id`),
  CONSTRAINT `FK_booking_seat_2_coach_id` FOREIGN KEY (`coach_id`) REFERENCES `coach_info` (`coach_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booking_seat`
--

/*!40000 ALTER TABLE `booking_seat` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking_seat` ENABLE KEYS */;


--
-- Definition of table `coach_info`
--

DROP TABLE IF EXISTS `coach_info`;
CREATE TABLE `coach_info` (
  `coach_id` int(10) unsigned NOT NULL auto_increment,
  `coach_name` varchar(45) NOT NULL,
  `coach_type` varchar(40) NOT NULL,
  `total_seat` varchar(45) NOT NULL,
  `train_id` int(10) unsigned NOT NULL,
  `ticket_price` double NOT NULL,
  PRIMARY KEY  (`coach_id`),
  KEY `FK_coach_info_1_train_id` (`train_id`),
  CONSTRAINT `FK_coach_info_1_train_id` FOREIGN KEY (`train_id`) REFERENCES `train_info` (`train_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `coach_info`
--

/*!40000 ALTER TABLE `coach_info` DISABLE KEYS */;
INSERT INTO `coach_info` (`coach_id`,`coach_name`,`coach_type`,`total_seat`,`train_id`,`ticket_price`) VALUES 
 (1,'D-4','INTERCITY','50',1,500);
/*!40000 ALTER TABLE `coach_info` ENABLE KEYS */;


--
-- Definition of table `route`
--

DROP TABLE IF EXISTS `route`;
CREATE TABLE `route` (
  `route_id` int(10) unsigned NOT NULL auto_increment,
  `route_no` int(10) unsigned NOT NULL,
  `route_name` varchar(45) NOT NULL,
  `source` varchar(60) NOT NULL,
  `destination` varchar(60) NOT NULL,
  PRIMARY KEY  (`route_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `route`
--

/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` (`route_id`,`route_no`,`route_name`,`source`,`destination`) VALUES 
 (1,102,'Dhaka-Sylhet','Dhaka','Sylhet'),
 (2,101,'Dhaka-Chittagong','Dhaka','Chittagong'),
 (3,10,'Dhaka-Kolkata','Dhaka','Kolkata'),
 (4,501,'Dhaka-Comilla','Dhaka','Comilla'),
 (5,305,'Dhaka-Khulna','Dhaka','Khulna');
/*!40000 ALTER TABLE `route` ENABLE KEYS */;


--
-- Definition of table `route_station`
--

DROP TABLE IF EXISTS `route_station`;
CREATE TABLE `route_station` (
  `station_id` int(10) unsigned NOT NULL auto_increment,
  `station_name` varchar(45) NOT NULL,
  `contact_no` int(10) unsigned NOT NULL,
  `route_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`station_id`),
  KEY `FK_route_station_1_route_id` (`route_id`),
  CONSTRAINT `FK_route_station_1_route_id` FOREIGN KEY (`route_id`) REFERENCES `route` (`route_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `route_station`
--

/*!40000 ALTER TABLE `route_station` DISABLE KEYS */;
INSERT INTO `route_station` (`station_id`,`station_name`,`contact_no`,`route_id`) VALUES 
 (1,'airport',1937745755,1),
 (2,'Comilla',193774555,2),
 (3,'Kamlapur',289658,3);
/*!40000 ALTER TABLE `route_station` ENABLE KEYS */;


--
-- Definition of table `train_info`
--

DROP TABLE IF EXISTS `train_info`;
CREATE TABLE `train_info` (
  `train_id` int(10) unsigned NOT NULL auto_increment,
  `train_name` varchar(60) NOT NULL,
  `off_day` varchar(45) NOT NULL,
  `train_type` varchar(45) NOT NULL,
  `capacity` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`train_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `train_info`
--

/*!40000 ALTER TABLE `train_info` DISABLE KEYS */;
INSERT INTO `train_info` (`train_id`,`train_name`,`off_day`,`train_type`,`capacity`) VALUES 
 (1,'Dhaka Express','Saturday','local',4000),
 (2,'Comilla Express','Friday','intercity',3000),
 (3,'Rangpur Express','Monday','intercity',5000),
 (4,'Sundarban Express','Monday','intercity',3000),
 (5,'Joyontika Express','Tuesday','intercity',3004),
 (6,'Kalini Express','None','local',5000),
 (7,'xfbgfcnhg','Monday','jnhm',123),
 (8,'Norail Express','Tuesday','local',3000);
/*!40000 ALTER TABLE `train_info` ENABLE KEYS */;


--
-- Definition of table `train_schedule`
--

DROP TABLE IF EXISTS `train_schedule`;
CREATE TABLE `train_schedule` (
  `schedule_id` int(10) unsigned NOT NULL auto_increment,
  `depar_date` date NOT NULL,
  `depar_time` varchar(30) NOT NULL,
  `train_id` int(10) unsigned NOT NULL,
  `route_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`schedule_id`),
  KEY `FK_train_schedule_1_train_id` (`train_id`),
  KEY `FK_train_schedule_2_route_id` (`route_id`),
  CONSTRAINT `FK_train_schedule_1_train_id` FOREIGN KEY (`train_id`) REFERENCES `train_info` (`train_id`),
  CONSTRAINT `FK_train_schedule_2_route_id` FOREIGN KEY (`route_id`) REFERENCES `route` (`route_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `train_schedule`
--

/*!40000 ALTER TABLE `train_schedule` DISABLE KEYS */;
INSERT INTO `train_schedule` (`schedule_id`,`depar_date`,`depar_time`,`train_id`,`route_id`) VALUES 
 (1,'2018-07-11','12:30:00',1,2),
 (2,'2018-04-10','01:30:00',2,2),
 (3,'2018-07-19','06:00:00',3,1),
 (4,'2018-07-19','12:00:00',2,4);
/*!40000 ALTER TABLE `train_schedule` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) unsigned NOT NULL auto_increment,
  `user_name` varchar(45) NOT NULL,
  `user_pass` varchar(45) NOT NULL,
  `u_type_id` int(10) unsigned NOT NULL,
  `user_phone` int(11) unsigned NOT NULL,
  `user_email` varchar(50) NOT NULL,
  `user_address` varchar(50) NOT NULL,
  PRIMARY KEY  (`user_id`),
  KEY `FK_user_u_type_id` (`u_type_id`),
  CONSTRAINT `FK_user_u_type_id` FOREIGN KEY (`u_type_id`) REFERENCES `user_type` (`u_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`user_id`,`user_name`,`user_pass`,`u_type_id`,`user_phone`,`user_email`,`user_address`) VALUES 
 (1,'mohsin008','52247',1,12556665,'mohsin.@gmail.com','malibag,dhaka'),
 (3,'jewel122','2334',4,25555,'jewe@gmial.vcom','dhaka'),
 (5,'Kamal12','123657',4,552566,'k@gmil.com','Comilla'),
 (6,'jewel23','456',4,25856,'jgf@gfng.cm','fhfhe'),
 (7,'hghfg','415265',4,4525852,'jhj@gmdx.bj','gfghhedg'),
 (8,'Reiaj','124',4,1785469875,'trtyrftuytf@gmail.com','d');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Definition of table `user_type`
--

DROP TABLE IF EXISTS `user_type`;
CREATE TABLE `user_type` (
  `u_type_id` int(10) unsigned NOT NULL auto_increment,
  `u_type_name` varchar(45) NOT NULL,
  PRIMARY KEY  (`u_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_type`
--

/*!40000 ALTER TABLE `user_type` DISABLE KEYS */;
INSERT INTO `user_type` (`u_type_id`,`u_type_name`) VALUES 
 (1,'admin'),
 (4,'user'),
 (5,'user2');
/*!40000 ALTER TABLE `user_type` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
