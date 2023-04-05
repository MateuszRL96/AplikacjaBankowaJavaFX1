--
-- File generated with SQLiteStudio v3.4.3 on �r. kwi 5 10:54:09 2023
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: Admins
CREATE TABLE IF NOT EXISTS "Admins" (
	"ID"	INTEGER NOT NULL,
	"Username"	TEXT NOT NULL,
	"Password"	TEXT NOT NULL,
	PRIMARY KEY("ID" AUTOINCREMENT)
);
INSERT INTO Admins (ID, Username, Password) VALUES (1, 'Admin', '123456');

-- Table: CheckingAccounts
CREATE TABLE IF NOT EXISTS "CheckingAccounts" (
	"ID"	INTEGER NOT NULL,
	"Owner"	TEXT NOT NULL,
	"AccountNumber"	TEXT NOT NULL,
	"TransactionLimit"	REAL NOT NULL,
	"Balance"	REAL NOT NULL,
	PRIMARY KEY("ID" AUTOINCREMENT)
);
INSERT INTO CheckingAccounts (ID, Owner, AccountNumber, TransactionLimit, Balance) VALUES (1, '@bBaker1', '3201 6901', 10.0, 1236.32);
INSERT INTO CheckingAccounts (ID, Owner, AccountNumber, TransactionLimit, Balance) VALUES (2, '@fRoberts2', '3201 5877', 10.0, 1000.0);
INSERT INTO CheckingAccounts (ID, Owner, AccountNumber, TransactionLimit, Balance) VALUES (3, '@cClark3', '3201 7087', 10.0, 1000.0);
INSERT INTO CheckingAccounts (ID, Owner, AccountNumber, TransactionLimit, Balance) VALUES (4, '@lHurley4', '3201 5465', 10.0, 756.42);
INSERT INTO CheckingAccounts (ID, Owner, AccountNumber, TransactionLimit, Balance) VALUES (5, '@sWest5', '3201 3368', 10.0, 2045.77);
INSERT INTO CheckingAccounts (ID, Owner, AccountNumber, TransactionLimit, Balance) VALUES (6, '@pMiller6', '3201 8410', 10.0, 4020.31);
INSERT INTO CheckingAccounts (ID, Owner, AccountNumber, TransactionLimit, Balance) VALUES (7, '@aJonhson7', '3201 10816', 10.0, 2500.0);
INSERT INTO CheckingAccounts (ID, Owner, AccountNumber, TransactionLimit, Balance) VALUES (8, '@jPeters8', '3201 7145', 10.0, 2311.56);

-- Table: Clients
CREATE TABLE IF NOT EXISTS "Clients" (
	"ID"	INTEGER NOT NULL,
	"FirstName"	TEXT NOT NULL,
	"LastName"	TEXT NOT NULL,
	"PayeeAddress"	TEXT NOT NULL,
	"Password"	TEXT NOT NULL,
	"Date"	TEXT NOT NULL,
	PRIMARY KEY("ID" AUTOINCREMENT)
);
INSERT INTO Clients (ID, FirstName, LastName, PayeeAddress, Password, Date) VALUES (1, 'Banjamin', 'Baker', '@bBaker1', '123456', '2022-07-05');
INSERT INTO Clients (ID, FirstName, LastName, PayeeAddress, Password, Date) VALUES (2, 'Fiona', 'Roberts', '@fRoberts2', '123456', '2022-07-05');
INSERT INTO Clients (ID, FirstName, LastName, PayeeAddress, Password, Date) VALUES (3, 'Cali', 'Clark', '@cClark3', '123456', '2022-07-05');
INSERT INTO Clients (ID, FirstName, LastName, PayeeAddress, Password, Date) VALUES (4, 'Lisa', 'Hurley', '@lHurley4', '123456', '2022-07-09');
INSERT INTO Clients (ID, FirstName, LastName, PayeeAddress, Password, Date) VALUES (5, 'Susanne', 'West', '@sWest5', '123456', '2022-07-09');
INSERT INTO Clients (ID, FirstName, LastName, PayeeAddress, Password, Date) VALUES (6, 'Paul', 'Miller', '@pMiller6', '123456', '2022-07-09');
INSERT INTO Clients (ID, FirstName, LastName, PayeeAddress, Password, Date) VALUES (7, 'Adam', 'Jonhson', '@aJonhson7', '123456', '2022-07-11');
INSERT INTO Clients (ID, FirstName, LastName, PayeeAddress, Password, Date) VALUES (8, 'James', 'Peters', '@jPeters8', '123456', '2022-07-15');

