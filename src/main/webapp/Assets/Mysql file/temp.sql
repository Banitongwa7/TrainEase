-- MySQL dump 10.13  Distrib 8.0.31, for Linux (x86_64)
--
-- Host: localhost    Database: trainease
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `domaine`
--

DROP TABLE IF EXISTS `domaine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `domaine` (
  `code_domaine` int NOT NULL AUTO_INCREMENT,
  `libelle` multilinestring DEFAULT NULL,
  PRIMARY KEY (`code_domaine`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domaine`
--

LOCK TABLES `domaine` WRITE;
/*!40000 ALTER TABLE `domaine` DISABLE KEYS */;
/*!40000 ALTER TABLE `domaine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formateur`
--

DROP TABLE IF EXISTS `formateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `formateur` (
  `nom` linestring DEFAULT NULL,
  `prenom` linestring DEFAULT NULL,
  `code_formateur` int NOT NULL AUTO_INCREMENT,
  `email` linestring NOT NULL,
  `telephone` int DEFAULT NULL,
  PRIMARY KEY (`code_formateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formateur`
--

LOCK TABLES `formateur` WRITE;
/*!40000 ALTER TABLE `formateur` DISABLE KEYS */;
/*!40000 ALTER TABLE `formateur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formation`
--

DROP TABLE IF EXISTS `formation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `formation` (
  `code_formation` int NOT NULL AUTO_INCREMENT,
  `intitule` linestring DEFAULT NULL,
  `nombre_jours` int DEFAULT NULL,
  `annee` int DEFAULT NULL,
  `mois` int DEFAULT NULL,
  `nombre_participants` int DEFAULT NULL,
  `code_formateur` int DEFAULT NULL,
  `code_domaine` int DEFAULT NULL,
  PRIMARY KEY (`code_formation`),
  KEY `formation_domaine_null_fk` (`code_domaine`),
  KEY `formation_formateur_null_fk` (`code_formateur`),
  CONSTRAINT `formation_domaine_null_fk` FOREIGN KEY (`code_domaine`) REFERENCES `domaine` (`code_domaine`),
  CONSTRAINT `formation_formateur_null_fk` FOREIGN KEY (`code_formateur`) REFERENCES `formateur` (`code_formateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formation`
--

LOCK TABLES `formation` WRITE;
/*!40000 ALTER TABLE `formation` DISABLE KEYS */;
/*!40000 ALTER TABLE `formation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formation_participant`
--

DROP TABLE IF EXISTS `formation_participant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `formation_participant` (
  `code_formation` int NOT NULL,
  `matricule_participant` int NOT NULL,
  `date_inscription` date DEFAULT NULL,
  PRIMARY KEY (`matricule_participant`,`code_formation`),
  KEY `formation_participant_formation_null_fk` (`code_formation`),
  CONSTRAINT `formation_participant_formation_null_fk` FOREIGN KEY (`code_formation`) REFERENCES `formation` (`code_formation`),
  CONSTRAINT `formation_participant_participant_null_fk` FOREIGN KEY (`matricule_participant`) REFERENCES `participant` (`matricule_participant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formation_participant`
--

LOCK TABLES `formation_participant` WRITE;
/*!40000 ALTER TABLE `formation_participant` DISABLE KEYS */;
/*!40000 ALTER TABLE `formation_participant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participant`
--

DROP TABLE IF EXISTS `participant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participant` (
  `matricule_participant` int NOT NULL AUTO_INCREMENT,
  `nom` linestring DEFAULT NULL,
  `prenom` linestring DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `code_profil` int DEFAULT NULL,
  PRIMARY KEY (`matricule_participant`),
  KEY `participant_profil_fk` (`code_profil`),
  CONSTRAINT `participant_profil_fk` FOREIGN KEY (`code_profil`) REFERENCES `profil` (`code_profil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participant`
--

LOCK TABLES `participant` WRITE;
/*!40000 ALTER TABLE `participant` DISABLE KEYS */;
/*!40000 ALTER TABLE `participant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profil`
--

DROP TABLE IF EXISTS `profil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profil` (
  `code_profil` int NOT NULL AUTO_INCREMENT,
  `libelle` multilinestring DEFAULT NULL,
  PRIMARY KEY (`code_profil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profil`
--

LOCK TABLES `profil` WRITE;
/*!40000 ALTER TABLE `profil` DISABLE KEYS */;
/*!40000 ALTER TABLE `profil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `code_role` int NOT NULL AUTO_INCREMENT,
  `libelle` linestring DEFAULT NULL,
  PRIMARY KEY (`code_role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utilisateur` (
  `code_utilisateur` int NOT NULL,
  `email` linestring NOT NULL,
  `password` multilinestring NOT NULL,
  `code_role` int NOT NULL,
  PRIMARY KEY (`code_utilisateur`),
  KEY `utilisateur_role_fk` (`code_role`),
  CONSTRAINT `utilisateur_role_fk` FOREIGN KEY (`code_role`) REFERENCES `role` (`code_role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilisateur`
--

LOCK TABLES `utilisateur` WRITE;
/*!40000 ALTER TABLE `utilisateur` DISABLE KEYS */;
/*!40000 ALTER TABLE `utilisateur` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-25 17:43:51
