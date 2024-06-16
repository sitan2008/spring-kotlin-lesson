CREATE TABLE person
(
    id bigint NOT NULL,
    name varchar(255) NOT NULL,
    last_name varchar(255) NULL,
    PRIMARY KEY(id)

);

CREATE SEQUENCE PERSON_SEQUENCE START 1 INCREMENT 1