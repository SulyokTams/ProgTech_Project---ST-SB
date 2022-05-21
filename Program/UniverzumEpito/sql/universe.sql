-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2022. Máj 22. 01:45
-- Kiszolgáló verziója: 10.4.22-MariaDB
-- PHP verzió: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `universe`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `galaxies`
--

CREATE TABLE `galaxies` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `diameter` int(20) NOT NULL,
  `mass` varchar(30) NOT NULL,
  `numberOfStars` varchar(30) NOT NULL,
  `universe_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `galaxies`
--

INSERT INTO `galaxies` (`id`, `name`, `diameter`, `mass`, `numberOfStars`, `universe_id`) VALUES
(1, 'andromeda', 2000, '3333', '21321', 1),
(2, 'Milky Way', 100000, '150', '100', 1),
(5, 'Galax', 12312, '213213', '12312', 1);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `planets`
--

CREATE TABLE `planets` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `diameter` int(20) NOT NULL,
  `mass` varchar(20) NOT NULL,
  `orbitalPeriod` int(20) NOT NULL,
  `universe_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `planets`
--

INSERT INTO `planets` (`id`, `name`, `diameter`, `mass`, `orbitalPeriod`, `universe_id`) VALUES
(1, 'Earth', 12756, '2400000', 1, 1),
(2, 'Venus', 12000, '12321213521', 1, 1),
(4, 'Mars', 123123, '12321', 123123, 2);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `stars`
--

CREATE TABLE `stars` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `diameter` varchar(30) NOT NULL,
  `mass` varchar(30) NOT NULL,
  `brightness` varchar(30) NOT NULL,
  `universe_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `stars`
--

INSERT INTO `stars` (`id`, `name`, `diameter`, `mass`, `brightness`, `universe_id`) VALUES
(1, 'Alpha Centuri', '2000000', '2200000', '2000', 1),
(2, 'Sun', '1300000', '222222', '222', 1),
(3, 'Aurum', '12421', '214214', '124124', 1);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `universes`
--

CREATE TABLE `universes` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `universes`
--

INSERT INTO `universes` (`id`, `name`, `user_id`) VALUES
(1, 'unione', 2),
(2, 'universe 2', 2);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `users`
--

CREATE TABLE `users` (
  `id` int(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `users`
--

INSERT INTO `users` (`id`, `name`, `password`) VALUES
(1, 'Teszt Elek', 'password'),
(4, 'foo', 'foo2'),
(9, 'asd', 'test'),
(10, 'asd2', 'test');

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `galaxies`
--
ALTER TABLE `galaxies`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `planets`
--
ALTER TABLE `planets`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `stars`
--
ALTER TABLE `stars`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `universes`
--
ALTER TABLE `universes`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `galaxies`
--
ALTER TABLE `galaxies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT a táblához `planets`
--
ALTER TABLE `planets`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT a táblához `stars`
--
ALTER TABLE `stars`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT a táblához `universes`
--
ALTER TABLE `universes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT a táblához `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
