--
-- Dumping data for table `users`
--
LOCK TABLES `users` WRITE;
INSERT INTO users
VALUES (1, 'john@gmail.com', 'John', 'Smith', 'pass1', 'admin'),
       (2, 'ola@gmail.com', 'Ola', 'Nowak', 'pass2', 'user');
UNLOCK TABLES;

--
-- Dumping data for table `roles`
--
LOCK TABLES `roles` WRITE;
INSERT INTO roles
VALUES (1, 'ROLE_ADMIN'),
       (2, 'ROLE_USER');
UNLOCK TABLES;

--
-- Dumping data for table `users_roles`
--
LOCK TABLES `users_roles` WRITE;
INSERT INTO users_roles
VALUES (1, 1),
       (2, 2);
UNLOCK TABLES;

--
-- Dumping data for table `category_income`
--
LOCK TABLES `category_income` WRITE;
INSERT INTO category_income
VALUES (1, 'Salary'),
       (2, 'Sold'),
       (3, 'Renting'),
       (4, 'Side hustle');
UNLOCK TABLES;

--
-- Dumping data for table `incomes`
--

LOCK TABLES `incomes` WRITE;
INSERT INTO incomes
VALUES (1, '1200', 'Mountain Bike', '2020-12-10', '2', '1'),
       (2, '2500', 'Regular Salary', '2021-01-20', '1', '1'),
       (3, '500', 'Pizza Delivery', '2021-02-28', '4', '1');
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
       (7, 'Meal');
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
VALUES (1, '1800', 'Monthly Rate - Barclays', '2021-03-01', '1', '4', '1'),
       (2, '210', 'Grocery - Biedronka', '2021-01-12', '7', '5', '1'),
       (3, '150', 'Antibiotic', '2021-02-13', '5', '3', '1'),
       (4, '243', 'Petrol', '2021-03-17', '2', '2', '1'),
       (5, '620', 'Loan Rate - Millenium', '2021-02-07', '3', '4', '1'),
       (6, '120', 'Cinema with Family', '2021-03-22', '6', '1', '1');
UNLOCK TABLES;
