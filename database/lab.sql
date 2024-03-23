-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 23, 2024 at 11:10 AM
-- Server version: 8.2.0
-- PHP Version: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lab`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctor_list`
--

DROP TABLE IF EXISTS `doctor_list`;
CREATE TABLE IF NOT EXISTS `doctor_list` (
  `id` int NOT NULL AUTO_INCREMENT,
  `doctor_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `email` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `specialization` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `experience_year` int DEFAULT '0',
  `lk_id` int DEFAULT NULL,
  `phone_no` int DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `lab_booking`
--

DROP TABLE IF EXISTS `lab_booking`;
CREATE TABLE IF NOT EXISTS `lab_booking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lab_test` varchar(255) DEFAULT NULL,
  `doctor_name` varchar(255) DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `lab_test`
--

DROP TABLE IF EXISTS `lab_test`;
CREATE TABLE IF NOT EXISTS `lab_test` (
  `id` int NOT NULL AUTO_INCREMENT,
  `test_id` varchar(255) DEFAULT NULL,
  `test_name` varchar(255) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `lab_test_register`
--

DROP TABLE IF EXISTS `lab_test_register`;
CREATE TABLE IF NOT EXISTS `lab_test_register` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patient_name` varchar(255) DEFAULT NULL,
  `doctor_name` varchar(255) DEFAULT NULL,
  `test_type` varchar(255) DEFAULT NULL,
  `test_sample_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `lab_test_result`
--

DROP TABLE IF EXISTS `lab_test_result`;
CREATE TABLE IF NOT EXISTS `lab_test_result` (
  `id` int NOT NULL AUTO_INCREMENT,
  `LabRegister_ID` int DEFAULT NULL,
  `patientName` varchar(255) DEFAULT NULL,
  `result` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(191) DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nic` varchar(12) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `role` enum('admin','patient','guest') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `email`, `nic`, `password`, `role`) VALUES
(1, 'narkis', 'narkismunassaj@gmail.com', '200172502823', '123', 'admin'),
(2, 'muna', 'kis@gmail.com', '25365', '123', 'patient'),
(10, 'muna', 'qq152q@gmail.com', '13221212', '1235', 'patient'),
(4, 'muna', 'amrishabrar13@gmail.com', '200172502823', '1234', 'patient'),
(5, 'munassa', 'amrus@gmail.com', '200172502', '1234', 'patient'),
(6, 'jack', 'munhd@gmail.com', '215212', '12345', 'patient'),
(7, 'muna', 'asshhh@gmail.com', '222', '222', 'patient'),
(8, 'narkis ', 'qwe@gmail.com', '13221212', '789', 'patient'),
(9, 'kis', 'qqq@gmail.com', '3154221212', '456', 'patient'),
(11, 'muna', 'aaaaaa@gmail.com', '200172502823', '123', 'patient');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
