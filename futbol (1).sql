CREATE DATABASE  IF NOT EXISTS `futbol` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `futbol`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: futbol
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `auth_group`
--

DROP TABLE IF EXISTS `auth_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auth_group` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_group`
--

LOCK TABLES `auth_group` WRITE;
/*!40000 ALTER TABLE `auth_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `auth_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auth_group_permissions`
--

DROP TABLE IF EXISTS `auth_group_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auth_group_permissions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `group_id` int NOT NULL,
  `permission_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `auth_group_permissions_group_id_permission_id_0cd325b0_uniq` (`group_id`,`permission_id`),
  KEY `auth_group_permissio_permission_id_84c5c92e_fk_auth_perm` (`permission_id`),
  CONSTRAINT `auth_group_permissio_permission_id_84c5c92e_fk_auth_perm` FOREIGN KEY (`permission_id`) REFERENCES `auth_permission` (`id`),
  CONSTRAINT `auth_group_permissions_group_id_b120cbf9_fk_auth_group_id` FOREIGN KEY (`group_id`) REFERENCES `auth_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_group_permissions`
--

LOCK TABLES `auth_group_permissions` WRITE;
/*!40000 ALTER TABLE `auth_group_permissions` DISABLE KEYS */;
/*!40000 ALTER TABLE `auth_group_permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auth_permission`
--

DROP TABLE IF EXISTS `auth_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auth_permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `content_type_id` int NOT NULL,
  `codename` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `auth_permission_content_type_id_codename_01ab375a_uniq` (`content_type_id`,`codename`),
  CONSTRAINT `auth_permission_content_type_id_2f476e4b_fk_django_co` FOREIGN KEY (`content_type_id`) REFERENCES `django_content_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_permission`
--

LOCK TABLES `auth_permission` WRITE;
/*!40000 ALTER TABLE `auth_permission` DISABLE KEYS */;
INSERT INTO `auth_permission` VALUES (1,'Can add log entry',1,'add_logentry'),(2,'Can change log entry',1,'change_logentry'),(3,'Can delete log entry',1,'delete_logentry'),(4,'Can view log entry',1,'view_logentry'),(5,'Can add permission',2,'add_permission'),(6,'Can change permission',2,'change_permission'),(7,'Can delete permission',2,'delete_permission'),(8,'Can view permission',2,'view_permission'),(9,'Can add group',3,'add_group'),(10,'Can change group',3,'change_group'),(11,'Can delete group',3,'delete_group'),(12,'Can view group',3,'view_group'),(13,'Can add user',4,'add_user'),(14,'Can change user',4,'change_user'),(15,'Can delete user',4,'delete_user'),(16,'Can view user',4,'view_user'),(17,'Can add content type',5,'add_contenttype'),(18,'Can change content type',5,'change_contenttype'),(19,'Can delete content type',5,'delete_contenttype'),(20,'Can view content type',5,'view_contenttype'),(21,'Can add session',6,'add_session'),(22,'Can change session',6,'change_session'),(23,'Can delete session',6,'delete_session'),(24,'Can view session',6,'view_session'),(25,'Can add nacionalidade',7,'add_nacionalidade'),(26,'Can change nacionalidade',7,'change_nacionalidade'),(27,'Can delete nacionalidade',7,'delete_nacionalidade'),(28,'Can view nacionalidade',7,'view_nacionalidade'),(29,'Can add categoria',8,'add_categoria'),(30,'Can change categoria',8,'change_categoria'),(31,'Can delete categoria',8,'delete_categoria'),(32,'Can view categoria',8,'view_categoria'),(33,'Can add jugadora',9,'add_jugadora'),(34,'Can change jugadora',9,'change_jugadora'),(35,'Can delete jugadora',9,'delete_jugadora'),(36,'Can view jugadora',9,'view_jugadora'),(37,'Can add posicione',10,'add_posicione'),(38,'Can change posicione',10,'change_posicione'),(39,'Can delete posicione',10,'delete_posicione'),(40,'Can view posicione',10,'view_posicione'),(41,'Can add instancia jugadora',11,'add_instanciajugadora'),(42,'Can change instancia jugadora',11,'change_instanciajugadora'),(43,'Can delete instancia jugadora',11,'delete_instanciajugadora'),(44,'Can view instancia jugadora',11,'view_instanciajugadora');
/*!40000 ALTER TABLE `auth_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auth_user`
--

DROP TABLE IF EXISTS `auth_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auth_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(128) NOT NULL,
  `last_login` datetime(6) DEFAULT NULL,
  `is_superuser` tinyint(1) NOT NULL,
  `username` varchar(150) NOT NULL,
  `first_name` varchar(150) NOT NULL,
  `last_name` varchar(150) NOT NULL,
  `email` varchar(254) NOT NULL,
  `is_staff` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `date_joined` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_user`
--

LOCK TABLES `auth_user` WRITE;
/*!40000 ALTER TABLE `auth_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `auth_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auth_user_groups`
--

DROP TABLE IF EXISTS `auth_user_groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auth_user_groups` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `group_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `auth_user_groups_user_id_group_id_94350c0c_uniq` (`user_id`,`group_id`),
  KEY `auth_user_groups_group_id_97559544_fk_auth_group_id` (`group_id`),
  CONSTRAINT `auth_user_groups_group_id_97559544_fk_auth_group_id` FOREIGN KEY (`group_id`) REFERENCES `auth_group` (`id`),
  CONSTRAINT `auth_user_groups_user_id_6a12ed8b_fk_auth_user_id` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_user_groups`
--

LOCK TABLES `auth_user_groups` WRITE;
/*!40000 ALTER TABLE `auth_user_groups` DISABLE KEYS */;
/*!40000 ALTER TABLE `auth_user_groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auth_user_user_permissions`
--

DROP TABLE IF EXISTS `auth_user_user_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auth_user_user_permissions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `permission_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `auth_user_user_permissions_user_id_permission_id_14a6b632_uniq` (`user_id`,`permission_id`),
  KEY `auth_user_user_permi_permission_id_1fbb5f2c_fk_auth_perm` (`permission_id`),
  CONSTRAINT `auth_user_user_permi_permission_id_1fbb5f2c_fk_auth_perm` FOREIGN KEY (`permission_id`) REFERENCES `auth_permission` (`id`),
  CONSTRAINT `auth_user_user_permissions_user_id_a95ead1b_fk_auth_user_id` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_user_user_permissions`
--

LOCK TABLES `auth_user_user_permissions` WRITE;
/*!40000 ALTER TABLE `auth_user_user_permissions` DISABLE KEYS */;
/*!40000 ALTER TABLE `auth_user_user_permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catalog_categoria`
--

DROP TABLE IF EXISTS `catalog_categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `catalog_categoria` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalog_categoria`
--

LOCK TABLES `catalog_categoria` WRITE;
/*!40000 ALTER TABLE `catalog_categoria` DISABLE KEYS */;
INSERT INTO `catalog_categoria` VALUES (1,'Primera Division'),(2,'Regional'),(3,'Cadete'),(4,'Infantil');
/*!40000 ALTER TABLE `catalog_categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catalog_instanciajugadora`
--

DROP TABLE IF EXISTS `catalog_instanciajugadora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `catalog_instanciajugadora` (
  `id` char(32) NOT NULL,
  `jugadora_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `catalog_instanciajug_jugadora_id_02ea62d0_fk_catalog_j` (`jugadora_id`),
  CONSTRAINT `catalog_instanciajug_jugadora_id_02ea62d0_fk_catalog_j` FOREIGN KEY (`jugadora_id`) REFERENCES `catalog_jugadora` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalog_instanciajugadora`
--

LOCK TABLES `catalog_instanciajugadora` WRITE;
/*!40000 ALTER TABLE `catalog_instanciajugadora` DISABLE KEYS */;
/*!40000 ALTER TABLE `catalog_instanciajugadora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catalog_jugadora`
--

DROP TABLE IF EXISTS `catalog_jugadora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `catalog_jugadora` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  `apellidos` varchar(200) NOT NULL,
  `nacionalidad_id` bigint DEFAULT NULL,
  `categoria_id` bigint DEFAULT NULL,
  `posicion_id` bigint DEFAULT NULL,
  `dorsal` int NOT NULL,
  `imagen` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `catalog_jugadoras_nacionalidad_id_8bccff37_fk_catalog_n` (`nacionalidad_id`),
  KEY `catalog_jugadora_categoria_id_e3a18118_fk_catalog_categoria_id` (`categoria_id`),
  KEY `catalog_jugadora_posicion_id_032cf79c_fk_catalog_posicione_id` (`posicion_id`),
  CONSTRAINT `catalog_jugadora_categoria_id_e3a18118_fk_catalog_categoria_id` FOREIGN KEY (`categoria_id`) REFERENCES `catalog_categoria` (`id`),
  CONSTRAINT `catalog_jugadora_posicion_id_032cf79c_fk_catalog_posicione_id` FOREIGN KEY (`posicion_id`) REFERENCES `catalog_posicione` (`id`),
  CONSTRAINT `catalog_jugadoras_nacionalidad_id_8bccff37_fk_catalog_n` FOREIGN KEY (`nacionalidad_id`) REFERENCES `catalog_nacionalidade` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalog_jugadora`
--

LOCK TABLES `catalog_jugadora` WRITE;
/*!40000 ALTER TABLE `catalog_jugadora` DISABLE KEYS */;
INSERT INTO `catalog_jugadora` VALUES (1,'Inma','Martín',1,1,2,8,'inma.PNG'),(2,'Celia','Jiménez',1,1,3,10,'celia.PNG'),(8,'Patry','Montilla',1,1,2,7,'patry.PNG'),(9,'Alicia','Benete',1,1,4,9,'bene.PNG'),(10,'Claudia','Bollero',1,1,3,11,'claudia.PNG'),(11,'Miriam','Rodríguez',1,1,1,12,'pitu.PNG'),(12,'Alicia','Voto',1,1,2,14,'piti.PNG'),(13,'Marina','Montufo',1,1,3,17,'montufo.PNG'),(14,'Silvia','Carral',1,1,4,18,'silvia.PNG'),(15,'Clau','López',1,1,4,20,'clau.PNG'),(16,'Ari','Pérez',1,1,1,23,'ari.PNG');
/*!40000 ALTER TABLE `catalog_jugadora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catalog_nacionalidade`
--

DROP TABLE IF EXISTS `catalog_nacionalidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `catalog_nacionalidade` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalog_nacionalidade`
--

LOCK TABLES `catalog_nacionalidade` WRITE;
/*!40000 ALTER TABLE `catalog_nacionalidade` DISABLE KEYS */;
INSERT INTO `catalog_nacionalidade` VALUES (1,'Española'),(2,'Portuguesa'),(3,'Brasileña');
/*!40000 ALTER TABLE `catalog_nacionalidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catalog_posicione`
--

DROP TABLE IF EXISTS `catalog_posicione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `catalog_posicione` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalog_posicione`
--

LOCK TABLES `catalog_posicione` WRITE;
/*!40000 ALTER TABLE `catalog_posicione` DISABLE KEYS */;
INSERT INTO `catalog_posicione` VALUES (1,'Portera'),(2,'Cierre'),(3,'Ala'),(4,'Pivot'),(5,'Entrenador');
/*!40000 ALTER TABLE `catalog_posicione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `django_admin_log`
--

DROP TABLE IF EXISTS `django_admin_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `django_admin_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `action_time` datetime(6) NOT NULL,
  `object_id` longtext,
  `object_repr` varchar(200) NOT NULL,
  `action_flag` smallint unsigned NOT NULL,
  `change_message` longtext NOT NULL,
  `content_type_id` int DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `django_admin_log_content_type_id_c4bce8eb_fk_django_co` (`content_type_id`),
  KEY `django_admin_log_user_id_c564eba6_fk_auth_user_id` (`user_id`),
  CONSTRAINT `django_admin_log_content_type_id_c4bce8eb_fk_django_co` FOREIGN KEY (`content_type_id`) REFERENCES `django_content_type` (`id`),
  CONSTRAINT `django_admin_log_user_id_c564eba6_fk_auth_user_id` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`id`),
  CONSTRAINT `django_admin_log_chk_1` CHECK ((`action_flag` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `django_admin_log`
--

LOCK TABLES `django_admin_log` WRITE;
/*!40000 ALTER TABLE `django_admin_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `django_admin_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `django_content_type`
--

DROP TABLE IF EXISTS `django_content_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `django_content_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `app_label` varchar(100) NOT NULL,
  `model` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `django_content_type_app_label_model_76bd3d3b_uniq` (`app_label`,`model`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `django_content_type`
--

LOCK TABLES `django_content_type` WRITE;
/*!40000 ALTER TABLE `django_content_type` DISABLE KEYS */;
INSERT INTO `django_content_type` VALUES (1,'admin','logentry'),(3,'auth','group'),(2,'auth','permission'),(4,'auth','user'),(8,'catalog','categoria'),(11,'catalog','instanciajugadora'),(9,'catalog','jugadora'),(7,'catalog','nacionalidade'),(10,'catalog','posicione'),(5,'contenttypes','contenttype'),(6,'sessions','session');
/*!40000 ALTER TABLE `django_content_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `django_migrations`
--

DROP TABLE IF EXISTS `django_migrations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `django_migrations` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `app` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `applied` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `django_migrations`
--

LOCK TABLES `django_migrations` WRITE;
/*!40000 ALTER TABLE `django_migrations` DISABLE KEYS */;
INSERT INTO `django_migrations` VALUES (1,'contenttypes','0001_initial','2024-04-23 08:40:49.699373'),(2,'auth','0001_initial','2024-04-23 08:40:50.279836'),(3,'admin','0001_initial','2024-04-23 08:40:50.395526'),(4,'admin','0002_logentry_remove_auto_add','2024-04-23 08:40:50.404502'),(5,'admin','0003_logentry_add_action_flag_choices','2024-04-23 08:40:50.410486'),(6,'contenttypes','0002_remove_content_type_name','2024-04-23 08:40:50.485286'),(7,'auth','0002_alter_permission_name_max_length','2024-04-23 08:40:50.532161'),(8,'auth','0003_alter_user_email_max_length','2024-04-23 08:40:50.562081'),(9,'auth','0004_alter_user_username_opts','2024-04-23 08:40:50.572054'),(10,'auth','0005_alter_user_last_login_null','2024-04-23 08:40:50.668804'),(11,'auth','0006_require_contenttypes_0002','2024-04-23 08:40:50.674788'),(12,'auth','0007_alter_validators_add_error_messages','2024-04-23 08:40:50.681770'),(13,'auth','0008_alter_user_username_max_length','2024-04-23 08:40:50.762554'),(14,'auth','0009_alter_user_last_name_max_length','2024-04-23 08:40:50.819401'),(15,'auth','0010_alter_group_name_max_length','2024-04-23 08:40:50.835359'),(16,'auth','0011_update_proxy_permissions','2024-04-23 08:40:50.841343'),(17,'auth','0012_alter_user_first_name_max_length','2024-04-23 08:40:50.898191'),(18,'catalog','0001_initial','2024-04-23 08:40:51.096670'),(19,'catalog','0002_rename_categoria_categorias_and_more','2024-04-23 08:40:51.324074'),(20,'catalog','0003_rename_nacionalidades_nacionalidade','2024-04-23 08:40:51.413856'),(21,'catalog','0004_rename_categorias_categoria_and_more','2024-04-23 08:40:51.587391'),(22,'catalog','0005_posicione_status','2024-04-23 08:40:51.610330'),(23,'catalog','0006_remove_categoria_jugadoras_remove_categoria_nombre_and_more','2024-04-23 08:40:51.728015'),(24,'catalog','0007_remove_jugadora_categoría_remove_jugadora_posición_and_more','2024-04-23 08:40:51.802822'),(25,'catalog','0008_categoria_nombre_jugadora_categoria_and_more','2024-04-23 08:40:51.953422'),(26,'catalog','0009_jugadora_dorsal','2024-04-23 08:40:51.975365'),(27,'catalog','0010_instanciajugadora','2024-04-23 08:40:52.040189'),(28,'catalog','0011_jugadora_imagen','2024-04-23 08:40:52.071106'),(29,'catalog','0012_alter_jugadora_imagen','2024-04-23 08:40:52.084071'),(30,'catalog','0013_alter_jugadora_imagen','2024-04-23 08:40:52.088061'),(31,'catalog','0014_alter_jugadora_imagen','2024-04-23 08:40:52.092050'),(32,'sessions','0001_initial','2024-04-23 08:40:52.121970');
/*!40000 ALTER TABLE `django_migrations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `django_session`
--

DROP TABLE IF EXISTS `django_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `django_session` (
  `session_key` varchar(40) NOT NULL,
  `session_data` longtext NOT NULL,
  `expire_date` datetime(6) NOT NULL,
  PRIMARY KEY (`session_key`),
  KEY `django_session_expire_date_a5c62663` (`expire_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `django_session`
--

LOCK TABLES `django_session` WRITE;
/*!40000 ALTER TABLE `django_session` DISABLE KEYS */;
/*!40000 ALTER TABLE `django_session` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-23 11:23:17
