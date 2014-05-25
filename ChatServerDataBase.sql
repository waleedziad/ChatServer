-- phpMyAdmin SQL Dump
-- version 4.0.3
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 25, 2014 at 02:46 PM
-- Server version: 5.6.11-log
-- PHP Version: 5.5.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `chatserver`
--
CREATE DATABASE IF NOT EXISTS `chatserver` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `chatserver`;

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE IF NOT EXISTS `message` (
  `MessageContent` varchar(1000) NOT NULL,
  `RoomID` int(11) NOT NULL,
  `UserID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE IF NOT EXISTS `room` (
  `RoomID` int(11) NOT NULL,
  `RoomName` varchar(200) NOT NULL,
  `RoomAdminID` int(11) NOT NULL,
  PRIMARY KEY (`RoomID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `UserID` int(11) NOT NULL,
  `UserName` varchar(200) NOT NULL,
  `RoomID` int(11) NOT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