-- Table: SavingsAccounts
CREATE TABLE IF NOT EXISTS "SavingsAccounts" (
	"ID"	INTEGER NOT NULL,
	"Owner"	TEXT NOT NULL,
	"AccountNumber"	TEXT NOT NULL,
	"WithdrawalLimit"	REAL NOT NULL,
	"Balance"	REAL NOT NULL,
	PRIMARY KEY("ID" AUTOINCREMENT)
);
INSERT INTO SavingsAccounts (ID, Owner, AccountNumber, WithdrawalLimit, Balance) VALUES (1, '@bBaker1', '3201 3475', 2000.0, 23000.0);
INSERT INTO SavingsAccounts (ID, Owner, AccountNumber, WithdrawalLimit, Balance) VALUES (2, '@fRoberts2', '3201 4681', 2000.0, 27000.0);
INSERT INTO SavingsAccounts (ID, Owner, AccountNumber, WithdrawalLimit, Balance) VALUES (3, '@cClark3', '3201 6083', 2000.0, 14000.0);
INSERT INTO SavingsAccounts (ID, Owner, AccountNumber, WithdrawalLimit, Balance) VALUES (4, '@lHurley4', '3201 7240', 2000.0, 6210.05);
INSERT INTO SavingsAccounts (ID, Owner, AccountNumber, WithdrawalLimit, Balance) VALUES (5, '@sWest5', '3201 3192', 2000.0, 16992.04);
INSERT INTO SavingsAccounts (ID, Owner, AccountNumber, WithdrawalLimit, Balance) VALUES (6, '@pMiller6', '3201 2378', 2000.0, 40500.0);
INSERT INTO SavingsAccounts (ID, Owner, AccountNumber, WithdrawalLimit, Balance) VALUES (7, '@aJonhson7', '3201 4053', 2000.0, 2500.0);
INSERT INTO SavingsAccounts (ID, Owner, AccountNumber, WithdrawalLimit, Balance) VALUES (8, '@jPeters8', '3201 4152', 2000.0, 2311.56);

