package com.vaibhav.Agora.Entities;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.vaibhav.Agora.Common.Constants.BookCategory;
import com.vaibhav.Agora.Common.Constants.Genre;
import com.vaibhav.Agora.Common.Constants.Language;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "book")
public class Book extends BaseEntity implements  Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    private UUID bookId;
    private String title;


    private UUID authorId;

    @Enumerated(EnumType.STRING)
    private BookCategory category;

    @Enumerated(EnumType.STRING)
    private Genre genre;


    private UUID publicationId;
    private String edition;

    @Enumerated(EnumType.STRING)
    private Language language;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId")
    private Set<BookUnit> bookUnits;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId")
    private Set<Rating> ratings;

    public Book() {
        super();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Set<BookUnit> getBookUnits() {
        return bookUnits;
    }

    public void setBookUnits(Set<BookUnit> bookUnits) {
        this.bookUnits = bookUnits;
    }

    public UUID getBookId() {
        return bookId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
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

    public UUID getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(UUID publicationId) {
        this.publicationId = publicationId;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BookDetails{");
        sb.append("bookId=").append(bookId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", authorId=").append(authorId);
        sb.append(", category=").append(category);
        sb.append(", genre=").append(genre);
        sb.append(", publicationId='").append(publicationId).append('\'');
        sb.append(", edition='").append(edition).append('\'');
        sb.append(", bookUnits=").append(bookUnits.toString());
        sb.append(", language=").append(language);
        sb.append('}');
        return sb.toString();
    }

}

