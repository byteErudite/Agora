package com.vaibhav.Agora.DTOEntities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.UUID;


public class BookUnitDTO implements Serializable {
    private UUID bookUnitId;
    private Boolean isAvailable;
    private Boolean isReserved;
    private String isbn;
    private UUID bookId;

    public BookUnitDTO() {
    }

    public UUID getBookUnitId() {
        return bookUnitId;
    }

    public void setBookUnitId(UUID bookUnitId) {
        this.bookUnitId = bookUnitId;
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

    public UUID getBookId() {
        return bookId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }
}
