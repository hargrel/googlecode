CREATE TABLE Tour (
	tourID NUMBER PRIMARY KEY,
	tourName VARCHAR2(30),
	tourDesc VARCHAR2(256),
	price NUMBER(7,2),
	totalDays NUMBER
);

COMMIT;