USE SoniakBewWFM_CharlesM;

-- This is the Query that will be used to insert the data into all of the tables


-- Data that was inserted into the DeliveryEmployee Table
INSERT INTO DeliveryEmployee (Forename, Surname, Salary, BankNum, NINum)
VALUES 
    ('Olivia', 'Smith', 26500.00, 'GB12ABCD1234567890', 'AB123456C'),
    ('James', 'Brown', 27000.00, 'GB34EFGH2345678901', 'CD234567E'),
    ('Emily', 'Taylor', 25500.00, 'GB56IJKL3456789012', 'EF345678F'),
    ('Liam', 'Wilson', 27000.00, 'GB78MNOP4567890123', 'GH456789G'),
    ('Sophia', 'Davis', 26000.00, 'GB90QRST5678901234', 'IJ567890J'),
    ('William', 'Harris', 26500.00, 'GB12UVWX6789012345', 'KL678901K'),
    ('Ava', 'Martin', 27000.00, 'GB34YZAB7890123456', 'MN789012M'),
    ('Noah', 'Walker', 26000.00, 'GB56CDEF8901234567', 'OP890123O'),
    ('Oliver', 'Wright', 27000.00, 'GB78GHIJ9012345678', 'QR901234Q'),
    ('Isabella', 'Lewis', 26500.00, 'GB90KLMN0123456789', 'ST012345S'),
    ('Ethan', 'Clark', 26000.00, 'GB12OPQR1234567890', 'UV123456U'),
    ('Mia', 'Mitchell', 26500.00, 'GB34STUV2345678901', 'WX234567W'),
    ('Lucas', 'White', 27000.00, 'GB56WXYZ3456789012', 'YZ345678Y'),
    ('Charlotte', 'Adams', 26500.00, 'GB78ABCD4567890123', 'AB456789A'),
    ('Henry', 'Green', 26000.00, 'GB90EFGH5678901234', 'CD567890C'),
    ('Sophie', 'Johnson', 27000.00, 'GB12IJKL6789012345', 'EF678901E'),
    ('Jacob', 'Hill', 26500.00, 'GB34MNOP7890123456', 'GH789012G'),
    ('Aria', 'Parker', 26000.00, 'GB56QRST9012345678', 'IJ901234I'),
    ('Mason', 'Hall', 27000.00, 'GB78UVWX0123456789', 'KL012345K'),
    ('Ava', 'Cook', 26500.00, 'GB12YZAB1234567890', 'MN123456M'),
    ('Oliver', 'Carter', 27000.00, 'GB34CDEF2345678901', 'OP234567O'),
    ('Liam', 'Bennett', 26500.00, 'GB56GHIJ3456789012', 'QR345678Q'),
    ('Sophia', 'King', 27000.00, 'GB78KLMN4567890123', 'ST456789S'),
    ('Jack', 'Evans', 26500.00, 'GB90OPQR5678901234', 'UV567890U'),
    ('Ella', 'Morgan', 27000.00, 'GB12STUV6789012345', 'WX678901W'),
    ('Harry', 'Roberts', 26500.00, 'GB34WXYZ7890123456', 'YZ789012Y'),
    ('Amelia', 'Price', 27000.00, 'GB56ABCD9012345678', 'AB901234A'),
    ('Oscar', 'Scott', 26500.00, 'GB78EFGH0123456789', 'CD012345C'),
    ('Charlotte', 'Thomas', 27000.00, 'GB12IJKL1234567890', 'EF123456E'),
    ('Sophie', 'Gray', 26500.00, 'GB34MNOP2345678901', 'GH234567G'),
    ('William', 'Turner', 27000.00, 'GB56PQRS3456789012', 'IJ345678I'),
    ('Aria', 'Collins', 26500.00, 'GB78TUVW4567890123', 'KL456789K'),
    ('Lucas', 'Baker', 27000.00, 'GB90YZAB5678901234', 'MN567890M'),
    ('Emily', 'Reed', 26500.00, 'GB12CDEF6789012345', 'OP678901O'),
    ('Benjamin', 'Perry', 27000.00, 'GB34GHIJ7890123456', 'QR789012Q'),
    ('Ava', 'Mitchell', 26500.00, 'GB56KLMN8901234567', 'ST890123S'),
    ('Mia', 'White', 27000.00, 'GB78OPQR0123456789', 'UV012345U'),
    ('Noah', 'Hill', 26500.00, 'GB90STUV1234567890', 'WX123456W'),
    ('Olivia', 'Cox', 27000.00, 'GB12WXYZ2345678901', 'YZ234567Y'),
    ('Henry', 'Davies', 26500.00, 'GB34ABCD3456789012', 'AB345678A'),
    ('Ella', 'Stewart', 27000.00, 'GB56EFGH4567890123', 'CD456789C'),
    ('Oliver', 'Murray', 26500.00, 'GB78IJKL5678901234', 'EF567890E'),
    ('Sophia', 'Anderson', 27000.00, 'GB90MNOP6789012345', 'GH678901G'),
    ('Jacob', 'Mitchell', 26500.00, 'GB12PQRS7890123456', 'IJ789012I'),
    ('Charlotte', 'Clark', 27000.00, 'GB34TUVW8901234567', 'KL890123K'),
    ('Liam', 'Fisher', 26500.00, 'GB56WXYZ0123456789', 'ST012345S'),
    ('Aria', 'Wright', 27000.00, 'GB78OPQR1234567890', 'UV123456U'),
    ('Oliver', 'Lewis', 26500.00, 'GB90STUV2345678901', 'WX234567W'
);




