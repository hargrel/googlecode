-- AccountUser: 10 Operator and 1 Admin -----------------------------------------------------------------

INSERT INTO AccountUser VALUES (
	0001, 'austravel', '460f727a0ef1f797995a24033ebd9a7d', 'operator'
);
INSERT INTO AccountUser VALUES (
	0002, 'ecotrans', '18fdec38e5777a28f0810333161c5e84', 'operator'
);
INSERT INTO AccountUser VALUES (
	0003, 'adventours', 'f84b407363cd30799f590982ea922384', 'operator'
);
INSERT INTO AccountUser VALUES (
	0004, 'travelscene', 'e3286d4aefa8e9e941dee81d6f73229f', 'operator'
);
INSERT INTO AccountUser VALUES (
	0005, 'ecotravel', 'f76be6d6433ea30b79cfe17f07331074', 'operator'
);
INSERT INTO AccountUser VALUES (
	0006, 'travelink', '0125e65edcc01c6d667b87686ebb0ace', 'operator'
);
INSERT INTO AccountUser VALUES (
	0007, 'scenictours', '883d5ec0f754cb60c4bab7dbd9e8c883', 'operator'
);
INSERT INTO AccountUser VALUES (
	0008, 'travelous', '73f3844aafd9ea2f387baecf11d20cb7', 'operator'
);
INSERT INTO AccountUser VALUES (
	0009, 'travelocity', '73ef0f17b0edb1d1a197e1ac992e712c', 'operator'
);
INSERT INTO AccountUser VALUES (
	0010, 'safari.link', 'f4c4ffae7d779da6ec95b6316b3fed26', 'operator'
);
INSERT INTO AccountUser VALUES (
	0011, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin'
);

-- TourOperator: 10 Operator ----------------------------------------------------------------

INSERT INTO TourOperator VALUES (
	0001, 'Austravel', 'Austravel is a leading travel centre representing Australia''s major tour operators. We offer a comprehensive travel planning and reservation service for all tours.', TO_DATE('13122020', 'DDMMYYYY'), 'tay.booncheen@gmail.com'  
);
INSERT INTO TourOperator VALUES (
	0002, 'Ecotrans', 'Ecotrans offers exhilarating outdoor adventures to Africa, Asia, Caribbean, Europe, Latin America, and the South Pacific. Whether it''s an eco adventure or a jungle safari, you can count on us to make your travel dreams come true.', TO_DATE('14122020', 'DDMMYYYY'), 'tay.booncheen@gmail.com' 
);
INSERT INTO TourOperator VALUES (
	0003, 'Adventours', 'Adventours is a long established specialist tour operator offering tailor-made adventure holidays to clients throughout the world.', TO_DATE('14122020', 'DDMMYYYY'), 'tay.booncheen@gmail.com' 
);
INSERT INTO TourOperator VALUES (
	0004, 'Travelscene', 'Travelscene offers great service, great deals and the best prices on all types of travel products. Our product range includes eco tours, harbour cruises, & extended adventures.', TO_DATE('13122020', 'DDMMYYYY'), 'tay.booncheen@gmail.com'  
);
INSERT INTO TourOperator VALUES (
	0005, 'Ecotravel', 'An eco friendly company based in Brisbane moving responsible travel to natural areas that conserve the environment and improves the well-being of local people.', TO_DATE('13122020', 'DDMMYYYY'), 'tay.booncheen@gmail.com'  
);
INSERT INTO TourOperator VALUES (
	0006, 'Travelink', 'Travelink pioneers small, group adventure holidays around the world. Travelink''s responsible tourism policy is the cornerstone of the company''s approach to tour operating.', TO_DATE('14122020', 'DDMMYYYY'), 'tay.booncheen@gmail.com' 
);
INSERT INTO TourOperator VALUES (
	0007, 'Scenictours', 'Scenic tours is an independent travel agency selling escorted treks and tours, adventure and activity travel, safari and wildlife trips and tailor-made holidays to customers who desire impeccable and personalised service.', TO_DATE('13122020', 'DDMMYYYY'), 'tay.booncheen@gmail.com'  
);
INSERT INTO TourOperator VALUES (
	0008, 'Travelous', 'Travelous provides advice, information and bookings for holidays, eco trips, and package tours to anywhere in the world. We ensure customers thoroughly enjoy the style in which their pre trip experience is delivered.', TO_DATE('13122020', 'DDMMYYYY'), 'tay.booncheen@gmail.com'  
);
INSERT INTO TourOperator VALUES (
	0009, 'Travelocity', 'A small, independent Travel Agency based in Chicago, United Travel offers discount holidays and travel services with financial protection to customers throughout the world.', TO_DATE('14122020', 'DDMMYYYY'), 'tay.booncheen@gmail.com' 
);
INSERT INTO TourOperator VALUES (
	0010, 'Safari Link', 'Safari Link is an established safari and holiday operator dedicated to offering high quality, bespoke and innovative safaris and holidays to Africa.', TO_DATE('13122020', 'DDMMYYYY'), 'tay.booncheen@gmail.com'  
);

