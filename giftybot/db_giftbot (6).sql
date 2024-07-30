-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 15, 2024 at 04:42 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_giftbot`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'safa', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `keywords`
--

CREATE TABLE `keywords` (
  `id` int(11) NOT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `age_group` varchar(10) DEFAULT NULL,
  `keyword` varchar(255) DEFAULT NULL,
  `message` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `link` text DEFAULT NULL,
  `product_name` varchar(255) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `keywords`
--

INSERT INTO `keywords` (`id`, `gender`, `age_group`, `keyword`, `message`, `link`, `product_name`, `description`) VALUES
(22, 'male', '26_35', 'tech', '?? Product: Smart Watch\n?? Description: Advanced smartwatch with fitness tracking.\n?? Purchase it here: http://example.com/smart-watch', 'http://example.com/smart-watch', 'Smart Watch', 'Advanced smartwatch with fitness tracking.'),
(23, 'female', '26_35', 'beauty', '?? Product: Skincare Set\n?? Description: Complete skincare set for glowing skin.\n?? Purchase it here: http://example.com/skincare-set', 'http://example.com/skincare-set', 'Skincare Set', 'Complete skincare set for glowing skin.'),
(26, 'Female', '16-25', 'Smart Watch', '?? Product: Smart Watch ?? Description: Advanced smartwatch with fitness tracking. ?? Purchase it here: http://example.com/smart-watch', 'qwertyu', 'qwerty', 'qwertyu'),
(27, 'male', '46_plus', 'fashion', 'qwertyui', '12345wertyu', 'wertyui', 'qwertyuio'),
(28, 'male', '46_plus', 'fashion', 'qwertyui', '12345wertyu', 'wertyui', 'qwertyuio'),
(29, 'male', '46_plus', 'fashion', 'qwertyui', '12345wertyu', 'wertyui', 'qwertyuio');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `id` int(11) NOT NULL,
  `chat_id` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id`, `chat_id`, `username`) VALUES
(15, '5702419887', 'restulestarii');

-- --------------------------------------------------------

--
-- Table structure for table `pesan`
--

