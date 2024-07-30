-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 16, 2024 at 11:08 AM
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
-- Database: `db_foodrecipe`
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
(1, 'restu', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `kunci`
--

CREATE TABLE `kunci` (
  `kata` varchar(255) NOT NULL,
  `pesan` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kunci`
--

INSERT INTO `kunci` (`kata`, `pesan`) VALUES
('hello', 'Hello there! How can I assist you today?'),
('makasi', 'sama-sama'),
('oke', 'Okeyyy'),
('thanks', 'You\'re welcome!');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `id` int(11) NOT NULL,
  `chat_id` varchar(20) NOT NULL,
  `username` varchar(255) NOT NULL,
  `registered_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id`, `chat_id`, `username`, `registered_at`) VALUES
(26, '5702419887', 'restulestarii', '2024-07-16 01:55:07'),
(27, '201575235', 'ajibsusanto', '2024-07-16 02:36:46');

-- --------------------------------------------------------

--
-- Table structure for table `pesan`
--

CREATE TABLE `pesan` (
  `id` int(11) NOT NULL,
  `chat_id` varchar(20) NOT NULL,
  `username` varchar(255) NOT NULL,
  `pesan` text NOT NULL,
  `date` date NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pesan`
--

INSERT INTO `pesan` (`id`, `chat_id`, `username`, `pesan`, `date`, `created_at`) VALUES
(565, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 20:49:09'),
(566, '2631836', 'giftyrestu_bot', 'Keyword not found!. Please try another keyword or use /help for available commands.', '2024-07-16', '2024-07-15 20:49:10'),
(567, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 20:49:12'),
(568, '2631836', 'giftyrestu_bot', 'Keyword not found!. Please try another keyword or use /help for available commands.', '2024-07-16', '2024-07-15 20:49:12'),
(569, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 20:49:15'),
(570, '2631836', 'giftyrestu_bot', 'Keyword not found!. Please try another keyword or use /help for available commands.', '2024-07-16', '2024-07-15 20:49:16'),
(571, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 20:49:17'),
(572, '2631836', 'giftyrestu_bot', 'Keyword not found!. Please try another keyword or use /help for available commands.', '2024-07-16', '2024-07-15 20:49:17'),
(573, '5702419887', 'restulestarii', '/help', '2024-07-16', '2024-07-15 20:49:18'),
(574, '2631836', 'giftyrestu_bot', 'Keyword not found!. Please try another keyword or use /help for available commands.', '2024-07-16', '2024-07-15 20:49:19'),
(575, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 20:50:06'),
(576, '2631836', 'frecipe_bot', 'Keyword not found!. Please try another keyword or use /help for available commands.', '2024-07-16', '2024-07-15 20:50:06'),
(577, '5702419887', 'restulestarii', '/help', '2024-07-16', '2024-07-15 20:50:10'),
(578, '2631836', 'frecipe_bot', 'Keyword not found!. Please try another keyword or use /help for available commands.', '2024-07-16', '2024-07-15 20:50:11'),
(579, '5702419887', 'restulestarii', '/help', '2024-07-16', '2024-07-15 20:55:21'),
(580, '5702419887', 'frecipe_bot', 'Here are some of the available commands:\n\n/register - Register with the bot to get full access\n/recipe <query> - Search for a recipe\n/recommend - Get recommended recipes\n/help - Display help and commands', '2024-07-16', '2024-07-15 20:55:21'),
(581, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 20:55:28'),
(582, '5702419887', 'frecipe_bot', 'Welcome to FoodRecipeBot 🍲\n\nPlease use the commands below:\n/register - Register to gain full access\n/recipe <query> - Search for a recipe\n/recommend - Get recommended recipes\n/help - Display help and commands', '2024-07-16', '2024-07-15 20:55:28'),
(583, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 20:55:30'),
(584, '5702419887', 'frecipe_bot', 'Invalid command. Please use /help to see the list of available commands.', '2024-07-16', '2024-07-15 20:55:30'),
(585, '5702419887', 'restulestarii', '/recipe', '2024-07-16', '2024-07-15 20:55:33'),
(586, '5702419887', 'frecipe_bot', 'Please specify a query for the recipe, e.g., /recipe chicken.', '2024-07-16', '2024-07-15 20:55:34'),
(587, '5702419887', 'restulestarii', '/recipe ramen', '2024-07-16', '2024-07-15 20:55:41'),
(588, '5702419887', 'frecipe_bot', 'Sent recipe details for: Homemade Tonkotsu Ramen', '2024-07-16', '2024-07-15 20:55:44'),
(589, '5702419887', 'frecipe_bot', 'Fetching recipe: Homemade Tonkotsu Ramen', '2024-07-16', '2024-07-15 20:55:44'),
(590, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 20:55:47'),
(591, '5702419887', 'restulestarii', 'Tartufi', '2024-07-16', '2024-07-15 20:55:50'),
(592, '5702419887', 'frecipe_bot', 'Sent recipe details for: Tartufi', '2024-07-16', '2024-07-15 20:55:51'),
(593, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 20:56:06'),
(594, '5702419887', 'frecipe_bot', 'Invalid command. Please use /help to see the list of available commands.', '2024-07-16', '2024-07-15 20:56:07'),
(595, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 20:56:51'),
(596, '5702419887', 'frecipe_bot', 'Invalid command. Please use /help to see the list of available commands.', '2024-07-16', '2024-07-15 20:56:51'),
(597, '5702419887', 'restulestarii', '/help', '2024-07-16', '2024-07-15 20:56:53'),
(598, '5702419887', 'frecipe_bot', 'Here are some of the available commands:\n\n/register - Register with the bot to get full access\n/recipe <query> - Search for a recipe\n/recommend - Get recommended recipes\n/help - Display help and commands', '2024-07-16', '2024-07-15 20:56:54'),
(599, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 21:01:23'),
(600, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 21:01:31'),
(601, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 21:03:12'),
(602, '5702419887', 'frecipe_bot', 'Thank you for registering! You can now use the following commands:\n/recipe <query> - Search for a recipe\n/recommend - Get recommended recipes\n/help - Display help and commands', '2024-07-16', '2024-07-15 21:03:12'),
(603, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 21:03:15'),
(604, '5702419887', 'frecipe_bot', 'Welcome to FoodRecipeBot 🍲\n\nPlease use the commands below:\n/register - Register to gain full access\n/recipe <query> - Search for a recipe\n/recommend - Get recommended recipes\n/help - Display help and commands', '2024-07-16', '2024-07-15 21:03:16'),
(605, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 21:03:37'),
(606, '5702419887', 'frecipe_bot', 'Invalid command. Please use /help to see the list of available commands.', '2024-07-16', '2024-07-15 21:03:37'),
(607, '5702419887', 'restulestarii', '/recipe', '2024-07-16', '2024-07-15 21:03:40'),
(608, '5702419887', 'frecipe_bot', 'Please specify a query for the recipe, e.g., /recipe chicken.', '2024-07-16', '2024-07-15 21:03:40'),
(609, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 21:03:43'),
(610, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 21:04:06'),
(611, '5702419887', 'restulestarii', 'Buttermilk Panna Cotta', '2024-07-16', '2024-07-15 21:04:10'),
(612, '5702419887', 'frecipe_bot', 'Sent recipe details for: Buttermilk Panna Cotta', '2024-07-16', '2024-07-15 21:04:12'),
(613, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 21:06:04'),
(614, '5702419887', 'frecipe_bot', 'You are already registered. Use available commands.', '2024-07-16', '2024-07-15 21:06:04'),
(615, '5702419887', 'frecipe_bot', 'Invalid command. Please use /help to see the list of available commands.', '2024-07-16', '2024-07-15 21:06:05'),
(616, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 21:06:12'),
(617, '5702419887', 'frecipe_bot', 'You are already registered. Use available commands.', '2024-07-16', '2024-07-15 21:06:12'),
(618, '5702419887', 'frecipe_bot', 'Welcome to FoodRecipeBot 🍲\n\nPlease use the commands below:\n/register - Register to gain full access\n/recipe <query> - Search for a recipe\n/recommend - Get recommended recipes\n/help - Display help and commands', '2024-07-16', '2024-07-15 21:06:13'),
(619, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 21:10:44'),
(620, '5702419887', 'frecipe_bot', 'You are already registered. Use available commands.', '2024-07-16', '2024-07-15 21:10:44'),
(621, '5702419887', 'frecipe_bot', 'Invalid command. Please use /help to see the list of available commands.', '2024-07-16', '2024-07-15 21:10:45'),
(622, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 21:10:54'),
(623, '5702419887', 'frecipe_bot', 'You are already registered. Use available commands.', '2024-07-16', '2024-07-15 21:10:54'),
(624, '5702419887', 'frecipe_bot', 'Welcome to FoodRecipeBot 🍲\n\nPlease use the commands below:\n/register - Register to gain full access\n/recipe <query> - Search for a recipe\n/recommend - Get recommended recipes\n/help - Display help and commands', '2024-07-16', '2024-07-15 21:10:55'),
(625, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 21:11:40'),
(626, '5702419887', 'frecipe_bot', 'You are already registered. Use available commands.', '2024-07-16', '2024-07-15 21:11:40'),
(627, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 21:11:42'),
(628, '5702419887', 'frecipe_bot', 'You are already registered. Use available commands.', '2024-07-16', '2024-07-15 21:11:43'),
(629, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 21:23:59'),
(630, '5702419887', 'frecipe_bot', 'I\'m sorry, I don\'t understand that command.', '2024-07-16', '2024-07-15 21:23:59'),
(631, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 21:24:03'),
(632, '5702419887', 'frecipe_bot', 'I\'m sorry, I don\'t understand that command.', '2024-07-16', '2024-07-15 21:24:03'),
(633, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 21:24:04'),
(634, '5702419887', 'frecipe_bot', 'I\'m sorry, I don\'t understand that command.', '2024-07-16', '2024-07-15 21:24:05'),
(635, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 21:24:11'),
(636, '5702419887', 'frecipe_bot', 'I\'m sorry, I don\'t understand that command.', '2024-07-16', '2024-07-15 21:24:11'),
(637, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 21:27:53'),
(638, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 21:27:57'),
(639, '2631836', 'frecipe_bot', 'You are already registered! Use the following commands:\n/recipe <query> - To search for recipes\n/recommend - To get recipe recommendations\n/help - To display help and commands', '2024-07-16', '2024-07-15 21:27:57'),
(640, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 21:30:06'),
(641, '2631836', 'frecipe_bot', 'You are already registered! Use the following commands:\n/recipe <query> - To search for recipes\n/recommend - To get recipe recommendations\n/help - To display help and commands', '2024-07-16', '2024-07-15 21:30:07'),
(642, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 21:30:27'),
(643, '2631836', 'frecipe_bot', 'Please register first using the /register command', '2024-07-16', '2024-07-15 21:30:27'),
(644, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 21:30:34'),
(645, '2631836', 'frecipe_bot', 'Thank you for registering 🤗\n\nPlease use the commands below:\n--------------------------------------------------------------------\n/register - Register to gain full access\n/recipe <query> - Search for a recipe\n/recommend - Get recommended recipes\n/help - Display help and commands\n==================================\n Your chat will be visible in our database\n\nBy Restu Lestari', '2024-07-16', '2024-07-15 21:30:34'),
(646, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 21:30:55'),
(647, '2631836', 'frecipe_bot', 'You are already registered! Use the following commands:\n/recipe <query> - To search for recipes\n/recommend - To get recipe recommendations\n/help - To display help and commands', '2024-07-16', '2024-07-15 21:30:55'),
(648, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 21:31:39'),
(649, '5702419887', 'restulestarii', 'Spiced Fennel Salad With Creme Fraiche And Meyer Lemon', '2024-07-16', '2024-07-15 21:31:42'),
(650, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 21:33:56'),
(651, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 21:34:01'),
(652, '2631836', 'frecipe_bot', 'You are already registered! Use the following commands:\n/recipe <query> - To search for recipes\n/recommend - To get recipe recommendations\n/help - To display help and commands', '2024-07-16', '2024-07-15 21:34:02'),
(653, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 21:34:09'),
(654, '5702419887', 'restulestarii', 'Tartufi', '2024-07-16', '2024-07-15 21:34:12'),
(655, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 21:35:34'),
(656, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 21:35:38'),
(657, '2631836', 'frecipe_bot', 'You are already registered!\n\nUse the following commands:\n--------------------------------------------------------------------\n/recipe <query> - To search for recipes\n/recommend - To get recipe recommendations\n/help - To display help and commands\n==================================', '2024-07-16', '2024-07-15 21:35:38'),
(658, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 21:35:42'),
(659, '5702419887', 'restulestarii', 'Raspberry-Rosé Sorbet', '2024-07-16', '2024-07-15 21:35:45'),
(660, '5702419887', 'frecipe_bot', 'Sent recipe details for: Raspberry-Rosé Sorbet', '2024-07-16', '2024-07-15 21:35:47'),
(661, '5702419887', 'restulestarii', '/recipe ramen', '2024-07-16', '2024-07-15 21:37:13'),
(662, '5702419887', 'frecipe_bot', 'Sent recipe details for: Homemade Tonkotsu Ramen', '2024-07-16', '2024-07-15 21:37:17'),
(663, '5702419887', 'frecipe_bot', 'Fetching recipe: Homemade Tonkotsu Ramen', '2024-07-16', '2024-07-15 21:37:17'),
(664, '2631836', 'frecipe_bot', 'pppp', '2024-07-16', '2024-07-15 21:37:31'),
(665, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 21:37:57'),
(666, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 21:38:03'),
(667, '5702419887', 'restulestarii', 'Grilled Sweet Potato Soup with Chorizo Toast', '2024-07-16', '2024-07-15 21:38:09'),
(668, '5702419887', 'frecipe_bot', 'Sent recipe details for: Grilled Sweet Potato Soup with Chorizo Toast', '2024-07-16', '2024-07-15 21:38:11'),
(669, '5702419887', 'restulestarii', '/help', '2024-07-16', '2024-07-15 21:38:26'),
(670, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 21:38:53'),
(671, '2631836', 'frecipe_bot', 'You are already registered!\n\nUse the following commands:\n--------------------------------------------------------------------\n/recipe <query> - To search for recipes\n/recommend - To get recipe recommendations\n/help - To display help and commands\n==================================', '2024-07-16', '2024-07-15 21:38:54'),
(672, '5702419887', 'restulestarii', '/help', '2024-07-16', '2024-07-15 21:39:29'),
(673, '2631836', 'frecipe_bot', 'Here are some of the available commands:\n\n/register - Register with the bot to get full access\n/weather - Check the current weather by city', '2024-07-16', '2024-07-15 21:39:29'),
(674, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 21:40:32'),
(675, '2631836', 'frecipe_bot', 'Please register first using the /register command', '2024-07-16', '2024-07-15 21:40:32'),
(676, '5702419887', 'restulestarii', 'yugg', '2024-07-16', '2024-07-15 21:40:55'),
(677, '2631836', 'frecipe_bot', 'Please register first using the /register command', '2024-07-16', '2024-07-15 21:40:56'),
(678, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 21:40:57'),
(679, '2631836', 'frecipe_bot', 'Thank you for registering 🤗\n\nPlease use the commands below:\n--------------------------------------------------------------------\n/register - Register to gain full access\n/recipe <query> - Search for a recipe\n/recommend - Get recommended recipes\n/help - Display help and commands\n==================================\n Your chat will be visible in our database\n\nBy Restu Lestari', '2024-07-16', '2024-07-15 21:40:58'),
(680, '5702419887', 'restulestarii', 'fdrgc', '2024-07-16', '2024-07-15 21:41:00'),
(681, '5702419887', 'restulestarii', '/recipe', '2024-07-16', '2024-07-15 21:41:17'),
(682, '5702419887', 'restulestarii', 'uwuwhahsbs', '2024-07-16', '2024-07-15 21:41:22'),
(683, '5702419887', 'restulestarii', '/recipe 7272hwhs', '2024-07-16', '2024-07-15 21:41:37'),
(684, '5702419887', 'restulestarii', 'hello', '2024-07-16', '2024-07-15 21:41:43'),
(685, '5702419887', 'restulestarii', 'thanks', '2024-07-16', '2024-07-15 21:41:46'),
(686, '5702419887', 'restulestarii', 'haha', '2024-07-16', '2024-07-15 21:43:45'),
(687, '5702419887', 'restulestarii', 'thanks', '2024-07-16', '2024-07-15 21:43:52'),
(688, '5702419887', 'restulestarii', 'makasi', '2024-07-16', '2024-07-15 21:44:15'),
(689, '5702419887', 'restulestarii', '/uwhaha', '2024-07-16', '2024-07-15 21:46:38'),
(690, '5702419887', 'restulestarii', 'makasi', '2024-07-16', '2024-07-15 21:46:42'),
(691, '5702419887', 'restulestarii', 'thanks', '2024-07-16', '2024-07-15 21:47:16'),
(692, '5702419887', 'restulestarii', '/uwhaha', '2024-07-16', '2024-07-15 21:48:31'),
(693, '5702419887', 'restulestarii', 'makasi', '2024-07-16', '2024-07-15 21:48:36'),
(694, '5702419887', 'restulestarii', 'thanks', '2024-07-16', '2024-07-15 21:48:43'),
(695, '5702419887', 'restulestarii', '/uwhaha', '2024-07-16', '2024-07-15 21:50:09'),
(696, '5702419887', 'restulestarii', 'thanks', '2024-07-16', '2024-07-15 21:50:13'),
(697, '2631836', 'frecipe_bot', 'You\'re welcome!', '2024-07-16', '2024-07-15 21:50:13'),
(698, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 21:50:16'),
(699, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 21:50:38'),
(700, '2631836', 'frecipe_bot', 'Command not recognized. Please use /help to see available commands.', '2024-07-16', '2024-07-15 21:50:38'),
(701, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 21:51:53'),
(702, '2631836', 'frecipe_bot', 'Command not recognized. Please use /help to see available commands.', '2024-07-16', '2024-07-15 21:51:53'),
(703, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 21:51:55'),
(704, '2631836', 'frecipe_bot', 'Command not recognized. Please use /help to see available commands.', '2024-07-16', '2024-07-15 21:51:56'),
(705, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 21:51:57'),
(706, '2631836', 'frecipe_bot', 'Command not recognized. Please use /help to see available commands.', '2024-07-16', '2024-07-15 21:51:58'),
(707, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 21:55:01'),
(708, '2631836', 'frecipe_bot', 'Command not recognized. Please use /help to see available commands.', '2024-07-16', '2024-07-15 21:55:01'),
(709, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 21:55:03'),
(710, '2631836', 'frecipe_bot', 'Command not recognized. Please use /help to see available commands.', '2024-07-16', '2024-07-15 21:55:03'),
(711, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 21:55:57'),
(712, '2631836', 'frecipe_bot', 'Command not recognized. Please use /help to see available commands.', '2024-07-16', '2024-07-15 21:55:57'),
(713, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 21:58:38'),
(714, '2631836', 'frecipe_bot', 'Please register first using the /register command.', '2024-07-16', '2024-07-15 21:58:39'),
(715, '5702419887', 'restulestarii', '/ywhshsh', '2024-07-16', '2024-07-15 21:58:46'),
(716, '2631836', 'frecipe_bot', 'Command not recognized. Please use /help to see available commands.', '2024-07-16', '2024-07-15 21:58:46'),
(717, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 21:59:25'),
(718, '2631836', 'frecipe_bot', 'Please register first using the /register command.', '2024-07-16', '2024-07-15 21:59:25'),
(719, '5702419887', 'restulestarii', 'thanks', '2024-07-16', '2024-07-15 21:59:31'),
(720, '2631836', 'frecipe_bot', 'You\'re welcome!', '2024-07-16', '2024-07-15 21:59:32'),
(721, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 21:59:50'),
(722, '2631836', 'frecipe_bot', 'Please register first using the /register command.', '2024-07-16', '2024-07-15 21:59:51'),
(723, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 21:59:52'),
(724, '2631836', 'frecipe_bot', 'Thank you for registering 🤗\n\nPlease use the commands below:\n--------------------------------------------------------------------\n/register - Register to gain full access\n/recipe <query> - Search for a recipe\n/recommend - Get recommended recipes\n/help - Display help and commands\n==================================\n Your chat will be visible in our database\n\nBy Restu Lestari', '2024-07-16', '2024-07-15 21:59:53'),
(725, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 22:00:08'),
(726, '2631836', 'frecipe_bot', 'You are already registered!\n\nUse the following commands:\n--------------------------------------------------------------------\n/recipe <query> - To search for recipes\n/recommend - To get recipe recommendations\n/help - To display help and commands\n==================================', '2024-07-16', '2024-07-15 22:00:08'),
(727, '5702419887', 'restulestarii', '/recipe', '2024-07-16', '2024-07-15 22:00:18'),
(728, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:01:53'),
(729, '5702419887', 'restulestarii', 'Raspberry-Rosé Sorbet', '2024-07-16', '2024-07-15 22:01:56'),
(730, '5702419887', 'frecipe_bot', 'Sent recipe details for: Raspberry-Rosé Sorbet', '2024-07-16', '2024-07-15 22:01:58'),
(731, '5702419887', 'restulestarii', 'thanks', '2024-07-16', '2024-07-15 22:02:17'),
(732, '2631836', 'frecipe_bot', 'Command not recognized. Please use /help to see available commands.', '2024-07-16', '2024-07-15 22:02:18'),
(733, '5702419887', 'restulestarii', '/jshsbs', '2024-07-16', '2024-07-15 22:02:25'),
(734, '2631836', 'frecipe_bot', 'Command not recognized. Please use /help to see available commands.', '2024-07-16', '2024-07-15 22:02:25'),
(735, '5702419887', 'restulestarii', 'ya', '2024-07-16', '2024-07-15 22:02:27'),
(736, '2631836', 'frecipe_bot', 'Command not recognized. Please use /help to see available commands.', '2024-07-16', '2024-07-15 22:02:28'),
(737, '5702419887', 'restulestarii', 'thanks', '2024-07-16', '2024-07-15 22:02:33'),
(738, '2631836', 'frecipe_bot', 'Command not recognized. Please use /help to see available commands.', '2024-07-16', '2024-07-15 22:02:33'),
(739, '5702419887', 'restulestarii', '/recipe ramen', '2024-07-16', '2024-07-15 22:05:00'),
(740, '5702419887', 'frecipe_bot', 'Sent recipe details for: Homemade Tonkotsu Ramen', '2024-07-16', '2024-07-15 22:05:04'),
(741, '5702419887', 'frecipe_bot', 'Fetching recipe: Homemade Tonkotsu Ramen', '2024-07-16', '2024-07-15 22:05:04'),
(742, '5702419887', 'restulestarii', 'thanks', '2024-07-16', '2024-07-15 22:05:04'),
(743, '2631836', 'frecipe_bot', 'Command not recognized. Please use /help to see available commands.', '2024-07-16', '2024-07-15 22:05:04'),
(744, '5702419887', 'restulestarii', 'thanks', '2024-07-16', '2024-07-15 22:06:13'),
(745, '2631836', 'frecipe_bot', 'Command not recognized. Please use /help to see available commands.', '2024-07-16', '2024-07-15 22:06:14'),
(746, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 22:06:23'),
(747, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 22:06:27'),
(748, '2631836', 'frecipe_bot', 'You are already registered!\n\nUse the following commands:\n--------------------------------------------------------------------\n/recipe <query> - To search for recipes\n/recommend - To get recipe recommendations\n/help - To display help and commands\n==================================', '2024-07-16', '2024-07-15 22:06:27'),
(749, '5702419887', 'restulestarii', 'thanks', '2024-07-16', '2024-07-15 22:06:31'),
(750, '2631836', 'frecipe_bot', 'Command not recognized. Please use /help to see available commands.', '2024-07-16', '2024-07-15 22:06:32'),
(751, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 22:07:42'),
(752, '2631836', 'frecipe_bot', 'You are already registered!\n\nUse the following commands:\n--------------------------------------------------------------------\n/recipe <query> - To search for recipes\n/recommend - To get recipe recommendations\n/help - To display help and commands\n==================================', '2024-07-16', '2024-07-15 22:07:42'),
(753, '5702419887', 'restulestarii', 'thanks', '2024-07-16', '2024-07-15 22:07:45'),
(754, '2631836', 'frecipe_bot', 'Command not recognized. Please use /help to see available commands.', '2024-07-16', '2024-07-15 22:07:46'),
(755, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 22:08:59'),
(756, '2631836', 'frecipe_bot', 'You are already registered!\n\nUse the following commands:\n--------------------------------------------------------------------\n/recipe <query> - To search for recipes\n/recommend - To get recipe recommendations\n/help - To display help and commands\n==================================', '2024-07-16', '2024-07-15 22:08:59'),
(757, '5702419887', 'restulestarii', 'thnks', '2024-07-16', '2024-07-15 22:09:00'),
(758, '2631836', 'frecipe_bot', 'Command not recognized. Please use /help to see available commands.', '2024-07-16', '2024-07-15 22:09:01'),
(759, '5702419887', 'restulestarii', 'thanks', '2024-07-16', '2024-07-15 22:09:08'),
(760, '2631836', 'frecipe_bot', 'Command not recognized. Please use /help to see available commands.', '2024-07-16', '2024-07-15 22:09:08'),
(761, '5702419887', 'restulestarii', '/uwhwhwh', '2024-07-16', '2024-07-15 22:12:07'),
(762, '2631836', 'frecipe_bot', 'Command not recognized. Please use /help to see available commands.', '2024-07-16', '2024-07-15 22:12:07'),
(763, '5702419887', 'restulestarii', 'thnk', '2024-07-16', '2024-07-15 22:12:12'),
(764, '2631836', 'frecipe_bot', 'Keyword not found: thnk', '2024-07-16', '2024-07-15 22:12:12'),
(765, '5702419887', 'restulestarii', 'thanks', '2024-07-16', '2024-07-15 22:12:15'),
(766, '2631836', 'frecipe_bot', 'You\'re welcome!', '2024-07-16', '2024-07-15 22:12:15'),
(767, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 22:12:22'),
(768, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 22:12:24'),
(769, '2631836', 'frecipe_bot', 'User requested /register again', '2024-07-16', '2024-07-15 22:12:25'),
(770, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:12:27'),
(771, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:12:56'),
(772, '5702419887', 'restulestarii', 'Raspberry-Rosé Sorbet', '2024-07-16', '2024-07-15 22:13:00'),
(773, '5702419887', 'frecipe_bot', 'Sent recipe details for: Raspberry-Rosé Sorbet', '2024-07-16', '2024-07-15 22:13:02'),
(774, '5702419887', 'restulestarii', '/recipe', '2024-07-16', '2024-07-15 22:13:09'),
(775, '5702419887', 'restulestarii', '/recipe sayur', '2024-07-16', '2024-07-15 22:13:27'),
(776, '5702419887', 'frecipe_bot', 'Fetching recipe: Sayur Lodeh recipes', '2024-07-16', '2024-07-15 22:13:31'),
(777, '5702419887', 'restulestarii', '/recipe sayur', '2024-07-16', '2024-07-15 22:13:39'),
(778, '5702419887', 'frecipe_bot', 'Fetching recipe: Sayur Lodeh recipes', '2024-07-16', '2024-07-15 22:13:42'),
(779, '5702419887', 'restulestarii', '/recipe mangga', '2024-07-16', '2024-07-15 22:13:49'),
(780, '5702419887', 'frecipe_bot', 'Sent recipe details for: Burong Mangga/Pickled Green Mango', '2024-07-16', '2024-07-15 22:13:52'),
(781, '5702419887', 'frecipe_bot', 'Fetching recipe: Burong Mangga/Pickled Green Mango', '2024-07-16', '2024-07-15 22:13:52'),
(782, '5702419887', 'restulestarii', '/recipe apel', '2024-07-16', '2024-07-15 22:14:10'),
(783, '5702419887', 'restulestarii', '/recipe ramen', '2024-07-16', '2024-07-15 22:14:30'),
(784, '5702419887', 'frecipe_bot', 'Sent recipe details for: Homemade Tonkotsu Ramen', '2024-07-16', '2024-07-15 22:14:33'),
(785, '5702419887', 'frecipe_bot', 'Fetching recipe: Homemade Tonkotsu Ramen', '2024-07-16', '2024-07-15 22:14:33'),
(786, '5702419887', 'restulestarii', '/recipe spagetti', '2024-07-16', '2024-07-15 22:14:43'),
(787, '5702419887', 'frecipe_bot', 'Sent recipe details for: Spagetti Squash Soup', '2024-07-16', '2024-07-15 22:14:46'),
(788, '5702419887', 'frecipe_bot', 'Fetching recipe: Spagetti Squash Soup', '2024-07-16', '2024-07-15 22:14:46'),
(789, '5702419887', 'restulestarii', 'thanks', '2024-07-16', '2024-07-15 22:15:01'),
(790, '2631836', 'frecipe_bot', 'You\'re welcome!', '2024-07-16', '2024-07-15 22:15:01'),
(791, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:16:29'),
(792, '5702419887', 'restulestarii', 'Gado Gado (Mixed Vegetable Salad With Indonesian Peanut Sauce)', '2024-07-16', '2024-07-15 22:16:36'),
(793, '5702419887', 'frecipe_bot', 'Sent recipe details for: Gado Gado (Mixed Vegetable Salad With Indonesian Peanut Sauce)', '2024-07-16', '2024-07-15 22:16:38'),
(794, '5702419887', 'restulestarii', 'Indonesian Chicken', '2024-07-16', '2024-07-15 22:16:48'),
(795, '5702419887', 'frecipe_bot', 'Sent recipe details for: Indonesian Chicken', '2024-07-16', '2024-07-15 22:16:50'),
(796, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:17:52'),
(797, '5702419887', 'restulestarii', 'Indonesian Baked Fish', '2024-07-16', '2024-07-15 22:17:58'),
(798, '5702419887', 'restulestarii', 'Indonesian Baked Fish', '2024-07-16', '2024-07-15 22:18:03'),
(799, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:18:07'),
(800, '5702419887', 'restulestarii', 'Sweet Soy Sauce', '2024-07-16', '2024-07-15 22:18:09'),
(801, '5702419887', 'frecipe_bot', 'Sent recipe details for: Sweet Soy Sauce', '2024-07-16', '2024-07-15 22:18:11'),
(802, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:18:14'),
(803, '5702419887', 'restulestarii', 'Opor (Indonesian Candlenut Curry)', '2024-07-16', '2024-07-15 22:18:18'),
(804, '5702419887', 'frecipe_bot', 'Sent recipe details for: Opor (Indonesian Candlenut Curry)', '2024-07-16', '2024-07-15 22:18:20'),
(805, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:18:23'),
(806, '5702419887', 'restulestarii', 'Indonesian Tofu Satays', '2024-07-16', '2024-07-15 22:18:26'),
(807, '5702419887', 'frecipe_bot', 'Sent recipe details for: Indonesian Tofu Satays', '2024-07-16', '2024-07-15 22:18:27'),
(808, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:18:34'),
(809, '5702419887', 'restulestarii', 'Jus Alpukat (Indonesian Avocado-Coffee Shake) Recipe', '2024-07-16', '2024-07-15 22:18:41'),
(810, '5702419887', 'frecipe_bot', 'Sent recipe details for: Jus Alpukat (Indonesian Avocado-Coffee Shake) Recipe', '2024-07-16', '2024-07-15 22:18:42'),
(811, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:18:57'),
(812, '5702419887', 'restulestarii', 'Indonesian Baked Fish', '2024-07-16', '2024-07-15 22:19:01'),
(813, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:20:12'),
(814, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:20:23'),
(815, '5702419887', 'restulestarii', 'Indonesian Baked Fish', '2024-07-16', '2024-07-15 22:20:33'),
(816, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:21:02'),
(817, '5702419887', 'restulestarii', 'Gado Gado (Mixed Vegetable Salad With Indonesian Peanut Sauce)', '2024-07-16', '2024-07-15 22:21:06'),
(818, '5702419887', 'frecipe_bot', 'Sent recipe details for: Gado Gado (Mixed Vegetable Salad With Indonesian Peanut Sauce)', '2024-07-16', '2024-07-15 22:21:08'),
(819, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:21:20'),
(820, '5702419887', 'restulestarii', 'Indonesian Tofu Satays', '2024-07-16', '2024-07-15 22:21:24'),
(821, '5702419887', 'frecipe_bot', 'Sent recipe details for: Indonesian Tofu Satays', '2024-07-16', '2024-07-15 22:21:26'),
(822, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:23:08'),
(823, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:23:14'),
(824, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:24:12'),
(825, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:24:16'),
(826, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:25:08'),
(827, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:25:35'),
(828, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:27:18'),
(829, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:28:48'),
(830, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:32:14'),
(831, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:32:22'),
(832, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:32:59'),
(833, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:38:23'),
(834, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:38:24'),
(835, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:39:59'),
(836, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:40:06'),
(837, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:40:09'),
(838, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:40:40'),
(839, '5702419887', 'restulestarii', 'Cilantro-Lime Noodles with Shrimp', '2024-07-16', '2024-07-15 22:40:45'),
(840, '5702419887', 'frecipe_bot', 'Sent recipe details for: Cilantro-Lime Noodles with Shrimp', '2024-07-16', '2024-07-15 22:40:47'),
(841, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:40:50'),
(842, '5702419887', 'restulestarii', 'Tofu Caprese, Taste of Asia', '2024-07-16', '2024-07-15 22:40:52'),
(843, '5702419887', 'frecipe_bot', 'Sent recipe details for: Tofu Caprese, Taste of Asia', '2024-07-16', '2024-07-15 22:40:54'),
(844, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:40:56'),
(845, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:40:58'),
(846, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:41:02'),
(847, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:41:04'),
(848, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:41:39'),
(849, '5702419887', 'restulestarii', 'Tofu Caprese, Taste of Asia', '2024-07-16', '2024-07-15 22:42:10'),
(850, '5702419887', 'frecipe_bot', 'Sent recipe details for: Tofu Caprese, Taste of Asia', '2024-07-16', '2024-07-15 22:42:12'),
(851, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:42:42'),
(852, '5702419887', 'restulestarii', 'thanks', '2024-07-16', '2024-07-15 22:42:44'),
(853, '2631836', 'frecipe_bot', 'You\'re welcome!', '2024-07-16', '2024-07-15 22:42:44'),
(854, '5702419887', 'restulestarii', 'Spiced Fennel Salad With Creme Fraiche And Meyer Lemon', '2024-07-16', '2024-07-15 22:42:47'),
(855, '5702419887', 'frecipe_bot', 'Sent recipe details for: Spiced Fennel Salad With Creme Fraiche And Meyer Lemon', '2024-07-16', '2024-07-15 22:42:49'),
(856, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:43:54'),
(857, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:45:40'),
(858, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:47:17'),
(859, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 22:57:27'),
(860, '5702419887', 'restulestarii', 'Gado Gado (Mixed Vegetable Salad With Indonesian Peanut Sauce)', '2024-07-16', '2024-07-15 22:57:32'),
(861, '5702419887', 'frecipe_bot', 'Sent recipe details for: Gado Gado (Mixed Vegetable Salad With Indonesian Peanut Sauce)', '2024-07-16', '2024-07-15 22:57:33'),
(862, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 23:00:29'),
(863, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 23:00:31'),
(864, '2631836', 'frecipe_bot', 'User requested /register again', '2024-07-16', '2024-07-15 23:00:32'),
(865, '5702419887', 'restulestarii', '/recipe', '2024-07-16', '2024-07-15 23:00:34'),
(866, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 23:00:37'),
(867, '5702419887', 'restulestarii', 'Opor (Indonesian Candlenut Curry)', '2024-07-16', '2024-07-15 23:00:40'),
(868, '5702419887', 'frecipe_bot', 'Sent recipe details for: Opor (Indonesian Candlenut Curry)', '2024-07-16', '2024-07-15 23:00:41'),
(869, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 23:01:18'),
(870, '2631836', 'frecipe_bot', 'Unrecognized command from unregistered user', '2024-07-16', '2024-07-15 23:01:19'),
(871, '5702419887', 'restulestarii', '/help', '2024-07-16', '2024-07-15 23:01:20'),
(872, '2631836', 'frecipe_bot', 'User requested help without registration', '2024-07-16', '2024-07-15 23:01:21'),
(873, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 23:01:31'),
(874, '2631836', 'frecipe_bot', 'Thank you for registering 🤗\n\nPlease use the commands below:\n--------------------------------------------------------------------\n/register - Register to gain full access\n/recipe <query> - Search for a recipe\n/recommend - Get recommended recipes\n/help - Display help and commands\n==================================\nYour chat will be visible in our database\n\nBy Restu Lestari', '2024-07-16', '2024-07-15 23:01:31'),
(875, '5702419887', 'restulestarii', 'oke', '2024-07-16', '2024-07-15 23:02:19'),
(876, '2631836', 'frecipe_bot', 'Okeyyy', '2024-07-16', '2024-07-15 23:02:20'),
(877, '2631836', 'frecipe_bot', 'pp', '2024-07-16', '2024-07-15 23:02:39'),
(878, '2631836', 'frecipe_bot', 'hahaha\n', '2024-07-16', '2024-07-15 23:06:11'),
(879, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 23:07:20'),
(880, '2631836', 'frecipe_bot', 'User requested /register again', '2024-07-16', '2024-07-15 23:07:21'),
(881, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 23:07:22'),
(882, '2631836', 'frecipe_bot', 'ppp', '2024-07-16', '2024-07-15 23:36:13'),
(883, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 23:41:38'),
(884, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 23:41:43'),
(885, '2631836', 'frecipe_bot', 'User requested /register again', '2024-07-16', '2024-07-15 23:41:44'),
(886, '5702419887', 'restulestarii', '/recipe salmon', '2024-07-16', '2024-07-15 23:42:00'),
(887, '5702419887', 'frecipe_bot', 'Sent recipe details for: Salmon Rillettes/Salmon Spread', '2024-07-16', '2024-07-15 23:42:04'),
(888, '5702419887', 'frecipe_bot', 'Fetching recipe: Salmon Rillettes/Salmon Spread', '2024-07-16', '2024-07-15 23:42:04'),
(889, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 23:42:10'),
(890, '5702419887', 'restulestarii', 'Indonesian Tofu Satays', '2024-07-16', '2024-07-15 23:42:16'),
(891, '5702419887', 'frecipe_bot', 'Sent recipe details for: Indonesian Tofu Satays', '2024-07-16', '2024-07-15 23:42:18'),
(892, '5702419887', 'restulestarii', '/help', '2024-07-16', '2024-07-15 23:42:25'),
(893, '5702419887', 'restulestarii', 'thanks', '2024-07-16', '2024-07-15 23:42:28'),
(894, '2631836', 'frecipe_bot', 'You\'re welcome!', '2024-07-16', '2024-07-15 23:42:28'),
(895, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 23:44:23'),
(896, '2631836', 'frecipe_bot', 'User tried to use /run without registration', '2024-07-16', '2024-07-15 23:44:24'),
(897, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-15 23:44:39'),
(898, '2631836', 'frecipe_bot', 'User tried to use /run without registration', '2024-07-16', '2024-07-15 23:44:39'),
(899, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 23:44:42'),
(900, '2631836', 'frecipe_bot', 'Thank you for registering 🤗\n\nPlease use the commands below:\n--------------------------------------------------------------------\n/register - Register to gain full access\n/recipe <query> - Search for a recipe\n/recommend - Get recommended recipes\n/help - Display help and commands\n==================================\nYour chat will be visible in our database\n\nBy Restu Lestari', '2024-07-16', '2024-07-15 23:44:42'),
(901, '5702419887', 'restulestarii', '/help', '2024-07-16', '2024-07-15 23:44:50'),
(902, '5702419887', 'restulestarii', '/recipe', '2024-07-16', '2024-07-15 23:44:55'),
(903, '5702419887', 'restulestarii', '/recipe salmon', '2024-07-16', '2024-07-15 23:45:01'),
(904, '5702419887', 'frecipe_bot', 'Sent recipe details for: Salmon Rillettes/Salmon Spread', '2024-07-16', '2024-07-15 23:45:04'),
(905, '5702419887', 'frecipe_bot', 'Fetching recipe: Salmon Rillettes/Salmon Spread', '2024-07-16', '2024-07-15 23:45:04'),
(906, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 23:45:06'),
(907, '5702419887', 'restulestarii', 'Sweet Soy Sauce', '2024-07-16', '2024-07-15 23:45:12'),
(908, '5702419887', 'frecipe_bot', 'Sent recipe details for: Sweet Soy Sauce', '2024-07-16', '2024-07-15 23:45:14'),
(909, '5702419887', 'restulestarii', 'Opor (Indonesian Candlenut Curry)', '2024-07-16', '2024-07-15 23:45:19'),
(910, '5702419887', 'frecipe_bot', 'Sent recipe details for: Opor (Indonesian Candlenut Curry)', '2024-07-16', '2024-07-15 23:45:21'),
(911, '5702419887', 'restulestarii', 'thanks', '2024-07-16', '2024-07-15 23:45:27'),
(912, '2631836', 'frecipe_bot', 'You\'re welcome!', '2024-07-16', '2024-07-15 23:45:27'),
(913, '5702419887', 'restulestarii', 'hello', '2024-07-16', '2024-07-15 23:46:29'),
(914, '2631836', 'frecipe_bot', 'Hello there! How can I assist you today?', '2024-07-16', '2024-07-15 23:46:30'),
(915, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-15 23:46:37'),
(916, '2631836', 'frecipe_bot', 'User requested /register again', '2024-07-16', '2024-07-15 23:46:37'),
(917, '5702419887', 'restulestarii', '/recipe ramen', '2024-07-16', '2024-07-15 23:46:46'),
(918, '2631836', 'frecipe_bot', 'Sent recipe details for: Homemade Tonkotsu Ramen', '2024-07-16', '2024-07-15 23:46:49'),
(919, '2631836', 'frecipe_bot', 'Fetching recipe: Homemade Tonkotsu Ramen', '2024-07-16', '2024-07-15 23:46:49'),
(920, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-15 23:46:52'),
(921, '5702419887', 'restulestarii', 'Dim Sum Dipping Sauce', '2024-07-16', '2024-07-15 23:46:58'),
(922, '2631836', 'frecipe_bot', 'Sent recipe details for: Dim Sum Dipping Sauce', '2024-07-16', '2024-07-15 23:46:59'),
(923, '5702419887', 'restulestarii', 'thanks', '2024-07-16', '2024-07-15 23:47:09'),
(924, '2631836', 'frecipe_bot', 'You\'re welcome!', '2024-07-16', '2024-07-15 23:47:10'),
(925, '5702419887', 'restulestarii', 'oke', '2024-07-16', '2024-07-15 23:47:13'),
(926, '2631836', 'frecipe_bot', 'Okeyyy', '2024-07-16', '2024-07-15 23:47:14'),
(927, '2631836', 'frecipe_bot', 'haiii', '2024-07-16', '2024-07-16 01:51:35'),
(928, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-16 01:52:08'),
(929, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-16 01:54:48'),
(930, '2631836', 'frecipe_bot', 'User tried to use /run without registration', '2024-07-16', '2024-07-16 01:54:50'),
(931, '5702419887', 'restulestarii', '/recommend', '2024-07-16', '2024-07-16 01:55:02'),
(932, '2631836', 'frecipe_bot', 'Unrecognized command from unregistered user', '2024-07-16', '2024-07-16 01:55:03'),
(933, '5702419887', 'restulestarii', '/register', '2024-07-16', '2024-07-16 01:55:07'),
(934, '2631836', 'frecipe_bot', 'Thank you for registering 🤗\n\nPlease use the commands below:\n--------------------------------------------------------------------\n/register - Register to gain full access\n/recipe <query> - Search for a recipe\n/recommend - Get recommended recipes\n/help - Display help and commands\n==================================\nYour chat will be visible in our database\n\nBy Restu Lestari', '2024-07-16', '2024-07-16 01:55:08'),
(935, '5702419887', 'restulestarii', '/run', '2024-07-16', '2024-07-16 02:27:26'),
(936, '201575235', 'ajibsusanto', '/start', '2024-07-16', '2024-07-16 02:36:34'),
(937, '2631836', 'frecipe_bot', 'Unrecognized command from unregistered user', '2024-07-16', '2024-07-16 02:36:36'),
(938, '201575235', 'ajibsusanto', 'tes', '2024-07-16', '2024-07-16 02:36:36'),
(939, '2631836', 'frecipe_bot', 'Keyword not found: tes', '2024-07-16', '2024-07-16 02:36:36'),
(940, '201575235', 'ajibsusanto', '/help', '2024-07-16', '2024-07-16 02:36:41'),
(941, '2631836', 'frecipe_bot', 'User requested help without registration', '2024-07-16', '2024-07-16 02:36:42'),
(942, '201575235', 'ajibsusanto', '/register', '2024-07-16', '2024-07-16 02:36:46'),
(943, '2631836', 'frecipe_bot', 'Thank you for registering 🤗\n\nPlease use the commands below:\n--------------------------------------------------------------------\n/register - Register to gain full access\n/recipe <query> - Search for a recipe\n/recommend - Get recommended recipes\n/help - Display help and commands\n==================================\nYour chat will be visible in our database\n\nBy Restu Lestari', '2024-07-16', '2024-07-16 02:36:46'),
(944, '201575235', 'ajibsusanto', '/help', '2024-07-16', '2024-07-16 02:36:59'),
(945, '201575235', 'ajibsusanto', '/recipe', '2024-07-16', '2024-07-16 02:37:05'),
(946, '201575235', 'ajibsusanto', '/recipe rendang', '2024-07-16', '2024-07-16 02:37:19'),
(947, '201575235', 'frecipe_bot', 'Sent recipe details for: Rendang Ayam (Spiced Chicken Rendang)', '2024-07-16', '2024-07-16 02:37:27'),
(948, '201575235', 'frecipe_bot', 'Fetching recipe: Rendang Ayam (Spiced Chicken Rendang)', '2024-07-16', '2024-07-16 02:37:27'),
(949, '201575235', 'ajibsusanto', '/recipe rawon', '2024-07-16', '2024-07-16 02:38:00'),
(950, '201575235', 'ajibsusanto', '/recommend', '2024-07-16', '2024-07-16 02:40:14'),
(951, '201575235', 'ajibsusanto', 'Indonesian Chicken', '2024-07-16', '2024-07-16 02:40:23'),
(952, '201575235', 'frecipe_bot', 'Sent recipe details for: Indonesian Chicken', '2024-07-16', '2024-07-16 02:40:29'),
(953, '2631836', 'frecipe_bot', 'haiii', '2024-07-16', '2024-07-16 02:40:58');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `chat_id` varchar(20) NOT NULL,
  `username` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `chat_id`, `username`, `created_at`) VALUES
(195, '5702419887', 'restulestarii', '2024-07-16 02:27:26'),
(196, '201575235', 'ajibsusanto', '2024-07-16 02:36:34');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kunci`
--
ALTER TABLE `kunci`
  ADD PRIMARY KEY (`kata`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `chat_id` (`chat_id`);

--
-- Indexes for table `pesan`
--
ALTER TABLE `pesan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `chat_id` (`chat_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `pesan`
--
ALTER TABLE `pesan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=954;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=205;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
