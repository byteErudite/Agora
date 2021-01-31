package com.vaibhav.Agora.DTOEntities;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

public class IssuesReport {
    private String bookId;
    private String bookName;
    private UUID bookUnitId;
    private Timestamp issueDate;
    private Timestamp returnDate;
    private Timestamp issuedTill;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public UUID getBookUnitId() {
        return bookUnitId;
    }

    public void setBookUnitId(UUID bookUnitId) {
        this.bookUnitId = bookUnitId;
    }

    public Timestamp getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Timestamp issueDate) {
        this.issueDate = issueDate;
    }

    public Timestamp getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }

    public Timestamp getIssuedTill() {
        return issuedTill;
    }

    public void setIssuedTill(Timestamp issuedTill) {
        this.issuedTill = issuedTill;
    }

    public IssuesReport() {
    }

    public IssuesReport(String bookId, String bookName, UUID bookUnitId, Timestamp issueDate, Timestamp returnDate, Timestamp issuedTill) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookUnitId = bookUnitId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.issuedTill = issuedTill;
    }
}
