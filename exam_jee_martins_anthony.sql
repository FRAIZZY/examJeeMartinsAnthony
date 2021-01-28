DROP DATABASE IF EXISTS exam_jee_martins_anthony;

CREATE DATABASE IF NOT EXISTS exam_jee_martins_anthony;

USE exam_jee_martins_anthony; 

CREATE TABLE user (
    id INT NOT NULL auto_increment,
    login VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    date_entry_company DATE,
    phone VARCHAR(255) NOT NULL,
    imageLink VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
 ) ENGINE=InnoDB;
