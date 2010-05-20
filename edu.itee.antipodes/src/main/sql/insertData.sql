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

-- Total 55 tours all listed by default 
-- First 30 tours (i.e. tour 1-30) for Operator 1, 
-- Then 5 tours (i.e. tours 31-35, 36-40, 41-45, 46-50) for each of Operator 2,3,4,5, 
-- And 1 tour (i.e. tours 51,52,53,54,55) for each of Operator 6,7,8,9,10

-- total_Days = 2 days for all tours 1-50

-- TOUR 51: total_Days = 2 days for tour 51, and tour 51 has MULTIPLE start date, finish date

-- total_Days = 1 day for on demand tours 52,53,54,55 
-- On Demand tours are tours 52,53,54,55 (i.e. on_Demand = 1)

-- Tour(tour_ID, tour_Name, tour_Desc, price, total_Days, on_Demand, currency, operator_ID, points, levels)	
	
INSERT INTO Tour VALUES (
	0001, 'Europe Adventure', 'Trek the Alps from France to Italy, France, UK, and Russia; cross glaciers and pine forests, visit remote villages and mountain refuges before finishing your days with local cuisine and wines.',
	1269.55, 2, 0,'USD',1, 'erknGsgm`A}jaSlg{fAiofi@|sxJx`vKm|moAel`V_op{N', 'BBBBB'
);
INSERT INTO Tour VALUES (
	0002, 'Asia Trekking', 'Follow in the steps of the Incas on this trip to the "must-see" highlight of Asia - from China to Thailand! This tour is spectacular and the first glimpse of Asia will leave memories.',
	1289.75, 2, 0,'USD',1, 'qmutCovjmGvrxJqmquE_entA_pihCnofeCoihC', 'BBBB'
);
INSERT INTO Tour VALUES (
	0003, 'Trekking Mont Blanc', 'Trek the Alps from France to Italy and Switzerland; cross glaciers and pine forests, visit remote villages and mountain refuges before finishing your days with local cuisine and wines.',
	1399.35, 2, 0,'AUD',1, 's{tvFufl}Aqi{g@|{p_B', 'BB'
);
INSERT INTO Tour VALUES (
	0004, 'Himalaya Mountain Trekking', 'Love to hike? Then this 8-day active adventure in Nepal is for you! Enjoy mountain treks offering magnificent views, encounters with Berber villagers and the opportunity to explore bustling Marrakech.',
	1679.95, 2, 0,'AUD',1, 'o}dhHcnhuOxnfi@cfvpBinwW{f~vAny_{A~pchB', 'BBBB'
);
INSERT INTO Tour VALUES (
	0005, 'Sicilian Volcano Trail', 'Exhilarating hiking on the edge! A week of unforgettable hikes over three active volcanoes: Vulcano; Stromboli, one of the most active volcanoes in the world; and mighty Etna, Europe highest active volcano.',
	1899.95, 2, 0,'AUD',1, '{zqrFsrst@wibf@ftcA|on@aswg@', 'BBB'
);
INSERT INTO Tour VALUES (
	0006, 'Nomadic Mongolia', 'An incredible journey to the land of blue skies, green hills and nomadic people. Get out and explore the city of Ulaan Baatar and lush green countryside, which is dotted with ancient monasteries.',
	2099.95, 2, 0,'AUD',1, 'o}dhHcnhuOi`fCgroaAdyxA}gxv@eyxAmra{@', 'BBBB'
);
INSERT INTO Tour VALUES (
	0007, 'Thailand Sailing Adventure', 'Island hop in Southern Thailand to some of the best snorkeling and diving locations in the world. Enjoy a week aboard a sailing catamaran, while swimming in deserted waters among turtles.',
	1899.95, 2, 0,'AUD',1, 'bCcmnuPmzuRwh', 'BBBB'
);
INSERT INTO Tour VALUES (
	0008, 'Roam India', 'India is home to great food, fascinating culture, alluring sights and friendly and inviting people. Discover the charms and mystery that makes up this incredible country.',
	1999.95, 2, 0,'AUD',1, '_d{jCsqzgLaqbk@ms{Z`acLyren@~n~]os{Z', 'BBBB'
);
INSERT INTO Tour VALUES (
	0009, 'China Hike, Bike & Raft', 'From rural roads through endless rice fields in southern China to the bustling streets of Beijing, over the Great Wall of China and down the Li River, see China in a unique way!',
	1599.95, 2, 0,'EUR',1, '_{xaFsespMm~gi@chjp@xuvNogtcAjezCufl}Acucd@ugf}@|pnL}gxv@', 'BBBBBB'
);
INSERT INTO Tour VALUES (
	0010, 'Trekking Alpen', 'Trek the Alps from France to Italy and Switzerland; cross glaciers and pine forests, visit remote villages and mountain refuges before finishing your days with local cuisine and wines.',
	1399.35, 2, 0,'AUD',1, 's{tvFufl}Aqi{g@|{p_B', 'BB'
);
INSERT INTO Tour VALUES (
	0011, 'The Old Woods', 'Trek the Alps from France to Italy, France, UK, and Russia; cross glaciers and pine forests, visit remote villages and mountain refuges before finishing your days with local cuisine and wines.',
	1269.55, 2, 0,'USD',1, 'erknGsgm`A}jaSlg{fAiofi@|sxJx`vKm|moAel`V_op{N', 'BBBBB'
);
INSERT INTO Tour VALUES (
	0012, 'Asia Magic', 'Follow in the steps of the Incas on this trip to the "must-see" highlight of Asia - from China to Thailand! This tour is spectacular and the first glimpse of Asia will leave memories.',
	1289.75, 2, 0,'USD',1, 'qmutCovjmGvrxJqmquE_entA_pihCnofeCoihC', 'BBBB'
);
INSERT INTO Tour VALUES (
	0013, 'More Winter Walks', 'Trek the Alps from France to Italy and Switzerland; cross glaciers and pine forests, visit remote villages and mountain refuges before finishing your days with local cuisine and wines.',
	1399.35, 2, 0,'AUD',1, 's{tvFufl}Aqi{g@|{p_B', 'BB'
);
INSERT INTO Tour VALUES (
	0014, 'Trek Himalaya', 'Love to hike? Then this 8-day active adventure in Nepal is for you! Enjoy mountain treks offering magnificent views, encounters with Berber villagers and the opportunity to explore bustling Marrakech.',
	1679.95, 2, 0,'AUD',1, 'o}dhHcnhuOxnfi@cfvpBinwW{f~vAny_{A~pchB', 'BBBB'
);
INSERT INTO Tour VALUES (
	0015, 'Volcano Sicily', 'Exhilarating hiking on the edge! A week of unforgettable hikes over three active volcanoes: Vulcano; Stromboli, one of the most active volcanoes in the world; and mighty Etna, Europe highest active volcano.',
	1899.95, 2, 0,'AUD',1, '{zqrFsrst@wibf@ftcA|on@aswg@', 'BBB'
);
INSERT INTO Tour VALUES (
	0016, 'Mongolian Lamb', 'An incredible journey to the land of blue skies, green hills and nomadic people. Get out and explore the city of Ulaan Baatar and lush green countryside, which is dotted with ancient monasteries.',
	2099.95, 2, 0,'AUD',1, 'o}dhHcnhuOi`fCgroaAdyxA}gxv@eyxAmra{@', 'BBBB'
);
INSERT INTO Tour VALUES (
	0017, 'Adventure Thailand', 'Island hop in Southern Thailand to some of the best snorkeling and diving locations in the world. Enjoy a week aboard a sailing catamaran, while swimming in deserted waters among turtles.',
	1899.95, 2, 0,'AUD',1, 'bCcmnuPmzuRwh', 'BBBB'
);
INSERT INTO Tour VALUES (
	0018, 'Good India', 'India is home to great food, fascinating culture, alluring sights and friendly and inviting people. Discover the charms and mystery that makes up this incredible country.',
	1999.95, 2, 0,'AUD',1, '_d{jCsqzgLaqbk@ms{Z`acLyren@~n~]os{Z', 'BBBB'
);
INSERT INTO Tour VALUES (
	0019, 'Hike China, Bike & Raft', 'From rural roads through endless rice fields in southern China to the bustling streets of Beijing, over the Great Wall of China and down the Li River, see China in a unique way!',
	1599.95, 2, 0,'EUR',1, '_{xaFsespMm~gi@chjp@xuvNogtcAjezCufl}Acucd@ugf}@|pnL}gxv@', 'BBBBBB'
);
INSERT INTO Tour VALUES (
	0020, 'Alps Trek', 'Trek the Alps from France to Italy and Switzerland; cross glaciers and pine forests, visit remote villages and mountain refuges before finishing your days with local cuisine and wines.',
	1399.35, 2, 0,'AUD',1, 's{tvFufl}Aqi{g@|{p_B', 'BB'
);
INSERT INTO Tour VALUES (
	0021, 'Here Be Europe', 'Trek the Alps from France to Italy, France, UK, and Russia; cross glaciers and pine forests, visit remote villages and mountain refuges before finishing your days with local cuisine and wines.',
	1269.55, 2, 0,'USD',1, 'erknGsgm`A}jaSlg{fAiofi@|sxJx`vKm|moAel`V_op{N', 'BBBBB'
);
INSERT INTO Tour VALUES (
	0022, 'Asia Adventure', 'Follow in the steps of the Incas on this trip to the "must-see" highlight of Asia - from China to Thailand! This tour is spectacular and the first glimpse of Asia will leave memories.',
	1289.75, 2, 0,'USD',1, 'qmutCovjmGvrxJqmquE_entA_pihCnofeCoihC', 'BBBB'
);
INSERT INTO Tour VALUES (
	0023, 'Silent Night', 'Trek the Alps from France to Italy and Switzerland; cross glaciers and pine forests, visit remote villages and mountain refuges before finishing your days with local cuisine and wines.',
	1399.35, 2, 0,'AUD',1, 's{tvFufl}Aqi{g@|{p_B', 'BB'
);
INSERT INTO Tour VALUES (
	0024, 'Go Himalayas', 'Love to hike? Then this 8-day active adventure in Nepal is for you! Enjoy mountain treks offering magnificent views, encounters with Berber villagers and the opportunity to explore bustling Marrakech.',
	1679.95, 2, 0,'AUD',1, 'o}dhHcnhuOxnfi@cfvpBinwW{f~vAny_{A~pchB', 'BBBB'
);
INSERT INTO Tour VALUES (
	0025, 'Trail Volcano', 'Exhilarating hiking on the edge! A week of unforgettable hikes over three active volcanoes: Vulcano; Stromboli, one of the most active volcanoes in the world; and mighty Etna, Europe highest active volcano.',
	1899.95, 2, 0,'AUD',1, '{zqrFsrst@wibf@ftcA|on@aswg@', 'BBB'
);
INSERT INTO Tour VALUES (
	0026, 'I Love Mongolia', 'An incredible journey to the land of blue skies, green hills and nomadic people. Get out and explore the city of Ulaan Baatar and lush green countryside, which is dotted with ancient monasteries.',
	2099.95, 2, 0,'AUD',1, 'o}dhHcnhuOi`fCgroaAdyxA}gxv@eyxAmra{@', 'BBBB'
);
INSERT INTO Tour VALUES (
	0027, 'Sail Thailand', 'Island hop in Southern Thailand to some of the best snorkeling and diving locations in the world. Enjoy a week aboard a sailing catamaran, while swimming in deserted waters among turtles.',
	1899.95, 2, 0,'AUD',1, 'bCcmnuPmzuRwh', 'BBBB'
);
INSERT INTO Tour VALUES (
	0028, 'Here Be India', 'India is home to great food, fascinating culture, alluring sights and friendly and inviting people. Discover the charms and mystery that makes up this incredible country.',
	1999.95, 2, 0,'AUD',1, '_d{jCsqzgLaqbk@ms{Z`acLyren@~n~]os{Z', 'BBBB'
);
INSERT INTO Tour VALUES (
	0029, 'Beautiful China, Bike & Raft', 'From rural roads through endless rice fields in southern China to the bustling streets of Beijing, over the Great Wall of China and down the Li River, see China in a unique way!',
	1599.95, 2, 0,'EUR',1, '_{xaFsespMm~gi@chjp@xuvNogtcAjezCufl}Acucd@ugf}@|pnL}gxv@', 'BBBBBB'
);
INSERT INTO Tour VALUES (
	0030, 'Winter Wonderland', 'Trek the Alps from France to Italy and Switzerland; cross glaciers and pine forests, visit remote villages and mountain refuges before finishing your days with local cuisine and wines.',
	1399.35, 2, 0,'AUD',1, 's{tvFufl}Aqi{g@|{p_B', 'BB'
);
INSERT INTO Tour VALUES (
	0031, 'Give Me Europe', 'Trek the Alps from France to Italy, France, UK, and Russia; cross glaciers and pine forests, visit remote villages and mountain refuges before finishing your days with local cuisine and wines.',
	1269.55, 2, 0,'USD',2, 'erknGsgm`A}jaSlg{fAiofi@|sxJx`vKm|moAel`V_op{N', 'BBBBB'
);
INSERT INTO Tour VALUES (
	0032, 'Trek Asia', 'Follow in the steps of the Incas on this trip to the "must-see" highlight of Asia - from China to Thailand! This tour is spectacular and the first glimpse of Asia will leave memories.',
	1289.75, 2, 0,'USD',2, 'qmutCovjmGvrxJqmquE_entA_pihCnofeCoihC', 'BBBB'
);
INSERT INTO Tour VALUES (
	0033, 'Stille Nacht', 'Trek the Alps from France to Italy and Switzerland; cross glaciers and pine forests, visit remote villages and mountain refuges before finishing your days with local cuisine and wines.',
	1399.35, 2, 0,'AUD',2, 's{tvFufl}Aqi{g@|{p_B', 'BB'
);
INSERT INTO Tour VALUES (
	0034, 'I Love the Himalayas', 'Love to hike? Then this 8-day active adventure in Nepal is for you! Enjoy mountain treks offering magnificent views, encounters with Berber villagers and the opportunity to explore bustling Marrakech.',
	1679.95, 2, 0,'AUD',2, 'o}dhHcnhuOxnfi@cfvpBinwW{f~vAny_{A~pchB', 'BBBB'
);
INSERT INTO Tour VALUES (
	0035, 'Blow Up Sicily', 'Exhilarating hiking on the edge! A week of unforgettable hikes over three active volcanoes: Vulcano; Stromboli, one of the most active volcanoes in the world; and mighty Etna, Europe highest active volcano.',
	1899.95, 2, 0,'AUD',2, '{zqrFsrst@wibf@ftcA|on@aswg@', 'BBB'
);
INSERT INTO Tour VALUES (
	0036, 'Where is Mongolia', 'An incredible journey to the land of blue skies, green hills and nomadic people. Get out and explore the city of Ulaan Baatar and lush green countryside, which is dotted with ancient monasteries.',
	2099.95, 2, 0,'AUD',3, 'o}dhHcnhuOi`fCgroaAdyxA}gxv@eyxAmra{@', 'BBBB'
);
INSERT INTO Tour VALUES (
	0037, 'Thai Boats', 'Island hop in Southern Thailand to some of the best snorkeling and diving locations in the world. Enjoy a week aboard a sailing catamaran, while swimming in deserted waters among turtles.',
	1899.95, 2, 0,'AUD',3, 'bCcmnuPmzuRwh', 'BBBB'
);
INSERT INTO Tour VALUES (
	0038, 'Indian Fun', 'India is home to great food, fascinating culture, alluring sights and friendly and inviting people. Discover the charms and mystery that makes up this incredible country.',
	1999.95, 2, 0,'AUD',3, '_d{jCsqzgLaqbk@ms{Z`acLyren@~n~]os{Z', 'BBBB'
);
INSERT INTO Tour VALUES (
	0039, 'Northern China, Bike & Raft', 'From rural roads through endless rice fields in southern China to the bustling streets of Beijing, over the Great Wall of China and down the Li River, see China in a unique way!',
	1599.95, 2, 0,'EUR',3, '_{xaFsespMm~gi@chjp@xuvNogtcAjezCufl}Acucd@ugf}@|pnL}gxv@', 'BBBBBB'
);
INSERT INTO Tour VALUES (
	0040, 'My Winter', 'Trek the Alps from France to Italy and Switzerland; cross glaciers and pine forests, visit remote villages and mountain refuges before finishing your days with local cuisine and wines.',
	1399.35, 2, 0,'AUD',3, 's{tvFufl}Aqi{g@|{p_B', 'BB'
);
INSERT INTO Tour VALUES (
	0041, 'Europe Je Taime', 'Trek the Alps from France to Italy, France, UK, and Russia; cross glaciers and pine forests, visit remote villages and mountain refuges before finishing your days with local cuisine and wines.',
	1269.55, 2, 0,'USD',4, 'erknGsgm`A}jaSlg{fAiofi@|sxJx`vKm|moAel`V_op{N', 'BBBBB'
);
INSERT INTO Tour VALUES (
	0042, 'Beautiful Asia', 'Follow in the steps of the Incas on this trip to the "must-see" highlight of Asia - from China to Thailand! This tour is spectacular and the first glimpse of Asia will leave memories.',
	1289.75, 2, 0,'USD',4, 'qmutCovjmGvrxJqmquE_entA_pihCnofeCoihC', 'BBBB'
);
INSERT INTO Tour VALUES (
	0043, 'Trekking Mont Blanc', 'Trek the Alps from France to Italy and Switzerland; cross glaciers and pine forests, visit remote villages and mountain refuges before finishing your days with local cuisine and wines.',
	1399.35, 2, 0,'AUD',4, 's{tvFufl}Aqi{g@|{p_B', 'BB'
);
INSERT INTO Tour VALUES (
	0044, 'Sherpa Chicken', 'Love to hike? Then this 8-day active adventure in Nepal is for you! Enjoy mountain treks offering magnificent views, encounters with Berber villagers and the opportunity to explore bustling Marrakech.',
	1679.95, 2, 0,'AUD',4, 'o}dhHcnhuOxnfi@cfvpBinwW{f~vAny_{A~pchB', 'BBBB'
);
INSERT INTO Tour VALUES (
	0045, 'Sicily, Te Amo', 'Exhilarating hiking on the edge! A week of unforgettable hikes over three active volcanoes: Vulcano; Stromboli, one of the most active volcanoes in the world; and mighty Etna, Europe highest active volcano.',
	1899.95, 2, 0,'AUD',4, '{zqrFsrst@wibf@ftcA|on@aswg@', 'BBB'
);
INSERT INTO Tour VALUES (
	0046, 'Finding Mongolia', 'An incredible journey to the land of blue skies, green hills and nomadic people. Get out and explore the city of Ulaan Baatar and lush green countryside, which is dotted with ancient monasteries.',
	2099.95, 2, 0,'AUD',5, 'o}dhHcnhuOi`fCgroaAdyxA}gxv@eyxAmra{@', 'BBBB'
);
INSERT INTO Tour VALUES (
	0047, 'Boating Thai', 'Island hop in Southern Thailand to some of the best snorkeling and diving locations in the world. Enjoy a week aboard a sailing catamaran, while swimming in deserted waters among turtles.',
	1899.95, 2, 0,'AUD',5, 'bCcmnuPmzuRwh', 'BBBB'
);
INSERT INTO Tour VALUES (
	0048, 'Indiana Jones', 'India is home to great food, fascinating culture, alluring sights and friendly and inviting people. Discover the charms and mystery that makes up this incredible country.',
	1999.95, 2, 0,'AUD',5, '_d{jCsqzgLaqbk@ms{Z`acLyren@~n~]os{Z', 'BBBB'
);
INSERT INTO Tour VALUES (
	0049, 'Bike Asia, Bike & Raft', 'From rural roads through endless rice fields in southern China to the bustling streets of Beijing, over the Great Wall of China and down the Li River, see China in a unique way!',
	1599.95, 2, 0,'EUR',5, '_{xaFsespMm~gi@chjp@xuvNogtcAjezCufl}Acucd@ugf}@|pnL}gxv@', 'BBBBBB'
);
INSERT INTO Tour VALUES (
	0050, 'Alpine Adventure', 'Trek the Alps from France to Italy and Switzerland; cross glaciers and pine forests, visit remote villages and mountain refuges before finishing your days with local cuisine and wines.',
	1399.35, 2, 0,'AUD',5, 's{tvFufl}Aqi{g@|{p_B', 'BB'
);
-- Tour 51 is NOT on demand (i.e. on_Demand = 0), it has MULTIPLE start date, finish date

