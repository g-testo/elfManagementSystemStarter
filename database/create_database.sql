DROP DATABASE IF EXISTS elf;
CREATE DATABASE IF NOT EXISTS elf;
USE elf;

# ---------------------------------------------------------------------- #
# Tables                                                                 #
# ---------------------------------------------------------------------- #

-- Create the roles table
CREATE TABLE roles (
    role_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (role_id)
);

-- Create the elves table
CREATE TABLE elves (
    elf_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    elf_rank INT NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY (elf_id),
    FOREIGN KEY (role_id) REFERENCES roles(role_id)
);


CREATE TABLE users (
    user_id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    hashed_password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE profiles (
    user_id INT NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(200) NOT NULL,
    address VARCHAR(200) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    zip VARCHAR(20) NOT NULL,
    PRIMARY KEY (user_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- Insert seed data into roles
INSERT INTO roles (name) VALUES
('Toy Designer'),
('Toy Assembler'),
('Quality Inspector'),
('Packaging Specialist'),
('Logistics Coordinator');

-- Insert seed data into elves
INSERT INTO elves (name, image_url, elf_rank, role_id) VALUES
('Buddy', 'http://localhost:8080/buddy.png', 1, 1),
('Jingle', 'http://localhost:8080/jingle.png', 2, 1),
('Twinkle', 'http://localhost:8080/twinkle.png', 3, 2),
('Sparkle', 'http://localhost:8080/buddy.png', 4, 2),
('Frost', 'http://localhost:8080/frost.png', 5, 3),
('Snowflake', 'http://localhost:8080/buddy.png', 6, 3),
('Dasher', 'http://localhost:8080/buddy.png', 7, 3),
('Comet', 'http://localhost:8080/buddy.png', 8, 4),
('Blizzard', 'http://localhost:8080/buddy.png', 9, 4),
('Peppermint', 'http://localhost:8080/buddy.png', 10, 4),
('Holly', 'http://localhost:8080/buddy.png', 11, 5),
('Jolly', 'http://localhost:8080/buddy.png', 12, 5),
('Elvis', 'http://localhost:8080/buddy.png', 13, 5), -- Elvis look-alike
('Rudolph', 'http://localhost:8080/buddy.png', 14, 3),
('Tinsel', 'http://localhost:8080/buddy.png', 15, 1),
('Gingerbread', 'http://localhost:8080/buddy.png', 16, 2),
('Icicle', 'http://localhost:8080/buddy.png', 17, 3),
('Merry', 'http://localhost:8080/buddy.png', 18, 4),
('Zombie', 'http://localhost:8080/buddy.png', 19, 5), -- Zombie elf
('Chestnut', 'http://localhost:8080/buddy.png', 20, 2);

/*  INSERT Users  */
INSERT INTO users (username, hashed_password, role) 
VALUES  ('user','$2a$10$NkufUPF3V8dEPSZeo1fzHe9ScBu.LOay9S3N32M84yuUM2OJYEJ/.','ROLE_USER'),
        ('admin','$2a$10$lfQi9jSfhZZhfS6/Kyzv3u3418IgnWXWDQDk7IbcwlCFPgxg9Iud2','ROLE_ADMIN'),
        ('george','$2a$10$lfQi9jSfhZZhfS6/Kyzv3u3418IgnWXWDQDk7IbcwlCFPgxg9Iud2','ROLE_USER');

/* INSERT Profiles */
INSERT INTO profiles (user_id, first_name, last_name, phone, email, address, city, state, zip)
VALUES  (1, 'Joe', 'Joesephus', '800-555-1234', 'joejoesephus@email.com', '789 Oak Avenue', 'Dallas', 'TX', '75051'),
        (2, 'Adam', 'Admamson', '800-555-1212', 'aaadamson@email.com', '456 Elm Street','Dallas','TX','75052'),
        (3, 'George', 'Jetson', '800-555-9876', 'george.jetson@email.com', '123 Birch Parkway','Dallas','TX','75051')     ;
