-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: forumapplication
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `comment_id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(1000) DEFAULT NULL,
  `author_id` bigint DEFAULT NULL,
  `post_id` bigint DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `FK23kl900eipat1xpq25pqp63cy` (`author_id`),
  KEY `FKs1slvnkuemjsq2kj4h3vhx7i1` (`post_id`),
  CONSTRAINT `FK23kl900eipat1xpq25pqp63cy` FOREIGN KEY (`author_id`) REFERENCES `usr` (`id`),
  CONSTRAINT `FKs1slvnkuemjsq2kj4h3vhx7i1` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,'Absolutely love these tips! Spending time outdoors and trying new activities are my go-to summer rituals. There\'s nothing like soaking up the sun and exploring new adventures. Can\'t wait to embark on new experiences this summer!',3,2),(2,'Absolutely love these tips! Spending time outdoors and trying new activities are my go-to summer rituals. There\'s nothing like soaking up the sun and exploring new adventures. Can\'t wait to embark on new experiences this summer!',3,1),(3,'I couldn\'t agree more with the idea of diving into a good book during the summer. It\'s the perfect time to escape into different worlds and let my imagination run wild.',4,1),(4,'Summer is the perfect time for adventure, and these tips are spot-on! Exploring new places, trying thrilling activities, and embracing the spirit of wanderlust is what summer is all about. Can\'t wait to chase sunsets, hike mountain trails, and create unforgettable memories this summer',2,3),(5,'Thanks for sharing these tips! I\'m just starting with Java, and this post is really helpful. I\'ll make sure to follow these best practices while writing my code.',6,4),(6,'Lviv looks like a fairytale city! The Old Town is incredibly charming, and the coffee culture is fascinating. I can\'t wait to visit and experience it for myself',8,6),(7,'I\'ve been to Kyiv, and it\'s such a beautiful city! The Kyiv Pechersk Lavra is absolutely stunning, and the view from the top is breathtaking. Can\'t wait to explore more of Ukraine!',4,6),(8,'Odesa\'s nightlife is legendary! I had an amazing time exploring the bars and clubs along the coast. The energy and atmosphere were incredible. Can\'t wait to go back!',4,8);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `post_id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(2000) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `author_id` bigint DEFAULT NULL,
  `topic_id` bigint DEFAULT NULL,
  PRIMARY KEY (`post_id`),
  KEY `FK6i9e0diws1ifutrjnjtn8udm3` (`author_id`),
  KEY `FKg8ln3nj8tjclai0nuvpw5s5uw` (`topic_id`),
  CONSTRAINT `FK6i9e0diws1ifutrjnjtn8udm3` FOREIGN KEY (`author_id`) REFERENCES `usr` (`id`),
  CONSTRAINT `FKg8ln3nj8tjclai0nuvpw5s5uw` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,'Summer is a time of joy and relaxation. Here are a few tips to make the most of this season:\r\n\r\nSpend plenty of time outdoors - take walks in the parks, have picnics with friends, visit the beach.\r\nTry new activities - go cycling, take a dip in the pool, engage in sports.\r\nDiscover new places - embark on trips, visit interesting museums and cultural events.\r\nPursue your hobbies - read books, watch movies, engage in crafts.\r\nShare these moments with loved ones - spend time with family and friends, organize parties and barbecues.','Enjoy your summer!',2,6),(2,'Summer is the time to pursue your passions and engage in your favorite activities. Here are a few tips for an active and exciting summer break:\r\n\r\nIncorporate sports into your life - swim, play beach volleyball, go cycling, or practice yoga.\r\nExplore photography - go on photo walks, discover new places, and capture unforgettable moments.\r\nLearn new skills - enroll in courses or workshops that interest you and expand your knowledge.\r\nPlan trips - visit new cities or countries, immerse yourself in different cultures and traditions.\r\nEnjoy a family vacation - spend quality time with your loved ones, work on collaborative projects, and cherish shared moments.','Tips for an Active Summer Break!',3,6),(3,'Summer is the perfect time to indulge in various forms of entertainment. Here are a few ideas to have a blast during the summer days:\r\n\r\nOrganize a picnic with friends - head to a park or forest, prepare delicious food, and enjoy each other\'s company.\r\nVisit a water park - dive into the world of water slides, pools, and attractions.\r\nJoin a summer camp - acquire new skills, meet interesting people, and spend your time actively and meaningfully.\r\nThrow a themed party - choose a specific theme (pirates, beach, retro) and invite friends for an unforgettable evening.\r\nAttend concerts and festivals - immerse yourself in live music and the celebratory atmosphere.','Ideas for Summer Fun!',4,6),(4,'Java is a popular programming language known for its versatility and widespread use in various applications. If you are a beginner looking to get started with Java, this post will provide you with some essential resources and tips to help you on your learning journey.\r\n\r\nSet Up Your Development Environment: To begin coding in Java, you\'ll need to set up your development environment. Start by downloading and installing the Java Development Kit (JDK), which includes the necessary tools and libraries. You can find the JDK on the official Oracle website.\r\n\r\nLearn the Basics: Before diving into complex topics, it\'s crucial to understand the basics of Java programming. Familiarize yourself with concepts such as variables, data types, control structures (if-else, loops), and functions. Online tutorials and beginner-friendly books can be helpful in grasping these fundamentals.\r\n\r\nPractice with Simple Programs: As with any programming language, practice is key. Start by writing simple programs to reinforce your understanding of Java syntax and concepts. Create programs that perform tasks like calculating the sum of numbers or printing patterns. The more you code, the more comfortable you\'ll become with Java.\r\n\r\nUtilize Online Resources: There are numerous online resources available to learn Java. Websites like Codecademy, Coursera, and Udemy offer Java courses for beginners. Additionally, Oracle\'s official Java tutorials and documentation are excellent resources for understanding Java in-depth.\r\n\r\nRemember, learning to program takes time and dedication. Don\'t get discouraged if you encounter challenges along the way. Keep practicing, seeking help when needed, and gradually move on to more advanced topics.\r\n\r\nHappy coding!','Introduction to Java Programming for Beginners',7,1),(5,'Java has a vast ecosystem of libraries and frameworks that can greatly simplify your development process and expand the capabilities of your Java applications. As a beginner, it\'s essential to familiarize yourself with some of the popular libraries and frameworks available. In this post, we\'ll highlight a few essential ones:\r\n\r\nApache Commons: Apache Commons is a collection of reusable Java components that provide solutions to common programming challenges. It includes libraries for handling input/output, working with collections, manipulating strings, and more. Apache Commons can save you time and effort by providing pre-built solutions for common tasks.\r\n\r\nHibernate: Hibernate is an object-relational mapping (ORM) framework that simplifies database interactions in Java applications. It provides an abstraction layer between your code and the database, allowing you to work with objects instead of writing complex SQL queries. Hibernate handles the mapping of objects to database tables, making data persistence straightforward.\r\n\r\nSpring Framework: The Spring Framework is a powerful and widely used Java framework for building enterprise-level applications. It provides a comprehensive infrastructure for developing Java applications, including features like dependency injection, aspect-oriented programming, and MVC web development. Spring Boot, a part of the Spring ecosystem, is particularly popular for building microservices.','Essential Java Libraries and Frameworks for Beginners',6,1),(6,'Kyiv, the capital city of Ukraine, offers a mix of rich history, stunning architecture, and vibrant culture. In this topic, we\'ll explore some of the best places to visit and experiences to have in Kyiv.\r\n\r\nVisit Kyiv Pechersk Lavra: This UNESCO World Heritage site is a historic Orthodox Christian monastery complex, known for its beautiful churches, underground caves, and stunning views of the city. It\'s a must-visit for history and architecture enthusiasts.\r\n\r\nStroll through Maidan Nezalezhnosti: The central square of Kyiv, often referred to as the Maidan, is the heart of the city and has witnessed significant historical events. It\'s a great place to take a leisurely walk, admire the iconic Independence Monument, and soak in the lively atmosphere.\r\n\r\nExplore Andriyivsky Descent: This historic street is lined with charming buildings, art galleries, souvenir shops, and cafes. It\'s a favorite spot for both locals and tourists, offering a unique blend of traditional and contemporary art, culture, and craftsmanship.\r\n\r\nVisit St. Sophia\'s Cathedral: Another UNESCO World Heritage site, St. Sophia\'s Cathedral is an architectural masterpiece that dates back to the 11th century. Marvel at its stunning mosaics and frescoes, climb to the top for a panoramic view of the city, and explore the museum inside.\r\n\r\nEnjoy Ukrainian Cuisine: Kyiv is a food lover\'s paradise, with a wide range of traditional Ukrainian restaurants offering delicious dishes like borscht, varenyky (dumplings), and salo (pork fat). Don\'t miss the opportunity to taste these authentic flavors during your visit.\r\n\r\nKyiv has much more to offer, including museums, parks, and vibrant nightlife. It\'s a city that seamlessly combines its rich history with a modern, dynamic atmosphere.','Discovering Kyiv: The Vibrant Capital of Ukraine',3,10),(7,'Lviv, located in western Ukraine, is a city known for its stunning architecture, charming streets, and vibrant cultural scene. Let\'s explore some of the best places to visit and experiences to have in Lviv.\r\n\r\nWander through Lviv\'s Old Town: The Old Town of Lviv is a UNESCO World Heritage site, featuring beautiful medieval and Renaissance architecture. Take a leisurely stroll through its narrow cobblestone streets, admire the colorful buildings, and enjoy the lively atmosphere.\r\n\r\nVisit Lviv Opera House: The Lviv Opera House is a stunning architectural masterpiece and one of the most iconic landmarks in the city. Attend a performance or simply admire the grandeur of the building from the outside.\r\n\r\nClimb High Castle Hill: High Castle Hill offers a panoramic view of Lviv and is a popular spot for locals and tourists alike. Take a walk up the hill, enjoy the view, and visit the ruins of the High Castle, which dates back to the 14th century.\r\n\r\nExplore Lviv\'s Coffee Culture: Lviv is famous for its coffee culture, with numerous charming coffee shops scattered throughout the city. Enjoy a cup of aromatic coffee and indulge in delicious Lviv-style pastries while immersing yourself in the cozy ambiance.\r\n\r\nDiscover Lviv\'s Undergrounds: Lviv has an intricate system of underground tunnels and chambers, which can be explored through guided tours. Learn about the city\'s history, legends, and hidden stories as you venture beneath the surface.\r\n\r\nLviv\'s unique blend of history, culture, and culinary delights make it a must-visit destination in Ukraine.','The Beauty of Lviv: A Gem in Western Ukraine',5,10),(8,'Odesa, a vibrant city located on the shores of the Black Sea, is known for its beautiful beaches, lively nightlife, and unique cultural heritage. Let\'s delve into some of the best places to visit and experiences to have in Odesa.\r\n\r\nRelax on Odesa\'s Beaches: Odesa boasts several beautiful beaches along the Black Sea coast, offering sun, sand, and relaxation. Arkadia Beach and Lanzheron Beach are among the most popular choices, with a range of amenities and beach clubs.\r\n\r\nExplore Odesa\'s Historic Center: Odesa\'s historic center is a treasure trove of architectural gems, with its elegant 19th-century buildings and grand boulevards. Take a leisurely walk along Deribasivska Street, visit the iconic Potemkin Stairs, and explore the charming courtyards and hidden alleys.\r\n\r\nVisit Odesa Opera and Ballet Theater: Odesa\'s Opera and Ballet Theater is a true architectural masterpiece and a cultural gem. Attend a performance or take a guided tour to admire the stunning interior and learn about its fascinating history.\r\n\r\nIndulge in Odesa\'s Culinary Delights: Odesa is known for its diverse culinary scene, influenced by its multi-ethnic heritage. Try local specialties like Odessa-style fish dishes, Black Sea seafood, and the famous Odesa-style dumplings, known as \"vareniki.\"\r\n\r\nEnjoy Odesa\'s Nightlife: Odesa comes alive after dark, offering a vibrant nightlife scene. Explore the city\'s numerous bars, clubs, and beachfront establishments for an unforgettable evening of entertainment and socializing.\r\n\r\nOdesa\'s coastal charm, cultural heritage, and lively atmosphere make it a fantastic destination for both relaxation and exploration.','Coastal Beauty: Exploring Odesa and the Black Sea',8,10);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic` (
  `topic_id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`topic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` VALUES (1,'Getting Started with Java: Resources and Tips for Beginners'),(2,'Challenges for Programmers in the Era of Artificial Intelligence'),(5,'Favorite Hobbies and Summer Activities: Ideas and Tips'),(6,'Tips for Enjoying Your Summer'),(7,'Favorite Books, Movies, TV Series: Recommendations and Discussions'),(9,' Unforgettable Journeys: Share and Discover New Places'),(10,'Explore Ukraine: Best Places and Experiences'),(13,' Cultural Heritage of Ukraine');
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` bigint NOT NULL,
  `roles` enum('ADMIN','USER') DEFAULT NULL,
  KEY `FKfpm8swft53ulq2hl11yplpr5` (`user_id`),
  CONSTRAINT `FKfpm8swft53ulq2hl11yplpr5` FOREIGN KEY (`user_id`) REFERENCES `usr` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'ADMIN'),(2,'USER'),(3,'USER'),(4,'USER'),(5,'USER'),(6,'USER'),(7,'USER'),(8,'ADMIN');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usr`
