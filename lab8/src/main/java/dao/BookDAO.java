package dao;

import model.Author;
import model.Book;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Connection connection;

    public BookDAO() {
        try {
            this.connection = DatabaseConnection.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addBook(Book book) {
        String query = "INSERT INTO books (title, language, publication_date, number_of_pages, author_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getLanguage());
            statement.setDate(3, new Date(book.getPublicationDate().getTime()));
            statement.setInt(4, book.getNumberOfPages());
            statement.setInt(5, book.getAuthors().get(0).getId()); // Assuming one author for simplicity
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM books";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String language = resultSet.getString("language");
                Date publicationDate = resultSet.getDate("publication_date");
                int numberOfPages = resultSet.getInt("number_of_pages");
                int authorId = resultSet.getInt("author_id");

                // Retrieve author details
                Author author = getAuthorById(authorId);

                List<Author> authors = new ArrayList<>();
                authors.add(author);

                Book book = new Book(id, title, authors, language, publicationDate, numberOfPages);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    private Author getAuthorById(int authorId) {
        String query = "SELECT * FROM authors WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, authorId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    return new Author(authorId, name);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
