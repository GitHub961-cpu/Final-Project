CREATE TABLE PALINDROME (
     ID MEDIUMINT NOT NULL AUTO_INCREMENT,
     PHRASE VARCHAR(50) NOT NULL,
     COUNTER MEDIUMINT NOT NULL
     PRIMARY KEY (ID)
 );
INSERT INTO PALINDROME (PHRASE, COUNTER) 
VALUES ("Bob", 0), ("stack cats", 0), ("TacoCat", 0);