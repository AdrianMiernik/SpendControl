--
-- Dumping data for table `category_income`
--
LOCK TABLES `category_income` WRITE;
INSERT INTO category_income
VALUES (1, 'Salaries and Wages'),
       (2, 'Sold on Allegro'),
       (3, 'Flat rental'),
       (4, 'Side Hustle');
UNLOCK TABLES;

--
-- Dumping data for table `incomes`
--

LOCK TABLES `incomes` WRITE;
INSERT INTO incomes
VALUES (1, '1200', 'Mountain Bike', '2020-12-10', '2'),
       (2, '2500', 'Regular Salary', '2021-01-20', '1'),
       (3, '500', 'Pizza Delivery', '2021-02-28', '4');
UNLOCK TABLES;

