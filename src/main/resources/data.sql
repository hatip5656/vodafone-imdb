INSERT INTO imdb.Film_TvSeries (ID, endYear, genres, isAdult, originalTitle, primaryTitle, runtimeMinutes, startYear, type) VALUES (1, null, 0xACED0005737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000277040000000274000946616E746173746963740006416374696F6E78, false, 'Harry Potter', 'Harry Potter', '04:15:00', 1997, 'Film');
INSERT INTO imdb.Actor_Actress (ID, birthYear, deathYear, primaryName, primaryProfessions) VALUES (1, 1990, null, 'Daniel Radcliffe', 0xACED0005737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A657870000000017704000000017400054163746F7278);
INSERT INTO imdb.Actor_Actress (ID, birthYear, deathYear, primaryName, primaryProfessions) VALUES (2, 1990, null, 'Emma Watson', 0xACED0005737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A657870000000017704000000017400054163746F7278);
INSERT INTO imdb.Actor_Actress (ID, birthYear, deathYear, primaryName, primaryProfessions) VALUES (3, 1990, null, 'Rupert Grint', 0xACED0005737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A657870000000017704000000017400054163746F7278);
INSERT INTO imdb.ActorFilmRelation (ID, caracters, category, job, actorActress_ID, filmTVSeries_ID) VALUES (1, 0xACED0005737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000174000C486172727920506F7474657278, 'Film', 'Actor', 1, 1);
INSERT INTO imdb.ActorFilmRelation (ID, caracters, category, job, actorActress_ID, filmTVSeries_ID) VALUES (2, 0xACED0005737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A657870000000017704000000017400104865726D696F6E65204772616E67657278, 'Film', 'Actress', 2, 1);
INSERT INTO imdb.ActorFilmRelation (ID, caracters, category, job, actorActress_ID, filmTVSeries_ID) VALUES (3, 0xACED0005737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000177040000000174000B526F6E20576561736C657978, 'Film', 'Actor', 3, 1);