-- Data that was inserted into the SalesEmployee Table
INSERT INTO SalesEmployee (Forename, Surname, Salary, BankNum, NINum, ComRate)
VALUES
    ('James', 'Smith', 35000.00, 'GB12ABCD1234567890', 'AB123456C', 0.05),
    ('Sophie', 'Brown', 76000.00, 'GB34EFGH2345678901', 'CD234567E', 0.04),
    ('Oliver', 'Taylor', 38000.00, 'GB56IJKL3456789012', 'EF345678F', 0.06),
    ('Emily', 'Wilson', 31000.00, 'GB78MNOP4567890123', 'GH456789G', 0.03),
    ('Ethan', 'Davis', 36000.00, 'GB90QRST5678901234', 'IJ567890J', 0.05),
    ('Mia', 'Harris', 33000.00, 'GB12UVWX6789012345', 'KL678901K', 0.04),
    ('Harry', 'Martin', 37000.00, 'GB34YZAB7890123456', 'MN789012M', 0.06),
    ('Isabella', 'Walker', 55000.00, 'GB56CDEF8901234567', 'OP890123O', 0.04),
    ('Noah', 'Wright', 39000.00, 'GB78GHIJ9012345678', 'QR901234Q', 0.07),
    ('Charlotte', 'Lewis', 32000.00, 'GB90KLMN0123456789', 'ST012345S', 0.04),
    ('Liam', 'Clark', 35000.00, 'GB12OPQR1234567890', 'UV123456U', 0.05),
    ('Amelia', 'Mitchell', 36000.00, 'GB34STUV2345678901', 'WX234567W', 0.05),
    ('Olivia', 'White', 33000.00, 'GB56WXYZ3456789012', 'YZ345678Y', 0.04),
    ('William', 'Adams', 38000.00, 'GB78ABCD4567890123', 'AB456789A', 0.06),
    ('Ava', 'Green', 31000.00, 'GB90EFGH5678901234', 'CD567890C', 0.03),
    ('Oliver', 'Johnson', 37000.00, 'GB12IJKL6789012345', 'EF678901E', 0.05),
    ('Grace', 'Hill', 34000.00, 'GB34MNOP7890123456', 'GH789012G', 0.04),
    ('Jack', 'Parker', 39000.00, 'GB56QRST9012345678', 'IJ901234I', 0.07),
    ('Ella', 'Hall', 17000.00, 'GB78UVWX0123456789', 'KL012345K', 0.04),
    ('Thomas', 'Cook', 35000.00, 'GB90YZAB1234567890', 'MN123456M', 0.05),
    ('Ruby', 'Carter', 57000.00, 'GB12CDEF2345678901', 'OP234567O', 0.05),
    ('Aiden', 'Bennett', 9000.00, 'GB34GHIJ3456789012', 'QR345678Q', 0.04),
    ('Sophia', 'King', 22000.00, 'GB56KLMN4567890123', 'ST456789S', 0.06),
    ('Lucas', 'Evans', 31000.00, 'GB78OPQR5678901234', 'UV567890U', 0.03),
    ('Lily', 'Morgan', 37000.00, 'GB90STUV6789012345', 'WX678901W', 0.05),
    ('Henry', 'Roberts', 34000.00, 'GB12WXYZ7890123456', 'YZ789012Y', 0.04),
    ('Jacob', 'Price', 39000.00, 'GB34ABCD9012345678', 'AB901234A', 0.07),
    ('Aria', 'Sullivan', 99000.00, 'GB56EFGH0123456789', 'CD012345C', 0.04),
    ('William', 'Turner', 35000.00, 'GB78IJKL1234567890', 'EF123456E', 0.05),
    ('Isla', 'Collins', 36000.00, 'GB90MNOP2345678901', 'GH234567G', 0.05),
    ('Alexander', 'Hall', 33000.00, 'GB12PQRS3456789012', 'QR345678Q', 0.04),
    ('Mason', 'Davies', 38000.00, 'GB34TUVW4567890123', 'ST456789S', 0.06),
    ('Harper', 'Young', 31000.00, 'GB56XABC5678901234', 'UV567890U', 0.03),
    ('Jack', 'Gray', 37000.00, 'GB78DEFG6789012345', 'WX678901W', 0.05),
    ('Ava', 'Thomas', 34000.00, 'GB90HIJK7890123456', 'YZ789012Y', 0.04),
    ('Oscar', 'Perry', 67000.00, 'GB12LMNO9012345678', 'AB901234A', 0.07),
    ('Lily', 'Foster', 32000.00, 'GB34QRST0123456789', 'CD012345C', 0.04),
    ('Ethan', 'Dixon', 35000.00, 'GB56UVWX1234567890', 'EF123456E', 0.05),
    ('Grace', 'Ward', 87000.00, 'GB78YZAB2345678901', 'GH234567G', 0.05),
    ('Oliver', 'Cole', 33000.00, 'GB90CDEF3456789012', 'QR345678Q', 0.04),
    ('Sophia', 'Griffin', 38000.00, 'GB12GHIJ4567890123', 'ST456789S', 0.06),
    ('Noah', 'Wallace', 11000.00, 'GB34IJKL5678901234', 'UV567890U', 0.03),
    ('Aria', 'Kerr', 37000.00, 'GB56MNOP6789012345', 'WX678901W', 0.05),
    ('Harry', 'Barnes', 78000.00, 'GB78PQRS7890123456', 'YZ789012Y', 0.04),
    ('Mia', 'Cooper', 39000.00, 'GB90TUVW9012345678', 'AB901234A', 0.07
);




