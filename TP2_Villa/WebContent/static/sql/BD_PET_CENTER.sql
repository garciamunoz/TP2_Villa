CREATE DATABASE  IF NOT EXISTS `bd_petcenter` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bd_petcenter`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_petcenter
-- ------------------------------------------------------
-- Server version	5.7.14-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_cliente`
--

DROP TABLE IF EXISTS `tb_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `codCliente` varchar(10) NOT NULL,
  `idTipoCliente` tinyint(4) NOT NULL,
  `idTipoDocumento` tinyint(4) NOT NULL,
  `nroDocumento` varchar(15) NOT NULL,
  `nomCliente` varchar(30) NOT NULL,
  `apePaternoCliente` varchar(30) NOT NULL,
  `apeMaternoCliente` varchar(30) NOT NULL,
  `idGeneroCliente` tinyint(4) NOT NULL,
  `fecNacCliente` date NOT NULL,
  `idSede` tinyint(4) NOT NULL,
  `idDistrito` int(11) NOT NULL,
  `direcCliente` varchar(50) NOT NULL,
  `celCliente` varchar(30) NOT NULL,
  `telfDomCliente` varchar(30) NOT NULL,
  `telfTraCliente` varchar(30) NOT NULL,
  `indNotificaciones` tinyint(1) NOT NULL,
  `correoElectCliente` varchar(80) NOT NULL,
  `estadoCliente` tinyint(4) NOT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE KEY `idx_cliente_codigo` (`codCliente`),
  KEY `fk_cliente_distrito` (`idDistrito`),
  KEY `fk_cliente_sede` (`idSede`),
  KEY `fk_cliente_tipoCliente` (`idTipoCliente`),
  KEY `fk_cliente_tipoDocumento` (`idTipoDocumento`),
  KEY `fk_cliente_GeneroCliente` (`idGeneroCliente`),
  CONSTRAINT `fk_cliente_GeneroCliente` FOREIGN KEY (`idGeneroCliente`) REFERENCES `tb_generocliente` (`idGeneroCliente`),
  CONSTRAINT `fk_cliente_distrito` FOREIGN KEY (`idDistrito`) REFERENCES `tb_distrito` (`idDistrito`),
  CONSTRAINT `fk_cliente_sede` FOREIGN KEY (`idSede`) REFERENCES `tb_sede` (`idSede`),
  CONSTRAINT `fk_cliente_tipoCliente` FOREIGN KEY (`idTipoCliente`) REFERENCES `tb_tipocliente` (`idTipoCliente`),
  CONSTRAINT `fk_cliente_tipoDocumento` FOREIGN KEY (`idTipoDocumento`) REFERENCES `tb_tipodocumento` (`idTipoDocumento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cliente`
--

LOCK TABLES `tb_cliente` WRITE;
/*!40000 ALTER TABLE `tb_cliente` DISABLE KEYS */;
INSERT INTO `tb_cliente` VALUES (1,'CLI0000001',1,1,'10233775','Cecilia','Ramirez','Ludeña',2,'1980-01-15',1,1,'Av. Revolucion 1247','99784514','2457866','4512487',1,'celiciaramirez@gmail.com',1),(2,'CLI0000002',1,1,'10226478','Manuel','Garcia','Ruiz',1,'1978-04-16',1,2,'Jr. Miramar 452','94441114','2411866','3512487',1,'manuelgr@gmail.com',1),(3,'CLI0000003',1,1,'10354612','Raul','Morales','Olivos',1,'1977-01-22',1,3,'Jr. Las Begonias 1452','98741114','2311266','4512487',1,'manuelgr@gmail.com',1);
/*!40000 ALTER TABLE `tb_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_consolidadobanpel`
--

DROP TABLE IF EXISTS `tb_consolidadobanpel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_consolidadobanpel` (
  `idConsolidadoBanPel` int(11) NOT NULL AUTO_INCREMENT,
  `descripcionBanPel` varchar(50) NOT NULL,
  PRIMARY KEY (`idConsolidadoBanPel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_consolidadobanpel`
--

LOCK TABLES `tb_consolidadobanpel` WRITE;
/*!40000 ALTER TABLE `tb_consolidadobanpel` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_consolidadobanpel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_contactosecundario`
--

