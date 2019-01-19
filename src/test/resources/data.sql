-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 13, 2019 at 12:11 PM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.8

SET AUTOCOMMIT = 0;
-- START TRANSACTION;
-- SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: cinema
--

--
-- Dumping data for table cinema
--

INSERT INTO cinema (id, location, name) VALUES
(0, 'Chasséveld 15, 4811 DH Breda', 'Pathé Breda');

--
-- Dumping data for table film
--

INSERT INTO film (id, description, duration, title) VALUES
(0, 'Gandalf and Aragorn lead the World of Men against Saurons army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.', 263, 'The Lord of the Rings: The Return of the King'),
(1, 'After a cyber-attack reveals the identity of all of the active undercover agents in Britain, Johnny English is forced to come out of retirement to find the mastermind hacker.', 89, 'Johnny English Strikes Again'),
(2, 'A skilled London police officer is transferred to a small town with a dark secret.', 121, 'Hot Fuzz');

--
-- Dumping data for table order
--

INSERT INTO "order" (id, order_time, state, customer_id) VALUES
(0, '2019-01-12 16:51:31', 1, 1),
(1, '2019-01-12 22:10:49', 0, 2);

--
-- Dumping data for table screen
--

INSERT INTO screen (id, max_seats, size, cinema_id) VALUES
(0, 180, 48, 0),
(1, 380, 64, 0);

--
-- Dumping data for table screening
--

INSERT INTO screening (id, end_time, start_time, film_id, screen_id) VALUES
(0, '2019-01-26 23:55:00', '2019-01-26 19:20:00', 0, 0),
(1, '2019-01-26 23:45:00', '2019-01-26 19:10:00', 0, 1),
(2, '2019-01-28 22:10:00', '2019-01-28 20:30:00', 1, 0);

--
-- Dumping data for table seat
--

INSERT INTO seat (id, isvip, seat_nr, screen_id) VALUES
(0, 0, 10, 0),
(1, 0, 11, 0),
(2, 0, 12, 0),
(3, 1, 20, 0),
(4, 1, 21, 0),
(5, 0, 10, 1),
(6, 0, 11, 1),
(7, 0, 12, 1),
(8, 1, 40, 1),
(9, 1, 41, 1);

--
-- Dumping data for table ticket
--

INSERT INTO ticket (id, description, price, order_id, screening_id, seat_id) VALUES
(0, NULL, '8.90', 0, 0, 0),
(1, NULL, '8.90', 0, 0, 1),
(2, NULL, '12.60', 1, 2, 9);

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