-- Table: Transactions
CREATE TABLE IF NOT EXISTS "Transactions" (
	"ID"	INTEGER NOT NULL,
	"Sender"	TEXT NOT NULL,
	"Receiver"	TEXT NOT NULL,
	"Amount"	REAL NOT NULL,
	"Date"	TEXT NOT NULL,
	"Message"	TEXT,
	PRIMARY KEY("ID" AUTOINCREMENT)
);
INSERT INTO Transactions (ID, Sender, Receiver, Amount, Date, Message) VALUES (1, '@bBaker1', '@fRoberts2', 100.0, '2022-03-13', 'For the lunch');
INSERT INTO Transactions (ID, Sender, Receiver, Amount, Date, Message) VALUES (2, '@bBaker1', '@lHurley4', 50.0, '2022-03-17', 'Thank you for the game');
INSERT INTO Transactions (ID, Sender, Receiver, Amount, Date, Message) VALUES (3, '@cClark3', '@bBaker1', 600.0, '2022-03-18', '');
INSERT INTO Transactions (ID, Sender, Receiver, Amount, Date, Message) VALUES (4, '@sWest5', '@bBaker1', 300.0, '2022-03-18', 'Thank you.');
INSERT INTO Transactions (ID, Sender, Receiver, Amount, Date, Message) VALUES (5, '@pMiller6', '@bBaker1', 10.0, '2022-03-20', 'For the uber');
INSERT INTO Transactions (ID, Sender, Receiver, Amount, Date, Message) VALUES (6, '@fRoberts2', '@bBaker1', 900.0, '2022-03-04', 'For rent');
INSERT INTO Transactions (ID, Sender, Receiver, Amount, Date, Message) VALUES (7, '@fRoberts2', '@lHulrey4', 100.0, '2022-03-12', '');
INSERT INTO Transactions (ID, Sender, Receiver, Amount, Date, Message) VALUES (8, '@sWest5', '@fRoberts2', 50.0, '2022-03-12', 'thnx for the shoes');
INSERT INTO Transactions (ID, Sender, Receiver, Amount, Date, Message) VALUES (9, '@cClark3', '@fRoberts2', 100.0, '2022-03-12', 'I will send the rest tomorrow');
INSERT INTO Transactions (ID, Sender, Receiver, Amount, Date, Message) VALUES (10, '@fRoberts2', '@pMiller6', 10.0, '2022-03-12', '');
INSERT INTO Transactions (ID, Sender, Receiver, Amount, Date, Message) VALUES (11, '@cClark3', '@bBaker1', 300.0, '2022-06-01', 'For the car repair');
INSERT INTO Transactions (ID, Sender, Receiver, Amount, Date, Message) VALUES (12, '@pMiller6', '@cClark3', 10.0, '2022-06-07', 'Thanks for the tea');
INSERT INTO Transactions (ID, Sender, Receiver, Amount, Date, Message) VALUES (13, '@sWest5', '@cClark3', 33.5, '2022-06-10', '');
INSERT INTO Transactions (ID, Sender, Receiver, Amount, Date, Message) VALUES (14, '@cClark3', '@fRoberts2', 111.3, '2022-06-15', 'Package received');
INSERT INTO Transactions (ID, Sender, Receiver, Amount, Date, Message) VALUES (15, '@lHurley4', '@cClark3', 700.0, '2022-06-17', '');
INSERT INTO Transactions (ID, Sender, Receiver, Amount, Date, Message) VALUES (16, '@pMiller6', '@cClark3', 85.0, '2022-06-20', 'Let me know when');
INSERT INTO Transactions (ID, Sender, Receiver, Amount, Date, Message) VALUES (17, '@lHurley4', '@bBaker1', 300.0, '2022-06-21', 'For the car repair');
INSERT INTO Transactions (ID, Sender, Receiver, Amount, Date, Message) VALUES (18, '@pMiller6', '@lHurley4', 10.0, '2022-06-21', '');
INSERT INTO Transactions (ID, Sender, Receiver, Amount, Date, Message) VALUES (19, '@sWest5', '@lHurley4', 41.73, '2022-06-23', '');
INSERT INTO Transactions (ID, Sender, Receiver, Amount, Date, Message) VALUES (20, '@lHurley4', '@fRoberts2', 90.3, '2022-06-25', 'Received the package');
INSERT INTO Transactions (ID, Sender, Receiver, Amount, Date, Message) VALUES (21, '@lHurley4', '@cClark3', 700.0, '2022-06-17', '');
INSERT INTO Transactions (ID, Sender, Receiver, Amount, Date, Message) VALUES (22, '@sWest5', '@fRoberts2', 200.0, '2022-06-18', '');
INSERT INTO Transactions (ID, Sender, Receiver, Amount, Date, Message) VALUES (23, '@bBaker1', '@sWest5', 25.0, '2022-06-19', 'Get some coffee.');
INSERT INTO Transactions (ID, Sender, Receiver, Amount, Date, Message) VALUES (24, '@sWest5', '@lHurley4', 109.0, '2022-06-19', 'For the phone repair.');
INSERT INTO Transactions (ID, Sender, Receiver, Amount, Date, Message) VALUES (25, '@sWest5', '@fRoberts2', 550.0, '2022-06-22', 'For the PS5');
INSERT INTO Transactions (ID, Sender, Receiver, Amount, Date, Message) VALUES (26, '@bBaker1', '@fRoberts2', 2000.0, '2022-07-13', '');

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