DROP TABLE IF EXISTS `tb_contactosecundario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_contactosecundario` (
  `idContactoSecundario` int(11) NOT NULL AUTO_INCREMENT,
  `idParentContactoSecCli` tinyint(4) NOT NULL,
  `idcliente` int(11) NOT NULL,
  `nomContactoSec` varchar(30) NOT NULL,
  `apePaternoContactoSec` varchar(30) NOT NULL,
  `apeMaternoContactoSec` varchar(30) NOT NULL,
  `celContactoSec` varchar(30) NOT NULL,
  `telfDomContactoSec` varchar(30) NOT NULL,
  `descContactoSecundario` varchar(150) NOT NULL,
  PRIMARY KEY (`idContactoSecundario`),
  KEY `fk_contactoSecundario_Parentesco` (`idParentContactoSecCli`),
  CONSTRAINT `fk_contactoSecundario_Parentesco` FOREIGN KEY (`idParentContactoSecCli`) REFERENCES `tb_parentcontactoseccli` (`idParentContactoSecCli`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_contactosecundario`
--

LOCK TABLES `tb_contactosecundario` WRITE;
/*!40000 ALTER TABLE `tb_contactosecundario` DISABLE KEYS */;
INSERT INTO `tb_contactosecundario` VALUES (1,1,1,'JAMES','PARIONA','ROJAS','997130854','287-0442','Llamarlo por las tardes en la mañana no puede contestar'),(2,1,2,'MIGUEL','BORJAS','APAZA','944130854','233-0442','Llamar de preferencia al celular'),(3,2,3,'JHON','PARIONA','RIVERA','995630854','286-6442','Persona morena de 1.70m aprox.');
/*!40000 ALTER TABLE `tb_contactosecundario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_distrito`
--

DROP TABLE IF EXISTS `tb_distrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_distrito` (
  `idDistrito` int(11) NOT NULL AUTO_INCREMENT,
  `descripcionDistrito` varchar(50) NOT NULL,
  `idProvincia` int(11) NOT NULL,
  PRIMARY KEY (`idDistrito`),
  KEY `fk_distrito_provincia` (`idProvincia`),
  CONSTRAINT `fk_distrito_provincia` FOREIGN KEY (`idProvincia`) REFERENCES `tb_provincia` (`idProvincia`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_distrito`
--

LOCK TABLES `tb_distrito` WRITE;
/*!40000 ALTER TABLE `tb_distrito` DISABLE KEYS */;
INSERT INTO `tb_distrito` VALUES (1,'Chorrillos',1),(2,'Miraflores',1),(3,'Barranco',1),(4,'Villa El Salvador',1),(5,'Surco',1),(6,'Surquillo',1),(7,'Magdalena',1),(8,'San Juan de Miraflores',1),(9,'Villa Maria',1);
/*!40000 ALTER TABLE `tb_distrito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_especie`
--

DROP TABLE IF EXISTS `tb_especie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_especie` (
  `idEspecie` tinyint(4) NOT NULL AUTO_INCREMENT,
  `descripcionEspecie` varchar(50) NOT NULL,
  PRIMARY KEY (`idEspecie`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_especie`
--

LOCK TABLES `tb_especie` WRITE;
/*!40000 ALTER TABLE `tb_especie` DISABLE KEYS */;
INSERT INTO `tb_especie` VALUES (1,'CANINO'),(2,'FELINO'),(3,'ROEDOR'),(4,'AVE'),(5,'OTROS');
/*!40000 ALTER TABLE `tb_especie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_fichacontrol`
--

DROP TABLE IF EXISTS `tb_fichacontrol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_fichacontrol` (
  `idFichaControl` int(11) NOT NULL AUTO_INCREMENT,
  `idMascota` int(11) NOT NULL,
  `observaciones` varchar(300) NOT NULL,
  `fechaControl` date NOT NULL,
  `proximoControl` date NOT NULL,
  `estadoFicha` tinyint(4) NOT NULL,
  PRIMARY KEY (`idFichaControl`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_fichacontrol`
--

LOCK TABLES `tb_fichacontrol` WRITE;
/*!40000 ALTER TABLE `tb_fichacontrol` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_fichacontrol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_generocliente`
--

DROP TABLE IF EXISTS `tb_generocliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_generocliente` (
  `idGeneroCliente` tinyint(4) NOT NULL AUTO_INCREMENT,
  `descripcionGeneroCliente` varchar(50) NOT NULL,
  PRIMARY KEY (`idGeneroCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_generocliente`
--

LOCK TABLES `tb_generocliente` WRITE;
/*!40000 ALTER TABLE `tb_generocliente` DISABLE KEYS */;
INSERT INTO `tb_generocliente` VALUES (1,'MASCULINO'),(2,'FEMENINO'),(3,'OTROS');
/*!40000 ALTER TABLE `tb_generocliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_generomascota`
--

DROP TABLE IF EXISTS `tb_generomascota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_generomascota` (
  `idGeneroMascota` tinyint(4) NOT NULL AUTO_INCREMENT,
  `descripcionGenMascota` varchar(50) NOT NULL,
  PRIMARY KEY (`idGeneroMascota`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_generomascota`
--

LOCK TABLES `tb_generomascota` WRITE;
/*!40000 ALTER TABLE `tb_generomascota` DISABLE KEYS */;
INSERT INTO `tb_generomascota` VALUES (1,'MACHO'),(2,'HEMBRA');
/*!40000 ALTER TABLE `tb_generomascota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_historia_clinica`
--

DROP TABLE IF EXISTS `tb_historia_clinica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_historia_clinica` (
  `idHC` int(11) NOT NULL AUTO_INCREMENT,
  `idCliente` int(11) NOT NULL,
  `idMascota` int(11) NOT NULL,
  `edad` int(3) DEFAULT NULL,
  `observaciones` varchar(255) DEFAULT NULL,
  `estadoHC` tinyint(4) DEFAULT '1',
  `registrado` date NOT NULL,
  `actualizado` date DEFAULT NULL,
  PRIMARY KEY (`idHC`),
  KEY `fk_HC_cliente` (`idCliente`),
  KEY `fk_HC_mascota` (`idMascota`),
  CONSTRAINT `fk_HC_cliente` FOREIGN KEY (`idCliente`) REFERENCES `tb_cliente` (`idCliente`),
  CONSTRAINT `fk_HC_mascota` FOREIGN KEY (`idMascota`) REFERENCES `tb_mascota` (`idMascota`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_historia_clinica`
--

LOCK TABLES `tb_historia_clinica` WRITE;
/*!40000 ALTER TABLE `tb_historia_clinica` DISABLE KEYS */;
INSERT INTO `tb_historia_clinica` VALUES (1,1,5,12,'asdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasd',1,'2016-10-06',NULL),(2,1,2,50,'fgdgw1234241487148wf1d4w7e1fwef1we8f1we8f1we1f8we1f8we1f8ew1f87we1f87we1f87*we1f8*7wef7we81*f7we*8f7we1f7we8*f17we1*f87*we1f7e8*w1f7ew1*f87we1f7we8*1f7we*81f7we*1f7*we8f17we8*1f7we*1f*87we1f7we*81f7we*1f7we*1f7we*8f17we*f1we7*8f1we78*f1we7*f17we*8f17we*f1',1,'2016-10-06',NULL);
/*!40000 ALTER TABLE `tb_historia_clinica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_mascota`
--

DROP TABLE IF EXISTS `tb_mascota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_mascota` (
  `idMascota` int(11) NOT NULL AUTO_INCREMENT,
  `codMascota` varchar(10) NOT NULL,
  `nomMascota` varchar(30) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idRelClienteMascota` tinyint(4) NOT NULL,
  `idRaza` tinyint(4) NOT NULL,
  `fotoMascota` blob NOT NULL,
  `estadoMascota` tinyint(4) NOT NULL,
  `descMascota` varchar(150) NOT NULL,
  `idGeneroMascota` tinyint(4) NOT NULL,
  `fechaNacMascota` date NOT NULL,
  PRIMARY KEY (`idMascota`),
  UNIQUE KEY `idx_mascota_codigo` (`codMascota`),
  KEY `fk_mascota_cliente` (`idCliente`),
  KEY `fk_mascota_raza` (`idRaza`),
  KEY `fk_mascota_genero` (`idGeneroMascota`),
  KEY `fk_mascota_relacionCliente` (`idRelClienteMascota`),
  CONSTRAINT `fk_mascota_cliente` FOREIGN KEY (`idCliente`) REFERENCES `tb_cliente` (`idCliente`),
  CONSTRAINT `fk_mascota_genero` FOREIGN KEY (`idGeneroMascota`) REFERENCES `tb_generomascota` (`idGeneroMascota`),
  CONSTRAINT `fk_mascota_raza` FOREIGN KEY (`idRaza`) REFERENCES `tb_raza` (`idRaza`),
  CONSTRAINT `fk_mascota_relacionCliente` FOREIGN KEY (`idRelClienteMascota`) REFERENCES `tb_relacionclientemascota` (`idRelClienteMascota`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_mascota`
--

LOCK TABLES `tb_mascota` WRITE;
/*!40000 ALTER TABLE `tb_mascota` DISABLE KEYS */;
INSERT INTO `tb_mascota` VALUES (1,'MAS0000001','Firulay',1,1,1,'',1,'presenta alergias al spray antipulgas',1,'2014-05-12'),(2,'MAS0000002','Duquesa',1,1,2,'',1,'problemas al respirar',2,'2010-05-14'),(3,'MAS0000003','Bronco',1,1,4,'',1,'presenta problemas de la vista de un ojo',1,'2011-01-22'),(5,'mas03','CHIQUITO',1,1,1,'',1,'',2,'2014-05-12');
/*!40000 ALTER TABLE `tb_mascota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_pais`
--

DROP TABLE IF EXISTS `tb_pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_pais` (
  `idPais` int(11) NOT NULL AUTO_INCREMENT,
  `descripcionPais` varchar(50) NOT NULL,
  PRIMARY KEY (`idPais`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_pais`
--

LOCK TABLES `tb_pais` WRITE;
/*!40000 ALTER TABLE `tb_pais` DISABLE KEYS */;
INSERT INTO `tb_pais` VALUES (1,'PERU'),(2,'ARGENTINA'),(3,'BRASIL'),(4,'CHILE'),(5,'ECUADOR'),(6,'BOLIVIA'),(7,'OTROS');
/*!40000 ALTER TABLE `tb_pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_parentcontactoseccli`
--

DROP TABLE IF EXISTS `tb_parentcontactoseccli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_parentcontactoseccli` (
  `idParentContactoSecCli` tinyint(4) NOT NULL AUTO_INCREMENT,
  `descParentContactoSec` varchar(50) NOT NULL,
  PRIMARY KEY (`idParentContactoSecCli`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_parentcontactoseccli`
--

LOCK TABLES `tb_parentcontactoseccli` WRITE;
/*!40000 ALTER TABLE `tb_parentcontactoseccli` DISABLE KEYS */;
INSERT INTO `tb_parentcontactoseccli` VALUES (1,'SOBRINO'),(2,'HIJO'),(3,'HERMANO'),(4,'TIO'),(5,'OTROS');
/*!40000 ALTER TABLE `tb_parentcontactoseccli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_promocion`
--

DROP TABLE IF EXISTS `tb_promocion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_promocion` (
  `idPromocion` int(11) NOT NULL AUTO_INCREMENT,
  `descripcionProm` varchar(50) NOT NULL,
  PRIMARY KEY (`idPromocion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_promocion`
--

LOCK TABLES `tb_promocion` WRITE;
/*!40000 ALTER TABLE `tb_promocion` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_promocion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_provincia`
--

DROP TABLE IF EXISTS `tb_provincia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_provincia` (
  `idProvincia` int(11) NOT NULL AUTO_INCREMENT,
  `descripcionProvincia` varchar(50) NOT NULL,
  `idPais` int(11) NOT NULL,
  PRIMARY KEY (`idProvincia`),
  KEY `fk_provincia_pais` (`idPais`),
  CONSTRAINT `fk_provincia_pais` FOREIGN KEY (`idPais`) REFERENCES `tb_pais` (`idPais`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_provincia`
--

LOCK TABLES `tb_provincia` WRITE;
/*!40000 ALTER TABLE `tb_provincia` DISABLE KEYS */;
INSERT INTO `tb_provincia` VALUES (1,'LIMA',1),(2,'TACNA',1),(3,'AREQUIPA',1),(4,'CUSCO',1),(5,'TUMBES',1),(6,'CHICLAYO',1),(7,'BUENOS AIRES',2),(8,'SAO PAOLO',3),(9,'SANTIAGO',4),(10,'QUITO',5),(11,'LA PAZ',6),(12,'TANGAMANDAPIO',7);
/*!40000 ALTER TABLE `tb_provincia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_raza`
--

DROP TABLE IF EXISTS `tb_raza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_raza` (
  `idRaza` tinyint(4) NOT NULL AUTO_INCREMENT,
  `descripcionRaza` varchar(50) NOT NULL,
  `idEspecie` tinyint(4) NOT NULL,
  PRIMARY KEY (`idRaza`),
  KEY `fk_raza_especie` (`idEspecie`),
  CONSTRAINT `fk_raza_especie` FOREIGN KEY (`idEspecie`) REFERENCES `tb_especie` (`idEspecie`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_raza`
--

LOCK TABLES `tb_raza` WRITE;
/*!40000 ALTER TABLE `tb_raza` DISABLE KEYS */;
INSERT INTO `tb_raza` VALUES (1,'PITBUL',1),(2,'SIBERIANO',1),(3,'BOXER',1),(4,'Chow Chow',1),(5,'Cairn Terrier',1),(6,'San Bernardo',1),(7,'Shih Tzu',1),(8,'Pekines',1),(9,'Pastor Aleman',1),(10,'Schnauzer',1),(11,'Persa',2),(12,'Coon Maine',2),(13,'Siameses',2),(14,'Ragdoll',2),(15,'Oriental',2);
/*!40000 ALTER TABLE `tb_raza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_relacionclientemascota`
--

DROP TABLE IF EXISTS `tb_relacionclientemascota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_relacionclientemascota` (
  `idRelClienteMascota` tinyint(4) NOT NULL AUTO_INCREMENT,
  `descripcionRelClienteMascota` varchar(50) NOT NULL,
  PRIMARY KEY (`idRelClienteMascota`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_relacionclientemascota`
--

LOCK TABLES `tb_relacionclientemascota` WRITE;
/*!40000 ALTER TABLE `tb_relacionclientemascota` DISABLE KEYS */;
INSERT INTO `tb_relacionclientemascota` VALUES (1,'DUEÑO'),(2,'CONTACTO ANONIMO');
/*!40000 ALTER TABLE `tb_relacionclientemascota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_sede`
--

DROP TABLE IF EXISTS `tb_sede`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_sede` (
  `idSede` tinyint(4) NOT NULL AUTO_INCREMENT,
  `descripcionSede` varchar(50) NOT NULL,
  PRIMARY KEY (`idSede`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_sede`
--

LOCK TABLES `tb_sede` WRITE;
/*!40000 ALTER TABLE `tb_sede` DISABLE KEYS */;
INSERT INTO `tb_sede` VALUES (1,'SALAMANCA'),(2,'PACHACAMAC'),(3,'MIRAFLORES'),(4,'LA MOLINA');
/*!40000 ALTER TABLE `tb_sede` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipocliente`
--

DROP TABLE IF EXISTS `tb_tipocliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_tipocliente` (
  `idTipoCliente` tinyint(4) NOT NULL AUTO_INCREMENT,
  `descripcionTipoCliente` varchar(50) NOT NULL,
  PRIMARY KEY (`idTipoCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipocliente`
--

LOCK TABLES `tb_tipocliente` WRITE;
/*!40000 ALTER TABLE `tb_tipocliente` DISABLE KEYS */;
INSERT INTO `tb_tipocliente` VALUES (1,'NATURAL'),(2,'EMPRESA'),(3,'ONG');
/*!40000 ALTER TABLE `tb_tipocliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipodocumento`
--

DROP TABLE IF EXISTS `tb_tipodocumento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_tipodocumento` (
  `idTipoDocumento` tinyint(4) NOT NULL AUTO_INCREMENT,
  `descripcionTipoDocumento` varchar(50) NOT NULL,
  PRIMARY KEY (`idTipoDocumento`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipodocumento`
--

LOCK TABLES `tb_tipodocumento` WRITE;
/*!40000 ALTER TABLE `tb_tipodocumento` DISABLE KEYS */;
INSERT INTO `tb_tipodocumento` VALUES (1,'DNI'),(2,'RUC'),(3,'CARNET EXTRANJERIA'),(4,'PASAPORTE'),(5,'OTROS');
/*!40000 ALTER TABLE `tb_tipodocumento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-06 16:48:15