--

DROP TABLE IF EXISTS `usr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usr` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `admin_key` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usr`
--

LOCK TABLES `usr` WRITE;
/*!40000 ALTER TABLE `usr` DISABLE KEYS */;
INSERT INTO `usr` VALUES (1,_binary '','$2a$10$dWPINpufe5d5WR5BlNu5R.rULbdRyATNk.opjyHWJ8UgdwPlCVhpu','$2a$10$.iUOe75IFcWN3/82PP32neHeU8n5ImTxxbcaqYUmG6whTiWQ4QCZG','Admin'),(2,_binary '',NULL,'$2a$10$kJH/FyFga3XzQfQixtmzl.um9USnvKBP87hclQ0wDZKRLy8nc8MaS','Mykhailo Kovalenko'),(3,_binary '',NULL,'$2a$10$HhWi9QDLZP2cku1rWrnn.OXkLCvKZXsbSQ5r2iVvK7idYMT8H1yfq','Isabella Davis'),(4,_binary '',NULL,'$2a$10$bDyR2xCL56Tx0jujPWxerOaHU6GlEu4pK6mliScHs82bcQKyosiR2','Sofia Ivanova'),(5,_binary '',NULL,'$2a$10$tYepYwkN10QYXinylT0SoOdFfMaNMkeuAL8s4HG.jkfIuh0EUovqm','Kateryna Voloshyna'),(6,_binary '',NULL,'$2a$10$8UAVbTbdWmDySmHyHTzjVeMRZSzRUex.PgzSIrZOpNgqD5A4NlCv2','Oleksandr Hryshko'),(7,_binary '',NULL,'$2a$10$jGnJDVZelnQcwpsEI/wTbOzqRhh4HNIdNMbikdvVM/7w9pWSnJhHG','Noah Johnson'),(8,_binary '','$2a$10$ULwcnVrA5fFyt.3HqnC9M.Hl7r94cX//923vIs2B5l.ZpT/Py57WG','$2a$10$CRkb7TcbwvrhkWgdXBUYKeRVIssqsmK/tXq5P/VHIBd41TO7ipP8W','Evhenii Voroniuk');
/*!40000 ALTER TABLE `usr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'forumapplication'
--

--
-- Dumping routines for database 'forumapplication'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-06 18:39:52
