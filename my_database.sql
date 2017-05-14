-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.7.18-log - MySQL Community Server (GPL)
-- Операционная система:         Win64
-- HeidiSQL Версия:              9.4.0.5169
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных rent_station
DROP DATABASE IF EXISTS `rent_station`;
CREATE DATABASE IF NOT EXISTS `rent_station` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `rent_station`;

-- Дамп структуры для таблица rent_station.category_equip
DROP TABLE IF EXISTS `category_equip`;
CREATE TABLE IF NOT EXISTS `category_equip` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы rent_station.category_equip: ~5 rows (приблизительно)
DELETE FROM `category_equip`;
/*!40000 ALTER TABLE `category_equip` DISABLE KEYS */;
INSERT INTO `category_equip` (`id`, `title`) VALUES
	(1, 'bike'),
	(2, 'rollers'),
	(3, 'helmet'),
	(4, 'skatebord'),
	(5, 'elbow_pads');
/*!40000 ALTER TABLE `category_equip` ENABLE KEYS */;

-- Дамп структуры для таблица rent_station.equipment
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE IF NOT EXISTS `equipment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `category_equip` int(11) NOT NULL,
  `price` double NOT NULL,
  `type` enum('EQ','AC') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_equipment_type_equip` (`category_equip`),
  CONSTRAINT `FK_equipment_type_equip` FOREIGN KEY (`category_equip`) REFERENCES `category_equip` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы rent_station.equipment: ~4 rows (приблизительно)
DELETE FROM `equipment`;
/*!40000 ALTER TABLE `equipment` DISABLE KEYS */;
INSERT INTO `equipment` (`id`, `title`, `category_equip`, `price`, `type`) VALUES
	(1, 'Aist', 1, 15.2, 'EQ'),
	(3, 'Elbow pads', 5, 10, 'EQ'),
	(4, 'Skatebord', 4, 0.5, 'EQ'),
	(5, 'Skatebord', 4, 1.2, 'EQ');
/*!40000 ALTER TABLE `equipment` ENABLE KEYS */;

-- Дамп структуры для таблица rent_station.equip_parametr
DROP TABLE IF EXISTS `equip_parametr`;
CREATE TABLE IF NOT EXISTS `equip_parametr` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equip_id` int(11) NOT NULL DEFAULT '0',
  `parametr_id` int(11) NOT NULL DEFAULT '0',
  `value` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_equip_parametr_equipment` (`equip_id`),
  KEY `FK_equip_parametr_parametr_list` (`parametr_id`),
  CONSTRAINT `FK_equip_parametr_equipment` FOREIGN KEY (`equip_id`) REFERENCES `equipment` (`id`),
  CONSTRAINT `FK_equip_parametr_parametr_list` FOREIGN KEY (`parametr_id`) REFERENCES `parametr_list` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы rent_station.equip_parametr: ~6 rows (приблизительно)
DELETE FROM `equip_parametr`;
/*!40000 ALTER TABLE `equip_parametr` DISABLE KEYS */;
INSERT INTO `equip_parametr` (`id`, `equip_id`, `parametr_id`, `value`) VALUES
	(1, 1, 1, '10.0'),
	(2, 1, 3, '8.0'),
	(3, 3, 2, '36'),
	(4, 3, 1, '8.0'),
	(5, 4, 2, '170'),
	(6, 5, 2, '190');
/*!40000 ALTER TABLE `equip_parametr` ENABLE KEYS */;