INSERT INTO Tour VALUES (
	0051, 'China Hike, Bike & Raft', 'From rural roads through endless rice fields in southern China to the bustling streets of Beijing, over the Great Wall of China and down the Li River, see China in a unique way!',
	1599.95, 2, 0,'EUR',6, '_{xaFsespMm~gi@chjp@xuvNogtcAjezCufl}Acucd@ugf}@|pnL}gxv@', 'BBBBBB'
);

-- On demand tours 52,53,54,55 (i.e. on_Demand = 1 hence NO tourDate)
-- Tour(tour_ID, tour_Name, tour_Desc, price, total_Days, on_Demand, currency, operator_ID, points, levels)

INSERT INTO Tour VALUES (
	0052, 'Europe Adventure', 'Trek the Alps from France to Italy, France, UK, and Russia; cross glaciers and pine forests, visit remote villages and mountain refuges before finishing your days with local cuisine and wines.',
	1269.55, 2, 0,'USD',7, 'erknGsgm`A}jaSlg{fAiofi@|sxJx`vKm|moAel`V_op{N', 'BBBBB'
);
INSERT INTO Tour VALUES (
	0053, 'Asia Trekking', 'Follow in the steps of the Incas on this trip to the "must-see" highlight of Asia - from China to Thailand! This tour is spectacular and the first glimpse of Asia will leave memories.',
	1289.75, 2, 0,'USD',8, 'qmutCovjmGvrxJqmquE_entA_pihCnofeCoihC', 'BBBB'
);
INSERT INTO Tour VALUES (
	0054, 'Trekking Mont Blanc', 'Trek the Alps from France to Italy and Switzerland; cross glaciers and pine forests, visit remote villages and mountain refuges before finishing your days with local cuisine and wines.',
	1399.35, 2, 0,'AUD',9, 's{tvFufl}Aqi{g@|{p_B', 'BB'
);
INSERT INTO Tour VALUES (
	0055, 'Deepaks Fun', 'Love to hike? Then this 8-day active adventure in Nepal is for you! Enjoy mountain treks offering magnificent views, encounters with Berber villagers and the opportunity to explore bustling Marrakech.',
	1679.95, 2, 0,'AUD',10, 'o}dhHcnhuOxnfi@cfvpBinwW{f~vAny_{A~pchB', 'BBBB'
);




