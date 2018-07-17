-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 17, 2018 at 10:46 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jsp`
--

-- --------------------------------------------------------

--
-- Table structure for table `cardsales`
--

CREATE TABLE `cardsales` (
  `salesid` int(11) NOT NULL,
  `invoiceNo` int(11) NOT NULL,
  `fseid` int(11) NOT NULL,
  `shopname` varchar(30) NOT NULL,
  `date` date NOT NULL,
  `cardtype` varchar(10) NOT NULL,
  `quantity` int(11) NOT NULL,
  `start` varchar(30) NOT NULL,
  `end` varchar(30) NOT NULL,
  `price` float NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cardsales`
--

INSERT INTO `cardsales` (`salesid`, `invoiceNo`, `fseid`, `shopname`, `date`, `cardtype`, `quantity`, `start`, `end`, `price`) VALUES
(70, 20, 1, 'Thilak Stores', '2017-12-13', '20', 2, '1006', '1007', 38.4),
(68, 18, 1, 'Thilak Stores', '2017-12-13', '1000', 2, '5002', '5003', 1920),
(69, 19, 1, 'Thilak Stores', '2017-12-13', '1000', 2, '5004', '5005', 1920),
(62, 16, 1, 'Thilak Stores', '2017-12-13', '50', 1, '2002', '2002', 48),
(67, 17, 1, 'Thilak Stores', '2017-12-13', '1000', 2, '5000', '5001', 1920),
(66, 17, 1, 'Thilak Stores', '2017-12-13', '500', 2, '4002', '4003', 960),
(61, 15, 1, 'Thilak Stores', '2017-12-13', '20', 2, '1002', '1003', 38.4),
(40, 9, 1, 'shop1', '2017-12-10', '20', 2, '100500', '100501', 38.4),
(41, 10, 1, 'shop1', '2017-12-10', '20', 2, '100500', '100501', 38.4),
(42, 11, 1, 'shop1', '2017-12-10', '20', 2, '100502', '100503', 38.4),
(65, 17, 1, 'Thilak Stores', '2017-12-13', '100', 2, '3002', '3003', 192),
(72, 21, 1, 'Thilak Stores', '2018-05-23', '20', 2, '1008', '1009', 38.4),
(71, 20, 1, 'Thilak Stores', '2017-12-13', '100', 2, '3004', '3005', 192),
(60, 14, 1, 'shopname1', '2017-12-12', '100', 2, '3000', '3001', 192),
(59, 14, 1, 'shopname1', '2017-12-12', '50', 2, '2000', '2001', 96),
(58, 14, 1, 'shopname1', '2017-12-12', '20', 2, '1000', '1001', 38.4),
(63, 17, 1, 'Thilak Stores', '2017-12-13', '20', 2, '1004', '1005', 38.4),
(64, 17, 1, 'Thilak Stores', '2017-12-13', '50', 1, '2003', '2003', 48),
(73, 21, 1, 'Thilak Stores', '2018-05-23', '100', 2, '3006', '3007', 192);

-- --------------------------------------------------------

--
-- Table structure for table `damagecheck`
--

