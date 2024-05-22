package app;

import dao.AuthorDAO;
import dao.BookDAO;
import model.Author;
import model.Book;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManagerApp {
    private static final AuthorDAO authorDAO = new AuthorDAO();
    private static final BookDAO bookDAO = new BookDAO();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Author");
            System.out.println("2. Add Book");
            System.out.println("3. List All Books");
            System.out.println("4. List All Authors");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter author name: ");
                    String authorName = scanner.nextLine();
                    authorDAO.addAuthor(authorName);
                    break;
                case 2:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter language: ");
                    String language = scanner.nextLine();
                    System.out.print("Enter publication date (yyyy-mm-dd): ");
                    String pubDate = scanner.nextLine();
                    System.out.print("Enter number of pages: ");
                    int pages = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter author ID: ");
                    int authorId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Author author = new Author(authorId, null); // Placeholder author
                    List<Author> authors = new ArrayList<>();
                    authors.add(author);

                    Book book = new Book(0, title, authors, language, Date.valueOf(pubDate), pages);
                    bookDAO.addBook(book);
                    break;
                case 3:
                    List<Book> books = bookDAO.getAllBooks();
                    for (Book b : books) {
                        System.out.println("Title: " + b.getTitle() + ", Author: " + b.getAuthors().get(0).getName());
                    }
                    break;
                case 4:
                    List<String> authorsList = authorDAO.getAllAuthors();
                    for (String a : authorsList) {
                        System.out.println(a);
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
