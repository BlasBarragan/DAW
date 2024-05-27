-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Temps de generació: 12-04-2018 a les 18:47:29
-- Versió del servidor: 10.1.21-MariaDB
-- Versió de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de dades: `institut`
--

-- --------------------------------------------------------

--
-- Estructura de la taula `alumne`
--

CREATE TABLE `alumne` (
  `idAlumne` int(11) NOT NULL,
  `nomAlumne` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `pobAlumne` varchar(25) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Bolcant dades de la taula `alumne`
--

INSERT INTO `alumne` (`idAlumne`, `nomAlumne`, `pobAlumne`) VALUES
(1, 'Alumne 1', 'Algemesi'),
(2, 'Alumne 2', 'Sueca'),
(3, 'Alumne 3', 'Sueca'),
(4, 'Alumne 4', 'Algemesi'),
(5, 'Alumne 5', 'Alzira'),
(6, 'Alumne 6', 'Albalat'),
(7, 'Alumne 7', 'Carlet'),
(8, 'Alumne 8', 'Guadassuar'),
(9, 'Alumne 9', 'Alzira'),
(10, 'Alumne 10', 'Benimodo');

-- --------------------------------------------------------

--
-- Estructura de la taula `matricula`
--

CREATE TABLE `matricula` (
  `idMatricula` int(11) NOT NULL,
  `idAlumne` int(11) NOT NULL,
  `idModul` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Bolcant dades de la taula `matricula`
--

INSERT INTO `matricula` (`idMatricula`, `idAlumne`, `idModul`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 2, 2),
(6, 2, 3),
(7, 3, 3),
(8, 3, 5),
(9, 3, 7),
(10, 4, 5),
(11, 4, 7),
(12, 4, 8),
(13, 5, 5),
(14, 5, 6),
(15, 5, 7),
(16, 5, 8);

-- --------------------------------------------------------

--
-- Estructura de la taula `modul`
--

CREATE TABLE `modul` (
  `idModul` int(11) NOT NULL,
  `nomModul` varchar(25) COLLATE utf8_spanish2_ci NOT NULL,
  `abrModul` varchar(5) COLLATE utf8_spanish2_ci NOT NULL,
  `curs` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Bolcant dades de la taula `modul`
--

INSERT INTO `modul` (`idModul`, `nomModul`, `abrModul`, `curs`) VALUES
(1, 'Programacio', 'PROG', 1),
(2, 'Bases dades', 'BBDD', 1),
(3, 'Llenguatge marques', 'LMG', 1),
(4, 'Sistemes', 'SI', 1),
(5, 'Web client', 'WC', 2),
(6, 'Web servidor', 'WS', 2),
(7, 'Interficies Web', 'DI', 2),
(8, 'Despliegue', 'DW', 2);

--
-- Indexos per taules bolcades
--

--
-- Index de la taula `alumne`
--
ALTER TABLE `alumne`
  ADD PRIMARY KEY (`idAlumne`);

--
-- Index de la taula `matricula`
--
ALTER TABLE `matricula`
  ADD PRIMARY KEY (`idMatricula`),
  ADD KEY `idAlumne` (`idAlumne`),
  ADD KEY `idModul` (`idModul`);

--
-- Index de la taula `modul`
--
ALTER TABLE `modul`
  ADD PRIMARY KEY (`idModul`);

--
-- AUTO_INCREMENT per les taules bolcades
--

--
-- AUTO_INCREMENT per la taula `alumne`
--
ALTER TABLE `alumne`
  MODIFY `idAlumne` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT per la taula `matricula`
--
ALTER TABLE `matricula`
  MODIFY `idMatricula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT per la taula `modul`
--
ALTER TABLE `modul`
  MODIFY `idModul` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- Restriccions per taules bolcades
--

--
-- Restriccions per la taula `matricula`
--
ALTER TABLE `matricula`
  ADD CONSTRAINT `matricula_ibfk_1` FOREIGN KEY (`idAlumne`) REFERENCES `alumne` (`idAlumne`),
  ADD CONSTRAINT `matricula_ibfk_2` FOREIGN KEY (`idModul`) REFERENCES `modul` (`idModul`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
