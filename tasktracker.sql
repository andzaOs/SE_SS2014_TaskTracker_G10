
CREATE DATABASE IF NOT EXISTS `tasktracker` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `tasktracker`;



CREATE TABLE IF NOT EXISTS `klijent` (
  
`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  
`naziv` varchar(100) COLLATE utf8_bin NOT NULL,
  
`adresa` varchar(300) COLLATE utf8_bin NOT NULL,
  
`brojTelefona` varchar(30) COLLATE utf8_bin NOT NULL,

`email` varchar(50) COLLATE utf8_bin NOT NULL,

`vidljivo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;





CREATE TABLE IF NOT EXISTS `korisnik` (
  
`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  
`ime` varchar(20) COLLATE utf8_bin NOT NULL,
  
`prezime` varchar(20) COLLATE utf8_bin NOT NULL,
  
`jmbg` varchar(13) COLLATE utf8_bin NOT NULL,
  
`brojLK` varchar(10) COLLATE utf8_bin NOT NULL,
  
`adresa` varchar(100) COLLATE utf8_bin NOT NULL,
  
`telefon` varchar(20) COLLATE utf8_bin NOT NULL,
  
`email` varchar(30) COLLATE utf8_bin NOT NULL,
  
`datumZaposlenja` date NOT NULL,
  
`korisnickoIme` varchar(20) COLLATE utf8_bin NOT NULL,
  
`sifra` varchar(1024) COLLATE utf8_bin NOT NULL,
  
`tipKorisnika` bigint(20) unsigned NOT NULL,
  
`vidljivo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;




CREATE TABLE IF NOT EXISTS `obavljeni_posao` (
  
`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  
`preuzimanje` bigint(20) unsigned NOT NULL,
  
`usluga` int(10) unsigned NOT NULL,
  
`brojSati` int(10) unsigned NOT NULL,
  
`datumIzvrsenja` date NOT NULL,
  
`vrijemeUnosa` datetime NOT NULL,
  
`opis` varchar(300) COLLATE utf8_bin NOT NULL,
  
`vidljivo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;





CREATE TABLE IF NOT EXISTS `radni_zadatak` (
  
`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  
`klijent` bigint(20) unsigned NOT NULL,
  
`krajnjiDatumIzvrsenja` date NOT NULL,
  
`maxBrojServisera` int(11) NOT NULL,
  
`opis` varchar(1000) COLLATE utf8_bin NOT NULL,
  `
statusDodijeljenosti` int(11) NOT NULL,
  
`statusIzvrsenja` tinyint(1) NOT NULL,
  
`potpunoDodjeljen` tinyint(1) NOT NULL,
  
`vidljivo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;





CREATE TABLE IF NOT EXISTS `rasporedjeni_zadatak` (
  
`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  
`radniZadatak` bigint(20) unsigned NOT NULL,
  
`serviser` bigint(20) unsigned NOT NULL,
  
`vrijemePreuzimanja` datetime NOT NULL,
  
`vidljivo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;





CREATE TABLE IF NOT EXISTS `tip_korisnika` (
  
`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  
`naziv` varchar(20) COLLATE utf8_bin NOT NULL,
  
`vidljivo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;





CREATE TABLE IF NOT EXISTS `vrsta_usluge` (
  
`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  
`naziv` varchar(100) COLLATE utf8_bin NOT NULL,
  
`vidljivo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

