docker container exec -it ba9a4732f5e2 bash

mysql -u root -p

create database testdb;

use testdb;

CREATE TABLE hello (ID int NOT NULL AUTO_INCREMENT,
    test varchar(255) NOT NULL,
    PRIMARY KEY (ID)
);

INSERT INTO hello (test) VALUES ("Duy");