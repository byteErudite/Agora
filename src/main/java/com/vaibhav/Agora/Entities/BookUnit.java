package com.vaibhav.Agora.Entities;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Component
@Table(name = "book_unit")
public class BookUnit extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    private UUID bookUnitId;

    private Boolean isAvailable;
    private Boolean isReserved;
    private String isbn;

    private UUID bookId;

    public BookUnit() {
    }

    public UUID getBookId() {
        return bookId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Boolean getReserved() {
        return isReserved;
    }

    public void setReserved(Boolean reserved) {
        isReserved = reserved;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public UUID getBookUnitId() {
        return bookUnitId;
    }

    public void setBookUnitId(UUID bookUnitId) {
        this.bookUnitId = bookUnitId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BookUnit{");
        sb.append("bookUnitId=").append(bookUnitId);
        sb.append(", isAvailable=").append(isAvailable);
        sb.append(", isReserved=").append(isReserved);
        sb.append(", isbn='").append(isbn).append('\'');
        sb.append(", bookId=").append(bookId);
        sb.append('}');
        return sb.toString();
    }
}
