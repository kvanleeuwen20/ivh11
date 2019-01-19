-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 13, 2019 at 11:58 AM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.8

SET FOREIGN_KEY_CHECKS=0;
-- SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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

-- --------------------------------------------------------

--
-- Table structure for table app_user
--

DROP TABLE IF EXISTS app_user;
CREATE TABLE app_user (
  dtype varchar(31) NOT NULL,
  id int(11) NOT NULL,
  account_expired bit(1) NOT NULL,
  account_locked bit(1) NOT NULL,
  credentials_expired bit(1) NOT NULL,
  email varchar(255) DEFAULT NULL,
  enabled bit(1) NOT NULL,
  name varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  username varchar(255) DEFAULT NULL,
  employee_number int(11) DEFAULT NULL
);

--
-- Dumping data for table app_user
--

INSERT INTO app_user (dtype, id, account_expired, account_locked, credentials_expired, email, enabled, name, password, username, employee_number) VALUES
('Employee', 1, 0, 0, 0, 'admin@admin.nl', 1, 'Administrator', '$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035ha', 'admin', 76),
('Customer', 2, 0, 0, 0, 'john@doe.nl', 1, 'John Doe', '$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035ha', 'jdoe62', -1),
('Customer', 3, 0, 0, 0, 'erikjanssen@xs4all.nl', 1, 'Erik Janssen', '$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035ha', 'Erik_Janssen', -1);

-- --------------------------------------------------------

--
-- Table structure for table app_user_authorities
--

DROP TABLE IF EXISTS app_user_authorities;
CREATE TABLE app_user_authorities (
  app_user_id    INT(11)    NOT NULL,
  authorities_id BIGINT(20) NOT NULL
);

--
-- Dumping data for table app_user_authorities
--

INSERT INTO app_user_authorities (app_user_id, authorities_id) VALUES
(2, 1),
(2, 2),
(2, 3),
(2, 4),
(3, 1),
(3, 2),
(3, 3),
(3, 4);

-- --------------------------------------------------------

--
-- Table structure for table authority
--

DROP TABLE IF EXISTS authority;
CREATE TABLE authority (
  id bigint(20) NOT NULL,
  name varchar(255) DEFAULT NULL
);

--
-- Dumping data for table authority
--

INSERT INTO authority (id, name) VALUES
(4, 'ORDER_READ'),
(3, 'ORDER_DELETE'),
(2, 'ORDER_UPDATE'),
(1, 'ORDER_CREATE');

-- --------------------------------------------------------

--
-- Table structure for table cinema
--