CREATE TABLE `damagecheck` (
  `serialNo` int(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `damagecheck`
--

INSERT INTO `damagecheck` (`serialNo`) VALUES
(1000),
(1001),
(1002),
(1003),
(1004),
(1005),
(1006),
(1007),
(1008),
(1009),
(2000),
(2001),
(2002),
(2003),
(3000),
(3001),
(3002),
(3003),
(3004),
(3005),
(3006),
(3007),
(4002),
(4003),
(5002),
(5003),
(5004),
(5005),
(100508),
(100509);

-- --------------------------------------------------------

--
-- Table structure for table `damaged_fse`
--

CREATE TABLE `damaged_fse` (
  `Number` int(11) NOT NULL,
  `Date` date NOT NULL,
  `ShopId` int(11) NOT NULL,
  `Type` varchar(255) NOT NULL,
  `SerialNumber` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `damaged_main`
--

CREATE TABLE `damaged_main` (
  `Date` date NOT NULL,
  `FSEId` varchar(255) NOT NULL,
  `Type` varchar(255) NOT NULL,
  `SerialNumber` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `damaged_main`
--

INSERT INTO `damaged_main` (`Date`, `FSEId`, `Type`, `SerialNumber`) VALUES
('2017-12-02', '4', '100', '155855'),
('2017-12-03', '6', '500', '589689');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `Id` int(11) NOT NULL,
  `FirstName` varchar(255) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `NIC` varchar(255) NOT NULL,
  `DOB` date NOT NULL,
  `Type` varchar(255) NOT NULL,
  `EmpId` varchar(255) NOT NULL,
  `TpNum` int(11) NOT NULL,
  `Address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`Id`, `FirstName`, `LastName`, `Gender`, `NIC`, `DOB`, `Type`, `EmpId`, `TpNum`, `Address`) VALUES
(1, 'Ishara', 'Wickramasinghe', 'Female', '946754324V', '1994-04-05', 'Administrator', 'ADM02', 712345678, 'Police Junction,Anuradhapura'),
(2, 'Randika', 'Godigamuwa', 'Female', '946743232V', '1994-08-12', 'Manager', 'MAN03', 772245654, 'Panadura Town, Panadura'),
(3, 'Ruwanari', 'Heenkenda', 'Female', '946756787V', '1994-03-14', 'FSE', 'FSE09', 719876543, 'Dalada Widiya,Kandy'),
(4, 'Yasas', 'Ranawaka', 'male', '876545454V', '1987-02-05', 'FSE', 'FSE04', 718787878, 'Kirulapana,Colombo');

-- --------------------------------------------------------

--
-- Table structure for table `graphsales`
--

CREATE TABLE `graphsales` (
  `Date` date NOT NULL,
  `FSE1` decimal(14,2) NOT NULL,
  `FSE4` decimal(14,2) NOT NULL,
  `FSE6` decimal(14,2) NOT NULL,
  `FSE7` decimal(14,2) NOT NULL,
  `FSE8` decimal(14,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `graphsales`
--

INSERT INTO `graphsales` (`Date`, `FSE1`, `FSE4`, `FSE6`, `FSE7`, `FSE8`) VALUES
('2017-12-02', '1200.00', '2100.00', '865.00', '0.00', '0.00'),
('2017-12-03', '1300.00', '1500.00', '1023.00', '0.00', '0.00'),
('2017-12-09', '25.00', '123.00', '87.00', '67.00', '34.00'),
('2017-12-10', '254.00', '333.00', '222.00', '234.00', '366.00');

-- --------------------------------------------------------

--
-- Table structure for table `graphtable1`
--

CREATE TABLE `graphtable1` (
  `Id` int(11) NOT NULL,
  `Count` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `graphtable1`
--

INSERT INTO `graphtable1` (`Id`, `Count`) VALUES
(1, 60);

-- --------------------------------------------------------

--
-- Table structure for table `graphtable2`
--

CREATE TABLE `graphtable2` (
  `Type` int(11) NOT NULL,
  `Count` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `graphtable2`
--

INSERT INTO `graphtable2` (`Type`, `Count`) VALUES
(20, 10),
(50, 10),
(100, 10),
(200, 10),
(500, 10),
(1000, 10);

-- --------------------------------------------------------

--
-- Table structure for table `mainstock_summary`
--

CREATE TABLE `mainstock_summary` (
  `Type` varchar(100) NOT NULL,
  `RemainingAmount` int(11) NOT NULL,
  `ReorderLevel` int(11) NOT NULL,
  `BufferLevel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mainstock_summary`
--

INSERT INTO `mainstock_summary` (`Type`, `RemainingAmount`, `ReorderLevel`, `BufferLevel`) VALUES
('100', 40, 100, 50),
('1000', 40, 100, 50),
('20', 40, 100, 50),
('200', 40, 100, 50),
('50', 40, 100, 50),
('500', 40, 100, 50);

-- --------------------------------------------------------

--
-- Table structure for table `main_stock_deatils`
--

CREATE TABLE `main_stock_deatils` (
  `Type` int(11) NOT NULL,
  `Serial` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `main_stock_deatils`
--

INSERT INTO `main_stock_deatils` (`Type`, `Serial`) VALUES
(20, 100510),
(20, 100511),
(20, 100512),
(20, 100513),
(20, 100514),
(20, 100515),
(20, 100516),
(20, 100517),
(20, 100518),
(20, 100519),
(20, 100520),
(20, 100521),
(20, 100522),
(20, 100523),
(20, 100524),
(20, 100525),
(20, 100526),
(20, 100527),
(20, 100528),
(20, 100529),
(20, 100530),
(20, 100531),
(20, 100532),
(20, 100533),
(20, 100534),
(20, 100535),
(20, 100536),
(20, 100537),
(20, 100538),
(20, 100539),
(20, 100540),
(20, 100541),
(20, 100542),
(20, 100543),
(20, 100544),
(20, 100545),
(20, 100546),
(20, 100547),
(20, 100548),
(20, 100549),
(20, 100550),
(50, 100561),
(50, 100562),
(50, 100563),
(50, 100564),
(50, 100565),
(50, 100566),
(50, 100567),
(50, 100568),
(50, 100569),
(50, 100570),
(50, 100571),
(50, 100572),
(50, 100573),
(50, 100574),
(50, 100575),
(50, 100576),
(50, 100577),
(50, 100578),
(50, 100579),
(50, 100580),
(50, 100581),
(50, 100582),
(50, 100583),
(50, 100584),
(50, 100585),
(50, 100586),
(50, 100587),
(50, 100588),
(50, 100589),
(50, 100590),
(50, 100591),
(50, 100592),
(50, 100593),
(50, 100594),
(50, 100595),
(50, 100596),
(50, 100597),
(50, 100598),
(50, 100599),
(50, 100600),
(50, 100601),
(100, 100612),
(100, 100613),
(100, 100614),
(100, 100615),
(100, 100616),
(100, 100617),
(100, 100618),
(100, 100619),
(100, 100620),
(100, 100621),
(100, 100622),
(100, 100623),
(100, 100624),
(100, 100625),
(100, 100626),
(100, 100627),
(100, 100628),
(100, 100629),
(100, 100630),
(100, 100631),
(100, 100632),
(100, 100633),
(100, 100634),
(100, 100635),
(100, 100636),
(100, 100637),
(100, 100638),
(100, 100639),
(100, 100640),
(100, 100641),
(100, 100642),
(100, 100643),
(100, 100644),
(100, 100645),
(100, 100646),
(100, 100647),
(100, 100648),
(100, 100649),
(100, 100650),
(100, 100651),
(100, 100652),
(200, 100663),
(200, 100664),
(200, 100665),
(200, 100666),
(200, 100667),
(200, 100668),
(200, 100669),
(200, 100670),
(200, 100671),
(200, 100672),
(200, 100673),
(200, 100674),
(200, 100675),
(200, 100676),
(200, 100677),
(200, 100678),
(200, 100679),
(200, 100680),
(200, 100681),
(200, 100682),
(200, 100683),
(200, 100684),
(200, 100685),
(200, 100686),
(200, 100687),
(200, 100688),
(200, 100689),
(200, 100690),
(200, 100691),
(200, 100692),
(200, 100693),
(200, 100694),
(200, 100695),
(200, 100696),
(200, 100697),
(200, 100698),
(200, 100699),
(200, 100700),
(200, 100701),
(200, 100702),
(200, 100703),
(500, 100714),
(500, 100715),
(500, 100716),
(500, 100717),
(500, 100718),
(500, 100719),
(500, 100720),
(500, 100721),
(500, 100722),
(500, 100723),
(500, 100724),
(500, 100725),
(500, 100726),
(500, 100727),
(500, 100728),
(500, 100729),
(500, 100730),
(500, 100731),
(500, 100732),
(500, 100733),
(500, 100734),
(500, 100735),
(500, 100736),
(500, 100737),
(500, 100738),
(500, 100739),
(500, 100740),
(500, 100741),
(500, 100742),
(500, 100743),
(500, 100744),
(500, 100745),
(500, 100746),
(500, 100747),
(500, 100748),
(500, 100749),
(500, 100750),
(500, 100751),
(500, 100752),
(500, 100753),
(500, 100754),
(1000, 100765),
(1000, 100766),
(1000, 100767),
(1000, 100768),
(1000, 100769),
(1000, 100770),
(1000, 100771),
(1000, 100772),
(1000, 100773),
(1000, 100774),
(1000, 100775),
(1000, 100776),
(1000, 100777),
(1000, 100778),
(1000, 100779),
(1000, 100780),
(1000, 100781),
(1000, 100782),
(1000, 100783),
(1000, 100784),
(1000, 100785),
(1000, 100786),
(1000, 100787),
(1000, 100788),
(1000, 100789),
(1000, 100790),
(1000, 100791),
(1000, 100792),
(1000, 100793),
(1000, 100794),
(1000, 100795),
(1000, 100796),
(1000, 100797),
(1000, 100798),
(1000, 100799),
(1000, 100800),
(1000, 100801),
(1000, 100802),
(1000, 100803),
(1000, 100804),
(1000, 100805);

-- --------------------------------------------------------

--
-- Table structure for table `piegraphtable`
--

CREATE TABLE `piegraphtable` (
  `Date` date NOT NULL,
  `FseId` int(11) NOT NULL,
  `Amount` decimal(14,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `piegraphtable`
--

INSERT INTO `piegraphtable` (`Date`, `FseId`, `Amount`) VALUES
('2017-12-08', 1, '4.00'),
('2017-12-09', 1, '2500.00'),
('2017-12-08', 1, '1000.00');

-- --------------------------------------------------------

--
-- Table structure for table `reloads`
--

CREATE TABLE `reloads` (
  `Amount` decimal(15,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reloads`
--

INSERT INTO `reloads` (`Amount`) VALUES
('8271.25');

-- --------------------------------------------------------

--
-- Table structure for table `reloadsales`
--

CREATE TABLE `reloadsales` (
  `reloadsalesid` int(11) NOT NULL,
  `reloadinvoiceNo` int(11) NOT NULL,
  `fseid` int(11) NOT NULL,
  `shopname` varchar(30) NOT NULL,
  `date` date NOT NULL,
  `ammount` float NOT NULL,
  `price` float NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reloadsales`
--

INSERT INTO `reloadsales` (`reloadsalesid`, `reloadinvoiceNo`, `fseid`, `shopname`, `date`, `ammount`, `price`) VALUES
(28, 27, 1, 'Thilak Stores', '2018-04-14', 600, 576),
(10, 9, 1, 'shop1', '2017-12-10', 500, 480),
(11, 10, 1, 'shop1', '2017-12-10', 300, 288),
(12, 11, 1, 'shop1', '2017-12-10', 100, 96),
(13, 12, 1, 'shop1', '2017-12-10', 400, 384),
(14, 13, 3, 'shop1', '2017-12-10', 200, 192),
(15, 14, 3, 'shop1', '2017-12-10', 200, 192),
(16, 15, 3, 'shop1', '2017-12-10', 200, 192),
(17, 16, 3, 'shop1', '2017-12-10', 200, 192),
(18, 17, 3, 'shop1', '2017-12-10', 1000, 960),
(23, 22, 1, 'shopname', '2017-12-11', 400, 384),
(24, 23, 1, 'shopname', '2017-12-11', 400, 384),
(25, 24, 1, 'shopname', '2017-12-11', 800, 768),
(26, 25, 4, 'yaka', '2017-12-12', 200, 192),
(27, 26, 1, 'Thilak Stores', '2017-12-13', 200, 192);

-- --------------------------------------------------------

--
-- Table structure for table `reload_transferred_stock`
--

CREATE TABLE `reload_transferred_stock` (
  `FseId` int(11) NOT NULL,
  `Amount` decimal(15,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reload_transferred_stock`
--

INSERT INTO `reload_transferred_stock` (`FseId`, `Amount`) VALUES
(1, '7200.00'),
(3, '9000.00'),
(4, '9100.00'),
(5, '200.00'),
(6, '100.00');

-- --------------------------------------------------------

--
-- Table structure for table `route`
--

CREATE TABLE `route` (
  `Id` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Distance` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `route`
--

INSERT INTO `route` (`Id`, `Name`, `Distance`) VALUES
(1, 'Athugala read', 250),
(2, 'High Level Road', 550),
(3, 'Thalawathugoda Road', 156),
(4, 'Kandy Road', 413);

-- --------------------------------------------------------

--
-- Table structure for table `shop`
--

CREATE TABLE `shop` (
  `ShopId` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `OwnerName` varchar(255) NOT NULL,
  `OwnerNIC` varchar(255) NOT NULL,
  `TPNumber` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `RouteId` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shop`
--

INSERT INTO `shop` (`ShopId`, `Name`, `OwnerName`, `OwnerNIC`, `TPNumber`, `Address`, `RouteId`) VALUES
(1, 'Naduli Communication', 'Naduli Samarasinghe', '826543785V', '0772345433', 'N0.56,Athugala road,kurunegala', '1'),
(2, 'Thilak Stores', 'Thilak Jayawardena', '746751231V', '0256787654', 'HighLevel Road,Nugegoda', '2'),
(3, 'Pubudu Co Ltd', 'Pubudu Perera', '856787654V', '0114567534', 'Kandy Road, Wewaldeniya', '4');

-- --------------------------------------------------------

--
-- Table structure for table `sim`
--

CREATE TABLE `sim` (
  `SIM_No` varchar(10) NOT NULL,
  `FSE_Id` varchar(2) DEFAULT 'No',
  `PEF_Id` varchar(10) DEFAULT 'No',
  `Customer_NIC` varchar(10) DEFAULT 'No'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sim`
--

INSERT INTO `sim` (`SIM_No`, `FSE_Id`, `PEF_Id`, `Customer_NIC`) VALUES
('0750312356', 'No', 'No', 'No'),
('0751234567', 'No', 'No', 'No'),
('0751478523', '1', '507', '874563987'),
('0753496187', 'No', 'No', 'No'),
('0753698521', 'No', 'No', 'No'),
('0754567593', 'No', 'No', 'No'),
('0757531598', 'No', 'No', 'No'),
('0757894236', 'No', 'No', 'No'),
('0757894561', 'No', 'No', 'No'),
('0759517532', 'No', 'No', 'No');

-- --------------------------------------------------------

--
-- Table structure for table `transfer`
--

CREATE TABLE `transfer` (
  `Date` date NOT NULL,
  `StockKeeperId` varchar(255) NOT NULL,
  `FSEId` varchar(255) NOT NULL,
  `Type` varchar(255) NOT NULL,
  `SerialNumber` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transferred_stock`
--

CREATE TABLE `transferred_stock` (
  `TransferredDate` date NOT NULL,
  `Type` varchar(255) NOT NULL,
  `SerialNumber` varchar(255) NOT NULL,
  `FSEId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transferred_stock`
--

INSERT INTO `transferred_stock` (`TransferredDate`, `Type`, `SerialNumber`, `FSEId`) VALUES
('2017-12-14', '500', '	\r\n4002', 1),
('2017-12-14', '500', '	\r\n4003', 1),
('2017-12-10', '20', '1010', 1),
('2017-12-10', '20', '1011', 1),
('2017-12-10', '20', '1012', 1),
('2017-12-10', '20', '1014', 1),
('2017-12-10', '20', '1015', 1),
('2017-12-10', '20', '1016', 1),
('2017-12-10', '20', '1017', 1),
('2017-12-10', '20', '1018', 1),
('2017-12-10', '20', '1019', 1),
('2017-12-10', '20', '1020', 1),
('2017-12-10', '50', '2004', 1),
('2017-12-10', '50', '2005', 1),
('2017-12-10', '50', '2006', 1),
('2017-12-10', '50', '2007', 1),
('2017-12-14', '100', '3008', 1),
('2017-12-14', '100', '3009', 1),
('2017-12-14', '100', '3010', 1),
('2017-12-14', '100', '3011', 1),
('2017-12-14', '500', '4000', 1),
('2017-12-14', '500', '4001', 1),
('2017-12-14', '500', '4004', 1),
('2017-12-14', '500', '4005', 1),
('2017-12-14', '500', '4006', 1),
('2017-12-14', '500', '4007', 1),
('2017-12-14', '500', '4008', 1),
('2017-12-14', '500', '4009', 1),
('2017-12-14', '500', '4010', 1),
('2017-12-14', '500', '4011', 1),
('2017-12-14', '1000', '5006', 1),
('2017-12-14', '1000', '5007', 1),
('2017-12-14', '1000', '5008', 1),
('2017-12-14', '1000', '5009', 1),
('2017-12-14', '1000', '5010', 1),
('2017-12-14', '1000', '5011', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `Id` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `UserName` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`Id`, `Name`, `UserName`, `Password`, `Type`) VALUES
(1, 'Avishka', 'avi', '123', 'FSE'),
(2, 'ishara', 'papaya', '123', 'Administrator'),
(3, 'Randika', 'randi', '123', 'Manager'),
(4, 'Yasas', 'yasas', '123', 'FSE'),
(5, 'Prabash', 'prabash', '456', 'StockKeeper'),
(6, 'Dilan', 'dilan', '123', 'FSE'),
(7, 'Hansika', 'hansi', '456', 'FSE'),
(8, 'Chathurya', 'chathu', '567', 'FSE');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cardsales`
--
ALTER TABLE `cardsales`
  ADD PRIMARY KEY (`salesid`);

--
-- Indexes for table `damagecheck`
--
ALTER TABLE `damagecheck`
  ADD PRIMARY KEY (`serialNo`);

--
-- Indexes for table `damaged_fse`
--
ALTER TABLE `damaged_fse`
  ADD PRIMARY KEY (`Number`,`SerialNumber`);

--
-- Indexes for table `damaged_main`
--
ALTER TABLE `damaged_main`
  ADD PRIMARY KEY (`SerialNumber`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `graphtable1`
--
ALTER TABLE `graphtable1`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `mainstock_summary`
--
ALTER TABLE `mainstock_summary`
  ADD PRIMARY KEY (`Type`);

--
-- Indexes for table `main_stock_deatils`
--
ALTER TABLE `main_stock_deatils`
  ADD PRIMARY KEY (`Serial`);

--
-- Indexes for table `reloadsales`
--
ALTER TABLE `reloadsales`
  ADD PRIMARY KEY (`reloadsalesid`);

--
-- Indexes for table `reload_transferred_stock`
--
ALTER TABLE `reload_transferred_stock`
  ADD PRIMARY KEY (`FseId`);

--
-- Indexes for table `route`
--
ALTER TABLE `route`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `shop`
--
ALTER TABLE `shop`
  ADD PRIMARY KEY (`ShopId`);

--
-- Indexes for table `sim`
--
ALTER TABLE `sim`
  ADD PRIMARY KEY (`SIM_No`);

--
-- Indexes for table `transferred_stock`
--
ALTER TABLE `transferred_stock`
  ADD PRIMARY KEY (`SerialNumber`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cardsales`
--
ALTER TABLE `cardsales`
  MODIFY `salesid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=74;
--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `reloadsales`
--
ALTER TABLE `reloadsales`
  MODIFY `reloadsalesid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT for table `route`
--
ALTER TABLE `route`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `shop`
--
ALTER TABLE `shop`
  MODIFY `ShopId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