-- Tour: ----------------------------------------------------------------------------------------------------------------------

-- Total 30 tours all listed by default 
-- 5 tours for each of Operator 1,2,3,4,5, 
-- 1 tour for each of Operator 6,7,8,9,10

-- Tour(tour_ID, tour_Name, tour_Desc, price, total_Days, on_Demand, currency, operator_ID, points, levels)	
	
INSERT INTO Tour VALUES (
	0001, 'Europe Adventure', 'Trek the Alps from France to Italy, France, UK, and Russia; cross glaciers and pine forests, visit remote villages and mountain refuges before finishing your days with local cuisine and wines.',
	1269.55, 2, 0,'USD',1, 'erknGsgm`A}jaSlg{fAiofi@|sxJx`vKm|moAel`V_op{N', 'BBBBB'
);
INSERT INTO Tour VALUES (
	0002, 'The Old Woods', 'Trek the Alps from France to Italy, France, UK, and Russia; cross glaciers and pine forests, visit remote villages and mountain refuges before finishing your days with local cuisine and wines.',
	1289.75,3, 0,'USD',1, 'qmutCovjmGvrxJqmquE_entA_pihCnofeCoihC', 'BBBB'
);
INSERT INTO Tour VALUES (
	0003, 'Here Be Europe', 'Trek the Alps from France to Italy, France, UK, and Russia; cross glaciers and pine forests, visit remote villages and mountain refuges before finishing your days with local cuisine and wines.',
	1399.35, 4, 0,'AUD',1, 's{tvFufl}Aqi{g@|{p_B', 'BB'
);
INSERT INTO Tour VALUES (
	0004, 'More Winter Walks', 'Trek the Alps from France to Italy and Switzerland; cross glaciers and pine forests, visit remote villages and mountain refuges before finishing your days with local cuisine and wines.',
	1679.95, 6, 0,'AUD',1, 'o}dhHcnhuOxnfi@cfvpBinwW{f~vAny_{A~pchB', 'BBBB'
);
INSERT INTO Tour VALUES (
	0005, 'Alps Trek', 'Trek the Alps from France to Italy and Switzerland; cross glaciers and pine forests, visit remote villages and mountain refuges before finishing your days with local cuisine and wines.',
	1899.95, 6, 0,'AUD',1, '{zqrFsrst@wibf@ftcA|on@aswg@', 'BBB'
);
INSERT INTO Tour VALUES (
	0006, 'Trekking Mont Blanc', 'Trek the Alps from France to Italy and Switzerland; cross glaciers and pine forests, visit remote villages and mountain refuges before finishing your days with local cuisine and wines.',
	2099.95, 7, 0,'AUD',1, 'o}dhHcnhuOi`fCgroaAdyxA}gxv@eyxAmra{@', 'BBBB'
);
INSERT INTO Tour VALUES (
	0007, 'Trekking Alpen', 'Trek the Alps from France to Italy and Switzerland; cross glaciers and pine forests, visit remote villages and mountain refuges before finishing your days with local cuisine and wines.',
	1899.95, 8, 0,'AUD',1, 'bCcmnuPmzuRwh', 'BBBB'
);
INSERT INTO Tour VALUES (
	0008, 'Silent Night', 'Trek the Alps from France to Italy and Switzerland; cross glaciers and pine forests, visit remote villages and mountain refuges before finishing your days with local cuisine and wines.',
	1999.95, 4, 0,'AUD',1, '_d{jCsqzgLaqbk@ms{Z`acLyren@~n~]os{Z', 'BBBB'
);
INSERT INTO Tour VALUES (
	0009, 'Winter Wonderland', 'Trek the Alps from France to Italy and Switzerland; cross glaciers and pine forests, visit remote villages and mountain refuges before finishing your days with local cuisine and wines.',
	1599.95, 6, 0,'EUR',1, '_{xaFsespMm~gi@chjp@xuvNogtcAjezCufl}Acucd@ugf}@|pnL}gxv@', 'BBBBBB'
);
INSERT INTO Tour VALUES (
	0010, 'Denmark Adventure', 'Denmark is a small country made up of the Jutland Peninsula and over 500 islands with an abundance of places to visit.',
	1399.35, 2, 0,'AUD',1, 's{tvFufl}Aqi{g@|{p_B', 'BB'
);
INSERT INTO Tour VALUES (
	0011, 'Extraordinary Experiences', 'Denmark is home to a number of wonderful bike trails - gentle grades for families, and mountain bike trails for those who like a bit of adventure.',
	1269.55, 3, 0,'USD',1, 'erknGsgm`A}jaSlg{fAiofi@|sxJx`vKm|moAel`V_op{N', 'BBBBB'
);
INSERT INTO Tour VALUES (
	0012, 'Denmark Magic', 'Follow in the steps of the Incas on this trip to the "must-see" highlight of Denmark.',
	1289.75, 4, 0,'USD',1, 'qmutCovjmGvrxJqmquE_entA_pihCnofeCoihC', 'BBBB'
);
INSERT INTO Tour VALUES (
	0013, 'Travel to Russia', 'Go Russia ¨C cultural and discovery tours to Russia. We offer city-breaks, cruises, discovery and adventure  trips or a famous Trans Siberian journey.',
	1399.35, 5, 0,'AUD',1, 's{tvFufl}Aqi{g@|{p_B', 'BB'
);
INSERT INTO Tour VALUES (
	0014, 'Go Russia', 'Adventure tours in Russia and CIS countries. Elbrus climb, Kamchatka trekking and ski-tours, Caucasus ski-tours, Expeditions.',
	1679.95, 4, 0,'AUD',1, 'o}dhHcnhuOxnfi@cfvpBinwW{f~vAny_{A~pchB', 'BBBB'
);
INSERT INTO Tour VALUES (
	0015, 'Kamchatka - Russia', 'Take an adventure holiday in RUSSIA with World Expeditions, one of the world¡¯s leading travel companies.',
	1899.95, 3, 0,'AUD',1, '{zqrFsrst@wibf@ftcA|on@aswg@', 'BBB'
);
INSERT INTO Tour VALUES (
	0016, 'Mountain Travel-Sobek', 'Mountain Travel-Sobek is thrilled to announce what they believe will be the first ever adventure tour of Saudi Arabia',
	2099.95, 5, 0,'AUD',1, 'o}dhHcnhuOi`fCgroaAdyxA}gxv@eyxAmra{@', 'BBBB'
);
INSERT INTO Tour VALUES (
	0017, 'Go - Saudi Arabia', 'The largest country in the Arabian Peninsula, Saudi Arabia, tourism is an important business shaping up there.',
	1899.95,5, 0,'AUD',1, 'bCcmnuPmzuRwh', 'BBBB'
);
INSERT INTO Tour VALUES (
	0018, 'Cave Creeping', 'Availability of many caves across Saudi Arabia makes it an adventurous tourist destination for them who like to creep through the curious desert caves.',
	1999.95, 2, 0,'AUD',1, '_d{jCsqzgLaqbk@ms{Z`acLyren@~n~]os{Z', 'BBBB'
);
INSERT INTO Tour VALUES (
	0019, 'Roam India', 'India is home to great food, fascinating culture, alluring sights and friendly and inviting people. Discover the charms and mystery that makes up this incredible country.',
	1599.95, 3, 0,'EUR',1, '_{xaFsespMm~gi@chjp@xuvNogtcAjezCufl}Acucd@ugf}@|pnL}gxv@', 'BBBBBB'
);
INSERT INTO Tour VALUES (
	0020, 'Here Be India', 'India is home to great food, fascinating culture, alluring sights and friendly and inviting people. Discover the charms and mystery that makes up this incredible country.',
	1399.35, 4, 0,'AUD',1, 's{tvFufl}Aqi{g@|{p_B', 'BB'
);
INSERT INTO Tour VALUES (
	0021, 'Beautiful India - Manali', 'Manali, with its soothing backdrop of the Himalayas, offers a blend of tranquility and adventure that makes it one of northern India most popular tourist destinations.',
	1269.55, 2, 0,'USD',1, 'erknGsgm`A}jaSlg{fAiofi@|sxJx`vKm|moAel`V_op{N', 'BBBBB'
);
INSERT INTO Tour VALUES (
	0022, 'Asia Adventure', 'Follow in the steps of the Incas on this trip to the "must-see" highlight of Asia - from China to Thailand! This tour is spectacular and the first glimpse of Asia will leave memories.',
	1289.75, 3, 0,'USD',1, 'qmutCovjmGvrxJqmquE_entA_pihCnofeCoihC', 'BBBB'
);
INSERT INTO Tour VALUES (
	0023, 'Hike China, Bike & Raft', 'From rural roads through endless rice fields in southern China to the bustling streets of Beijing, over the Great Wall of China and down the Li River, see China in a unique way!',
	1399.35, 4, 0,'AUD',1, 's{tvFufl}Aqi{g@|{p_B', 'BB'
);
INSERT INTO Tour VALUES (
	0024, 'I Love Mongolia', 'An incredible journey to the land of blue skies, green hills and nomadic people. Get out and explore the city of Ulaan Baatar and lush green countryside, which is dotted with ancient monasteries.',
	1679.95, 5, 0,'AUD',1, 'o}dhHcnhuOxnfi@cfvpBinwW{f~vAny_{A~pchB', 'BBBB'
);
INSERT INTO Tour VALUES (
	0025, 'Thailand Sailing Adventure', 'Island hop in Southern Thailand to some of the best snorkeling and diving locations in the world. Enjoy a week aboard a sailing catamaran, while swimming in deserted waters among turtles.',
	1899.95, 4, 0,'AUD',1, '{zqrFsrst@wibf@ftcA|on@aswg@', 'BBB'
);
INSERT INTO Tour VALUES (
	0026, 'Asia Magic', 'Follow in the steps of the Incas on this trip to the "must-see" highlight of Asia - from China to Thailand! This tour is spectacular and the first glimpse of Asia will leave memories.',
	2099.95, 3, 0,'AUD',1, 'o}dhHcnhuOi`fCgroaAdyxA}gxv@eyxAmra{@', 'BBBB'
);
INSERT INTO Tour VALUES (
	0027, 'Sail Thailand', 'Island hop in Southern Thailand to some of the best snorkeling and diving locations in the world. Enjoy a week aboard a sailing catamaran, while swimming in deserted waters among turtles.',
	1899.95, 2, 0,'AUD',1, 'bCcmnuPmzuRwh', 'BBBB'
);
INSERT INTO Tour VALUES (
	0028, 'Trail Volcano', 'Exhilarating hiking on the edge! A week of unforgettable hikes over three active volcanoes: Vulcano; Stromboli, one of the most active volcanoes in the world; and mighty Etna, Europe highest active volcano.',
	1999.95, 2, 0,'AUD',1, '_d{jCsqzgLaqbk@ms{Z`acLyren@~n~]os{Z', 'BBBB'
);
INSERT INTO Tour VALUES (
	0029, 'Go Himalayas', 'Love to hike? Then this 8-day active adventure in Nepal is for you! Enjoy mountain treks offering magnificent views, encounters with Berber villagers and the opportunity to explore bustling Marrakech.',
	1599.95, 2, 0,'EUR',1, '_{xaFsespMm~gi@chjp@xuvNogtcAjezCufl}Acucd@ugf}@|pnL}gxv@', 'BBBBBB'
);
INSERT INTO Tour VALUES (
	0030, 'Trek Himalaya', 'Love to hike? Then this 8-day active adventure in Nepal is for you! Enjoy mountain treks offering magnificent views, encounters with Berber villagers and the opportunity to explore bustling Marrakech.',
	1399.35, 2, 0,'AUD',1, 's{tvFufl}Aqi{g@|{p_B', 'BB'
);

