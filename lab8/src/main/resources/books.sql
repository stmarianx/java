CREATE DATABASE IF NOT EXISTS book_collection;

USE book_collection;

CREATE TABLE IF NOT EXISTS authors (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS books (
     id INT AUTO_INCREMENT PRIMARY KEY,
     title VARCHAR(255) NOT NULL,
    language VARCHAR(255) NOT NULL,
    publication_date DATE,
    number_of_pages INT,
    author_id INT,
    FOREIGN KEY (author_id) REFERENCES authors(id)
    );
