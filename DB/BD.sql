-- MySQL dump 10.13  Distrib 8.0.32, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: musicapp
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ADICIONA`
--

DROP TABLE IF EXISTS `ADICIONA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ADICIONA` (
  `ID_Musica` int NOT NULL,
  `ID_Playlist` int NOT NULL,
  PRIMARY KEY (`ID_Musica`,`ID_Playlist`),
  KEY `ID_Playlist` (`ID_Playlist`),
  CONSTRAINT `ADICIONA_ibfk_1` FOREIGN KEY (`ID_Musica`) REFERENCES `MUSICA` (`ID_Musica`) ON DELETE CASCADE,
  CONSTRAINT `ADICIONA_ibfk_2` FOREIGN KEY (`ID_Playlist`) REFERENCES `PLAYLIST` (`ID_Playlist`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ADICIONA`
--

LOCK TABLES `ADICIONA` WRITE;
/*!40000 ALTER TABLE `ADICIONA` DISABLE KEYS */;
/*!40000 ALTER TABLE `ADICIONA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ALBUM`
--

DROP TABLE IF EXISTS `ALBUM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ALBUM` (
  `Nome` varchar(255) DEFAULT NULL,
  `Ano` int DEFAULT NULL,
  `ID_Album` int NOT NULL,
  PRIMARY KEY (`ID_Album`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ALBUM`
--

LOCK TABLES `ALBUM` WRITE;
/*!40000 ALTER TABLE `ALBUM` DISABLE KEYS */;
INSERT INTO `ALBUM` VALUES (NULL,NULL,0),('Greatest Hits',2010,1),('Luzes da Cidade',2022,2),('Blonde',2016,36);
/*!40000 ALTER TABLE `ALBUM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ARTISTA`
--

DROP TABLE IF EXISTS `ARTISTA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ARTISTA` (
  `Remuneracao` double DEFAULT NULL,
  `Genero` varchar(255) DEFAULT NULL,
  `ID_Usuario` int NOT NULL,
  PRIMARY KEY (`ID_Usuario`),
  CONSTRAINT `ARTISTA_ibfk_1` FOREIGN KEY (`ID_Usuario`) REFERENCES `USUARIO` (`ID_Usuario`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ARTISTA`
--

LOCK TABLES `ARTISTA` WRITE;
/*!40000 ALTER TABLE `ARTISTA` DISABLE KEYS */;
INSERT INTO `ARTISTA` VALUES (2500,'R&B',49);
/*!40000 ALTER TABLE `ARTISTA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ASSINATURA`
--

DROP TABLE IF EXISTS `ASSINATURA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ASSINATURA` (
  `ID_Assinatura` int NOT NULL,
  `tipoAssinatura` varchar(255) DEFAULT NULL,
  `Valor` double DEFAULT NULL,
  PRIMARY KEY (`ID_Assinatura`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ASSINATURA`
--

LOCK TABLES `ASSINATURA` WRITE;
/*!40000 ALTER TABLE `ASSINATURA` DISABLE KEYS */;
INSERT INTO `ASSINATURA` VALUES (0,'Gratuita',0),(1,'Premium',9.99),(2,'Básica',4.99);
/*!40000 ALTER TABLE `ASSINATURA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `COMPOE`
--

DROP TABLE IF EXISTS `COMPOE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `COMPOE` (
  `ID_Musica` int NOT NULL,
  `ID_Usuario` int NOT NULL,
  PRIMARY KEY (`ID_Musica`,`ID_Usuario`),
  KEY `ID_SUsuario` (`ID_Usuario`),
  CONSTRAINT `COMPOE_ibfk_1` FOREIGN KEY (`ID_Musica`) REFERENCES `MUSICA` (`ID_Musica`) ON DELETE CASCADE,
  CONSTRAINT `COMPOE_ibfk_2` FOREIGN KEY (`ID_Usuario`) REFERENCES `ARTISTA` (`ID_Usuario`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COMPOE`
--

LOCK TABLES `COMPOE` WRITE;
/*!40000 ALTER TABLE `COMPOE` DISABLE KEYS */;
/*!40000 ALTER TABLE `COMPOE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MUSICA`
--

DROP TABLE IF EXISTS `MUSICA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `MUSICA` (
  `Nome` varchar(255) DEFAULT NULL,
  `Duracao` double DEFAULT NULL,
  `ID_Musica` int NOT NULL,
  `ID_Album` int DEFAULT NULL,
  PRIMARY KEY (`ID_Musica`),
  KEY `ID_Album` (`ID_Album`),
  CONSTRAINT `MUSICA_ibfk_1` FOREIGN KEY (`ID_Album`) REFERENCES `ALBUM` (`ID_Album`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MUSICA`
--

LOCK TABLES `MUSICA` WRITE;
/*!40000 ALTER TABLE `MUSICA` DISABLE KEYS */;
INSERT INTO `MUSICA` VALUES ('Shape of You',4.23,1,1),('Imagine',3,2,2),('Bohemian Rhapsody',6.07,3,0),('Hotel California',6.3,4,0),('Stairway to Heaven',8.02,5,0),('Smells Like Teen Spirit',5.01,6,0),('Sweet Child o\' Mine',5.55,7,0),('Billie Jean',4.54,8,0),('Hey Jude',7.11,9,0),('Wonderwall',4.18,10,0),('Back in Black',4.15,11,0),('Imagine',3,12,0),('Pyramids',600,54,36);
/*!40000 ALTER TABLE `MUSICA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PLAYLIST`
--

DROP TABLE IF EXISTS `PLAYLIST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PLAYLIST` (
  `Nome` varchar(255) DEFAULT NULL,
  `Descricao` varchar(255) DEFAULT NULL,
  `ID_Playlist` int NOT NULL,
  `ID_Usuario` int DEFAULT NULL,
  PRIMARY KEY (`ID_Playlist`),
  KEY `ID_Usuario` (`ID_Usuario`),
  CONSTRAINT `PLAYLIST_ibfk_1` FOREIGN KEY (`ID_Usuario`) REFERENCES `USUARIO` (`ID_Usuario`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PLAYLIST`
--

LOCK TABLES `PLAYLIST` WRITE;
/*!40000 ALTER TABLE `PLAYLIST` DISABLE KEYS */;
INSERT INTO `PLAYLIST` VALUES ('Gym Beats','Músicas motivacionais para malhar.',2,2);
/*!40000 ALTER TABLE `PLAYLIST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRODUZ`
--

DROP TABLE IF EXISTS `PRODUZ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PRODUZ` (
  `ID_Usuario` int NOT NULL,
  `ID_Album` int NOT NULL,
  PRIMARY KEY (`ID_Usuario`,`ID_Album`),
  KEY `ID_Album` (`ID_Album`),
  CONSTRAINT `PRODUZ_ibfk_1` FOREIGN KEY (`ID_Usuario`) REFERENCES `ARTISTA` (`ID_Usuario`) ON DELETE CASCADE,
  CONSTRAINT `PRODUZ_ibfk_2` FOREIGN KEY (`ID_Album`) REFERENCES `ALBUM` (`ID_Album`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODUZ`
--

LOCK TABLES `PRODUZ` WRITE;
/*!40000 ALTER TABLE `PRODUZ` DISABLE KEYS */;
/*!40000 ALTER TABLE `PRODUZ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USUARIO`
--

DROP TABLE IF EXISTS `USUARIO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `USUARIO` (
  `DataNascimento` date DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Nome` varchar(255) DEFAULT NULL,
  `Senha` varchar(255) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  `ID_Usuario` int NOT NULL,
  `dataInicio` date DEFAULT NULL,
  `dataFim` date DEFAULT NULL,
  `ID_Assinatura` int DEFAULT NULL,
  PRIMARY KEY (`ID_Usuario`),
  KEY `ID_Assinatura` (`ID_Assinatura`),
  CONSTRAINT `USUARIO_ibfk_1` FOREIGN KEY (`ID_Assinatura`) REFERENCES `ASSINATURA` (`ID_Assinatura`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USUARIO`
--

LOCK TABLES `USUARIO` WRITE;
/*!40000 ALTER TABLE `USUARIO` DISABLE KEYS */;
INSERT INTO `USUARIO` VALUES ('1988-10-20','maria@example.com','Maria Souza','abc456','mariasouza',2,'2022-12-01','2023-12-01',2),('1995-03-20','ana@example.com','Ana Oliveira','senha123','anaoliveira',3,'2023-02-01',NULL,1),('1987-08-10','carlos@example.com','Carlos Santos','abc456','carlossantos',4,'2023-01-15','2024-01-15',2),('1990-12-05','mariana@example.com','Mariana Silva','mariana789','marianasilva',5,'2022-12-01','2023-12-01',1),('1989-07-18','pedro@example.com','Pedro Souza','pedro987','pedrosouza',6,'2023-02-15',NULL,2),('1993-04-25','lucia@example.com','Lúcia Oliveira','lucia123','luciaoliveira',7,'2022-11-01',NULL,1),('1985-09-30','fernando@example.com','Fernando Lima','fer456','fernandolima',8,'2023-03-01','2024-03-01',2),('1991-06-12','patricia@example.com','Patrícia Santos','pat456','patriciasantos',9,'2023-01-01',NULL,1),('1997-02-08','rodrigo@example.com','Rodrigo Oliveira','rodrigo123','rodrigooliveira',10,'2023-04-01',NULL,2),('1988-11-15','ana@example.com','Antônio Silva','antonio789','antoniosilva',11,'2023-03-15','2024-03-15',1),('1994-10-20','carolina@example.com','Carolina Souza','carol456','carolinasouza',12,'2023-05-01',NULL,2),('2003-08-12','gustavo.gnz54@gmail.com','Gustavo Henrique','1234','gustavognz',49,NULL,NULL,0);
/*!40000 ALTER TABLE `USUARIO` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-29 10:41:56
