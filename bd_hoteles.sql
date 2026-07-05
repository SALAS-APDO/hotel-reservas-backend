-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-06-2026 a las 03:33:45
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 5.6.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_hoteles`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administradores`
--

CREATE TABLE `administradores` (
  `id_admin` bigint(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `correo` varchar(100) NOT NULL,
  `contrasena` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `administradores`
--

INSERT INTO `administradores` (`id_admin`, `nombre`, `correo`, `contrasena`) VALUES
(1, 'Corina Montoya', 'corinam', 'corina1'),
(2, 'Juan Cisneros', 'juanc', 'juan1'),
(3, 'Admin Tres', 'admin3', 'pass3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `chatbot_preguntas`
--

CREATE TABLE `chatbot_preguntas` (
  `id` bigint(20) NOT NULL,
  `pregunta` varchar(255) NOT NULL,
  `respuesta` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `chatbot_preguntas`
--

INSERT INTO `chatbot_preguntas` (`id`, `pregunta`, `respuesta`) VALUES
(1, '¿Cuál es su horario de atención?', 'Atendemos las 24 horas del día, los 7 días de la semana.'),
(2, '¿A qué hora es el check-in y check-out?', 'El check-in es a partir de las 2:00 PM y el check-out es hasta las 11:00 AM.'),
(3, '¿Incluye desayuno la reserva?', 'Sí, todas nuestras habitaciones incluyen un desayuno buffet continental gratuito.'),
(4, '¿Tienen estacionamiento disponible?', 'Contamos con estacionamiento privado gratuito para todos nuestros huéspedes.'),
(5, '¿Aceptan mascotas?', 'Lo sentimos, no permitimos el ingreso de mascotas en nuestras instalaciones.'),
(6, '¿Cómo puedo hacer una reserva?', 'Puedes realizar tu reserva directamente a través de nuestro sitio web o llamando a nuestra recepción.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `tipo_documento` varchar(255) DEFAULT NULL,
  `numero_documento` varchar(100) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `correo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nombre`, `apellido`, `tipo_documento`, `numero_documento`, `telefono`, `correo`) VALUES
(15, 'julia', 'salas', 'DNI', '08135807', '999444222', 'julia@gmail.com'),
(16, 'juan', 'aguirre', 'DNI', '70879366', '927990393', 'juandedioscisneros30@gmail.com'),
(17, 'alfredo', 'malla', 'DNI', '40268488', '999999999', 'alfredo@gmail.com'),
(18, 'aaronchalon', 'horna', 'DNI', '70879344', '999555333', 'horna@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitaciones`
--

CREATE TABLE `habitaciones` (
  `id_habitacion` int(11) NOT NULL,
  `id_hotel` int(11) NOT NULL,
  `numero_habitacion` varchar(255) NOT NULL,
  `tipo_habitacion` varchar(255) NOT NULL,
  `capacidad_maxima` int(11) NOT NULL,
  `precio_por_noche` decimal(38,2) NOT NULL,
  `estado` varchar(25) NOT NULL DEFAULT 'DISPONIBLE'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `habitaciones`
--

INSERT INTO `habitaciones` (`id_habitacion`, `id_hotel`, `numero_habitacion`, `tipo_habitacion`, `capacidad_maxima`, `precio_por_noche`, `estado`) VALUES
(1, 1, 'S101', 'SUITE', 4, '850.00', 'DISPONIBLE'),
(2, 1, 'S102', 'SUITE', 4, '800.00', 'DISPONIBLE'),
(3, 1, 'S103', 'SUITE', 4, '800.00', 'DISPONIBLE'),
(4, 1, 'S104', 'SUITE', 4, '800.00', 'DISPONIBLE'),
(5, 1, 'M101', 'MATRIMONIAL', 2, '500.00', 'DISPONIBLE'),
(6, 1, 'M102', 'MATRIMONIAL', 2, '500.00', 'DISPONIBLE'),
(7, 1, 'M103', 'MATRIMONIAL', 2, '500.00', 'DISPONIBLE'),
(8, 1, 'M104', 'MATRIMONIAL', 2, '500.00', 'DISPONIBLE'),
(9, 1, 'M105', 'MATRIMONIAL', 2, '500.00', 'DISPONIBLE'),
(10, 1, 'M106', 'MATRIMONIAL', 2, '500.00', 'DISPONIBLE'),
(11, 1, 'T101', 'TRIPLE', 3, '700.00', 'DISPONIBLE'),
(12, 1, 'T102', 'TRIPLE', 3, '700.00', 'DISPONIBLE'),
(13, 1, 'SF101', 'SUITE FAMILIAR', 5, '950.00', 'DISPONIBLE'),
(14, 1, 'SF102', 'SUITE FAMILIAR', 5, '950.00', 'DISPONIBLE'),
(15, 1, 'SF103', 'SUITE FAMILIAR', 5, '950.00', 'DISPONIBLE'),
(16, 2, 'S201', 'SUITE', 4, '800.00', 'DISPONIBLE'),
(17, 2, 'S202', 'SUITE', 4, '800.00', 'DISPONIBLE'),
(18, 2, 'S203', 'SUITE', 4, '800.00', 'DISPONIBLE'),
(19, 2, 'S204', 'SUITE', 4, '800.00', 'DISPONIBLE'),
(20, 2, 'S205', 'SUITE', 4, '800.00', 'DISPONIBLE'),
(21, 2, 'S206', 'SUITE', 4, '800.00', 'DISPONIBLE'),
(22, 2, 'M201', 'MATRIMONIAL', 2, '500.00', 'DISPONIBLE'),
(23, 2, 'M202', 'MATRIMONIAL', 2, '500.00', 'DISPONIBLE'),
(24, 2, 'M203', 'MATRIMONIAL', 2, '500.00', 'DISPONIBLE'),
(25, 2, 'M204', 'MATRIMONIAL', 2, '500.00', 'DISPONIBLE'),
(26, 2, 'M205', 'MATRIMONIAL', 2, '500.00', 'DISPONIBLE'),
(27, 2, 'M206', 'MATRIMONIAL', 2, '500.00', 'DISPONIBLE'),
(28, 2, 'M207', 'MATRIMONIAL', 2, '500.00', 'DISPONIBLE'),
(29, 2, 'M208', 'MATRIMONIAL', 2, '500.00', 'DISPONIBLE'),
(30, 2, 'M209', 'MATRIMONIAL', 2, '500.00', 'DISPONIBLE'),
(31, 2, 'M210', 'MATRIMONIAL', 2, '500.00', 'DISPONIBLE'),
(32, 2, 'T201', 'TRIPLE', 3, '700.00', 'DISPONIBLE'),
(33, 2, 'T202', 'TRIPLE', 3, '700.00', 'DISPONIBLE'),
(34, 2, 'T203', 'TRIPLE', 3, '700.00', 'DISPONIBLE'),
(35, 2, 'T204', 'TRIPLE', 3, '700.00', 'DISPONIBLE'),
(36, 2, 'SF201', 'SUITE FAMILIAR', 5, '950.00', 'DISPONIBLE'),
(37, 2, 'SF202', 'SUITE FAMILIAR', 5, '950.00', 'DISPONIBLE'),
(38, 2, 'SF203', 'SUITE FAMILIAR', 5, '950.00', 'DISPONIBLE'),
(39, 2, 'SF204', 'SUITE FAMILIAR', 5, '950.00', 'DISPONIBLE'),
(40, 2, 'SF205', 'SUITE FAMILIAR', 5, '950.00', 'DISPONIBLE'),
(41, 3, 'S301', 'SUITE', 4, '800.00', 'DISPONIBLE'),
(42, 3, 'S302', 'SUITE', 4, '800.00', 'DISPONIBLE'),
(43, 3, 'S303', 'SUITE', 4, '800.00', 'DISPONIBLE'),
(44, 3, 'M301', 'MATRIMONIAL', 2, '500.00', 'DISPONIBLE'),
(45, 3, 'M302', 'MATRIMONIAL', 2, '500.00', 'DISPONIBLE'),
(46, 3, 'M303', 'MATRIMONIAL', 2, '500.00', 'DISPONIBLE'),
(47, 3, 'M304', 'MATRIMONIAL', 2, '500.00', 'DISPONIBLE'),
(48, 3, 'M305', 'MATRIMONIAL', 2, '500.00', 'DISPONIBLE'),
(49, 3, 'M306', 'MATRIMONIAL', 2, '500.00', 'DISPONIBLE'),
(50, 3, 'M307', 'MATRIMONIAL', 2, '500.00', 'DISPONIBLE'),
(51, 3, 'T301', 'TRIPLE', 3, '700.00', 'DISPONIBLE'),
(52, 3, 'T302', 'TRIPLE', 3, '700.00', 'DISPONIBLE'),
(53, 3, 'SF301', 'SUITE FAMILIAR', 5, '950.00', 'DISPONIBLE'),
(54, 3, 'SF302', 'SUITE FAMILIAR', 5, '950.00', 'DISPONIBLE'),
(55, 3, 'SF303', 'SUITE FAMILIAR', 5, '950.00', 'DISPONIBLE'),
(56, 3, 'SF304', 'SUITE FAMILIAR', 5, '950.00', 'DISPONIBLE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hoteles`
--

CREATE TABLE `hoteles` (
  `id_hotel` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `ciudad` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `imagen_url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hoteles`
--

INSERT INTO `hoteles` (`id_hotel`, `nombre`, `ciudad`, `direccion`, `descripcion`, `imagen_url`) VALUES
(1, 'Hotel Andes', 'Cusco', 'Calle Real 456', 'Cerca de la plaza principal', 'assets/sede-andes.jpg'),
(2, 'Hotel Luna', 'Lima', 'Av. Principal 123', 'Piscina y spa', 'assets/sede-luna.jpg'),
(3, 'Hotel Sol', 'Ica', 'Jr. Bolívar 789', 'Vistas a la Huacachina', 'assets/sede-sol.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas`
--

CREATE TABLE `reservas` (
  `id_reserva` bigint(20) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_habitacion` int(11) NOT NULL,
  `fecha_entrada` date NOT NULL,
  `fecha_salida` date NOT NULL,
  `num_adultos` int(11) NOT NULL,
  `num_ninos` int(11) NOT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `precio_total` decimal(38,2) DEFAULT NULL,
  `tipo_comprobante` varchar(255) DEFAULT NULL,
  `ruc_empresa` varchar(255) DEFAULT NULL,
  `subtotal` decimal(38,2) DEFAULT NULL,
  `igv` decimal(38,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `reservas`
--

INSERT INTO `reservas` (`id_reserva`, `id_cliente`, `id_habitacion`, `fecha_entrada`, `fecha_salida`, `num_adultos`, `num_ninos`, `estado`, `precio_total`, `tipo_comprobante`, `ruc_empresa`, `subtotal`, `igv`) VALUES
(6, 15, 8, '2026-06-28', '2026-06-29', 1, 0, 'CONFIRMADA', NULL, 'BOLETA', '', NULL, NULL),
(7, 16, 16, '2026-06-28', '2026-06-30', 1, 0, 'CONFIRMADA', NULL, 'BOLETA', NULL, NULL, NULL),
(8, 17, 2, '2026-06-29', '2026-06-30', 4, 0, 'CONFIRMADA', NULL, 'BOLETA', '', NULL, NULL),
(9, 18, 5, '2026-06-30', '2026-07-01', 1, 0, 'PENDIENTE', NULL, 'BOLETA', '', NULL, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administradores`
--
ALTER TABLE `administradores`
  ADD PRIMARY KEY (`id_admin`),
  ADD UNIQUE KEY `correo` (`correo`);

--
-- Indices de la tabla `chatbot_preguntas`
--
ALTER TABLE `chatbot_preguntas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`),
  ADD UNIQUE KEY `correo` (`correo`),
  ADD UNIQUE KEY `numero_documento` (`numero_documento`);

--
-- Indices de la tabla `habitaciones`
--
ALTER TABLE `habitaciones`
  ADD PRIMARY KEY (`id_habitacion`),
  ADD KEY `id_hotel` (`id_hotel`);

--
-- Indices de la tabla `hoteles`
--
ALTER TABLE `hoteles`
  ADD PRIMARY KEY (`id_hotel`);

--
-- Indices de la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD PRIMARY KEY (`id_reserva`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_habitacion` (`id_habitacion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administradores`
--
ALTER TABLE `administradores`
  MODIFY `id_admin` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `chatbot_preguntas`
--
ALTER TABLE `chatbot_preguntas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `habitaciones`
--
ALTER TABLE `habitaciones`
  MODIFY `id_habitacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT de la tabla `hoteles`
--
ALTER TABLE `hoteles`
  MODIFY `id_hotel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `reservas`
--
ALTER TABLE `reservas`
  MODIFY `id_reserva` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `habitaciones`
--
ALTER TABLE `habitaciones`
  ADD CONSTRAINT `habitaciones_ibfk_1` FOREIGN KEY (`id_hotel`) REFERENCES `hoteles` (`id_hotel`);

--
-- Filtros para la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD CONSTRAINT `reservas_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`),
  ADD CONSTRAINT `reservas_ibfk_2` FOREIGN KEY (`id_habitacion`) REFERENCES `habitaciones` (`id_habitacion`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
