-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 29, 2017 at 10:00 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `collage_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `Co_Id` int(30) NOT NULL,
  `Co_Name` varchar(50) NOT NULL,
  `Co_Hours` int(20) NOT NULL,
  `Ins_Id` int(30) NOT NULL,
  `Dep_Id` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`Co_Id`, `Co_Name`, `Co_Hours`, `Ins_Id`, `Dep_Id`) VALUES
(1, 'jhgfugfy', 5, 1, 1),
(2, 'gkhjugkuy', 7, 2, 5),
(4, 'hgfjgyuftyf', 2, 3, 5);

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `Dep_Id` int(30) NOT NULL,
  `Dep_Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`Dep_Id`, `Dep_Name`) VALUES
(1, 'Computer Science'),
(2, 'Physics'),
(3, 'Mathematics'),
(4, 'English'),
(5, 'Chemistry');

-- --------------------------------------------------------

--
-- Table structure for table `instructor`
--

CREATE TABLE `instructor` (
  `Ins_Id` int(30) NOT NULL,
  `Ins_Name` varchar(50) NOT NULL,
  `Ins_Address` varchar(150) NOT NULL,
  `Ins_Phone` varchar(20) NOT NULL,
  `Ins_Salary` int(30) NOT NULL,
  `Dep_Id` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `instructor`
--

INSERT INTO `instructor` (`Ins_Id`, `Ins_Name`, `Ins_Address`, `Ins_Phone`, `Ins_Salary`, `Dep_Id`) VALUES
(1, 'sherif sami', 'menouf', '05647365473', 3000, 1),
(2, 'Ahmed Ali', 'Cairo', '56737873687', 2000, 2),
(3, 'zaki', 'mansoura', '5736736873', 1500, 1),
(4, 'kjkhgkhg', 'kljhl;jkhl;o', '5457887369', 5454, 3),
(5, 'kjhlkghliu', 'hjulhjulgh', '6547369783', 5000, 4);

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `Stud_Id` int(30) NOT NULL,
  `Stud_Name` varchar(50) NOT NULL,
  `Stud_Address` varchar(150) NOT NULL,
  `Stud_Phone` varchar(30) NOT NULL,
  `Dep_Id` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`Stud_Id`, `Stud_Name`, `Stud_Address`, `Stud_Phone`, `Dep_Id`) VALUES
(1, 'jhfjyugfjyuf', 'kjlgfkugf', '54564564769', 1),
(2, 'gfjyufiyuyu', 'gkuygukyg', '465778979', 2),
(3, 'hjuvgfkuhgfukh', 'hjvgkgkugyk', '01091506335', 3),
(4, 'Mohamed Elgendy', 'Menouf', '01091506335', 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`Co_Id`),
  ADD KEY `Dep_Id` (`Dep_Id`),
  ADD KEY `Ins_Id` (`Ins_Id`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`Dep_Id`);

--
-- Indexes for table `instructor`
--
ALTER TABLE `instructor`
  ADD PRIMARY KEY (`Ins_Id`),
  ADD KEY `Dep_Id` (`Dep_Id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`Stud_Id`),
  ADD KEY `Dep_Id` (`Dep_Id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `courses`
--
ALTER TABLE `courses`
  ADD CONSTRAINT `courses_ibfk_1` FOREIGN KEY (`Dep_Id`) REFERENCES `department` (`Dep_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `courses_ibfk_2` FOREIGN KEY (`Ins_Id`) REFERENCES `instructor` (`Ins_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `instructor`
--
ALTER TABLE `instructor`
  ADD CONSTRAINT `instructor_ibfk_1` FOREIGN KEY (`Dep_Id`) REFERENCES `department` (`Dep_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `students_ibfk_1` FOREIGN KEY (`Dep_Id`) REFERENCES `department` (`Dep_Id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
