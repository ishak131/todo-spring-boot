-- CREATE TABLE IF NOT EXISTS project ( id BIGINT PRIMARY KEY AUTO_INCREMENT, title VARCHAR(100), description VARCHAR(100))
-- CREATE TABLE IF NOT EXISTS test
-- (
--     id
--                BIGINT
--         PRIMARY
--             KEY
--         AUTO_INCREMENT,
--     title
--                VARCHAR(255) NOT NULL,
--     date       DATE         NOT NULL,
--     is_done    BOOLEAN      NOT NULL,
--     project_id BIGINT,
--     FOREIGN KEY
--         (
--          project_id
--             ) REFERENCES project
--         (
--          id
--             )
-- );
-- CREATE TABLE Persons (
--                          Personid int NOT NULL AUTO_INCREMENT,
--                          LastName varchar(255) NOT NULL,
--                          FirstName varchar(255),
--                          Age int,
--                          PRIMARY KEY (Personid)
-- -- );
--
-- create table TodoUser
-- (
--     id BIGINT NOT NULL AUTO_INCREMENT,
--     email
--         VARCHAR(255) NOT NULL,
--     password varchar(255),
--     username varchar(255),
--     PRIMARY KEY (id)
--
-- );