-- Дамп структуры для таблица rent_station.order
DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_order` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user` int(11) NOT NULL,
  `data_rent` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `data_return` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `FK_order_user` (`user`),
  CONSTRAINT `FK_order_user` FOREIGN KEY (`user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы rent_station.order: ~2 rows (приблизительно)
DELETE FROM `order`;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` (`id`, `data_order`, `user`, `data_rent`, `data_return`, `status`) VALUES
	(4, '2017-05-13 09:47:03', 1, '2017-05-13 09:47:06', '2017-10-13 09:47:08', 1),
	(5, '2017-05-13 09:47:20', 3, '2017-05-13 09:47:26', '2017-12-13 09:47:27', 1);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;

-- Дамп структуры для таблица rent_station.order_list
DROP TABLE IF EXISTS `order_list`;
CREATE TABLE IF NOT EXISTS `order_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  `equip_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_order_list_order` (`order_id`),
  KEY `FK_order_list_equipment` (`equip_id`),
  CONSTRAINT `FK_order_list_equipment` FOREIGN KEY (`equip_id`) REFERENCES `equipment` (`id`),
  CONSTRAINT `FK_order_list_order` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы rent_station.order_list: ~3 rows (приблизительно)
DELETE FROM `order_list`;
/*!40000 ALTER TABLE `order_list` DISABLE KEYS */;
INSERT INTO `order_list` (`id`, `order_id`, `equip_id`) VALUES
	(1, 4, 4),
	(2, 4, 3),
	(3, 5, 1);
/*!40000 ALTER TABLE `order_list` ENABLE KEYS */;

-- Дамп структуры для таблица rent_station.parametr_list
DROP TABLE IF EXISTS `parametr_list`;
CREATE TABLE IF NOT EXISTS `parametr_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parametr` varchar(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы rent_station.parametr_list: ~3 rows (приблизительно)
DELETE FROM `parametr_list`;
/*!40000 ALTER TABLE `parametr_list` DISABLE KEYS */;
INSERT INTO `parametr_list` (`id`, `parametr`) VALUES
	(1, 'size'),
	(2, 'growth'),
	(3, 'weight');
/*!40000 ALTER TABLE `parametr_list` ENABLE KEYS */;

-- Дамп структуры для таблица rent_station.role
DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы rent_station.role: ~2 rows (приблизительно)
DELETE FROM `role`;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `role`) VALUES
	(1, 'user'),
	(2, 'admin');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Дамп структуры для таблица rent_station.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) DEFAULT '0',
  `user` varchar(50) DEFAULT '0',
  `name` varchar(50) NOT NULL DEFAULT '0',
  `document` varchar(50) DEFAULT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_role` (`role`),
  CONSTRAINT `FK_user_role` FOREIGN KEY (`role`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы rent_station.user: ~3 rows (приблизительно)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `login`, `user`, `name`, `document`, `role`) VALUES
	(1, 'user', 'user', 'user1', NULL, 1),
	(2, 'admin', 'admin', 'admin', NULL, 2),
	(3, 'user1', 'user1', 'user_1', 'passport', 1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


-- Дамп структуры базы данных sport
DROP DATABASE IF EXISTS `sport`;
CREATE DATABASE IF NOT EXISTS `sport` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sport`;

-- Дамп структуры для таблица sport.equipment
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE IF NOT EXISTS `equipment` (
  `id_equipment` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL DEFAULT '0',
  `price` double NOT NULL,
  `type` enum('EQ','AC') NOT NULL,
  PRIMARY KEY (`id_equipment`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы sport.equipment: ~1 rows (приблизительно)
DELETE FROM `equipment`;
/*!40000 ALTER TABLE `equipment` DISABLE KEYS */;
INSERT INTO `equipment` (`id_equipment`, `title`, `price`, `type`) VALUES
	(1, 'bike', 1, 'EQ');
/*!40000 ALTER TABLE `equipment` ENABLE KEYS */;

-- Дамп структуры для таблица sport.order
DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
  `id_order` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL DEFAULT '0',
  `id_equipment` int(11) NOT NULL DEFAULT '0',
  `date_start` datetime NOT NULL,
  `date_end` datetime NOT NULL,
  `data_order` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  KEY `id_order` (`id_order`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы sport.order: ~7 rows (приблизительно)
DELETE FROM `order`;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` (`id_order`, `id_user`, `id_equipment`, `date_start`, `date_end`, `data_order`) VALUES
	(4, 2, 3, '2017-05-12 00:00:00', '2017-05-14 00:00:00', '2017-05-13 13:27:40'),
	(5, 5, 3, '2017-05-09 00:00:00', '2017-05-14 00:00:00', '2017-05-13 13:27:40'),
	(6, 3, 4, '2017-06-12 00:00:00', '2017-10-13 00:00:00', '2017-05-13 13:27:40'),
	(7, 2, 3, '2017-05-09 00:00:00', '2017-05-14 00:00:00', '2017-05-13 13:27:40'),
	(8, 1, 2, '2017-05-12 00:00:00', '2017-05-13 00:00:00', '2017-05-13 13:27:50'),
	(9, 2323, 3232, '2017-05-12 00:00:00', '2017-05-13 00:00:00', '2017-05-13 13:38:26'),
	(10, 4, 5, '2017-05-12 00:00:00', '2017-05-14 00:00:00', '2017-05-13 13:40:59');
/*!40000 ALTER TABLE `order` ENABLE KEYS */;

-- Дамп структуры для таблица sport.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `role` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы sport.user: ~2 rows (приблизительно)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id_user`, `login`, `password`, `name`, `role`) VALUES
	(1, 'user', 'user', 'User1', 0),
	(2, 'admin', 'admin', 'Admin1', 1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
