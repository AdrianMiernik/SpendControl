--
-- Dumping data for table `users`
--
-- admin password: pass1
-- user password: pass2
LOCK TABLES `users` WRITE;
INSERT INTO users
VALUES (1, 'john@gmail.com', 'John', 'Smith', '$2a$10$sQH8n.0CbcTSMDVVJFMVqukBoyGc20c7bBWcgKM6Tx2gp83r7i9au', 'admin'),
       (2, 'ola@gmail.com', 'Ola', 'Nowak', '$2a$10$XeuDAhqndVsDzZC.TwFGk.T9j.FRnHqr/oodfI970INRwKXDpDQf2', 'user');
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
       (3, '500', 'Pizza Delivery', '2021-02-28', '4', '1'),
       (4, '225', 'Old Chair', '2021-03-14', '2', '1');
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
       (6, '120', 'Train Tickets', '2021-03-22', '2', '1', '1'),
       (7, '234', 'Lidl', '2021-03-19', '7', '1', '1');

UNLOCK TABLES;
