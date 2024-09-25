-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 28-05-2019 a las 08:45:28
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `alquiler_vehiculos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
  `nif` varchar(10) NOT NULL,
  `nombre` varchar(35) NOT NULL,
  `direccion` varchar(35) NOT NULL,
  `poblacion` varchar(40) NOT NULL,
  `cpostal` varchar(6) NOT NULL,
  `email` varchar(25) NOT NULL,
  UNIQUE KEY `nif` (`nif`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`nif`, `nombre`, `direccion`, `poblacion`, `cpostal`, `email`) VALUES
('6695825R', 'Sánchez Carrero,Ramón ', 'C/Primera,23', 'Mérida', '06800', 'sanchezcarrero@gmail.com'),
('7885955F', 'Fernández López,Guadalupe', 'C/Segunda,24', 'Guareña', '08600', 'fernandezlopez@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `coches`
--

CREATE TABLE IF NOT EXISTS `coches` (
  `matricula` varchar(7) NOT NULL,
  `descripcion` varchar(30) NOT NULL,
  `klm` int(11) NOT NULL,
  `marca` varchar(15) NOT NULL,
  `combustible` varchar(1) NOT NULL,
  `ocupado` int(11) NOT NULL,
  `precio` int(11) NOT NULL,
  UNIQUE KEY `matricula` (`matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `coches`
--

INSERT INTO `coches` (`matricula`, `descripcion`, `klm`, `marca`, `combustible`, `ocupado`, `precio`) VALUES
('2553KKL', 'ranchera 7 plazas', 25032, 'BMW', 'd', 0, 85),
('4452KJL', 'Monovolumen de color negro', 35600, 'Mercedes', 'd', 0, 105);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicios`
--

CREATE TABLE IF NOT EXISTS `servicios` (
  `id_servicio` int(11) NOT NULL AUTO_INCREMENT,
  `nif` varchar(10) NOT NULL,
  `matricula` varchar(7) NOT NULL,
  `fecha_alquiler` date NOT NULL,
  `fecha_entrega` date NOT NULL,
  `total_precio` int(11) NOT NULL,
  PRIMARY KEY (`id_servicio`),
  UNIQUE KEY `id_servicio` (`id_servicio`),
  KEY `nif` (`nif`,`matricula`),
  KEY `matricula` (`matricula`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `servicios`
--

INSERT INTO `servicios` (`id_servicio`, `nif`, `matricula`, `fecha_alquiler`, `fecha_entrega`, `total_precio`) VALUES
(1, '6695825R', '2553KKL', '2019-05-01', '2019-05-04', 340),
(2, '7885955F', '4452KJL', '2019-05-07', '2019-05-14', 735);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `servicios`
--
ALTER TABLE `servicios`
  ADD CONSTRAINT `servicios_ibfk_1` FOREIGN KEY (`nif`) REFERENCES `clientes` (`nif`),
  ADD CONSTRAINT `servicios_ibfk_2` FOREIGN KEY (`matricula`) REFERENCES `coches` (`matricula`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
