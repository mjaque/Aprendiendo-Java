-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 07-08-2019 a las 10:18:56
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autores`
--

CREATE TABLE IF NOT EXISTS `autores` (
  `id_autor` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(35) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `poblacion` varchar(35) COLLATE utf8_spanish_ci NOT NULL,
  `nif` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_autor`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `autores`
--

INSERT INTO `autores` (`id_autor`, `Nombre`, `direccion`, `poblacion`, `nif`) VALUES
(1, 'Camilo José Cela', 'dir3', 'Madrid', '6669555N'),
(2, 'Miguel de Cervantes Saavedra', 'dir2', 'Alcalá de Henares', '6665888T'),
(3, 'Arturo Perez Reverte', 'dirección 3', 'Cadiz', '1222355'),
(4, 'Santiago Posteguillo', 'direccion 4', 'Valencia', '12225663');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `editorial`
--

CREATE TABLE IF NOT EXISTS `editorial` (
  `id_editorial` int(11) NOT NULL AUTO_INCREMENT,
  `denominacion` varchar(35) COLLATE utf8_spanish_ci NOT NULL,
  `sede` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_editorial`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `editorial`
--

INSERT INTO `editorial` (`id_editorial`, `denominacion`, `sede`) VALUES
(1, 'Planeta', 'Barcelona'),
(2, 'Santillana', 'Madrid'),
(3, 'Nadal', 'Barcelona'),
(4, 'Alfaguara', 'Madrid');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE IF NOT EXISTS `libros` (
  `id_libro` int(11) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `titulo` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `id_autor` int(11) NOT NULL,
  `id_editorial` int(11) NOT NULL,
  `tema` varchar(35) COLLATE utf8_spanish_ci NOT NULL,
  `prestado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_libro`),
  KEY `id_editorial` (`id_editorial`),
  KEY `id_autor` (`id_autor`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`id_libro`, `isbn`, `titulo`, `id_autor`, `id_editorial`, `tema`, `prestado`) VALUES
(1, '1', 'La Colmena', 1, 1, 'novela', 0),
(2, '2', 'D. Quijote de la Mancha', 2, 2, 'caballerias', 0),
(3, '1225566', 'La Carta Esférica', 3, 3, 'Novela', 0),
(4, '225566448', 'El Africanus', 4, 2, 'Novela histórica', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamos`
--

CREATE TABLE IF NOT EXISTS `prestamos` (
  `id_prestamo` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `id_libro` int(11) NOT NULL,
  `id_socio` int(11) NOT NULL,
  `devuelto` int(11) NOT NULL,
  `fecha_devolucion` date NOT NULL,
  PRIMARY KEY (`id_prestamo`),
  KEY `id_libro` (`id_libro`,`id_socio`),
  KEY `id_socio` (`id_socio`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `prestamos`
--

INSERT INTO `prestamos` (`id_prestamo`, `fecha`, `id_libro`, `id_socio`, `devuelto`, `fecha_devolucion`) VALUES
(1, '2018-06-06', 1, 1, 1, '2018-06-14'),
(2, '2018-06-06', 2, 3, 1, '2018-06-12'),
(3, '2018-06-14', 2, 6, 1, '2018-06-17');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socio`
--

CREATE TABLE IF NOT EXISTS `socio` (
  `id_socio` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(35) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `poblacion` varchar(35) COLLATE utf8_spanish_ci NOT NULL,
  `nif` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_alta` date NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  PRIMARY KEY (`id_socio`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `socio`
--

INSERT INTO `socio` (`id_socio`, `nombre`, `direccion`, `poblacion`, `nif`, `fecha_alta`, `fecha_nacimiento`) VALUES
(1, 'Ramón Sánchez Carrero', 'dir1', 'Mérida', '6996999N', '2018-03-07', '2015-04-28'),
(2, 'Diego Sánchez Barrera', 'dir2', 'Cáceres', '665888T', '2018-05-02', '2009-05-08'),
(3, 'Asunción Carrero Fernández', 'dir3', 'Guareña', '555699T', '2018-05-01', '2005-05-07'),
(4, 'Josefa Fernández Rodríguez', 'dir4', 'Mérida', '665666T', '2018-05-07', '1968-05-07'),
(5, 'Fernandez Barquilla', 'dir fer', 'f11111', 'Fernandez', '2018-06-06', '2018-06-04'),
(6, 'Correas Gonzlaez', 'dir correas', 'f111222', '222222c', '2018-06-05', '2018-06-06'),
(7, 'Garcia Perez', 'dir', 'null', '333333ddd', '2018-06-06', '2018-06-06'),
(8, 'Haro Solera', 'dir haro', 'merida', '4444ddd', '2018-06-06', '2018-06-06'),
(9, 'WenHong', 'd', 'China', '2233ee', '2018-06-06', '2018-06-06');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `libros`
--
ALTER TABLE `libros`
  ADD CONSTRAINT `libros_ibfk_1` FOREIGN KEY (`id_autor`) REFERENCES `autores` (`id_autor`),
  ADD CONSTRAINT `libros_ibfk_2` FOREIGN KEY (`id_editorial`) REFERENCES `editorial` (`id_editorial`);

--
-- Filtros para la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD CONSTRAINT `prestamos_ibfk_1` FOREIGN KEY (`id_libro`) REFERENCES `libros` (`id_libro`),
  ADD CONSTRAINT `prestamos_ibfk_2` FOREIGN KEY (`id_socio`) REFERENCES `socio` (`id_socio`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
