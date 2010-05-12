-- AccountUser -----------------------------------------------------------------

INSERT INTO AccountUser VALUES (
	0001, 'austravel', '7c6a180b36896a0a8c02787eeafb0e4c', 'operator'
);

INSERT INTO AccountUser VALUES (
	0002, 'ecotrans', '6cb75f652a9b52798eb6cf2201057c73', 'operator'
);

INSERT INTO AccountUser VALUES (
	0003, 'adventours', '7c6a180b36896a0a8c02787eeafb0e4c', 'operator'
);

INSERT INTO AccountUser VALUES (
	0004, 'travelscene', '7c6a180b36896a0a8c02787eeafb0e4c', 'operator'
);

INSERT INTO AccountUser VALUES (
	0005, 'ecotravel', '7c6a180b36896a0a8c02787eeafb0e4c', 'operator'
);

INSERT INTO AccountUser VALUES (
	0006, 'travelink', '6cb75f652a9b52798eb6cf2201057c73', 'operator'
);

INSERT INTO AccountUser VALUES (
	0007, 'scenictours', '6cb75f652a9b52798eb6cf2201057c73', 'operator'
);

INSERT INTO AccountUser VALUES (
	0008, 'travelous', '819b0643d6b89dc9b579fdfc9094f28e', 'operator'
);

INSERT INTO AccountUser VALUES (
	0009, 'travelocity', '6cb75f652a9b52798eb6cf2201057c73', 'operator'
);

INSERT INTO AccountUser VALUES (
	0010, 'safari.link', '819b0643d6b89dc9b579fdfc9094f28e', 'operator'
);

INSERT INTO AccountUser VALUES (
	0011, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin'
);

INSERT INTO AccountUser VALUES (
	0012, 'operator', '4b583376b2767b923c3e1da60d10de59', 'operator'
);
-- TourOperator ----------------------------------------------------------------
INSERT INTO TourOperator VALUES (
	0001, 'Austravel', 'Austravel is a leading travel centre representing Australia''s major tour operators. We offer a comprehensive travel planning and reservation service for all tours. Our product range includes eco tours, harbour cruises, and extended adventures', TO_DATE('13122020', 'DDMMYYYY'), 'austravel@gmail.com'  
);

INSERT INTO TourOperator VALUES (
	0002, 'Ecotrans', 'Ecotrans offers exhilarating outdoor adventures to Africa, Asia, Caribbean, Europe, Latin America, and the South Pacific. Whether it''s an eco adventure or a jungle safari, you can count on Ecotrans to make your travel dreams come true.', TO_DATE('14122020', 'DDMMYYYY'), 'ecotrans@yahoo.com' 
);

INSERT INTO TourOperator VALUES (
	0003, 'Adventours', 'Adventours is a long established specialist tour operator offering tailor-made adventure holidays to clients throughout the world.', TO_DATE('14122020', 'DDMMYYYY'), 'adventours@aol.com' 
);

INSERT INTO TourOperator VALUES (
	0004, 'Travelscene', 'Travelscene offers great service, great deals and the best prices on all types of travel products. Our product range includes eco tours, harbour cruises, accommodation packages, airfares, rail, coach, car hire & extended adventure.', TO_DATE('13122020', 'DDMMYYYY'), 'travel.scene@live.com'  
);

INSERT INTO TourOperator VALUES (
	0005, 'Ecotravel', 'An eco friendly company based in Brisbane moving responsible travel to natural areas that conserve the environment and improves the well-being of local people.', TO_DATE('13122020', 'DDMMYYYY'), 'eco.travel@gmail.com'  
);

INSERT INTO TourOperator VALUES (
	0006, 'Travelink', 'Travelink pioneers small, group adventure holidays around the world. Travelink''s responsible tourism policy is the cornerstone of the company''s approach to tour operating.', TO_DATE('14122020', 'DDMMYYYY'), 'travelink@gmail.com' 
);

INSERT INTO TourOperator VALUES (
	0007, 'Scenictours', 'Scenic tours is an independent travel agency selling escorted treks and tours, adventure and activity travel, safari and wildlife trips and tailor-made holidays to customers who desire impeccable and personalised service', TO_DATE('13122020', 'DDMMYYYY'), 'scenic.tours@aol.com'  
);

INSERT INTO TourOperator VALUES (
	0008, 'Travelous', 'Travelous provides advice, information and bookings for holidays, eco trips, and package tours to anywhere in the world. We ensure customers thoroughly enjoy the style in which their pre trip experience is delivered.', TO_DATE('13122020', 'DDMMYYYY'), 'travelous@gmail.com'  
);

