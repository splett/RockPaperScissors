CREATE DATABASE project;
use project;

CREATE TABLE `game` (
  `idGAME` int(11) NOT NULL,
  `idPLAYER` int(11) DEFAULT NULL,
  PRIMARY KEY (`idGAME`)
) ;

CREATE TABLE `matchs` (
  `idGame` int(11) NOT NULL,
  `idMatch` int(11) NOT NULL,
  `humanPlayer` int(11) DEFAULT NULL,
  `automaticPlayer` int(11) DEFAULT NULL,
  PRIMARY KEY (`idGame`,`idMatch`)
) ;

CREATE TABLE `player` (
  `idPlayer` int(11) NOT NULL,
  `namePlayer` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPlayer`)
) 