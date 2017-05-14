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


-- Дамп структуры базы данных sport
CREATE DATABASE IF NOT EXISTS `sport` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sport`;

-- Дамп структуры для таблица sport.equipment
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
CREATE TABLE IF NOT EXISTS `order` (
  `id_order` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL DEFAULT '0',
  `id_equipment` int(11) NOT NULL DEFAULT '0',
  `date_start` datetime NOT NULL,
  `date_end` datetime NOT NULL,
  `data_order` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  KEY `id_order` (`id_order`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы sport.order: ~4 rows (приблизительно)
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
