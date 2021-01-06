package com.vaibhav.Agora.RequestEntities;

import com.vaibhav.Agora.Common.Constants.BookCategory;
import com.vaibhav.Agora.Common.Constants.Genre;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public class BookSearchRequest {
    private List<UUID> bookUnitIds;
    private List<String> titles;
    private List<String> publications;
    private List<String> authors;
    private List<UUID> authorIds;
    private boolean isAvailable;
    private boolean isReserved;
    private int rating;
    private List<String> editions;
    private List<Genre> genre;
    private List<BookCategory> categories;
    private Timestamp timeOfIssueStart;
    private Timestamp timeOfIssueEnd;
    private Timestamp addedDate;

    public List<UUID> getBookUnitIds() {
        return bookUnitIds;
    }

    public void setBookUnitIds(List<UUID> bookUnitIds) {
        this.bookUnitIds = bookUnitIds;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<String> getPublications() {
        return publications;
    }

    public void setPublications(List<String> publications) {
        this.publications = publications;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<UUID> getAuthorIds() {
        return authorIds;
    }

    public void setAuthorIds(List<UUID> authorIds) {
        this.authorIds = authorIds;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<String> getEditions() {
        return editions;
    }

    public void setEditions(List<String> editions) {
        this.editions = editions;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public List<BookCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<BookCategory> categories) {
        this.categories = categories;
    }

    public Timestamp getTimeOfIssueStart() {
        return timeOfIssueStart;
    }

    public void setTimeOfIssueStart(Timestamp timeOfIssueStart) {
        this.timeOfIssueStart = timeOfIssueStart;
    }

    public Timestamp getTimeOfIssueEnd() {
        return timeOfIssueEnd;
    }

    public void setTimeOfIssueEnd(Timestamp timeOfIssueEnd) {
        this.timeOfIssueEnd = timeOfIssueEnd;
    }

    public Timestamp getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Timestamp addedDate) {
        this.addedDate = addedDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BookSearchRequest{");
        sb.append("bookUnitIds=").append(bookUnitIds);
        sb.append(", titles=").append(titles);
        sb.append(", publications=").append(publications);
        sb.append(", authors=").append(authors);
        sb.append(", authorIds=").append(authorIds);
        sb.append(", isAvailable=").append(isAvailable);
        sb.append(", isReserved=").append(isReserved);
        sb.append(", rating=").append(rating);
        sb.append(", editions=").append(editions);
        sb.append(", genre=").append(genre);
        sb.append(", categories=").append(categories);
        sb.append(", timeOfIssueStart=").append(timeOfIssueStart);
        sb.append(", timeOfIssueEnd=").append(timeOfIssueEnd);
        sb.append(", addedDate=").append(addedDate);
        sb.append('}');
        return sb.toString();
    }
}
