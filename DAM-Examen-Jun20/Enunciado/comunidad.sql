-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 26-05-2020 a las 07:07:12
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `comunidad`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuotas`
--

CREATE TABLE IF NOT EXISTS `cuotas` (
  `idcutoa` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `numero` int(11) NOT NULL,
  `concepto` varchar(50) NOT NULL,
  `importe` double NOT NULL,
  PRIMARY KEY (`idcutoa`),
  KEY `numero` (`numero`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `cuotas`
--

INSERT INTO `cuotas` (`idcutoa`, `fecha`, `numero`, `concepto`, `importe`) VALUES
(1, '2019-03-27', 1, 'pago mes marzo', 15),
(2, '2019-03-26', 2, 'pago cuota mes marzo', 18);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vecinos`
--

CREATE TABLE IF NOT EXISTS `vecinos` (
  `nif` varchar(15) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `direccion` varchar(35) NOT NULL,
  `poblacion` varchar(35) NOT NULL,
  `cpostal` varchar(5) NOT NULL,
  PRIMARY KEY (`nif`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vecinos`
--

INSERT INTO `vecinos` (`nif`, `nombre`, `direccion`, `poblacion`, `cpostal`) VALUES
('1', 'Ramón Sánchez Carrero', '1', '', ''),
('2', 'José Fernández López', '2', '', ''),
('3', 'Felipe Cidoncha', '3', '', ''),
('4', 'Julia Rodríguez Fernández', '0', '', ''),
('5', 'Carlos Sanz de Buroaga', '0', '', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `viviendas`
--

CREATE TABLE IF NOT EXISTS `viviendas` (
  `numero` int(6) NOT NULL AUTO_INCREMENT,
  `id_vivienda` varchar(5) NOT NULL,
  `nif` varchar(15) NOT NULL,
  `metros` int(11) NOT NULL,
  `porcentaje` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `direccion` varchar(35) NOT NULL,
  `poblacion` varchar(30) NOT NULL,
  `cpostal` varchar(5) NOT NULL,
  PRIMARY KEY (`numero`),
  UNIQUE KEY `numero` (`numero`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `viviendas`
--

INSERT INTO `viviendas` (`numero`, `id_vivienda`, `nif`, `metros`, `porcentaje`, `descripcion`, `direccion`, `poblacion`, `cpostal`) VALUES
(1, '1-1C', '1', 90, 5, 'piso 3 habitaciones,conia,baño y comedor', 'C/Juan Gómez Bravo,1', 'Mérida', '06800'),
(2, '1-4B', '2', 120, 7, '4 habitaciones,2 baños,cocina y comedor', 'C/Juan Gómez Bravo,1', 'Mérida', '06800'),
(3, '1A', '3', 95, 65, 'Bajo caa de dos plantas con patio privativo', 'Legión X', 'Mérida', '06800'),
(4, '2A', '4', 95, 35, 'Segundo piso vivienda dos plantas', 'Legión X', 'Mérida', '06800'),
(5, '2-2A', '1', 80, 3, 'Apartamento 2 habitaciones,salon, cocina,2 baños', 'C/Juan Gómez Bravo,1', 'Mérida', '06800'),
(6, '3-1D', '2', 60, 1, 'Apartamento 2 habitaciones', 'C/Juan Gómez Bravo,1', 'Mérida', '06800');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cuotas`
--
ALTER TABLE `cuotas`
  ADD CONSTRAINT `cuotas_ibfk_1` FOREIGN KEY (`numero`) REFERENCES `viviendas` (`numero`);

--
-- Filtros para la tabla `viviendas`
--
ALTER TABLE `viviendas`
  ADD CONSTRAINT `viviendas_ibfk_1` FOREIGN KEY (`numero`) REFERENCES `viviendas` (`numero`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