-- ListedTour -----------------------------------------------------------------------

-- Total 30 tours all listed by default 
-- 5 tours for each of Operator 1,2,3,4,5, 
-- 1 tour for each of Operator 6,7,8,9,10

-- ListedTour (listID, operatorID, tourID, listedFrom, listedTo)

INSERT INTO ListedTour VALUES (
	0001, 0001, 0001, TO_DATE('12012010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0002, 0001, 0002, TO_DATE('12052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0003, 0001, 0003, TO_DATE('02022010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0004, 0001, 0004, TO_DATE('03032010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0005, 0001, 0005, TO_DATE('01012010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0006, 0002, 0006, TO_DATE('12052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0007, 0002, 0007, TO_DATE('12052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0008, 0002, 0008, TO_DATE('12052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0009, 0002, 0009, TO_DATE('20052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0010, 0002, 0010, TO_DATE('12062010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0011, 0003, 0011, TO_DATE('12082010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0012, 0003, 0012, TO_DATE('12052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0013, 0003, 0013, TO_DATE('12062010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0014, 0003, 0014, TO_DATE('12052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0015, 0003, 0015, TO_DATE('12062010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0016, 0004, 0016, TO_DATE('13022010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0017, 0004, 0017, TO_DATE('14012010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0018, 0004, 0018, TO_DATE('14062010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0019, 0004, 0019, TO_DATE('14052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0020, 0004, 0020, TO_DATE('12052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0021, 0005, 0021, TO_DATE('12052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0022, 0005, 0022, TO_DATE('12052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0023, 0005, 0023, TO_DATE('12062010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0024, 0005, 0024, TO_DATE('13022010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0025, 0005, 0025, TO_DATE('14012010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0026, 0006, 0026, TO_DATE('14062010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0027, 0007, 0027, TO_DATE('14052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0028, 0008, 0028, TO_DATE('12052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0029, 0009, 0029, TO_DATE('12052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0030, 0010, 0030, TO_DATE('12052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);

-- Activity --------------------------------------------------------------------

-- Stored in databse in UPPERCASE
-- Search multiple activities seperated by comma WITHOUT space, any case accepted
-- peRU,NepAL without space will work
-- peRU, NepAL with space will not work

-- Activity 'HIKING' linked to Tour 1-50
-- Multiple activities 'CYCLING','SAILING','DIVING' linked to Tour 51-55 

-- Activity(activity_ID, activity_Name)

INSERT INTO Activity VALUES (0001, 'HIKING');
INSERT INTO Activity VALUES (0002, 'CYCLING');
INSERT INTO Activity VALUES (0003, 'SAILING');
INSERT INTO Activity VALUES (0004, 'DIVING');
INSERT INTO Activity VALUES (0005, 'YACHTING');
INSERT INTO Activity VALUES (0006, 'SAILING');
INSERT INTO Activity VALUES (0007, 'TREKKING');
INSERT INTO Activity VALUES (0008, 'DISCOVERING');
INSERT INTO Activity VALUES (0009, 'SNORKELING');
INSERT INTO Activity VALUES (0010, 'CANOEING');

-- TourActivity ----------------------------------------------------------------

-- TourActivity(activity_ID, tour_ID)

-- For Detecting Abuse Report
INSERT INTO TourActivity VALUES (0001, 0005);
INSERT INTO TourActivity VALUES (0002, 0005);
INSERT INTO TourActivity VALUES (0003, 0005);
INSERT INTO TourActivity VALUES (0004, 0005);
INSERT INTO TourActivity VALUES (0005, 0005);

INSERT INTO TourActivity VALUES (0001, 0001);
INSERT INTO TourActivity VALUES (0001, 0002);
INSERT INTO TourActivity VALUES (0001, 0003);
INSERT INTO TourActivity VALUES (0002, 0004);
--INSERT INTO TourActivity VALUES (0002, 0005);
INSERT INTO TourActivity VALUES (0002, 0006);
INSERT INTO TourActivity VALUES (0003, 0007);
INSERT INTO TourActivity VALUES (0003, 0008);
INSERT INTO TourActivity VALUES (0003, 0009);
INSERT INTO TourActivity VALUES (0004, 0010);
INSERT INTO TourActivity VALUES (0004, 0011);
INSERT INTO TourActivity VALUES (0004, 0012);
INSERT INTO TourActivity VALUES (0005, 0013);
INSERT INTO TourActivity VALUES (0005, 0014);
INSERT INTO TourActivity VALUES (0005, 0015);
INSERT INTO TourActivity VALUES (0006, 0016);
INSERT INTO TourActivity VALUES (0006, 0017);
INSERT INTO TourActivity VALUES (0006, 0018);
INSERT INTO TourActivity VALUES (0007, 0019);
INSERT INTO TourActivity VALUES (0007, 0020);
INSERT INTO TourActivity VALUES (0007, 0021);
INSERT INTO TourActivity VALUES (0008, 0022);
INSERT INTO TourActivity VALUES (0008, 0023);
INSERT INTO TourActivity VALUES (0008, 0024);
INSERT INTO TourActivity VALUES (0009, 0025);
INSERT INTO TourActivity VALUES (0009, 0026);
INSERT INTO TourActivity VALUES (0009, 0027);
INSERT INTO TourActivity VALUES (0010, 0028);
INSERT INTO TourActivity VALUES (0010, 0029);
INSERT INTO TourActivity VALUES (0010, 0030);

-- Location -----------------------------------------------------------------------

-- Location(location_ID, location_Name, lati, longi)

INSERT INTO Location VALUES (
	0001, 'UNITED KINGDOM', 55.378051, -3.435973
);
INSERT INTO Location VALUES (
	0002, 'FRANCE', 46.227638, 2.213749
);
INSERT INTO Location VALUES (
	0003, 'ITALY', 41.87194, 12.56738
);
INSERT INTO Location VALUES (
	0004, 'DENMARK', 56.26392, 9.501785
);
INSERT INTO Location VALUES (
	0005, 'RUSSIA', 50.51342652633956, 88.06640625
);
INSERT INTO Location VALUES (
	0006, 'SAUDI ARABIA', 23.885942, 45.079162
);
INSERT INTO Location VALUES (
	0007, 'INDIA', 20.593684, 78.96288
);
INSERT INTO Location VALUES (
	0008, 'CHINA', 35.86166, 104.195397
);
INSERT INTO Location VALUES (
	0009, 'THAILAND', 15.870032, 100.992541
);
INSERT INTO Location VALUES (
	0010, 'NEPAL', 28.394857, 84.124008
);

-- TourLocation -----------------------------------------------------------------------

-- TourLocation(location_ID, tour_ID)

INSERT INTO TourLocation VALUES (0001, 0001);
INSERT INTO TourLocation VALUES (0001, 0002);
INSERT INTO TourLocation VALUES (0001, 0003);
INSERT INTO TourLocation VALUES (0002, 0004);
INSERT INTO TourLocation VALUES (0002, 0005);
INSERT INTO TourLocation VALUES (0002, 0006);
INSERT INTO TourLocation VALUES (0003, 0007);
INSERT INTO TourLocation VALUES (0003, 0008);
INSERT INTO TourLocation VALUES (0003, 0009);
INSERT INTO TourLocation VALUES (0004, 0010);
INSERT INTO TourLocation VALUES (0004, 0011);
INSERT INTO TourLocation VALUES (0004, 0012);
INSERT INTO TourLocation VALUES (0005, 0013);
INSERT INTO TourLocation VALUES (0005, 0014);
INSERT INTO TourLocation VALUES (0005, 0015);
INSERT INTO TourLocation VALUES (0006, 0016);
INSERT INTO TourLocation VALUES (0006, 0017);
INSERT INTO TourLocation VALUES (0006, 0018);
INSERT INTO TourLocation VALUES (0007, 0019);
INSERT INTO TourLocation VALUES (0007, 0020);
INSERT INTO TourLocation VALUES (0007, 0021);
INSERT INTO TourLocation VALUES (0008, 0022);
INSERT INTO TourLocation VALUES (0008, 0023);
INSERT INTO TourLocation VALUES (0008, 0024);
INSERT INTO TourLocation VALUES (0009, 0025);
INSERT INTO TourLocation VALUES (0009, 0026);
INSERT INTO TourLocation VALUES (0009, 0027);
INSERT INTO TourLocation VALUES (0010, 0028);
INSERT INTO TourLocation VALUES (0010, 0029);
INSERT INTO TourLocation VALUES (0010, 0030);

-- Image -----------------------------------------------------------------------

-- All tours have one image
-- Image(image_ID, image_URL, tour_ID)

INSERT INTO Image VALUES (0001, '1.jpg', 0001);
INSERT INTO Image VALUES (0002, '2.jpg', 0002);
INSERT INTO Image VALUES (0003, '3.jpg', 0003);
INSERT INTO Image VALUES (0004, '4.jpg', 0004);
INSERT INTO Image VALUES (0005, '1.jpg', 0005);
INSERT INTO Image VALUES (0006, '2.jpg', 0006);
INSERT INTO Image VALUES (0007, '3.jpg', 0007);
INSERT INTO Image VALUES (0008, '4.jpg', 0008);
INSERT INTO Image VALUES (0009, '1.jpg', 0009);
INSERT INTO Image VALUES (0010, '2.jpg', 0010);
INSERT INTO Image VALUES (0011, '3.jpg', 0011);
INSERT INTO Image VALUES (0012, '4.jpg', 0012);
INSERT INTO Image VALUES (0013, '1.jpg', 0013);
INSERT INTO Image VALUES (0014, '2.jpg', 0014);
INSERT INTO Image VALUES (0015, '3.jpg', 0015);
INSERT INTO Image VALUES (0016, '4.jpg', 0016);
INSERT INTO Image VALUES (0017, '1.jpg', 0017);
INSERT INTO Image VALUES (0018, '2.jpg', 0018);
INSERT INTO Image VALUES (0019, '3.jpg', 0019);
INSERT INTO Image VALUES (0020, '4.jpg', 0020);
INSERT INTO Image VALUES (0021, '1.jpg', 0021);
INSERT INTO Image VALUES (0022, '2.jpg', 0022);
INSERT INTO Image VALUES (0023, '3.jpg', 0023);
INSERT INTO Image VALUES (0024, '4.jpg', 0024);
INSERT INTO Image VALUES (0025, '1.jpg', 0025);
INSERT INTO Image VALUES (0026, '2.jpg', 0026);
INSERT INTO Image VALUES (0027, '3.jpg', 0027);
INSERT INTO Image VALUES (0028, '4.jpg', 0028);
INSERT INTO Image VALUES (0029, '1.jpg', 0029);
INSERT INTO Image VALUES (0030, '2.jpg', 0030);

-- TourDate --------------------------------------------------------------------

-- TourDate(date_ID, tour_ID, start_Date, finish_Date)

INSERT INTO TourDate VALUES (
	0001, 0001, TO_DATE('01/06/2010', 'DD/MM/YYYY'), TO_DATE('03/06/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0002, 0002, TO_DATE('01/06/2010', 'DD/MM/YYYY'), TO_DATE('04/06/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0003, 0003, TO_DATE('01/06/2010', 'DD/MM/YYYY'), TO_DATE('05/06/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0004, 0004, TO_DATE('01/06/2010', 'DD/MM/YYYY'), TO_DATE('07/06/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0005, 0005, TO_DATE('01/06/2010', 'DD/MM/YYYY'), TO_DATE('07/06/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0006, 0006, TO_DATE('01/07/2010', 'DD/MM/YYYY'), TO_DATE('08/07/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0007, 0007, TO_DATE('01/07/2010', 'DD/MM/YYYY'), TO_DATE('09/07/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0008, 0008, TO_DATE('01/07/2010', 'DD/MM/YYYY'), TO_DATE('05/07/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0009, 0009, TO_DATE('01/07/2010', 'DD/MM/YYYY'), TO_DATE('07/07/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0010, 0010, TO_DATE('05/07/2010', 'DD/MM/YYYY'), TO_DATE('07/07/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0011, 0011, TO_DATE('05/08/2010', 'DD/MM/YYYY'), TO_DATE('08/08/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0012, 0012, TO_DATE('05/08/2010', 'DD/MM/YYYY'), TO_DATE('09/08/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0013, 0013, TO_DATE('05/08/2010', 'DD/MM/YYYY'), TO_DATE('10/08/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0014, 0014, TO_DATE('05/08/2010', 'DD/MM/YYYY'), TO_DATE('09/08/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0015, 0015, TO_DATE('05/08/2010', 'DD/MM/YYYY'), TO_DATE('08/08/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0016, 0016, TO_DATE('05/09/2010', 'DD/MM/YYYY'), TO_DATE('10/09/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0017, 0017, TO_DATE('05/09/2010', 'DD/MM/YYYY'), TO_DATE('10/09/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0018, 0018, TO_DATE('05/09/2010', 'DD/MM/YYYY'), TO_DATE('07/09/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0019, 0019, TO_DATE('05/09/2010', 'DD/MM/YYYY'), TO_DATE('08/09/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0020, 0020, TO_DATE('05/09/2010', 'DD/MM/YYYY'), TO_DATE('09/09/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0021, 0021, TO_DATE('10/10/2010', 'DD/MM/YYYY'), TO_DATE('13/10/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0022, 0022, TO_DATE('10/10/2010', 'DD/MM/YYYY'), TO_DATE('14/10/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0023, 0023, TO_DATE('10/10/2010', 'DD/MM/YYYY'), TO_DATE('15/10/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0024, 0024, TO_DATE('10/10/2010', 'DD/MM/YYYY'), TO_DATE('12/10/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0025, 0025, TO_DATE('10/10/2010', 'DD/MM/YYYY'), TO_DATE('13/10/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0026, 0026, TO_DATE('10/11/2010', 'DD/MM/YYYY'), TO_DATE('12/11/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0027, 0027, TO_DATE('10/11/2010', 'DD/MM/YYYY'), TO_DATE('15/11/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0028, 0028, TO_DATE('10/11/2010', 'DD/MM/YYYY'), TO_DATE('18/11/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0029, 0029, TO_DATE('10/12/2010', 'DD/MM/YYYY'), TO_DATE('13/11/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0030, 0030, TO_DATE('10/12/2010', 'DD/MM/YYYY'), TO_DATE('17/11/2010', 'DD/MM/YYYY')  
);

-- MonthlyFee -----------------------------------------------------------------------

-- MonthlyFee(fee_ID, MONTH_YEAR_START, FEE)

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
	0012, TO_DATE('01/12/2010', 'DD/MM/YYYY'), 112.50
);

COMMIT;