INSERT INTO TourOperator VALUES (
	0009, 'Travelocity', 'A small, independent Travel Agency based in Chicago, United Travel offers discount holidays and travel services with financial protection to customers throughout the world.', TO_DATE('14122020', 'DDMMYYYY'), 'travelocity@aol.com' 
);

INSERT INTO TourOperator VALUES (
	0010, 'Safari Link', 'Safari Link is an established safari and holiday operator dedicated to offering high quality, bespoke and innovative safaris and holidays to Africa', TO_DATE('13122020', 'DDMMYYYY'), 'safari.link@gmail.com'  
);

-- Tour ------------------------------------------------------------------------

INSERT INTO Tour VALUES (
	0001, 'Everest Adventure', 'Everest Base Camp conjures up visions of sheer awe and beauty, and this epic journey will not disappoint! Trek through the Himalayan foothills on the way to the base of the highest mountain in the world.',
	1269.55, 15, 0,'USD'
);

INSERT INTO Tour VALUES (
	0002, 'Inca Discovery', 'Follow in the steps of the Incas on this trip to the "must-see" highlight of Peru - the Inca Trail to Machu Picchu! The 4-day trek from Cuzco is spectacular and the first glimpse of Machu Picchu will leave memories to last a lifetime.',
	1289.75, 10, 0,'USD'
);

INSERT INTO Tour VALUES (
	0003, 'Trekking Mont Blanc', 'Trek the Alps from France to Italy and Switzerland; cross glaciers and pine forests, visit remote villages and mountain refuges before finishing your days with local cuisine and wines.',
	1399.35, 10, 1,'AUD'
);

INSERT INTO Tour VALUES (
	0004, 'Atlas Mountain Trekking', 'Love to hike? Then this 8-day active adventure in Morocco is for you! Enjoy mountain treks offering magnificent views, encounters with Berber villagers and the opportunity to explore bustling Marrakech.',
	1679.95, 12, 0,'AUD'
);

INSERT INTO Tour VALUES (
	0005, 'Sicilian Volcano Trail', 'Exhilarating hiking on the edge! A week of Mediterranean villages, black sand beaches, and unforgettable hikes over three active volcanoes: Vulcano; Stromboli, one of the most active volcanoes in the world; and mighty Etna, Europe highest active volcano.',
	1899.95, 14, 1,'AUD'
);

INSERT INTO Tour VALUES (
	0006, 'Turkey Multi Sport', 'Turkey''s rocky, mountainous coastline is perfect for the active adventurer. Hike, bike and paddle through the steep canyons, traditional villages, ancient ruins and olive groves of the southern Turkish countryside.',
	1519.95, 10, 0,'AUD'
);

INSERT INTO Tour VALUES (
	0007, 'Thailand Sailing Adventure', 'Island hop in Southern Thailand to some of the best snorkeling and diving locations in the world. Enjoy a week aboard a sailing catamaran, while swimming in deserted waters among turtles, manta rays, and beautiful fish as far as the eye can see.',
	1899.95, 10, 0,'AUD'
);

INSERT INTO Tour VALUES (
	0008, 'Bali Village Cycling', 'Riding in quiet villages expose the heart of bali about 17 km and set of after a tasty morning tea overlooking Batukaru, Batur and Agung Mountain.',
	999.95, 9, 1,'EUR'
);

INSERT INTO Tour VALUES (
	0009, 'Maldives Cruise', 'Take a relaxing voyage through many of the least developed atolls that make up the Maldives. On our traditional Dhoni we will visit isolated beaches, small towns and traditional fishing villages.',
	1899.95, 8, 1,'EUR'
);

INSERT INTO Tour VALUES (
	0010, 'Kenya Wildlife Adventure', 'Wildlife is one of the big draws of Kenya, and this trip has it all! Track down the Big 5 as you roam the savannah discovering the unique wildlife of Samburu, observe millions of flamingos at Lake Nakuru.',
	1999.95, 10, 0,'EUR'
);

INSERT INTO Tour VALUES (
	0011, 'Nigeria Expedition', 'An eco-tourism expedition to the two major sectors of the Gashaka-Gumpti National Park, Nigeria''s largest park. The expedition offers an unparalleled experience to explore the remote wilderness areas of Nigeria.',
	2899.95, 23, 1,'AUD'
);

