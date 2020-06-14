INSERT INTO Film_TvSeries (ID, endYear, genres, isAdult, originalTitle, primaryTitle, runtimeMinutes, startYear, type) VALUES (1, null, null, false, 'Harry Potter', 'Harry Potter', '04:15:00', 1997, 'Film') ON DUPLICATE KEY UPDATE id=id;
INSERT INTO Actor_Actress (ID, birthYear, deathYear, primaryName, primaryProfessions) VALUES (1, 1990, null
, 'Daniel Radcliffe', null) ON DUPLICATE KEY UPDATE id=id;
INSERT INTO Actor_Actress (ID, birthYear, deathYear, primaryName, primaryProfessions) VALUES (2, 1990, null
, 'Emma Watson', null) ON DUPLICATE KEY UPDATE id=id;
INSERT INTO Actor_Actress (ID, birthYear, deathYear, primaryName, primaryProfessions) VALUES (3, 1990, null
, 'Rupert Grint', null) ON DUPLICATE KEY UPDATE id=id;
INSERT INTO ActorFilmRelation (ID, caracters, category, job, actorActress_ID, filmTVSeries_ID) VALUES (1, null, 'Film', 'Actor', 1, 1) ON DUPLICATE KEY UPDATE id=id;
INSERT INTO ActorFilmRelation (ID, caracters, category, job, actorActress_ID, filmTVSeries_ID) VALUES (2, null, 'Film', 'Actress', 2, 1) ON DUPLICATE KEY UPDATE id=id;
INSERT INTO ActorFilmRelation (ID, caracters, category, job, actorActress_ID, filmTVSeries_ID) VALUES (3, null, 'Film', 'Actor', 3, 1) ON DUPLICATE KEY UPDATE id=id;