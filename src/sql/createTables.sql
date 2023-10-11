USE SoniakBewWFM_CharlesM;

CREATE TABLE DeliveryEmployee (
	DEmpID int AUTO_INCREMENT NOT NULL PRIMARY KEY,
	Forename varchar(20) NOT NULL,
	Surname varchar(20) NOT NULL,
	Salary decimal(9,2) NOT NULL,
	BankNum varchar(16) NOT NULL,
	NINum varchar(9) NOT NULL
);

CREATE TABLE SalesEmployee (
	SalesEmpID int AUTO_INCREMENT PRIMARY KEY,
	Forename varchar(20) NOT NULL,
	Surname varchar(20) NOT NULL,
	Salary decimal(9,2) NOT NULL,
	BankNum varchar(16) NOT NULL,
	NINum varchar(9) NOT NULL,
	ComRate decimal(9,2) NOT NULL
);

CREATE TABLE Client (
	ClientID int AUTO_INCREMENT PRIMARY KEY,
	Forename varchar(20) NOT NULL,
	Surname varchar(20) NOT NULL,
	SalesEmpID int NOT NULL,
	CONSTRAINT FOREIGN KEY (SalesEmpID) REFERENCES SalesEmployee(SalesEmpID)
);

CREATE TABLE Project (
	ProjectID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	ProjectName varchar(50) NOT NULL,
	ProjectValue decimal(9,2) NOT NULL,
	ClientID int,
	TechLeadID int NOT NULL,
	IsCompleted tinyint CHECK (IsCompleted = 0 OR isCompleted = 1) DEFAULT 0,
	CONSTRAINT FOREIGN KEY (ClientID) REFERENCES `Client`(ClientID),
	CONSTRAINT FOREIGN KEY (TechLeadID) REFERENCES DeliveryEmployee(DEmpID)
);

CREATE TABLE Project_DeliveryEmployee(
	EmployeeID int,
	ProjectID int,
	IsCurrentlyWorking tinyint CHECK (IsCurrentlyWorking = 0 OR IsCurrentlyWorking = 1) DEFAULT 1,
	PRIMARY KEY(EmployeeID, ProjectID),
	FOREIGN KEY (EmployeeID) REFERENCES DeliveryEmployee(DEmpID),
	FOREIGN KEY (ProjectID) REFERENCES Project(ProjectID)
);
