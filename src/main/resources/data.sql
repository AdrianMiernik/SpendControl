--
-- Dumping data for table `category_income`
--
LOCK TABLES `category_income` WRITE;
INSERT INTO category_income VALUES (1,'sold'),
                                   (2,'side hussle');
UNLOCK TABLES;

--
-- Dumping data for table `incomes`
--

LOCK TABLES `incomes` WRITE;
INSERT INTO incomes VALUES (1,'300', 'bike','2019-12-10','1'),
                           (2,'400','weekend work at shop', '2020-01-20','2');
UNLOCK TABLES;

