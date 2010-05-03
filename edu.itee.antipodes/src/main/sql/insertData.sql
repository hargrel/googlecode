-- AccountUser -----------------------------------------------------------------

INSERT INTO AccountUser VALUES (
	0001, 'user1', ORA_HASH('passsword1'), 'admin'
);

INSERT INTO AccountUser VALUES (
	0002, 'user2', ORA_HASH('passsword2'), 'admin'
);

INSERT INTO AccountUser VALUES (
	0003, 'user3', ORA_HASH('passsword3'), 'operator'
);

INSERT INTO AccountUser VALUES (
	0004, 'user4', ORA_HASH('passsword4'), 'operator'
);

-- TourOperator ----------------------------------------------------------------

INSERT INTO TourOperator VALUES (
	0003, 'Mr Operator 3', 'company3', TO_DATE('13122020', 'DDMMYYYY'), 'o3@3.com', 'USD' 
);

INSERT INTO TourOperator VALUES (
	0004, 'Mr Operator 4', 'company4', TO_DATE('14122020', 'DDMMYYYY'), 'o4@4.com', 'USD' 
);

-- Tour ------------------------------------------------------------------------

INSERT INTO Tour VALUES (
	0001, '5 Nights in Paris', 'Sample the food and wine of magical Paris.',
	1899.95, 6, 0
);

INSERT INTO Tour VALUES (
	0002, 'Australia Zoo', 'Experience the reef and rainforest in Cairns.',
	349.95, 4, 0
);

INSERT INTO Tour VALUES (
	0003, 'The Milford Track', 'Take 5 days off for this world famous guided hike.',
	1790.00, 5, 0
);

INSERT INTO Tour VALUES (
	0004, 'The Rock', 'The most electrifying rock in world entertainment.',
	1899.95, 2, 0
);

INSERT INTO Tour VALUES (
	0005, 'Egyptian Wonders', 'Rameses, Tutankhamun, Nefertiti and Cleopatra.',
	1899.95, 6, 1
);

INSERT INTO Tour VALUES (
	0006, 'Big Apple', 'New York at its finest; loud, proud and ugly.',
	2799.95, 9, 1
);

INSERT INTO Tour VALUES (
	0007, 'Pax Romana', 'Take a walking tour of Rome, the eternal city.',
	1899.95, 3, 1
);

INSERT INTO Tour VALUES (
	0008, 'Medieval Europe', 'Prague is Europe''s hidden gem, affordable and beautiful',
	999.95, 6, 1
);

INSERT INTO Tour VALUES (
	0009, 'Stonehenge', 'Take this day tour to the mythical site of the Druids',
	1899.95, 1, 1
);

INSERT INTO Tour VALUES (
	0010, 'Fire and Ice', 'It''s Iceland as you have never seen it before.',
	1299.95, 4, 1
);

INSERT INTO Tour VALUES (
	0011, 'Dostoyevski''s Ruin', 'Fancy a trip to Siberia? We don''t, but you can go.',
	1899.95, 23, 1
);

INSERT INTO Tour VALUES (
	0012, 'Holiday in Cambodia', 'What the heck was Jello Biafra talking about?',
	699.95, 6, 1
);

INSERT INTO Tour VALUES (
	0013, 'Wine Country', 'Bordeaux dans printemps. C''est vraiment bon.',
	1599.95, 8, 1
);

INSERT INTO Tour VALUES (
	0014, 'Eye of the Tiger', 'Who cares about the Declaration when you have Rocky.',
	1999.95, 4, 1
);

INSERT INTO Tour VALUES (
	0015, 'The Odyssey', 'Set off from Piraeus to the Ios and then beautiful Santorini.',
	1099.95, 6, 1
);

INSERT INTO Tour VALUES (
	0016, 'The Last Crusade', 'Starting in Turkey, and finishing in Palestine.',
	1199.95, 15, 1
);

INSERT INTO Tour VALUES (
	0017, 'World Game', 'Catch the 2010 Football World Cup in Johannesburg.',
	2599.95, 30, 1
);

-- ListedTour -----------------------------------------------------------------------

INSERT INTO ListedTour VALUES (
	0001, 0003, 0001, TO_DATE('11052010', 'DDMMYYYY'), TO_DATE('11122010', 'DDMMYYYY')  
);

INSERT INTO ListedTour VALUES (
	0002, 0003, 0002, TO_DATE('12052010', 'DDMMYYYY'), TO_DATE('12122010', 'DDMMYYYY')  
);

INSERT INTO ListedTour VALUES (
	0003, 0004, 0003, TO_DATE('13052010', 'DDMMYYYY'), TO_DATE('13122010', 'DDMMYYYY')  
);

