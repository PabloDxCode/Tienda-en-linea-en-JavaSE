-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-09-2015 a las 05:53:20
-- Versión del servidor: 5.6.16
-- Versión de PHP: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `electronicos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bitacora_login`
--

CREATE TABLE IF NOT EXISTS `bitacora_login` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `operacion` varchar(10) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `modificado` datetime NOT NULL,
  `tabla` varchar(50) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `bitacora_login`
--

INSERT INTO `bitacora_login` (`codigo`, `operacion`, `usuario`, `modificado`, `tabla`) VALUES
(1, 'Insertar', 'root@localhost', '2014-11-05 13:24:07', 'login'),
(2, 'Eliminar', 'root@localhost', '2014-11-05 13:24:14', 'login'),
(3, 'Actualizar', 'root@localhost', '2014-11-05 13:24:44', 'login'),
(4, 'Actualizar', 'root@localhost', '2014-11-09 01:59:39', 'login');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bitacora_producto`
--

CREATE TABLE IF NOT EXISTS `bitacora_producto` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `operacion` varchar(10) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `modificado` datetime NOT NULL,
  `tabla` varchar(50) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `bitacora_producto`
--

INSERT INTO `bitacora_producto` (`codigo`, `operacion`, `usuario`, `modificado`, `tabla`) VALUES
(1, 'Actualizar', 'root@localhost', '2014-11-08 20:01:52', 'productos'),
(2, 'Actualizar', 'root@localhost', '2014-11-08 20:02:02', 'productos'),
(3, 'Actualizar', 'root@localhost', '2014-11-08 20:02:07', 'productos'),
(4, 'Insertar', 'root@localhost', '2014-11-08 20:07:58', 'productos'),
(5, 'Eliminar', 'root@localhost', '2014-11-08 20:08:07', 'productos'),
(6, 'Actualizar', 'root@localhost', '2015-05-31 18:57:26', 'productos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL,
  `contraseña` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuario_UNIQUE` (`usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `login`
--

INSERT INTO `login` (`id`, `usuario`, `contraseña`) VALUES
(1, 'Pablo', 'pablo'),
(3, 'Uriel', '1234');

--
-- Disparadores `login`
--
DROP TRIGGER IF EXISTS `bitacoraActualizarL`;
DELIMITER //
CREATE TRIGGER `bitacoraActualizarL` AFTER UPDATE ON `login`
 FOR EACH ROW INSERT INTO bitacora_login(`usuario`, `operacion`, `modificado`, `tabla`) 
VALUES (current_user(), 'Actualizar', NOW(), 'login')
//
DELIMITER ;
DROP TRIGGER IF EXISTS `bitacoraBorrarL`;
DELIMITER //
CREATE TRIGGER `bitacoraBorrarL` AFTER DELETE ON `login`
 FOR EACH ROW INSERT INTO bitacora_login(`usuario`, `operacion`, `modificado`, `tabla`) 
VALUES (current_user(), 'Eliminar', NOW(), 'login')
//
DELIMITER ;
DROP TRIGGER IF EXISTS `bitacoraInsertarL`;
DELIMITER //
CREATE TRIGGER `bitacoraInsertarL` AFTER INSERT ON `login`
 FOR EACH ROW INSERT INTO bitacora_login(`usuario`, `operacion`, `modificado`, `tabla`) 
VALUES (current_user(), 'Insertar', NOW(), 'login')
//
DELIMITER ;
DROP TRIGGER IF EXISTS `loginActualizado`;
DELIMITER //
CREATE TRIGGER `loginActualizado` BEFORE UPDATE ON `login`
 FOR EACH ROW begin
set @datouno ='Se ha actualiazdo un dato';
end
//
DELIMITER ;
DROP TRIGGER IF EXISTS `loginBorrado`;
DELIMITER //
CREATE TRIGGER `loginBorrado` BEFORE DELETE ON `login`
 FOR EACH ROW begin
set @datodos = 'Se ha elimidado un dato';
end
//
DELIMITER ;
DROP TRIGGER IF EXISTS `loginInsertado`;
DELIMITER //
CREATE TRIGGER `loginInsertado` BEFORE INSERT ON `login`
 FOR EACH ROW begin
set @datouno = 'Se ha insertado un nuevo dato';
end
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nfolio`
--

CREATE TABLE IF NOT EXISTS `nfolio` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `folio` int(11) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `nfolio`
--

INSERT INTO `nfolio` (`codigo`, `folio`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE IF NOT EXISTS `productos` (
  `codigo` int(11) NOT NULL,
  `articulo` varchar(55) NOT NULL,
  `Categoria` varchar(35) NOT NULL,
  `precio` double NOT NULL,
  `imagen` varchar(20) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`codigo`, `articulo`, `Categoria`, `precio`, `imagen`) VALUES
(1, 'Tablet HP 8GB RAM', 'Celulares, camaras y relojes', 3500, '/imagenes/1.png'),
(2, 'Funda de celular', 'Celulares, camaras y relojes', 80, '/imagenes/2.png'),
(3, 'XPERIA Sony', 'Celulares, camaras y relojes', 2000, '/imagenes/3.png'),
(4, 'Iphone', 'Celulares, camaras y relojes', 9000, '/imagenes/4.png'),
(5, 'Camara profesional', 'Celulares, camaras y relojes', 6000, '/imagenes/5.png'),
(6, 'Camara de video', 'Celulares, camaras y relojes', 2500, '/imagenes/6.png'),
(7, 'Reloj digital', 'Celulares, camaras y relojes', 300, '/imagenes/7.png'),
(8, 'Computadora de escritorio Acer 8GB Ram 2TB Core i7', 'Computadoras', 8000, '/imagenes/8.png'),
(9, 'LapTop HP 4GB Ram 2TB DD Core i5', 'Computadoras', 9000, '/imagenes/9.png'),
(10, 'Laptop Acer 4GB Ram 1TB DD Core i3', 'Computadoras', 8000, '/imagenes/10.png'),
(11, 'LapTop AlienWare 8GB Ram 2TB DD Core i7', 'Computadoras', 16000, '/imagenes/11.png'),
(12, 'LapTop Toshiba  4GB Ram 500GB DD Intel insade', 'Computadoras', 6800, '/imagenes/12.png'),
(13, 'Mouse hp', 'Computadoras', 500, '/imagenes/13.png'),
(14, 'Mouse Dell', 'Computadoras', 400, '/imagenes/14.png'),
(15, 'Camara web HD', 'Computadoras', 200, '/imagenes/15.png'),
(16, 'Camara web', 'Computadoras', 150, '/imagenes/16.png'),
(17, 'Teclado inalambrico', 'Computadoras', 300, '/imagenes/17.png'),
(18, 'Impresora y scaner HP', 'Computadoras', 1900, '/imagenes/18.png'),
(19, 'DD 2TB puerto 3.0', 'Computadoras', 1600, '/imagenes/19.png'),
(20, 'USB Kingston 8', 'Computadoras', 110, '/imagenes/20.png'),
(21, 'USB Kingston 16GB', 'Dispositivos GPS', 180, '/imagenes/21.png'),
(22, 'Dispositivo GPS Acer', 'Dispositivos GPS', 900, '/imagenes/22.png'),
(23, 'Dispositivo GPS Dell', 'Dispositivos GPS', 750, '/imagenes/23.png'),
(24, 'Estereo Sony 2 bosinas con amplificador', 'Reproductores e instrumentos', 4000, '/imagenes/24.png'),
(25, 'Mini Componente Sony 6 bosinas', 'Reproductores e instrumentos', 2500, '/imagenes/25.png'),
(26, 'Estero 4 mini bosinas', 'Reproductores e instrumentos', 1200, '/imagenes/26.png'),
(27, 'Bosina con amplificador', 'Reproductores e instrumentos', 1100, '/imagenes/27.png'),
(28, 'Reproductor mp3 4GB', 'Reproductores e instrumentos', 400, '/imagenes/28.png'),
(29, 'Auto estereo Pionner', 'Reproductores e instrumentos', 1600, '/imagenes/29.png'),
(30, 'DVD Sony', 'Reproductores e instrumentos', 1200, '/imagenes/30.png'),
(31, 'Video casetera Maxell', 'Reproductores e instrumentos', 700, '/imagenes/31.png'),
(32, 'Guitarra Electrica', 'Reproductores e instrumentos', 4500, '/imagenes/32.png'),
(33, 'Guitarra electrica simple', 'Reproductores e instrumentos', 4000, '/imagenes/33.png'),
(34, 'Teclado electronico', 'Reproductores e instrumentos', 3500, '/imagenes/34.png'),
(35, 'Juego de bateria y guitarra', 'Reproductores e instrumentos', 4000, '/imagenes/35.png'),
(36, 'Teclado electronico simple', 'Reproductores e instrumentos', 2500, '/imagenes/36.png'),
(37, 'Audifonos beats', 'Reproductores e instrumentos', 900, '/imagenes/37.png'),
(38, 'Audifonos EARBUDS', 'Reproductores e instrumentos', 300, '/imagenes/38.png'),
(39, 'Televisor pantalla plana LCD 42pulg Sony', 'Televisores', 14000, '/imagenes/39.png'),
(40, 'Televisor pantalla plana Plasma 50pulg LG', 'Televisores', 10000, '/imagenes/40.png'),
(41, 'PSP VITA con fifa 14', 'Videojuegos', 2600, '/imagenes/41.png'),
(42, 'Wii U con Mario galaxy', 'Videojuegos', 2800, '/imagenes/42.png'),
(43, 'Play Station 3 200 GB DD', 'Videojuegos', 3000, '/imagenes/43.png'),
(44, 'Consola de videojuegos PS4', 'Videojuegos', 6000, '/imagenes/44.png'),
(45, 'XBOX 360 ELite 200GB DD', 'Videojuegos', 4000, '/imagenes/45.png'),
(46, 'XBOX 360 EDICION HALO 4', 'Videojuegos', 5000, '/imagenes/46.png');

--
-- Disparadores `productos`
--
DROP TRIGGER IF EXISTS `bitacoraActualizarP`;
DELIMITER //
CREATE TRIGGER `bitacoraActualizarP` AFTER UPDATE ON `productos`
 FOR EACH ROW INSERT INTO bitacora_producto(`usuario`, `operacion`, `modificado`, `tabla`) 
VALUES (current_user(), 'Actualizar', NOW(), 'productos')
//
DELIMITER ;
DROP TRIGGER IF EXISTS `bitacoraBorrarP`;
DELIMITER //
CREATE TRIGGER `bitacoraBorrarP` AFTER DELETE ON `productos`
 FOR EACH ROW INSERT INTO bitacora_producto(`usuario`, `operacion`, `modificado`, `tabla`) 
VALUES (current_user(), 'Eliminar', NOW(), 'productos')
//
DELIMITER ;
DROP TRIGGER IF EXISTS `bitacoraInsertarP`;
DELIMITER //
CREATE TRIGGER `bitacoraInsertarP` AFTER INSERT ON `productos`
 FOR EACH ROW INSERT INTO bitacora_producto(`usuario`, `operacion`, `modificado`, `tabla`) 
VALUES (current_user(), 'Insertar', NOW(), 'productos')
//
DELIMITER ;
DROP TRIGGER IF EXISTS `datoBorrado`;
DELIMITER //
CREATE TRIGGER `datoBorrado` BEFORE DELETE ON `productos`
 FOR EACH ROW begin
set @datoDos = 'Se ha elimidado un dato';
end
//
DELIMITER ;
DROP TRIGGER IF EXISTS `datoInsertado`;
DELIMITER //
CREATE TRIGGER `datoInsertado` BEFORE INSERT ON `productos`
 FOR EACH ROW begin
set @dato = 'Se ha insertado un nuevo dato';
end
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos_has_venta`
--

CREATE TABLE IF NOT EXISTS `productos_has_venta` (
  `Productos_codigo` int(11) NOT NULL,
  `Venta_codigo` int(11) NOT NULL,
  PRIMARY KEY (`Productos_codigo`,`Venta_codigo`),
  KEY `fk_Productos_has_Venta_Venta1_idx` (`Venta_codigo`),
  KEY `fk_Productos_has_Venta_Productos_idx` (`Productos_codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `productos_has_venta`
--

INSERT INTO `productos_has_venta` (`Productos_codigo`, `Venta_codigo`) VALUES
(2, 1),
(40, 2),
(9, 3),
(1, 4),
(40, 5),
(46, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE IF NOT EXISTS `venta` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `folio` int(11) NOT NULL,
  `producto` varchar(55) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `costo` int(11) NOT NULL,
  `costoTotal` int(11) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`codigo`, `folio`, `producto`, `cantidad`, `costo`, `costoTotal`) VALUES
(1, 1, 'Funda de celular', 2, 80, 160),
(2, 1, 'Televisor pantalla plana Plasma 50pulg LG', 1, 10000, 10000),
(3, 1, 'LapTop HP 4GB Ram 2TB DD Core i5', 2, 9000, 18000),
(4, 3, 'Tablet HP 8GB RAM', 1, 3500, 3500),
(5, 3, 'Televisor pantalla plana Plasma 50pulg LG', 1, 10000, 10000),
(6, 3, 'XBOX 360 EDICION HALO 4', 1, 5000, 5000);

--
-- Disparadores `venta`
--
DROP TRIGGER IF EXISTS `ventaActualizado`;
DELIMITER //
CREATE TRIGGER `ventaActualizado` BEFORE UPDATE ON `venta`
 FOR EACH ROW begin
set @ventauno ='Se ha actualiazdo un dato';
end
//
DELIMITER ;
DROP TRIGGER IF EXISTS `ventaBorrado`;
DELIMITER //
CREATE TRIGGER `ventaBorrado` BEFORE DELETE ON `venta`
 FOR EACH ROW begin
set @ventados = 'Se ha elimidado un dato';
end
//
DELIMITER ;
DROP TRIGGER IF EXISTS `ventaInsertado`;
DELIMITER //
CREATE TRIGGER `ventaInsertado` BEFORE INSERT ON `venta`
 FOR EACH ROW begin
set @ventauno = 'Se ha insertado un nuevo dato';
end
//
DELIMITER ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `productos_has_venta`
--
ALTER TABLE `productos_has_venta`
  ADD CONSTRAINT `fk_Productos_has_Venta_Productos` FOREIGN KEY (`Productos_codigo`) REFERENCES `productos` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Productos_has_Venta_Venta1` FOREIGN KEY (`Venta_codigo`) REFERENCES `venta` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
