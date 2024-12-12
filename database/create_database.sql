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
('Buddy', 'https://example.com/images/buddy.jpg', 1, 1),
('Jingle', 'https://example.com/images/jingle.jpg', 2, 1),
('Twinkle', 'https://example.com/images/twinkle.jpg', 3, 2),
('Sparkle', 'https://example.com/images/sparkle.jpg', 4, 2),
('Frost', 'https://example.com/images/frost.jpg', 5, 3),
('Snowflake', 'https://example.com/images/snowflake.jpg', 6, 3),
('Dasher', 'https://example.com/images/dasher.jpg', 7, 3),
('Comet', 'https://example.com/images/comet.jpg', 8, 4),
('Blizzard', 'https://example.com/images/blizzard.jpg', 9, 4),
('Peppermint', 'https://example.com/images/peppermint.jpg', 10, 4),
('Holly', 'https://example.com/images/holly.jpg', 11, 5),
('Jolly', 'https://example.com/images/jolly.jpg', 12, 5),
('Elvis', 'https://example.com/images/elvis.jpg', 13, 5), -- Elvis look-alike
('Rudolph', 'https://example.com/images/rudolph.jpg', 14, 3),
('Tinsel', 'https://example.com/images/tinsel.jpg', 15, 1),
('Gingerbread', 'https://example.com/images/gingerbread.jpg', 16, 2),
('Icicle', 'https://example.com/images/icicle.jpg', 17, 3),
('Merry', 'https://example.com/images/merry.jpg', 18, 4),
('Zombie', 'https://example.com/images/zombie.jpg', 19, 5), -- Zombie elf
('Chestnut', 'https://example.com/images/chestnut.jpg', 20, 2);

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
