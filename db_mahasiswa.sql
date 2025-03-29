-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 29, 2025 at 07:55 PM
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
-- Database: `db_mahasiswa`
--

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `id` int(11) NOT NULL,
  `nim` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `jenis_kelamin` varchar(255) NOT NULL,
  `kehadiran` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`id`, `nim`, `nama`, `jenis_kelamin`, `kehadiran`) VALUES
(1, '2203999', 'Amelia Zalfa Julianti', 'Perempuan', 90),
(2, '2202292', 'Muhammad Iqbal Fadhilah', 'Laki-laki', 85),
(3, '2202346', 'Muhammad Rifky Afandi', 'Laki-laki', 92),
(4, '2210239', 'Muhammad Hanif Abdillah', 'Laki-laki', 88),
(5, '2202046', 'Nurainun', 'Perempuan', 80),
(6, '2205101', 'Kelvin Julian Putra', 'Laki-laki', 95),
(7, '2200163', 'Rifanny Lysara Annastasya', 'Perempuan', 87),
(8, '2202869', 'Revana Faliha Salma', 'Perempuan', 93),
(9, '2209489', 'Rakha Dhifiargo Hariadi', 'Laki-laki', 76),
(10, '2203142', 'Roshan Syalwan Nurilham', 'Laki-laki', 89),
(11, '2200311', 'Raden Rahman Ismail', 'Laki-laki', 82),
(12, '2200978', 'Ratu Syahirah Khairunnisa', 'Perempuan', 91),
(13, '2204509', 'Muhammad Fahreza Fauzan', 'Laki-laki', 94),
(14, '2205027', 'Muhammad Rizki Revandi', 'Laki-laki', 77),
(15, '2203484', 'Arya Aydin Margono', 'Laki-laki', 85),
(16, '2200481', 'Marvel Ravindra Dioputra', 'Laki-laki', 90),
(17, '2209889', 'Muhammad Fadlul Hafiizh', 'Laki-laki', 80),
(18, '2206697', 'Rifa Sania', 'Perempuan', 92),
(19, '2207260', 'Imam Chalish Rafidhul Haque', 'Laki-laki', 88),
(20, '2204343', 'Meiva Labibah Putri', 'Perempuan', 85);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
