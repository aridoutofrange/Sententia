CREATE DATABASE sententia;
USE sententia;
CREATE TABLE leaderboard (
     id MEDIUMINT NOT NULL AUTO_INCREMENT,
     PlayerName CHAR(30),
     Score INT(6),
     PRIMARY KEY (id)
);