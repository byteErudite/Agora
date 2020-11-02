package com.vaibhav.Agora.DTOEntities;

import com.vaibhav.Agora.Common.Constants.BookCategory;
import com.vaibhav.Agora.Common.Constants.Genre;
import com.vaibhav.Agora.Entities.Author;

import java.util.UUID;

public class BookDTO {
    private UUID bookId;
    private String title;
    private Author author;
    private BookCategory category;
    private Genre genre;
    private String publication;
    private String edition;

    public BookDTO(String title, Author author, BookCategory category, Genre genre, String publication, String edition) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.genre = genre;
        this.publication = publication;
        this.edition = edition;
    }

    public UUID getBookId() {
        return bookId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

}
