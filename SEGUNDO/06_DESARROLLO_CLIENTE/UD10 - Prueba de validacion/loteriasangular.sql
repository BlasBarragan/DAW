-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 23-01-2025 a las 16:51:59
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `loteriasangular`
--
CREATE DATABASE IF NOT EXISTS `loteriasangular` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci;
USE `loteriasangular`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `premis`
--

CREATE TABLE `premis` (
  `ident` int(11) NOT NULL,
  `ident-sorteig` int(11) NOT NULL,
  `nom` varchar(80) NOT NULL,
  `numero` int(11) NOT NULL,
  `quantitat-total` bigint(25) NOT NULL,
  `quantitat-decim` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `premis`
--

INSERT INTO `premis` (`ident`, `ident-sorteig`, `nom`, `numero`, `quantitat-total`, `quantitat-decim`) VALUES
(123, 1, '1r premi', 11111, 40000000, 400000),
(124, 1, '2n premi', 12345, 200000000, 200000),
(125, 1, '3r premi(1)', 23456, 100000000, 1000000),
(126, 1, '3r premi(2)', 78788, 100000000, 1000000),
(127, 1, 'reintegre(1)', 78999, 2000, 20),
(128, 1, 'reintegre(2)', 45454, 2000, 20),
(133, 2, '1r premi', 22222, 200000000, 200000),
(134, 2, '2n premi', 25252, 1000000, 100000),
(135, 2, '3r premi', 45544, 2000000, 20000),
(136, 2, 'reintegre', 58784, 2000, 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sorteig`
--

CREATE TABLE `sorteig` (
  `identificador` int(11) NOT NULL,
  `data` date NOT NULL,
  `nom` varchar(50) NOT NULL,
  `descripcio` text NOT NULL,
  `foto-ruta` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `sorteig`
--

INSERT INTO `sorteig` (`identificador`, `data`, `nom`, `descripcio`, `foto-ruta`) VALUES
(1, '2025-01-06', 'Sorteig del xiquet', 'sorteig tradicional del xiquet realitzat el dia 6 de gener des de ...', './foto/2025-01-05-portada.png'),
(2, '2024-12-22', 'sorteig de nadal', 'sorteig de nadal del 2024', 'foto/2024-12-22.png'),
(3, '2025-02-15', 'soteig extraordinari enamorats', 'soteig extraordinari enamorats', 'foto.png'),
(4, '2025-03-15', 'soteig extraordinari falles', 'soteig extraordinari falles', 'foto.png'),
(6, '2025-03-07', 'sorteig 7 març 2025', 'sorteig 7 març 2025', 'foto.png'),
(8, '2025-03-14', 'sorteig 8 març 2025', 'sorteig 8 març 2025', 'foto.png'),
(11, '2025-03-22', 'sorteig 22 març 2025', 'sorteig 22 març 2025', 'foto.png'),
(12, '2025-03-29', 'sorteig 29 març 2025', 'sorteig 29 març 2025', 'foto.png');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `premis`
--
ALTER TABLE `premis`
  ADD PRIMARY KEY (`ident`);

--
-- Indices de la tabla `sorteig`
--
ALTER TABLE `sorteig`
  ADD PRIMARY KEY (`identificador`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