INSERT INTO Tour VALUES (
	0012, 'Ethiopia Explorer', 'Explore captivating Ethiopia! Experience ancient monasteries, castles, and rock-hewn churches, including the famous Saint George Church in Lalibela, which is carved out of one single rock.',
	2699.95, 16, 1,'AUD'
);

INSERT INTO Tour VALUES (
	0013, 'Cycle Tasmania', 'Join a group of like-minded adventure people for an active ride through some of the hidden treasures on Tasmania''s coastlines and mountains.',
	1099.95, 9, 0,'AUD'
);

INSERT INTO Tour VALUES (
	0014, 'Roam India', 'India is home to great food, fascinating culture, alluring sights and friendly and inviting people. Discover the charms and mystery that makes up this incredible country.',
	1999.95, 14, 0,'AUD'
);

INSERT INTO Tour VALUES (
	0015, 'Borneo Rainforest Walk', 'Explore one of the 2km jungle trails and learn about some of the unique medicinal plants, tropical hardwood trees, coastal vegetation, tropical dipterocarp rainforest and the ecology of the mangrove forest.',
	1099.95, 8, 0,'AUD'
);

INSERT INTO Tour VALUES (
	0016, 'China Hike, Bike & Raft', 'From rural roads through endless rice fields in southern China to the bustling streets of Beijing, over the Great Wall of China and down the Li River, see China in a unique way!',
	1599.95, 30, 1,'EUR'
);

INSERT INTO Tour VALUES (
	0017, 'Nomadic Mongolia', 'An incredible journey to the land of blue skies, green hills and nomadic people. Get out and explore the city of Ulaan Baatar and lush green countryside, which is dotted with ancient monasteries.',
	2099.95, 18, 0,'AUD'
);

INSERT INTO Tour VALUES (
	0018, 'Madagascar Experience', 'The fascinating island of Madagascar awaits. Escape the everyday routine on this 10-day journey encompassing natural beauty, stunning landscapes, Malgache history and culture, and of course, a wide variety of lemurs.',
	2999.95, 14, 0,'AUD'
);

INSERT INTO Tour VALUES (
	0019, 'Uluru Walk', 'An absorbing exposition of Uluru''s (Ayers Rock) natural history and deep significance to the Aboriginal people. Short walks bring you close to this powerful place, view rock art, waterholes, flora and fauna of Uluru.',
	1099.95, 9, 0,'AUD'
);

INSERT INTO Tour VALUES (
	0020, 'Japan Adventure', 'Known as much for its high tech gadgets as for its centuries old traditions, Japan is blessed with some of the most pristine scenery in Asia. With beautiful rivers, lakes and mountains, Japan really is the perfect place for a multi-sport adventure!',
	1899.95, 10, 1,'EUR'
);

-- ListedTour -----------------------------------------------------------------------

INSERT INTO ListedTour VALUES (
	0001, 0003, 0002, TO_DATE('12052010', 'DDMMYYYY'), TO_DATE('12052010', 'DDMMYYYY')  
);

INSERT INTO ListedTour VALUES (
	0002, 0003, 0002, TO_DATE('12062010', 'DDMMYYYY'), TO_DATE('12122010', 'DDMMYYYY')  
);

INSERT INTO ListedTour VALUES (
	0003, 0004, 0003, TO_DATE('13022010', 'DDMMYYYY'), TO_DATE('13122010', 'DDMMYYYY')  
);

