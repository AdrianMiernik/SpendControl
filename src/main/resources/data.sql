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

--
-- Dumping data for table `expense`
--
LOCK TABLES `category_expense` WRITE;
INSERT INTO category_expense
VALUES (1, 'Mortgage'),
       (2, 'Transportation'),
       (3, 'Loans'),
       (4, 'Utility Bills'),
       (5, 'Pharmacy'),
       (6, 'Entertainment'),
       (7, 'Meals');
UNLOCK TABLES;

--
-- Dumping data for table `payment_method`
--
LOCK TABLES `payment_method` WRITE;
INSERT INTO payment_method
VALUES (1, 'Credit Card'),
       (2, 'Debit Card'),
       (3, 'Cash'),
       (4, 'Money Transfer'),
       (5, 'Blik');
UNLOCK TABLES;

--
-- Dumping data for table `expense`
--
LOCK TABLES `expenses` WRITE;
INSERT INTO expenses
VALUES (1, '1800', 'Monthly Rate - Barclays', '2021-03-01', '1', '4'),
       (2, '210', 'Grocery - Biedronka', '2021-01-12', '6', '5'),
       (3, '150', 'Antibiotic', '2021-02-13', '4', '3'),
       (4, '243', 'Petrol', '2021-03-17', '2', '2'),
       (5, '620', 'Loan Rate - Millenium', '2021-02-07', '3', '4'),
       (6, '120', 'Cinema with Family', '2021-03-22', '5', '1');
UNLOCK TABLES;