INSERT INTO ListedTour VALUES (
	0004, 0004, 0004, TO_DATE('14052010', 'DDMMYYYY'), TO_DATE('14122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0005, 0004, 0004, TO_DATE('14052010', 'DDMMYYYY'), TO_DATE('14122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0006, 0004, 0004, TO_DATE('14052010', 'DDMMYYYY'), TO_DATE('14122010', 'DDMMYYYY')  
);

-- Activity --------------------------------------------------------------------

INSERT INTO Activity VALUES (
	0001, 'Jump'
);

INSERT INTO Activity VALUES (
	0002, 'Run'
);

INSERT INTO Activity VALUES (
	0003, 'Hide'
);

INSERT INTO Activity VALUES (
	0004, 'Seek'
);

-- TourActivity ----------------------------------------------------------------

INSERT INTO TourActivity VALUES (
	0001, 0001
);

INSERT INTO TourActivity VALUES (
	0002, 0002
);

INSERT INTO TourActivity VALUES (
	0003, 0003
);

INSERT INTO TourActivity VALUES (
	0004, 0004
);

-- Location -----------------------------------------------------------------------

INSERT INTO Location VALUES (
	0001, 'Sydney', -10425.01545, 2035.0135
);

INSERT INTO Location VALUES (
	0002, 'Brisbane', 1045435345.054353453452, -2053453.024332423
);

INSERT INTO Location VALUES (
	0003, 'NewYork', 10234522.0000123333355, 205435435.03342342
);

INSERT INTO Location VALUES (
	0004, 'Perth', 10890444.04890403890, 202342342.04432423423
);

-- TourLocation -----------------------------------------------------------------------

INSERT INTO TourLocation VALUES (
	0001, 0003
);

INSERT INTO TourLocation VALUES (
	0002, 0004
);

INSERT INTO TourLocation VALUES (
	0003, 0003
);

INSERT INTO TourLocation VALUES (
	0004, 0004
);

-- Image -----------------------------------------------------------------------

INSERT INTO Image VALUES (
	0001, 'http://localhost/image0001.jpg', 0001
);

INSERT INTO Image VALUES (
	0002, 'http://localhost/image0002.jpg', 0002
);

INSERT INTO Image VALUES (
	0003, 'http://localhost/image0003.jpg', 0003
);

INSERT INTO Image VALUES (
	0004, 'http://localhost/image0004.jpg', 0004
);

-- TourDate --------------------------------------------------------------------

INSERT INTO TourDate VALUES (
	0001, 0001, TO_DATE('11/05/2010', 'DD/MM/YYYY'), TO_DATE('11/12/2010', 'DD/MM/YYYY')  
);

INSERT INTO TourDate VALUES (
	0002, 0002, TO_DATE('12/05/2010', 'DD/MM/YYYY'), TO_DATE('12/12/2010', 'DD/MM/YYYY')  
);

INSERT INTO TourDate VALUES (
	0003, 0003, TO_DATE('13/05/2010', 'DD/MM/YYYY'), TO_DATE('13/12/2010', 'DD/MM/YYYY')  
);

INSERT INTO TourDate VALUES (
	0004, 0004, TO_DATE('14/05/2010', 'DD/MM/YYYY'), TO_DATE('14/12/2010', 'DD/MM/YYYY')  
);

-- MonthlyFee -----------------------------------------------------------------------

INSERT INTO MonthlyFee VALUES (
	0001, TO_DATE('01/01/2010', 'DD/MM/YYYY'), 101.50
);

INSERT INTO MonthlyFee VALUES (
	0002, TO_DATE('01/02/2010', 'DD/MM/YYYY'), 102.50
);

INSERT INTO MonthlyFee VALUES (
	0003, TO_DATE('01/03/2010', 'DD/MM/YYYY'), 103.50
);

INSERT INTO MonthlyFee VALUES (
	0004, TO_DATE('01/04/2010', 'DD/MM/YYYY'), 104.50
);

INSERT INTO MonthlyFee VALUES (
	0005, TO_DATE('01/05/2010', 'DD/MM/YYYY'), 105.50
);

INSERT INTO MonthlyFee VALUES (
	0006, TO_DATE('01/06/2010', 'DD/MM/YYYY'), 106.50
);

INSERT INTO MonthlyFee VALUES (
	0007, TO_DATE('01/07/2010', 'DD/MM/YYYY'), 107.50
);

INSERT INTO MonthlyFee VALUES (
	0008, TO_DATE('01/08/2010', 'DD/MM/YYYY'), 108.50
);

INSERT INTO MonthlyFee VALUES (
	0009, TO_DATE('01/09/2010', 'DD/MM/YYYY'), 109.50
);

INSERT INTO MonthlyFee VALUES (
	0010, TO_DATE('01/10/2010', 'DD/MM/YYYY'), 110.50
);

INSERT INTO MonthlyFee VALUES (
	0011, TO_DATE('01/11/2010', 'DD/MM/YYYY'), 111.50
);

INSERT INTO MonthlyFee VALUES (
	0012, TO_DATE('01/12/2010', 'DD/MM/YYYY'),112.50
);

COMMIT;