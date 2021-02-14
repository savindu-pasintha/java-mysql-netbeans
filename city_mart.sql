-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 20, 2020 at 07:48 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `city_mart`
--

-- --------------------------------------------------------

--
-- Table structure for table `perchaseorder`
--

CREATE TABLE `perchaseorder` (
  `order_id` int(100) NOT NULL,
  `item_name` varchar(100) NOT NULL,
  `supplier_name` varchar(100) NOT NULL,
  `unite_price` varchar(50) NOT NULL,
  `quentity` varchar(100) NOT NULL,
  `discount` varchar(50) NOT NULL,
  `Totat_price` varchar(50) NOT NULL,
  `Date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `perchaseorder`
--

INSERT INTO `perchaseorder` (`order_id`, `item_name`, `supplier_name`, `unite_price`, `quentity`, `discount`, `Totat_price`, `Date`) VALUES
(1, 'orange', 'supun', '20', '200', '56', '400000', '2009-10-20 06:34:59'),
(2, 'Orange', 'Oshada', '20', '1500', '2000', '28000.0', '2011-11-20 15:27:25'),
(3, 'Mango', 'Oshada', '25', '1300', '760', '31740.0', '2011-11-20 15:36:24'),
(5, 'mango', 'saman', '82', '300', '200', '24400.0', '2009-10-20 14:07:10'),
(8, 'orange', 'Pn', '75', '80', '10', '5990.0', '2009-10-20 14:34:33'),
(9, 'savindu', 'sasa', '60', '80', '20', '4780.0', '2010-10-20 03:43:28'),
(10, 'orange', 'supun', '80.2', '60', '50', '4762.0', '2009-10-20 06:52:07'),
(11, 'll', 'iooio', '50', '60', '80', '2920.0', '2008-11-20 05:03:20'),
(12, 'mango', 'savindu', '100', '300', '50', '1800.0', '2020-11-11 03:47:47'),
(13, 'mango', 'savindu', '100', '300', '50', '1800.0', '2020-11-11 03:47:47'),
(14, 'mango', 'savindu', '100', '300', '50', '1800.0', '2020-11-11 03:47:47'),
(15, 'mango', 'savindu', '100', '300', '50', '1800.0', '2020-11-11 03:47:47'),
(80, 'Mango', 'supun', '100', '50', '20', '4980.0', '2008-11-20 03:11:26'),
(507, 'mango', 'sumudu', '50', '60', '20', '2980.0', '2010-11-20 13:38:35');

-- --------------------------------------------------------

--
-- Table structure for table `request_order`
--

CREATE TABLE `request_order` (
  `ro_id` int(100) NOT NULL,
  `ro_full_name` varchar(250) NOT NULL,
  `ro_date` varchar(50) NOT NULL,
  `ro_birthdate` varchar(50) NOT NULL,
  `ro_add` varchar(250) NOT NULL,
  `ro_email` varchar(250) NOT NULL,
  `ro_contact` int(10) NOT NULL,
  `ro_item` varchar(50) NOT NULL,
  `ro_quentity` varchar(50) NOT NULL,
  `ro_yourprice` varchar(50) NOT NULL,
  `ro_description` text NOT NULL,
  `Approve` varchar(5) DEFAULT NULL,
  `Stored_type` varchar(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `request_order`
--

INSERT INTO `request_order` (`ro_id`, `ro_full_name`, `ro_date`, `ro_birthdate`, `ro_add`, `ro_email`, `ro_contact`, `ro_item`, `ro_quentity`, `ro_yourprice`, `ro_description`, `Approve`, `Stored_type`) VALUES
(2, 'Savindu Pasintha', '', '1999-08-24', 'Klauthar,Benthota', 'savindu@gmail.com', 745557588, 'Orange', '380', '3544', 'Big tasty Orange', 'No', 'Yes'),
(3, 'Oshada Nethsara', '09/10/20   08:07:59', '1999-05-24', 'No.57,kaluthra,Clombu', 'Oshada@gmail.com', 768755787, 'Mango', '500', '2560', 'its very delisious fruit,and cheeep to sell.', 'Yes', 'No');

-- --------------------------------------------------------

--
-- Table structure for table `store`
--

CREATE TABLE `store` (
  `id` int(100) NOT NULL,
  `item_name` varchar(50) NOT NULL,
  `amount` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `store`
--

INSERT INTO `store` (`id`, `item_name`, `amount`) VALUES
(1, 'Mango', 1000),
(2, 'Apple', 10088),
(3, 'pinapple', 18384),
(4, 'Grapes', 876);

-- --------------------------------------------------------

--
-- Table structure for table `suplieraccounttable`
--

CREATE TABLE `suplieraccounttable` (
  `s_id` int(5) NOT NULL,
  `s_name` varchar(50) NOT NULL,
  `s_contact_no` int(10) NOT NULL,
  `s_add` varchar(250) NOT NULL,
  `s_food_type` varchar(100) NOT NULL,
  `enter_date` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `suplieraccounttable`
--

INSERT INTO `suplieraccounttable` (`s_id`, `s_name`, `s_contact_no`, `s_add`, `s_food_type`, `enter_date`) VALUES
(2, 'Supun', 342273512, 'No.5,Nugegoda,Colombo 7', 'Apple', '2020-11-09 12:33:15'),
(3, 'Aloka', 754015676, 'No.57,Pahekanuwa,Aluthgama', 'Orange', '2020-11-11 15:09:52');

-- --------------------------------------------------------

--
-- Table structure for table `user_accountstable`
--

CREATE TABLE `user_accountstable` (
  `id` int(11) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `addline1` varchar(100) NOT NULL,
  `addline2` varchar(100) NOT NULL,
  `cityname` varchar(50) NOT NULL,
  `country` varchar(50) NOT NULL,
  `nic` varchar(15) NOT NULL,
  `age` int(2) NOT NULL,
  `contactno` int(11) NOT NULL,
  `worktype` varchar(15) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(15) NOT NULL,
  `comfrimpassword` varchar(15) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `add_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_accountstable`
--

INSERT INTO `user_accountstable` (`id`, `firstname`, `lastname`, `addline1`, `addline2`, `cityname`, `country`, `nic`, `age`, `contactno`, `worktype`, `username`, `password`, `comfrimpassword`, `gender`, `add_date`) VALUES
(1, 'savinsu', 'pasintha', 'no.57', 'ritiketiya', 'aluthgama', 'Sri lanka', '0768755787', 21, 768755787, 'manager', 'user', 'pass', 'pass', 'male', '2020-10-08 03:00:17'),
(3, 'savinsu', 'pasintha', 'no.57', 'ritiketiya', 'aluthgama', 'Sri Lanka', '0768755787', 21, 768755787, 'Stock-Keeper', 'u', 'u', 'u', 'female', '2020-10-08 03:00:17'),
(4, 'Supuni', 'Sulakshana', 'No,68', 'Galmaththa', 'Aluthgama', 'Japan', '0764567890', 20, 768755787, 'Cashier', 'SupuniSulakshana999', '99pass', '99pass', 'female', '2020-10-08 03:00:17'),
(6, 'savinsu', 'pasintha', 'no.57', 'ritiketiya', 'aluthgama', 'Sri Lanka', '0768755787', 21, 768755787, 'Manager', 'new', 'new', 'new', 'male', '2020-10-08 03:00:17'),
(7, 'savinsu', 'pasintha', 'no.57', 'ritiketiya', 'aluthgama', 'Sri Lanka', '0768755787', 21, 768755787, 'Cashier', 'u', 'u', 'u', 'female', '2020-10-08 03:00:17'),
(100, 'savindu ', 'pasintha', 'No,57,Ritiketiya', 'New Colone', 'Aluthgama', 'Sri Lanka', '991452278v', 21, 768755787, 'Manager', 'savindupasintha123', 'pass99', 'pass99', 'male', '2020-11-11 14:34:40');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `perchaseorder`
--
ALTER TABLE `perchaseorder`
  ADD PRIMARY KEY (`order_id`);

--
-- Indexes for table `request_order`
--
ALTER TABLE `request_order`
  ADD PRIMARY KEY (`ro_id`);

--
-- Indexes for table `store`
--
ALTER TABLE `store`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `suplieraccounttable`
--
ALTER TABLE `suplieraccounttable`
  ADD PRIMARY KEY (`s_id`);

--
-- Indexes for table `user_accountstable`
--
ALTER TABLE `user_accountstable`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `request_order`
--
ALTER TABLE `request_order`
  MODIFY `ro_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
