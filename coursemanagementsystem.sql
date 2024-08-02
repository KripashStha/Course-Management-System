-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 12, 2024 at 06:25 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coursemanagementsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `admin_email` varchar(255) DEFAULT NULL,
  `admin_password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `admin_name`, `admin_email`, `admin_password`) VALUES
(1, 'Kripash', 'kripash@gmail.com', 'kkrr');

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `course` varchar(255) DEFAULT NULL,
  `Year` varchar(255) DEFAULT NULL,
  `Semester` varchar(255) DEFAULT NULL,
  `Module_1` varchar(255) DEFAULT NULL,
  `Module_2` varchar(255) DEFAULT NULL,
  `Module_3` varchar(255) DEFAULT NULL,
  `Module_4` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`id`, `course`, `Year`, `Semester`, `Module_1`, `Module_2`, `Module_3`, `Module_4`) VALUES
(1, 'BSc Hons Computer Science', '1', '1', 'Concepts of AI', 'OOP', 'NMC', 'Computing'),
(2, 'BCA', '1', '1', 'Mathematics', 'Programming', 'Academic Skills', 'Internet Architecture'),
(3, 'CSIT', '1', '1', 'Big Data', 'Web Technologies', 'Computing', 'Cloud'),
(4, 'BBA', '1', '1', 'Finance', 'Accounting', 'Business Law', 'Economics');

-- --------------------------------------------------------

--
-- Table structure for table `instructor`
--

CREATE TABLE `instructor` (
  `teacher_id` int(11) NOT NULL,
  `teacher_name` varchar(255) DEFAULT NULL,
  `teacher_email` varchar(255) DEFAULT NULL,
  `teacher_password` varchar(255) DEFAULT NULL,
  `Module_1` varchar(255) DEFAULT NULL,
  `Module_2` varchar(255) DEFAULT NULL,
  `Module_3` varchar(255) DEFAULT NULL,
  `Module_4` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `instructor`
--

INSERT INTO `instructor` (`teacher_id`, `teacher_name`, `teacher_email`, `teacher_password`, `Module_1`, `Module_2`, `Module_3`, `Module_4`) VALUES
(1, 'teacher', 'teacher@gmail.com', 'teacher123', 'Concepts of AI', 'OOP', 'NMC', 'Computing'),
(3, 'aashina', 'aashina@gmail.com', 'aashina123', 'Mathematics', 'Programming', 'Academic Skills', 'Internet Architecture'),
(4, 'Ram', 'ram@gmail.com', 'ram123', 'Finance', 'Accounting', 'Business Law', 'Economics');

-- --------------------------------------------------------

--
-- Table structure for table `result`
--

CREATE TABLE `result` (
  `id` int(11) NOT NULL,
  `student_id` int(11) DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL,
  `semseter` int(11) DEFAULT NULL,
  `Module_1` varchar(255) DEFAULT NULL,
  `marks_1` varchar(255) DEFAULT NULL,
  `Module_2` varchar(255) DEFAULT NULL,
  `marks_2` varchar(255) DEFAULT NULL,
  `Module_3` varchar(255) DEFAULT NULL,
  `marks_3` varchar(255) DEFAULT NULL,
  `Module_4` varchar(255) DEFAULT NULL,
  `marks_4` varchar(255) DEFAULT NULL,
  `Result` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `result`
--

INSERT INTO `result` (`id`, `student_id`, `course`, `semseter`, `Module_1`, `marks_1`, `Module_2`, `marks_2`, `Module_3`, `marks_3`, `Module_4`, `marks_4`, `Result`) VALUES
(1, 1, 'BSc Hons Computer Science', 1, 'Concepts of AI', '    70', 'OOP', '    80', 'NMC', '    76', 'Computing', '   78', 'Pass'),
(2, 7, 'BCA', 1, 'Mathematics', '    70.0', 'Programming', '    76.0', 'Academic Skills', '    80.0', 'Internet Architecture', '   77.0', 'Pass'),
(3, 8, 'BCA', 1, 'Mathematics', '    70.0', 'Programming', '    80.0', 'Academic Skills', '    76.0', 'Internet Architecture', '   78.0', 'Pass');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `username`, `email`, `password`, `course`) VALUES
(1, 'kripash', 'kripash@gmail.com', 'kripash', 'BSc Hons Computer Science'),
(3, 'jake', 'jake@gmail.com', 'jake', 'BBA'),
(6, 'pras', 'pras@gmail.com', 'pras', 'BSc Hons Computer Science'),
(7, 'ram', 'kkk@gmail.com', 'ram', 'BCA'),
(8, 'john', 'john@gmail.com', 'john', 'BCA');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `instructor`
--
ALTER TABLE `instructor`
  ADD PRIMARY KEY (`teacher_id`);

--
-- Indexes for table `result`
--
ALTER TABLE `result`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `instructor`
--
ALTER TABLE `instructor`
  MODIFY `teacher_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `result`
--
ALTER TABLE `result`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