-- Data that was inserted into the Client Table
INSERT INTO Client (Forename, Surname, SalesEmpID)
VALUES 
    ('Alice', 'Smith', 3),
    ('James', 'Brown', 34),
    ('Olivia', 'Johnson', 12),
    ('William', 'Taylor', 11),
    ('Sophia', 'Wilson', 20),
    ('Alexander', 'Davis', 5),
    ('Charlotte', 'Evans', 19),
    ('George', 'Roberts', 21),
    ('Emily', 'Hughes', 41),
    ('Daniel', 'Morgan', 15),
    ('Amelia', 'Thomas', 7),
    ('Mason', 'King', 9),
    ('Sophie', 'Scott', 4),
    ('Liam', 'Baker', 39),
    ('Isabella', 'Carter', 24
);




-- Data that was inserted into the Project Table
INSERT INTO Project (ProjectName, ProjectValue, ClientID, TechLeadID)
VALUES
    ('Secure Cloud Migration', 175000.00, 2, 30),
    ('IoT Smart Home Integration', 125000.50, 4, 2),
    ('Blockchain Supply Chain', 250000.75, 3, 5),
    ('AI-Powered Customer Support', 85000.25, 1, 23),
    ('Data Analytics Platform', 200000.50, 14, 12),
    ('Cybersecurity Enhancement', 110000.00, 9, 22),
    ('Mobile App Development', 75000.25, 5, 5),
    ('Virtual Reality Training', 180000.25, 12, 31),
    ('5G Network Expansion', 135000.50, 2, 30),
    ('Machine Learning Research', 160000.00, 6, 31),
    ('E-commerce Website Redesign', 95000.25, 8, 6),
    ('Big Data Infrastructure', 300000.00, 10, 11),
    ('Digital Marketing Campaign', 70000.75, 13, 40),
    ('AI Chatbot Integration', 220000.50, 12, 15),
    ('Autonomous Vehicle Research', 130000.00, 7, 40),
    ('Renewable Energy Integration', 240000.75, 11, 21),
    ('Robotic Process Automation', 105000.00, 11, 20),
    ('Cloud-Based Collaboration', 125000.25, 10, 14),
    ('Augmented Reality App', 165000.50, 13, 9),
    ('Smart City Infrastructure', 190000.00, 15, 32
);




-- Data that was inserted into the Project_DelieveryEmployee Table
INSERT INTO Project_DeliveryEmployee (EmployeeID, ProjectID, IsCurrentlyWorking)
VALUES 
	(21, 20),
	(1, 11),
	(3, 2),
	(37, 1),
	(22, 13),
	(10, 12),
	(9, 19),
	(21, 15),
	(6, 5),
	(29, 9),
	(18, 18),
	(2, 12),
	(27, 4),
	(31, 14),
	(39, 18),
	(7, 3
);

