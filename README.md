This project represents sort of a Student Gradebook for a college.
The operations you can do: Add a student, View student list, Delete a student, Change a student grade, Add/remove teachers (stored in database)

PREREQUISITES:
Following is SQL code for phpmyadmin database:
-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 31, 2024 at 10:19 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `student`
--

-- --------------------------------------------------------

--
-- Table structure for table `studentinfo`
--

CREATE TABLE `studentinfo` (
  `First Name` varchar(50) NOT NULL,
  `Last Name` varchar(50) NOT NULL,
  `Student ID` int(20) NOT NULL,
  `Course` varchar(10) NOT NULL,
  `Final Grade` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `studentinfo`
--

INSERT INTO `studentinfo` (`First Name`, `Last Name`, `Student ID`, `Course`, `Final Grade`) VALUES
('Kleda', 'Peci', 3456789, 'SWE', 'CB'),
('Lori', 'Kalemasi', 4444444, 'CE', 'DD'),
('Daniela', 'Shahini', 5555555, 'SWE', 'AA'),
('Rosela', 'Berberi', 3333333, 'CEN', 'CB'),
('tini', 'stoessel', 245667, 'CEN', 'FF'),
('xas', 'as', 2, 'SWE', 'AA'),
('st', 'st', 12, 'CEN', 'AA');

-- --------------------------------------------------------

--
-- Table structure for table `teacherinfo`
--

CREATE TABLE `teacherinfo` (
  `Name` varchar(50) NOT NULL,
  `Surname` varchar(50) NOT NULL,
  `Teacher ID` int(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `License Number` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teacherinfo`
--

INSERT INTO `teacherinfo` (`Name`, `Surname`, `Teacher ID`, `Email`, `License Number`) VALUES
('atea', 'caslli', 23424, 'hbhgbk', 34444),
('dff', 'sdsdf', 43, 'dsef', 355),
('asas', 'dadd', 5453, 'zdv', 35),
('gfdh', 'dhdhgt', 3444, 'zsxvgsdg@gmail.com', 324555),
('drh', 'thy', 56, '65rd', 56),
('grfdg', 'rgdht', 567, 'fgb', 66667),
('hgf', 'ftjt', 5555, 'xfhd', 4444),
('ateaaaaa', 'caslliiii', 999, 'ftvg', 999999),
('Teacher', 'Surname', 12345678, 'teachersurname@gmail.com', 44567),
('ateac', 'c', 2333, 'sdd', 1233);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
