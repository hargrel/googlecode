CREATE TABLE AccountUser (
	user_ID NUMBER PRIMARY KEY,
	user_Name VARCHAR2(256),
	password VARCHAR2(256),
	user_Type VARCHAR2(16)
);

CREATE TABLE TourOperator (
	operator_ID NUMBER PRIMARY KEY references AccountUser(user_ID),
	operator_Name VARCHAR2(256),
	company_Info VARCHAR2(256),
	membership_Expired DATE,	
	email VARCHAR2(256)
);

CREATE TABLE Tour (
	tour_ID NUMBER PRIMARY KEY,
	tour_Name VARCHAR2(256),
	tour_Desc VARCHAR2(256),
	price FLOAT,
	total_Days NUMBER,
	on_Demand NUMBER(1),
	currency CHAR(3),
	operator_ID NUMBER references TourOperator(operator_ID),
	points VARCHAR2(256),
	levels VARCHAR2(256)
	
);

CREATE TABLE ListedTour (
	list_ID NUMBER PRIMARY KEY,
	operator_ID NUMBER references TourOperator(operator_ID),
	tour_ID NUMBER,
	listed_From DATE,
	listed_To DATE
);

CREATE TABLE Activity (
	activity_ID NUMBER PRIMARY KEY,
	activity_Name VARCHAR2(256)
);

CREATE TABLE TourActivity (
	activity_ID NUMBER references Activity(activity_ID),
	tour_ID NUMBER references Tour(tour_ID),
	PRIMARY KEY (activity_ID, tour_ID)
);

CREATE TABLE Location (
	location_ID NUMBER PRIMARY KEY,
	location_Name VARCHAR2(256),
	latitude FLOAT,
	longitude FLOAT
);

CREATE TABLE TourLocation (
	location_ID NUMBER references Location(location_ID),
	tour_ID NUMBER references Tour(tour_ID),
	PRIMARY KEY (location_ID, tour_ID)
);

CREATE TABLE TourDate(
	date_ID NUMBER PRIMARY KEY,
	tour_ID NUMBER references Tour(tour_ID),
	start_Date DATE,
	finish_Date DATE
);

CREATE TABLE Image (
	image_ID NUMBER PRIMARY KEY,
	image_URL VARCHAR2(256),
	tour_ID NUMBER references Tour(tour_ID)
);

CREATE TABLE MonthlyFee (
	fee_ID NUMBER PRIMARY KEY,
	MONTH_YEAR_START DATE,
	FEE NUMBER(7,2)
);

COMMIT;