DROP TABLE IF EXISTS cinema;
CREATE TABLE cinema (
  id bigint(20) NOT NULL,
  location varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table film
--

DROP TABLE IF EXISTS film;
CREATE TABLE film (
  id bigint(20) NOT NULL,
  description varchar(255) DEFAULT NULL,
  duration int(11) NOT NULL,
  title varchar(255) DEFAULT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table hibernate_sequence
--

DROP TABLE IF EXISTS hibernate_sequence;
CREATE TABLE hibernate_sequence (
  next_val bigint(20) DEFAULT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table oauth_access_token
--

DROP TABLE IF EXISTS oauth_access_token;
CREATE TABLE oauth_access_token (
  token_id varchar(255) DEFAULT NULL,
  token blob,
  authentication_id varchar(255) DEFAULT NULL,
  user_name varchar(255) DEFAULT NULL,
  client_id varchar(255) DEFAULT NULL,
  authentication blob,
  refresh_token varchar(255) DEFAULT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table oauth_client_details
--

DROP TABLE IF EXISTS oauth_client_details;
CREATE TABLE oauth_client_details (
  client_id varchar(255) NOT NULL,
  resource_ids varchar(255) DEFAULT NULL,
  client_secret varchar(255) DEFAULT NULL,
  scope varchar(255) DEFAULT NULL,
  authorized_grant_types varchar(255) DEFAULT NULL,
  web_server_redirect_uri varchar(255) DEFAULT NULL,
  authorities varchar(255) DEFAULT NULL,
  access_token_validity int(11) DEFAULT NULL,
  refresh_token_validity int(11) DEFAULT NULL,
  additional_information varchar(4096) DEFAULT NULL,
  autoapprove tinyint(4) DEFAULT NULL
);

--
-- Dumping data for table oauth_client_details
--

INSERT INTO oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) VALUES
('spring-security-oauth2-read-client', 'resource-server-rest-api', '$2a$04$WGq2P9egiOYoOFemBRfsiO9qTcyJtNRnPKNBl5tokP7IP.eZn93km', 'read', 'password,authorization_code,refresh_token,implicit', NULL, 'USER', 10800, 2592000, NULL, NULL),
('spring-security-oauth2-read-write-client', 'resource-server-rest-api', '$2a$04$soeOR.QFmClXeFIrhJVLWOQxfHjsJLSpWrU1iGxcMGdu.a5hvfY4W', 'read,write', 'password,authorization_code,refresh_token,implicit', NULL, 'USER', 10800, 2592000, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table oauth_client_token
--

DROP TABLE IF EXISTS oauth_client_token;
CREATE TABLE oauth_client_token (
  token_id varchar(255) DEFAULT NULL,
  token blob,
  authentication_id varchar(255) DEFAULT NULL,
  user_name varchar(255) DEFAULT NULL,
  client_id varchar(255) DEFAULT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table oauth_code
--

DROP TABLE IF EXISTS oauth_code;
CREATE TABLE oauth_code (
  code varchar(255) DEFAULT NULL,
  authentication blob
);

-- --------------------------------------------------------

--
-- Table structure for table oauth_refresh_token
--

DROP TABLE IF EXISTS oauth_refresh_token;
CREATE TABLE oauth_refresh_token (
  token_id varchar(255) DEFAULT NULL,
  token blob,
  authentication blob
);

-- --------------------------------------------------------

--
-- Table structure for table order
--

DROP TABLE IF EXISTS "order";
CREATE TABLE "order" (
  id int(11) NOT NULL,
  order_time datetime DEFAULT NULL,
  state int(11) DEFAULT NULL,
  customer_id int(11) DEFAULT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table screen
--

DROP TABLE IF EXISTS screen;
CREATE TABLE screen (
  id int(11) NOT NULL,
  max_seats int(11) NOT NULL,
  size int(11) NOT NULL,
  cinema_id bigint(20) DEFAULT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table screening
--

DROP TABLE IF EXISTS screening;
CREATE TABLE screening (
  id bigint(20) NOT NULL,
  end_time datetime DEFAULT NULL,
  start_time datetime DEFAULT NULL,
  film_id bigint(20) DEFAULT NULL,
  screen_id int(11) DEFAULT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table seat
--

DROP TABLE IF EXISTS seat;
CREATE TABLE seat (
  id int(11) NOT NULL,
  isvip bit(1) NOT NULL,
  seat_nr int(11) NOT NULL,
  screen_id int(11) DEFAULT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table ticket
--

DROP TABLE IF EXISTS ticket;
CREATE TABLE ticket (
  id int(11) NOT NULL,
  description varchar(255) DEFAULT NULL,
  price decimal(19,2) DEFAULT NULL,
  order_id int(11) DEFAULT NULL,
  screening_id bigint(20) DEFAULT NULL,
  seat_id int(11) DEFAULT NULL
);

--
-- Indexes for dumped tables
--

--
-- Indexes for table app_user
--
ALTER TABLE app_user
  ADD PRIMARY KEY (id);

--
-- Indexes for table app_user_authorities
--
ALTER TABLE app_user_authorities
  ADD PRIMARY KEY (app_user_id,authorities_id);
--
-- Indexes for table authority
--
ALTER TABLE authority
  ADD PRIMARY KEY (id);

--
-- Indexes for table cinema
--
ALTER TABLE cinema
  ADD PRIMARY KEY (id);

--
-- Indexes for table film
--
ALTER TABLE film
  ADD PRIMARY KEY (id);

--
-- Indexes for table oauth_client_details
--
ALTER TABLE oauth_client_details
  ADD PRIMARY KEY (client_id);

--
-- Indexes for table order
--
ALTER TABLE "order"
  ADD PRIMARY KEY (id);

--
-- Indexes for table screen
--
ALTER TABLE screen
  ADD PRIMARY KEY (id);

--
-- Indexes for table screening
--
ALTER TABLE screening
  ADD PRIMARY KEY (id);

--
-- Indexes for table seat
--
ALTER TABLE seat
  ADD PRIMARY KEY (id);

--
-- Indexes for table ticket
--
ALTER TABLE ticket
  ADD PRIMARY KEY (id);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table authority
--
ALTER TABLE authority
  MODIFY id bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table cinema
--
ALTER TABLE cinema
  MODIFY id bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table film
--
ALTER TABLE film
  MODIFY id bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table order
--
ALTER TABLE "order"
  MODIFY id int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table screen
--
ALTER TABLE screen
  MODIFY id int(11) NOT NULL AUTO_INCREMENT;

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