CREATE TABLE `pesan` (
  `id` int(11) NOT NULL,
  `chat_id` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `pesan` text NOT NULL,
  `date` date NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pesan`
--

INSERT INTO `pesan` (`id`, `chat_id`, `username`, `pesan`, `date`, `created_at`) VALUES
(146, '5702419887', 'restulestarii', '/run', '2024-07-15', '2024-07-15 02:38:26'),
(147, '1234567', 'giftyrestu_bot', 'Please register first using the /register command.', '2024-07-15', '2024-07-15 02:38:26'),
(148, '5702419887', 'restulestarii', '/run', '2024-07-15', '2024-07-15 02:38:53'),
(149, '1234567', 'giftyrestu_bot', 'Please register first using the /register command.', '2024-07-15', '2024-07-15 02:38:54'),
(150, '5702419887', 'restulestarii', '/run', '2024-07-15', '2024-07-15 02:39:44'),
(151, '1234567', 'giftyrestu_bot', 'Please register first using the /register command.', '2024-07-15', '2024-07-15 02:39:44'),
(152, '5702419887', 'restulestarii', '/run', '2024-07-15', '2024-07-15 02:40:33'),
(153, '1234567', 'giftyrestu_bot', 'Please register first using the /register command.', '2024-07-15', '2024-07-15 02:40:33'),
(154, '5702419887', 'restulestarii', '/register', '2024-07-15', '2024-07-15 02:40:35'),
(155, '1234567', 'giftyrestu_bot', 'Thank you for registering! 🤗\n\nPlease choose one of the commands below:\n /gift - Get a gift suggestion\n /help - Display help and list of commands', '2024-07-15', '2024-07-15 02:40:35'),
(156, '5702419887', 'restulestarii', '/run', '2024-07-15', '2024-07-15 02:43:38'),
(157, '1234567', 'giftyrestu_bot', 'Please register first using the /register command.', '2024-07-15', '2024-07-15 02:43:39'),
(158, '5702419887', 'restulestarii', '/register', '2024-07-15', '2024-07-15 02:43:40'),
(159, '1234567', 'giftyrestu_bot', 'Thank you for registering! 🤗\n\nPlease choose one of the commands below:\n /gift - Get a gift suggestion\n /help - Display help and list of commands', '2024-07-15', '2024-07-15 02:43:41'),
(160, '5702419887', 'restulestarii', '/run', '2024-07-15', '2024-07-15 02:44:45'),
(161, '1234567', 'giftyrestu_bot', 'Please register first using the /register command.', '2024-07-15', '2024-07-15 02:44:46'),
(162, '5702419887', 'restulestarii', '/run', '2024-07-15', '2024-07-15 02:45:25'),
(163, '1234567', 'giftyrestu_bot', 'Please register first using the /register command.', '2024-07-15', '2024-07-15 02:45:26'),
(164, '5702419887', 'restulestarii', '/register', '2024-07-15', '2024-07-15 02:45:27'),
(165, '1234567', 'giftyrestu_bot', 'Thank you for registering! 🤗\n\nPlease choose one of the commands below:\n /gift - Get a gift suggestion\n /help - Display help and list of commands', '2024-07-15', '2024-07-15 02:45:28'),
(166, '5702419887', 'restulestarii', '/register', '2024-07-15', '2024-07-15 02:48:33'),
(167, '1234567', 'giftyrestu_bot', 'Thank you for registering! 🤗\n\nPlease choose one of the commands below:\n /gift - Get a gift suggestion\n /help - Display help and list of commands', '2024-07-15', '2024-07-15 02:48:33'),
(168, '5702419887', 'restulestarii', '/register', '2024-07-15', '2024-07-15 02:51:09'),
(169, '1234567', 'giftyrestu_bot', 'Thank you for registering! 🤗\n\nPlease choose one of the commands below:\n /gift - Get a gift suggestion\n /help - Display help and list of commands', '2024-07-15', '2024-07-15 02:51:09'),
(170, '5702419887', 'restulestarii', '/register', '2024-07-15', '2024-07-15 02:52:23'),
(171, '1234567', 'giftyrestu_bot', 'You are already registered! 😊\n\nPlease choose one of the commands below:\n /gift - Get a gift suggestion\n /help - Display help and list of commands', '2024-07-15', '2024-07-15 02:52:24'),
(172, '5702419887', 'restulestarii', '/gift', '2024-07-15', '2024-07-15 02:52:25'),
(173, '5702419887', 'restulestarii', '/gift', '2024-07-15', '2024-07-15 02:54:07'),
(174, '1234567', 'giftyrestu_bot', 'Please register first using the /register command.', '2024-07-15', '2024-07-15 02:54:08'),
(175, '5702419887', 'restulestarii', '/register', '2024-07-15', '2024-07-15 02:54:20'),
(176, '1234567', 'giftyrestu_bot', 'Thank you for registering! 🤗\n\nPlease choose one of the commands below:\n /gift - Get a gift suggestion\n /help - Display help and list of commands', '2024-07-15', '2024-07-15 02:54:20'),
(177, '5702419887', 'restulestarii', '/register', '2024-07-15', '2024-07-15 03:01:11'),
(178, '1234567', 'giftyrestu_bot', 'Thank you for registering! 🤗\n\nPlease choose one of the commands below:\n /gift - Get a gift suggestion\n /help - Display help and list of commands', '2024-07-15', '2024-07-15 03:01:11'),
(179, '5702419887', 'restulestarii', '/gift', '2024-07-15', '2024-07-15 03:01:15'),
(180, '5702419887', 'restulestarii', '/run', '2024-07-15', '2024-07-15 05:23:55'),
(181, '1234567', 'giftyrestu_bot', 'Please register first using the /register command.', '2024-07-15', '2024-07-15 05:23:55'),
(182, '5702419887', 'restulestarii', '/run', '2024-07-15', '2024-07-15 05:24:10'),
(183, '1234567', 'giftyrestu_bot', 'Please register first using the /register command.', '2024-07-15', '2024-07-15 05:24:10'),
(184, '5702419887', 'restulestarii', '/register', '2024-07-15', '2024-07-15 05:24:24'),
(185, '1234567', 'giftyrestu_bot', 'Thank you for registering! 🤗\n\nPlease choose one of the commands below:\n /gift - Get a gift suggestion\n /help - Display help and list of commands', '2024-07-15', '2024-07-15 05:24:24'),
(186, '5702419887', 'restulestarii', '/run', '2024-07-15', '2024-07-15 05:25:40'),
(187, '1234567', 'giftyrestu_bot', 'Please register first using the /register command.', '2024-07-15', '2024-07-15 05:25:41'),
(188, '5702419887', 'restulestarii', '/register', '2024-07-15', '2024-07-15 05:25:42'),
(189, '1234567', 'giftyrestu_bot', 'Thank you for registering! 🤗\n\nPlease choose one of the commands below:\n /gift - Get a gift suggestion\n /help - Display help and list of commands', '2024-07-15', '2024-07-15 05:25:43'),
(190, '5702419887', 'restulestarii', '/run', '2024-07-15', '2024-07-15 05:28:07'),
(191, '1234567', 'giftyrestu_bot', 'Welcome to GiftBot 🎁\n\nPlease choose one of the commands below:\n /gift - Get a gift suggestion\n /help - Display help and list of commands', '2024-07-15', '2024-07-15 05:28:08'),
(192, '5702419887', 'restulestarii', '/run', '2024-07-15', '2024-07-15 05:34:37'),
(193, '1234567', 'giftyrestu_bot', 'Please register first using the /register command.', '2024-07-15', '2024-07-15 05:34:38'),
(194, '5702419887', 'restulestarii', '/register', '2024-07-15', '2024-07-15 05:34:40'),
(195, '1234567', 'giftyrestu_bot', 'Thank you for registering! 🤗\n\nPlease choose one of the commands below:\n /gift - Get a gift suggestion\n /help - Display help and list of commands', '2024-07-15', '2024-07-15 05:34:40'),
(196, '5702419887', 'restulestarii', '/register', '2024-07-15', '2024-07-15 06:33:26'),
(197, '1234567', 'giftyrestu_bot', 'You are already registered! 😊\n\nPlease choose one of the commands below:\n /gift - Get a gift suggestion\n /help - Display help and list of commands', '2024-07-15', '2024-07-15 06:33:27'),
(198, '5702419887', 'restulestarii', '/run', '2024-07-15', '2024-07-15 06:33:52'),
(199, '1234567', 'giftyrestu_bot', 'Welcome to GiftBot 🎁\n\nPlease choose one of the commands below:\n /gift - Get a gift suggestion\n /help - Display help and list of commands', '2024-07-15', '2024-07-15 06:33:53'),
(200, '5702419887', 'restulestarii', '/run', '2024-07-15', '2024-07-15 13:02:23'),
(201, '1234567', 'giftyrestu_bot', 'Welcome to GiftBot 🎁\n\nPlease choose one of the commands below:\n /gift - Get a gift suggestion\n /help - Display help and list of commands', '2024-07-15', '2024-07-15 13:02:24'),
(202, '5702419887', 'restulestarii', '/gift', '2024-07-15', '2024-07-15 13:02:27'),
(203, '1234567', 'giftyrestu_bot', 'You selected:\nGender: female\nAge Group: 18_25\n\nNow please enter a keyword to get a gift suggestion:', '2024-07-15', '2024-07-15 13:02:58'),
(204, '1234567', 'giftyrestu_bot', 'Available keywords for your selection:\n- beauty\n- fashion\n', '2024-07-15', '2024-07-15 13:02:59'),
(205, '5702419887', 'restulestarii', 'beauty', '2024-07-15', '2024-07-15 13:05:41'),
(206, '1234567', 'giftyrestu_bot', 'A skincare set or a popular makeup palette.\n\nYou can purchase it here: https://example.com/skincare-set', '2024-07-15', '2024-07-15 13:05:41'),
(207, '5702419887', 'restulestarii', 'fashion', '2024-07-15', '2024-07-15 13:05:49'),
(208, '1234567', 'giftyrestu_bot', 'A trendy handbag or a stylish piece of jewelry.\n\nYou can purchase it here: https://example.com/handbag', '2024-07-15', '2024-07-15 13:05:49'),
(209, '5702419887', 'restulestarii', 'haha', '2024-07-15', '2024-07-15 13:05:56'),
(210, '1234567', 'giftyrestu_bot', 'Keyword not found!', '2024-07-15', '2024-07-15 13:05:57'),
(211, '5702419887', 'restulestarii', '/run', '2024-07-15', '2024-07-15 13:09:20'),
(212, '1234567', 'giftyrestu_bot', 'Welcome to GiftBot 🎁\n\nPlease choose one of the commands below:\n /gift - Get a gift suggestion\n /help - Display help and list of commands', '2024-07-15', '2024-07-15 13:09:21'),
(213, '5702419887', 'restulestarii', '/gift', '2024-07-15', '2024-07-15 13:09:23'),
(214, '1234567', 'giftyrestu_bot', 'You selected:\nGender: male\nAge Group: 26_35\n\nNow please enter a keyword to get a gift suggestion:', '2024-07-15', '2024-07-15 13:09:28'),
(215, '1234567', 'giftyrestu_bot', 'Available keywords for your selection:\n- fashion\n', '2024-07-15', '2024-07-15 13:09:29'),
(216, '5702419887', 'restulestarii', 'fashion', '2024-07-15', '2024-07-15 13:09:41'),
(217, '1234567', 'giftyrestu_bot', 'A stylish leather wallet or a high-quality belt.\n\nYou can purchase it here: https://example.com/leather-wallet', '2024-07-15', '2024-07-15 13:09:42'),
(218, '1234567', 'giftyrestu_bot', 'You selected:\nGender: male\nAge Group: 18_25\n\nNow please enter a keyword to get a gift suggestion:', '2024-07-15', '2024-07-15 13:10:29'),
(219, '1234567', 'giftyrestu_bot', 'Available keywords for your selection:\n- sports\n', '2024-07-15', '2024-07-15 13:10:29'),
(220, '5702419887', 'restulestarii', '/gift', '2024-07-15', '2024-07-15 13:28:08'),
(221, '1234567', 'giftyrestu_bot', 'You selected:\nGender: female\nAge Group: 16_25\n\nNow please enter a keyword to get a gift suggestion:', '2024-07-15', '2024-07-15 13:28:37'),
(222, '1234567', 'giftyrestu_bot', 'Available keywords for your selection:\n', '2024-07-15', '2024-07-15 13:28:37'),
(223, '1234567', 'giftyrestu_bot', 'You selected:\nGender: female\nAge Group: 26_35\n\nNow please enter a keyword to get a gift suggestion:', '2024-07-15', '2024-07-15 13:28:51'),
(224, '1234567', 'giftyrestu_bot', 'Available keywords for your selection:\n', '2024-07-15', '2024-07-15 13:28:51'),
(225, '5702419887', 'restulestarii', 'gaming', '2024-07-15', '2024-07-15 13:29:02'),
(226, '1234567', 'giftyrestu_bot', 'Keyword not found!', '2024-07-15', '2024-07-15 13:29:03'),
(227, '5702419887', 'restulestarii', '/gift', '2024-07-15', '2024-07-15 13:31:52'),
(228, '1234567', 'giftyrestu_bot', 'You selected:\nGender: female\nAge Group: 26_35\n\nPlease choose a keyword from the list below:', '2024-07-15', '2024-07-15 13:31:56'),
(229, '5702419887', 'restulestarii', 'tech', '2024-07-15', '2024-07-15 13:32:10'),
(230, '1234567', 'giftyrestu_bot', 'Keyword not found!', '2024-07-15', '2024-07-15 13:32:11'),
(231, '5702419887', 'restulestarii', 'beauty', '2024-07-15', '2024-07-15 13:32:30'),
(232, '1234567', 'giftyrestu_bot', 'Keyword not found!', '2024-07-15', '2024-07-15 13:32:30'),
(233, '5702419887', 'restulestarii', '/gift', '2024-07-15', '2024-07-15 13:33:28'),
(234, '1234567', 'giftyrestu_bot', 'You selected:\nGender: female\nAge Group: 26_35\n\nPlease choose a keyword from the list below:', '2024-07-15', '2024-07-15 13:33:40'),
(235, '5702419887', 'restulestarii', '/gift', '2024-07-15', '2024-07-15 13:34:39'),
(236, '5702419887', 'restulestarii', '/gift', '2024-07-15', '2024-07-15 13:35:34'),
(237, '1234567', 'giftyrestu_bot', 'You selected:\nGender: female\nAge Group: 26_35\n\nPlease choose a keyword from the list below:', '2024-07-15', '2024-07-15 13:35:45'),
(238, '5702419887', 'restulestarii', '/gift', '2024-07-15', '2024-07-15 13:37:24'),
(239, '1234567', 'giftyrestu_bot', 'You selected:\nGender: female\nAge Group: 26_35\n\nPlease choose a keyword from the list below:', '2024-07-15', '2024-07-15 13:37:28'),
(240, '1234567', 'giftyrestu_bot', 'Available keywords for your selection:\n- beauty\n', '2024-07-15', '2024-07-15 13:37:29'),
(241, '5702419887', 'restulestarii', 'beauty', '2024-07-15', '2024-07-15 13:37:54'),
(242, '1234567', 'giftyrestu_bot', '?? Product: Skincare Set\n?? Description: Complete skincare set for glowing skin.\n?? Purchase it here: http://example.com/skincare-set\n🎁 Product: Skincare Set\n📝 Description: Complete skincare set for glowing skin.\n🔗 Purchase it here: http://example.com/skincare-set', '2024-07-15', '2024-07-15 13:37:54'),
(243, '5702419887', 'restulestarii', '/gift', '2024-07-15', '2024-07-15 13:40:51'),
(244, '1234567', 'giftyrestu_bot', 'You selected:\nGender: female\nAge Group: 26_35\n\nPlease choose a keyword from the list below:', '2024-07-15', '2024-07-15 13:40:56'),
(245, '1234567', 'giftyrestu_bot', 'Available keywords for your selection:\n- beauty\n', '2024-07-15', '2024-07-15 13:40:56'),
(246, '5702419887', 'restulestarii', 'beauty', '2024-07-15', '2024-07-15 13:41:00'),
(247, '1234567', 'giftyrestu_bot', '🎁 Product: Skincare Set\n📝 Description: Complete skincare set for glowing skin.\n🔗 Purchase it here: http://example.com/skincare-set', '2024-07-15', '2024-07-15 13:41:01'),
(248, '5702419887', 'restulestarii', '/gift', '2024-07-15', '2024-07-15 14:19:03'),
(249, '1234567', 'giftyrestu_bot', 'You selected:\nGender: female\nAge Group: 16_25\n\nPlease choose a keyword from the list below:', '2024-07-15', '2024-07-15 14:19:11'),
(250, '1234567', 'giftyrestu_bot', 'Available keywords for your selection:\n', '2024-07-15', '2024-07-15 14:19:12'),
(251, '5702419887', 'restulestarii', '1234567', '2024-07-15', '2024-07-15 14:19:20'),
(252, '1234567', 'giftyrestu_bot', 'Keyword not found!', '2024-07-15', '2024-07-15 14:19:20'),
(253, '1234567', 'giftyrestu_bot', 'You selected:\nGender: female\nAge Group: 26_35\n\nPlease choose a keyword from the list below:', '2024-07-15', '2024-07-15 14:19:28'),
(254, '1234567', 'giftyrestu_bot', 'Available keywords for your selection:\n- beauty\n', '2024-07-15', '2024-07-15 14:19:28'),
(255, '1234567', 'giftyrestu_bot', 'You selected:\nGender: female\nAge Group: 16_25\n\nPlease choose a keyword from the list below:', '2024-07-15', '2024-07-15 14:19:50'),
(256, '1234567', 'giftyrestu_bot', 'Available keywords for your selection:\n', '2024-07-15', '2024-07-15 14:19:50'),
(257, '5702419887', 'restulestarii', '/gift', '2024-07-15', '2024-07-15 14:23:24'),
(258, '1234567', 'giftyrestu_bot', 'You selected:\nGender: female\nAge Group: 26_35\n\nPlease choose a keyword from the list below:', '2024-07-15', '2024-07-15 14:23:35'),
(259, '1234567', 'giftyrestu_bot', 'Available keywords for your selection:\n- beauty\n', '2024-07-15', '2024-07-15 14:23:36'),
(260, '1234567', 'giftyrestu_bot', 'You selected:\nGender: female\nAge Group: 16_25\n\nPlease choose a keyword from the list below:', '2024-07-15', '2024-07-15 14:24:18'),
(261, '1234567', 'giftyrestu_bot', 'Available keywords for your selection:\n', '2024-07-15', '2024-07-15 14:24:19'),
(262, '5702419887', 'restulestarii', 'fashion', '2024-07-15', '2024-07-15 14:24:30'),
(263, '1234567', 'giftyrestu_bot', 'Keyword not found!', '2024-07-15', '2024-07-15 14:24:31'),
(264, '1234567', 'giftyrestu_bot', 'You selected:\nGender: female\nAge Group: 16_25\n\nPlease choose a keyword from the list below:', '2024-07-15', '2024-07-15 14:24:42'),
(265, '1234567', 'giftyrestu_bot', 'Available keywords for your selection:\n', '2024-07-15', '2024-07-15 14:24:42'),
(266, '5702419887', 'restulestarii', '/gift', '2024-07-15', '2024-07-15 14:33:39'),
(267, '1234567', 'giftyrestu_bot', 'You selected:\nGender: female\nAge Group: 16_25\n\nPlease choose a keyword from the list below:', '2024-07-15', '2024-07-15 14:33:45'),
(268, '1234567', 'giftyrestu_bot', 'Available keywords for your selection:\n- fashion\n', '2024-07-15', '2024-07-15 14:33:46'),
(269, '1234567', 'giftyrestu_bot', 'You selected:\nGender: female\nAge Group: 46_plus\n\nPlease choose a keyword from the list below:', '2024-07-15', '2024-07-15 14:34:25'),
(270, '1234567', 'giftyrestu_bot', 'Available keywords for your selection:\n', '2024-07-15', '2024-07-15 14:34:26'),
(271, '5702419887', 'restulestarii', '/gift', '2024-07-15', '2024-07-15 14:35:33'),
(272, '5702419887', 'restulestarii', '/gift', '2024-07-15', '2024-07-15 14:35:50'),
(273, '5702419887', 'restulestarii', '/gift', '2024-07-15', '2024-07-15 14:37:18'),
(274, '1234567', 'giftyrestu_bot', 'You selected:\nGender: male\nAge Group: 46_plus\n\nPlease choose a keyword from the list below:', '2024-07-15', '2024-07-15 14:37:23'),
(275, '1234567', 'giftyrestu_bot', 'Available keywords for your selection:\n', '2024-07-15', '2024-07-15 14:37:24'),
(276, '5702419887', 'restulestarii', '/gift', '2024-07-15', '2024-07-15 14:38:34'),
(277, '1234567', 'giftyrestu_bot', 'You selected:\nGender: male\nAge Group: 46_plus\n\nPlease choose a keyword from the list below:', '2024-07-15', '2024-07-15 14:38:39'),
(278, '1234567', 'giftyrestu_bot', 'Available keywords for your selection:\n- fashion\n- fashion\n- fashion\n', '2024-07-15', '2024-07-15 14:38:39'),
(279, '5702419887', 'restulestarii', '/gift', '2024-07-15', '2024-07-15 14:40:26'),
(280, '1234567', 'giftyrestu_bot', 'You selected:\nGender: male\nAge Group: 46_plus\n\nPlease choose a keyword from the list below:', '2024-07-15', '2024-07-15 14:40:32'),
(281, '1234567', 'giftyrestu_bot', 'Available keywords for your selection:\n- fashion\n- fashion\n- fashion\n', '2024-07-15', '2024-07-15 14:40:32'),
(282, '5702419887', 'restulestarii', '/gift', '2024-07-15', '2024-07-15 14:41:53'),
(283, '1234567', 'giftyrestu_bot', 'You selected:\nGender: male\nAge Group: 46_plus\n\nPlease choose a keyword from the list below:', '2024-07-15', '2024-07-15 14:42:00'),
(284, '1234567', 'giftyrestu_bot', 'Available keywords for your selection:\n- fashion\n', '2024-07-15', '2024-07-15 14:42:01');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `chat_id` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `chat_id`, `username`) VALUES
(14, '5702419887', 'restulestarii');

-- --------------------------------------------------------

--
-- Table structure for table `user_choice`
--

CREATE TABLE `user_choice` (
  `chat_id` varchar(255) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `age_group` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_choice`
--

INSERT INTO `user_choice` (`chat_id`, `gender`, `age_group`) VALUES
('5702419887', 'male', '46_plus');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `keywords`
--
ALTER TABLE `keywords`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pesan`
--
ALTER TABLE `pesan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_choice`
--
ALTER TABLE `user_choice`
  ADD PRIMARY KEY (`chat_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `keywords`
--
ALTER TABLE `keywords`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `pesan`
--
ALTER TABLE `pesan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=285;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
