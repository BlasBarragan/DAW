-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 25, 2018 at 07:57 
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotels`
--

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `idClient` int(11) NOT NULL,
  `nomClient` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `cognomClient` varchar(20) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `dirClient` varchar(25) COLLATE utf8_spanish2_ci NOT NULL,
  `cpostalClient` varchar(5) COLLATE utf8_spanish2_ci NOT NULL,
  `pobClient` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `provClient` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `tfnoClient` varchar(20) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`idClient`, `nomClient`, `cognomClient`, `dirClient`, `cpostalClient`, `pobClient`, `provClient`, `tfnoClient`) VALUES
(1, 'sfsadf', 'sfsf', 'sdfsf', '13212', 'sfsdfsdf', 'sdfsdf', 'sdfsdf'),
(2, '234234', '45646', '456456', '45666', '666', '666', '666');

-- --------------------------------------------------------

--
-- Table structure for table `habitacio`
--

CREATE TABLE `habitacio` (
  `idHotel` int(11) NOT NULL,
  `idHabitacio` int(11) NOT NULL,
  `planta` tinyint(4) NOT NULL,
  `llits` tinyint(4) NOT NULL,
  `preu` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Dumping data for table `habitacio`
--

INSERT INTO `habitacio` (`idHotel`, `idHabitacio`, `planta`, `llits`, `preu`) VALUES
(1, 1, 1, 2, 50),
(1, 2, 1, 1, 100),
(2, 1, 1, 1, 11);

-- --------------------------------------------------------

--
-- Table structure for table `hotel`
--

CREATE TABLE `hotel` (
  `idHotel` int(11) NOT NULL,
  `nomHotel` varchar(25) COLLATE utf8_spanish2_ci NOT NULL,
  `dirHotel` varchar(25) COLLATE utf8_spanish2_ci NOT NULL,
  `cpostalHotel` varchar(5) COLLATE utf8_spanish2_ci NOT NULL,
  `pobHotel` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `provHotel` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `tfnoHotel` varchar(16) COLLATE utf8_spanish2_ci NOT NULL,
  `catHotel` enum('1','2','3') COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Dumping data for table `hotel`
--

INSERT INTO `hotel` (`idHotel`, `nomHotel`, `dirHotel`, `cpostalHotel`, `pobHotel`, `provHotel`, `tfnoHotel`, `catHotel`) VALUES
(1, 'Les Palmeres', 'C/ La Pau', '46410', 'Sueca', 'Valencia', '97324234', '3'),
(2, 'Sicani', 'sdfsdf', '46666', 'Cullera', 'Valencia', '', '2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idClient`);

--
-- Indexes for table `habitacio`
--
ALTER TABLE `habitacio`
  ADD PRIMARY KEY (`idHotel`,`idHabitacio`);

--
-- Indexes for table `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`idHotel`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `idClient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `hotel`
--
ALTER TABLE `hotel`
  MODIFY `idHotel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `habitacio`
--
ALTER TABLE `habitacio`
  ADD CONSTRAINT `habitacio_ibfk_1` FOREIGN KEY (`idHotel`) REFERENCES `hotel` (`idHotel`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