INSERT INTO ListedTour VALUES (
	0004, 0004, 0004, TO_DATE('14012010', 'DDMMYYYY'), TO_DATE('14122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0005, 0004, 0004, TO_DATE('14062010', 'DDMMYYYY'), TO_DATE('14122010', 'DDMMYYYY')  
);
INSERT INTO ListedTour VALUES (
	0006, 0004, 0004, TO_DATE('14052010', 'DDMMYYYY'), TO_DATE('14122010', 'DDMMYYYY')  
);

-- Activity --------------------------------------------------------------------

INSERT INTO Activity VALUES (
	0001, 'Hiking'
);

INSERT INTO Activity VALUES (
	0002, 'Cycling'
);

INSERT INTO Activity VALUES (
	0003, 'Rafting'
);

INSERT INTO Activity VALUES (
	0004, 'Kayaking'
);

INSERT INTO Activity VALUES (
	0005, 'Yachting'
);

INSERT INTO Activity VALUES (
	0006, 'Sailing'
);

INSERT INTO Activity VALUES (
	0007, 'Trekking'
);

INSERT INTO Activity VALUES (
	0008, 'Diving'
);

INSERT INTO Activity VALUES (
	0009, 'Snorkeling'
);

INSERT INTO Activity VALUES (
	0010, 'Canoeing'
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
	0001, 'Nepal', 28.275358281817105, 85.572509765625, '_pqkDekhiOktDf~vAy{bAuqGxyQhtcAk~~@dvpBm_jArwg@j~Mf~vAy{cBpwnC', 'BBBBBBBB'
);

INSERT INTO Location VALUES (
	0002, 'Peru', -13.21788749549483, -72.37106323242188, 'xrtoAb~uxLjnAbiGoy@nwDyvDtcA|l@l{B}aD|nDprAtjD', 'BBBBBBB'
);

INSERT INTO Location VALUES (
	0003, 'France', 45.84602106744843, 6.92413330078125, 'shyvGyjgi@koKpaMtfA~nD', 'BBB'
);

INSERT INTO Location VALUES (
	0004, 'Morocco', 31.121145709156313, -7.646484375, 'ej}|Dnmtm@jcThdPb{Kxl[l~D~vXqzQnuP', 'BBBBB'
);

INSERT INTO Location VALUES (
	0005, 'Italy', 38.7991826637395, 15.239582061767578, '{}xkFkn_|AcX~MoK`]wTtW', 'BBBB'
);

INSERT INTO Location VALUES (
	0006, 'Turkey', 36.63619261281252, 29.121665954589844, 'eor~EmyvpD{^fB_^qGq`@rW', 'BBBB'
);

INSERT INTO Location VALUES (
	0007, 'Thailand', 7.9756827477767755, 98.28094482421875, '_wto@{nzvQgCqd@{Umb@kEia@', 'BBBB'
);

INSERT INTO Location VALUES (
	0008, 'Bali', -8.402413266504553, 115.59368133544922, '`bhr@o{o`U_xBg}@~OwX{uBmTu`BsV', 'BBBBB'
);

INSERT INTO Location VALUES (
	0009, 'Maldives', -0.6831960899681082, 73.16688537597656, '~ldCalq}LucAu_CmbF_mE', 'BBB'
);

INSERT INTO Location VALUES (
	0010, 'Kenya', -0.3685544346850061, 36.11480712890625, 'l~fAqtl{Emc@fQkp@sHqs@bAkp@hC', 'BBBBB'
);

INSERT INTO Location VALUES (
	0011, 'Nigeria', 7.357018957392011, 11.78009033203125, 'k|{k@qx{fAgi]yeX{w\xeXcgCxs^i_PhvI', 'BBBBB'
);

INSERT INTO Location VALUES (
	0012, 'Ethiopia', 12.016319242084627, 39.05261993408203, '_}ihA{mjmFgo@mEiZb^eX_Nyz@npA', 'BBBBB'
);

INSERT INTO Location VALUES (
	0013, 'Tasmania', -43.30119623257964, 145.83526611328125, '~oegGardyZczMrqGylOxpNuyF~sH', 'BBBB'
);

INSERT INTO Location VALUES (
	0014, 'India', 27.178683414381183, 78.0532693862915, 'wi{dD}wk{M~CbDfD~I|DzOtEnFvDfJ|ErD', 'BBBBBBB'
);

INSERT INTO Location VALUES (
	0015, 'Malaysia', 2.8634922717744704, 111.9287109375, 'ygnPmadjTs{Dox`@iiKguf@q{Dcv_@', 'BBBB'
);

INSERT INTO Location VALUES (
	0016, 'China', 24.777227510913374, 110.5198860168457, 'uhfvCi|paTba@udAtIi`@c_@urA', 'BBBB'
);

INSERT INTO Location VALUES (
	0017, 'Mongolia', 43.13306116240612, 99.437255859375, 'slgfG{i|}Qg|{@fhjBtbBff}@cyaA~hR_iYria@m`d@fzcB', 'BBBBBB'
);

INSERT INTO Location VALUES (
	0018, 'Madagascar', -21.453707704648814, 47.44102478027344, 'td}aCkyp`HwfEbPynDflA}ZeuCyzE_mE', 'BBBBB'
);

INSERT INTO Location VALUES (
	0019, 'Alice Springs', -25.35891851754525, 130.81283569335938, 'f|wyCgkl}WgVqqRslAybHooFquEgyDpnB', 'BBBBB'
);

INSERT INTO Location VALUES (
	0020, 'Japan', 36.602574752590314, 137.84906387329102, 'a}k~EssjhYgPsV}Qa]i\{K', 'BBBB'
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