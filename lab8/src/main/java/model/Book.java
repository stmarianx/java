package model;

import java.util.Date;
import java.util.List;

public class Book {
    private int id;
    private String title;
    private List<Author> authors;
    private String language;
    private Date publicationDate;
    private int numberOfPages;

    public Book(int id, String title, List<Author> authors, String language, Date publicationDate, int numberOfPages) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.language = language;
        this.publicationDate = publicationDate;
        this.numberOfPages = numberOfPages;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
