package com.vaibhav.Agora.DTOEntities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vaibhav.Agora.Common.Constants.BookCategory;
import com.vaibhav.Agora.Common.Constants.Genre;
import com.vaibhav.Agora.Entities.BaseEntity;
import com.vaibhav.Agora.Entities.BookUnit;
import com.vaibhav.Agora.Entities.Rating;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDTO extends BaseEntity implements Serializable {
    public static final long serialVersionUID = 1L;

    private UUID bookId;
    private String title;
    private UUID authorId;
    private BookCategory category;
    private Genre genre;
    private UUID publicationId;
    private String edition;
    private String language;
    private Set<BookUnitDTO> bookUnits;

    public BookDTO() {
    }

    public BookDTO(UUID bookId, String title, UUID authorId, BookCategory category, Genre genre, UUID publicationId, String edition, String language) {
        this.bookId = bookId;
        this.title = title;
        this.authorId = authorId;
        this.category = category;
        this.genre = genre;
        this.publicationId = publicationId;
        this.edition = edition;
        this.language = language;
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

    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    public Genre getGenre() {
        return genre;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }

    public UUID getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(UUID publicationId) {
        this.publicationId = publicationId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Set<BookUnitDTO> getBookUnits() {
        return bookUnits;
    }

    public void setBookUnits(Set<BookUnitDTO> bookUnits) {
        this.bookUnits = bookUnits;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

}