-- ListedTour -----------------------------------------------------------------------

-- First 30 listed tours (i.e. tours 1-30) for Operator 1, 
-- Then 5 listed tours (i.e. tours 31-35, 36-40, 41-45, 46-50) for each of Operator 2,3,4,5, 
-- And 1 listed tour (i.e. tours 51,52,53,54,55) for each of Operator 6,7,8,9,10

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
	0006, 0001, 0006, TO_DATE('12052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0007, 0001, 0007, TO_DATE('12052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0008, 0001, 0008, TO_DATE('12052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0009, 0001, 0009, TO_DATE('20052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0010, 0001, 0010, TO_DATE('12062010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0011, 0001, 0011, TO_DATE('12082010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0012, 0001, 0012, TO_DATE('12052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0013, 0001, 0013, TO_DATE('12062010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0014, 0001, 0014, TO_DATE('12052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0015, 0001, 0015, TO_DATE('12062010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0016, 0001, 0016, TO_DATE('13022010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0017, 0001, 0017, TO_DATE('14012010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0018, 0001, 0018, TO_DATE('14062010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0019, 0001, 0019, TO_DATE('14052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0020, 0001, 0020, TO_DATE('12052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0021, 0001, 0021, TO_DATE('12052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0022, 0001, 0022, TO_DATE('12052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0023, 0001, 0023, TO_DATE('12062010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0024, 0001, 0024, TO_DATE('13022010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0025, 0001, 0025, TO_DATE('14012010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0026, 0001, 0026, TO_DATE('14062010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0027, 0001, 0027, TO_DATE('14052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0028, 0001, 0028, TO_DATE('12052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0029, 0001, 0029, TO_DATE('12052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0030, 0001, 0030, TO_DATE('12052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0031, 0002, 0031, TO_DATE('12062010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0032, 0002, 0032, TO_DATE('13022010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0033, 0002, 0033, TO_DATE('14012010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0034, 0002, 0034, TO_DATE('14062010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0035, 0002, 0035, TO_DATE('14052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0036, 0003, 0036, TO_DATE('12062010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0037, 0003, 0037, TO_DATE('13022010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0038, 0003, 0038, TO_DATE('14012010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0039, 0003, 0039, TO_DATE('14062010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0040, 0003, 0040, TO_DATE('14052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0041, 0004, 0041, TO_DATE('14052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0042, 0004, 0042, TO_DATE('14052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0043, 0004, 0043, TO_DATE('14052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0044, 0004, 0044, TO_DATE('14052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0045, 0004, 0045, TO_DATE('14052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0046, 0005, 0046, TO_DATE('14052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0047, 0005, 0047, TO_DATE('14052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0048, 0005, 0048, TO_DATE('14052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0049, 0005, 0049, TO_DATE('14052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0050, 0005, 0050, TO_DATE('14052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0051, 0006, 0051, TO_DATE('14052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0052, 0007, 0052, TO_DATE('14052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0053, 0008, 0053, TO_DATE('14052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0054, 0009, 0054, TO_DATE('14052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0055, 0010, 0055, TO_DATE('14052010', 'DDMMYYYY'), TO_DATE('31122010', 'DDMMYYYY')  
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





-- TourActivity ----------------------------------------------------------------

-- Activity 'HIKING' linked to Tour 1-50
-- Multiple activities 'CYCLING','SAILING','DIVING' linked to Tour 51-55 

-- TourActivity(activity_ID, tour_ID)

INSERT INTO TourActivity VALUES (0001, 0001);
INSERT INTO TourActivity VALUES (0001, 0002);
INSERT INTO TourActivity VALUES (0001, 0003);
INSERT INTO TourActivity VALUES (0001, 0004);
INSERT INTO TourActivity VALUES (0001, 0005);
INSERT INTO TourActivity VALUES (0001, 0006);
INSERT INTO TourActivity VALUES (0001, 0007);
INSERT INTO TourActivity VALUES (0001, 0008);
INSERT INTO TourActivity VALUES (0001, 0009);
INSERT INTO TourActivity VALUES (0001, 0010);
INSERT INTO TourActivity VALUES (0001, 0011);
INSERT INTO TourActivity VALUES (0001, 0012);
INSERT INTO TourActivity VALUES (0001, 0013);
INSERT INTO TourActivity VALUES (0001, 0014);
INSERT INTO TourActivity VALUES (0001, 0015);
INSERT INTO TourActivity VALUES (0001, 0016);
INSERT INTO TourActivity VALUES (0001, 0017);
INSERT INTO TourActivity VALUES (0001, 0018);
INSERT INTO TourActivity VALUES (0001, 0019);
INSERT INTO TourActivity VALUES (0001, 0020);
INSERT INTO TourActivity VALUES (0001, 0021);
INSERT INTO TourActivity VALUES (0001, 0022);
INSERT INTO TourActivity VALUES (0001, 0023);
INSERT INTO TourActivity VALUES (0001, 0024);
INSERT INTO TourActivity VALUES (0001, 0025);
INSERT INTO TourActivity VALUES (0001, 0026);
INSERT INTO TourActivity VALUES (0001, 0027);
INSERT INTO TourActivity VALUES (0001, 0028);
INSERT INTO TourActivity VALUES (0001, 0029);
INSERT INTO TourActivity VALUES (0001, 0030);
INSERT INTO TourActivity VALUES (0001, 0031);
INSERT INTO TourActivity VALUES (0001, 0032);
INSERT INTO TourActivity VALUES (0001, 0033);
INSERT INTO TourActivity VALUES (0001, 0034);
INSERT INTO TourActivity VALUES (0001, 0035);
INSERT INTO TourActivity VALUES (0001, 0036);
INSERT INTO TourActivity VALUES (0001, 0037);
INSERT INTO TourActivity VALUES (0001, 0038);
INSERT INTO TourActivity VALUES (0001, 0039);
INSERT INTO TourActivity VALUES (0001, 0040);
INSERT INTO TourActivity VALUES (0001, 0041);
INSERT INTO TourActivity VALUES (0001, 0042);
INSERT INTO TourActivity VALUES (0001, 0043);
INSERT INTO TourActivity VALUES (0001, 0044);
INSERT INTO TourActivity VALUES (0001, 0045);
INSERT INTO TourActivity VALUES (0001, 0046);
INSERT INTO TourActivity VALUES (0001, 0047);
INSERT INTO TourActivity VALUES (0001, 0048);
INSERT INTO TourActivity VALUES (0001, 0049);
INSERT INTO TourActivity VALUES (0001, 0050);

INSERT INTO TourActivity VALUES (0002, 0051);
INSERT INTO TourActivity VALUES (0002, 0052);
INSERT INTO TourActivity VALUES (0002, 0053);
INSERT INTO TourActivity VALUES (0002, 0054);
INSERT INTO TourActivity VALUES (0002, 0055);
INSERT INTO TourActivity VALUES (0003, 0051);
INSERT INTO TourActivity VALUES (0003, 0052);
INSERT INTO TourActivity VALUES (0003, 0053);
INSERT INTO TourActivity VALUES (0003, 0054);
INSERT INTO TourActivity VALUES (0003, 0055);
INSERT INTO TourActivity VALUES (0004, 0051);
INSERT INTO TourActivity VALUES (0004, 0052);
INSERT INTO TourActivity VALUES (0004, 0053);
INSERT INTO TourActivity VALUES (0004, 0054);
INSERT INTO TourActivity VALUES (0004, 0055);





-- Location -----------------------------------------------------------------------

-- Location 'UK' linked to Tour 1,11,21,31,41
-- Location 'SAUDI ARABIA' linked to Tour 2,12,22,32,42
-- Location 'FRANCE' linked to Tour 3,13,23,33,43
-- Location 'NEPAL' linked to Tour 4,14,24,34,44
-- Location 'ITALY' linked to Tour 5,15,25,35,45
-- Location 'CHINA' linked to Tour 6,16,26,36,46
-- Location 'THAILAND' linked to Tour 7,17,27,37,47
-- Location 'INDIA' linked to Tour 8,18,28,38,48
-- Location 'CHINA' linked to Tour 9,19,29,39,49
-- Location 'ITALY' linked to Tour 10,20,30,40,50

-- Multiple locations 'NEPAL','CHINA' linked to Tour 51
-- Multiple locations 'UK','ITALY','FRANCE','DENMARK','RUSSIA' linked to Tour 52
-- Multiple locations 'SAUDI ARABIA','INDIA','CHINA','THAILAND' linked to Tour 53
-- Multiple locations 'ITALY','FRANCE' linked to Tour 54
-- Multiple locations 'NEPAL','CHINA' linked to Tour 55

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

-- Location 'UK' linked to Tour 1,11,21,31,41
-- Location 'SAUDI ARABIA' linked to Tour 2,12,22,32,42
-- Location 'FRANCE' linked to Tour 3,13,23,33,43
-- Location 'NEPAL' linked to Tour 4,14,24,34,44
-- Location 'ITALY' linked to Tour 5,15,25,35,45
-- Location 'CHINA' linked to Tour 6,16,26,36,46
-- Location 'THAILAND' linked to Tour 7,17,27,37,47
-- Location 'INDIA' linked to Tour 8,18,28,38,48
-- Location 'CHINA' linked to Tour 9,19,29,39,49
-- Location 'ITALY' linked to Tour 10,20,30,40,50

-- Multiple locations 'NEPAL','CHINA' linked to Tour 51
-- Multiple locations 'UK','ITALY','FRANCE','DENMARK','RUSSIA' linked to Tour 52
-- Multiple locations 'SAUDI ARABIA','INDIA','CHINA','THAILAND' linked to Tour 53
-- Multiple locations 'ITALY','FRANCE' linked to Tour 54
-- Multiple locations 'NEPAL','CHINA' linked to Tour 55

-- TourLocation(location_ID, tour_ID)

INSERT INTO TourLocation VALUES (0001, 0001);
INSERT INTO TourLocation VALUES (0006, 0002);
INSERT INTO TourLocation VALUES (0002, 0003);
INSERT INTO TourLocation VALUES (0010, 0004);
INSERT INTO TourLocation VALUES (0003, 0005);
INSERT INTO TourLocation VALUES (0008, 0006);
INSERT INTO TourLocation VALUES (0009, 0007);
INSERT INTO TourLocation VALUES (0007, 0008);
INSERT INTO TourLocation VALUES (0008, 0009);
INSERT INTO TourLocation VALUES (0003, 0010);

INSERT INTO TourLocation VALUES (0001, 0011);
INSERT INTO TourLocation VALUES (0006, 0012);
INSERT INTO TourLocation VALUES (0002, 0013);
INSERT INTO TourLocation VALUES (0010, 0014);
INSERT INTO TourLocation VALUES (0003, 0015);
INSERT INTO TourLocation VALUES (0008, 0016);
INSERT INTO TourLocation VALUES (0009, 0017);
INSERT INTO TourLocation VALUES (0007, 0018);
INSERT INTO TourLocation VALUES (0008, 0019);
INSERT INTO TourLocation VALUES (0003, 0020);

INSERT INTO TourLocation VALUES (0001, 0021);
INSERT INTO TourLocation VALUES (0006, 0022);
INSERT INTO TourLocation VALUES (0002, 0023);
INSERT INTO TourLocation VALUES (0010, 0024);
INSERT INTO TourLocation VALUES (0003, 0025);
INSERT INTO TourLocation VALUES (0008, 0026);
INSERT INTO TourLocation VALUES (0009, 0027);
INSERT INTO TourLocation VALUES (0007, 0028);
INSERT INTO TourLocation VALUES (0008, 0029);
INSERT INTO TourLocation VALUES (0003, 0030);

INSERT INTO TourLocation VALUES (0001, 0031);
INSERT INTO TourLocation VALUES (0006, 0032);
INSERT INTO TourLocation VALUES (0002, 0033);
INSERT INTO TourLocation VALUES (0010, 0034);
INSERT INTO TourLocation VALUES (0003, 0035);
INSERT INTO TourLocation VALUES (0008, 0036);
INSERT INTO TourLocation VALUES (0009, 0037);
INSERT INTO TourLocation VALUES (0007, 0038);
INSERT INTO TourLocation VALUES (0008, 0039);
INSERT INTO TourLocation VALUES (0003, 0040);

INSERT INTO TourLocation VALUES (0001, 0041);
INSERT INTO TourLocation VALUES (0006, 0042);
INSERT INTO TourLocation VALUES (0002, 0043);
INSERT INTO TourLocation VALUES (0010, 0044);
INSERT INTO TourLocation VALUES (0003, 0045);
INSERT INTO TourLocation VALUES (0008, 0046);
INSERT INTO TourLocation VALUES (0009, 0047);
INSERT INTO TourLocation VALUES (0007, 0048);
INSERT INTO TourLocation VALUES (0008, 0049);
INSERT INTO TourLocation VALUES (0003, 0050);

INSERT INTO TourLocation VALUES (0008, 0051);
INSERT INTO TourLocation VALUES (0009, 0051);
INSERT INTO TourLocation VALUES (0001, 0052);
INSERT INTO TourLocation VALUES (0002, 0052);
INSERT INTO TourLocation VALUES (0003, 0052);
INSERT INTO TourLocation VALUES (0004, 0052);
INSERT INTO TourLocation VALUES (0005, 0052);
INSERT INTO TourLocation VALUES (0006, 0053);
INSERT INTO TourLocation VALUES (0007, 0053);
INSERT INTO TourLocation VALUES (0008, 0053);
INSERT INTO TourLocation VALUES (0009, 0053);
INSERT INTO TourLocation VALUES (0010, 0053);
INSERT INTO TourLocation VALUES (0002, 0054);
INSERT INTO TourLocation VALUES (0003, 0054);
INSERT INTO TourLocation VALUES (0008, 0055);
INSERT INTO TourLocation VALUES (0010, 0055);



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
INSERT INTO Image VALUES (0031, '3.jpg', 0031);
INSERT INTO Image VALUES (0032, '4.jpg', 0032);
INSERT INTO Image VALUES (0033, '3.jpg', 0033);
INSERT INTO Image VALUES (0034, '4.jpg', 0034);
INSERT INTO Image VALUES (0035, '1.jpg', 0035);
INSERT INTO Image VALUES (0036, '2.jpg', 0036);
INSERT INTO Image VALUES (0037, '3.jpg', 0037);
INSERT INTO Image VALUES (0038, '4.jpg', 0038);
INSERT INTO Image VALUES (0039, '1.jpg', 0039);
INSERT INTO Image VALUES (0040, '2.jpg', 0040);
INSERT INTO Image VALUES (0041, '3.jpg', 0041);
INSERT INTO Image VALUES (0042, '4.jpg', 0042);
INSERT INTO Image VALUES (0043, '1.jpg', 0043);
INSERT INTO Image VALUES (0044, '2.jpg', 0044);
INSERT INTO Image VALUES (0045, '3.jpg', 0045);
INSERT INTO Image VALUES (0046, '4.jpg', 0046);
INSERT INTO Image VALUES (0047, '1.jpg', 0047);
INSERT INTO Image VALUES (0048, '2.jpg', 0048);
INSERT INTO Image VALUES (0049, '3.jpg', 0049);
INSERT INTO Image VALUES (0050, '4.jpg', 0050);
INSERT INTO Image VALUES (0051, '1.jpg', 0051);
INSERT INTO Image VALUES (0052, '2.jpg', 0052);
INSERT INTO Image VALUES (0053, '3.jpg', 0053);
INSERT INTO Image VALUES (0054, '4.jpg', 0054);
INSERT INTO Image VALUES (0055, '1.jpg', 0055);




-- TourDate --------------------------------------------------------------------

-- all dates between 1 Jun 2010 - 31 Dec 2010
-- total_Days = 2 days for all tours 1-50

-- TOUR 51: total_Days = 2 days for tour 51, and tour 51 has MULTIPLE start date, finish date 

-- total_Days = 1 day for on demand tours 52,53,54,55 

-- TourDate(date_ID, tour_ID, start_Date, finish_Date)

INSERT INTO TourDate VALUES (
	0001, 0001, TO_DATE('01/06/2010', 'DD/MM/YYYY'), TO_DATE('03/06/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0002, 0002, TO_DATE('01/06/2010', 'DD/MM/YYYY'), TO_DATE('03/06/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0003, 0003, TO_DATE('01/06/2010', 'DD/MM/YYYY'), TO_DATE('03/06/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0004, 0004, TO_DATE('01/06/2010', 'DD/MM/YYYY'), TO_DATE('03/06/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0005, 0005, TO_DATE('01/06/2010', 'DD/MM/YYYY'), TO_DATE('03/06/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0006, 0006, TO_DATE('01/06/2010', 'DD/MM/YYYY'), TO_DATE('03/06/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0007, 0007, TO_DATE('01/06/2010', 'DD/MM/YYYY'), TO_DATE('03/06/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0008, 0008, TO_DATE('01/06/2010', 'DD/MM/YYYY'), TO_DATE('03/06/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0009, 0009, TO_DATE('01/06/2010', 'DD/MM/YYYY'), TO_DATE('03/06/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0010, 0010, TO_DATE('05/07/2010', 'DD/MM/YYYY'), TO_DATE('07/07/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0011, 0011, TO_DATE('05/07/2010', 'DD/MM/YYYY'), TO_DATE('07/07/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0012, 0012, TO_DATE('05/07/2010', 'DD/MM/YYYY'), TO_DATE('07/07/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0013, 0013, TO_DATE('05/07/2010', 'DD/MM/YYYY'), TO_DATE('07/07/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0014, 0014, TO_DATE('05/07/2010', 'DD/MM/YYYY'), TO_DATE('07/07/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0015, 0015, TO_DATE('05/07/2010', 'DD/MM/YYYY'), TO_DATE('07/07/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0016, 0016, TO_DATE('05/07/2010', 'DD/MM/YYYY'), TO_DATE('07/07/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0017, 0017, TO_DATE('05/07/2010', 'DD/MM/YYYY'), TO_DATE('07/07/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0018, 0018, TO_DATE('05/07/2010', 'DD/MM/YYYY'), TO_DATE('07/07/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0019, 0019, TO_DATE('05/07/2010', 'DD/MM/YYYY'), TO_DATE('07/07/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0020, 0020, TO_DATE('05/07/2010', 'DD/MM/YYYY'), TO_DATE('07/07/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0021, 0021, TO_DATE('10/08/2010', 'DD/MM/YYYY'), TO_DATE('12/08/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0022, 0022, TO_DATE('10/08/2010', 'DD/MM/YYYY'), TO_DATE('12/08/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0023, 0023, TO_DATE('10/08/2010', 'DD/MM/YYYY'), TO_DATE('12/08/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0024, 0024, TO_DATE('10/08/2010', 'DD/MM/YYYY'), TO_DATE('12/08/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0025, 0025, TO_DATE('10/08/2010', 'DD/MM/YYYY'), TO_DATE('12/08/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0026, 0026, TO_DATE('10/08/2010', 'DD/MM/YYYY'), TO_DATE('12/08/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0027, 0027, TO_DATE('10/08/2010', 'DD/MM/YYYY'), TO_DATE('12/08/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0028, 0028, TO_DATE('10/08/2010', 'DD/MM/YYYY'), TO_DATE('12/08/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0029, 0029, TO_DATE('10/08/2010', 'DD/MM/YYYY'), TO_DATE('12/08/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0030, 0030, TO_DATE('10/08/2010', 'DD/MM/YYYY'), TO_DATE('12/08/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0031, 0031, TO_DATE('15/09/2010', 'DD/MM/YYYY'), TO_DATE('17/09/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0032, 0032, TO_DATE('15/09/2010', 'DD/MM/YYYY'), TO_DATE('17/09/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0033, 0033, TO_DATE('15/09/2010', 'DD/MM/YYYY'), TO_DATE('17/09/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0034, 0034, TO_DATE('15/09/2010', 'DD/MM/YYYY'), TO_DATE('17/09/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0035, 0035, TO_DATE('15/09/2010', 'DD/MM/YYYY'), TO_DATE('17/09/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0036, 0036, TO_DATE('15/09/2010', 'DD/MM/YYYY'), TO_DATE('17/09/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0037, 0037, TO_DATE('15/09/2010', 'DD/MM/YYYY'), TO_DATE('17/09/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0038, 0038, TO_DATE('15/09/2010', 'DD/MM/YYYY'), TO_DATE('17/09/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0039, 0039, TO_DATE('15/09/2010', 'DD/MM/YYYY'), TO_DATE('17/09/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0040, 0040, TO_DATE('15/09/2010', 'DD/MM/YYYY'), TO_DATE('17/09/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0041, 0041, TO_DATE('20/10/2010', 'DD/MM/YYYY'), TO_DATE('22/10/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0042, 0042, TO_DATE('20/10/2010', 'DD/MM/YYYY'), TO_DATE('22/10/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0043, 0043, TO_DATE('20/10/2010', 'DD/MM/YYYY'), TO_DATE('22/10/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0044, 0044, TO_DATE('20/10/2010', 'DD/MM/YYYY'), TO_DATE('22/10/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0045, 0045, TO_DATE('20/10/2010', 'DD/MM/YYYY'), TO_DATE('22/10/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0046, 0046, TO_DATE('20/10/2010', 'DD/MM/YYYY'), TO_DATE('22/10/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0047, 0047, TO_DATE('20/10/2010', 'DD/MM/YYYY'), TO_DATE('22/10/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0048, 0048, TO_DATE('20/10/2010', 'DD/MM/YYYY'), TO_DATE('22/10/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0049, 0049, TO_DATE('20/10/2010', 'DD/MM/YYYY'), TO_DATE('22/10/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0050, 0050, TO_DATE('20/10/2010', 'DD/MM/YYYY'), TO_DATE('22/10/2010', 'DD/MM/YYYY')  
);

-- TOUR 51: MULTIPLE start date, finish date; total_Days = 2 days for tour 51 
INSERT INTO TourDate VALUES (
	0051, 0051, TO_DATE('12/11/2010', 'DD/MM/YYYY'), TO_DATE('14/11/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0052, 0051, TO_DATE('20/11/2010', 'DD/MM/YYYY'), TO_DATE('22/11/2010', 'DD/MM/YYYY')  
);

-- NO start date, finish date; total_Days = 1 day for on demand tours 52,53,54,55

-- *** start date, finish date will be removed later *** 

INSERT INTO TourDate VALUES (
	0053, 0052, TO_DATE('25/12/2010', 'DD/MM/YYYY'), TO_DATE('26/12/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0054, 0053, TO_DATE('25/12/2010', 'DD/MM/YYYY'), TO_DATE('26/12/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0055, 0054, TO_DATE('25/12/2010', 'DD/MM/YYYY'), TO_DATE('26/12/2010', 'DD/MM/YYYY')  
);
INSERT INTO TourDate VALUES (
	0056, 0055, TO_DATE('25/12/2010', 'DD/MM/YYYY'), TO_DATE('26/12/2010', 'DD/MM/YYYY')  
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

