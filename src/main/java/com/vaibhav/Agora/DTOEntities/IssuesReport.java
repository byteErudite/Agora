package com.vaibhav.Agora.DTOEntities;

import java.sql.Date;
import java.util.UUID;

public class IssuesReport {
    public String bookId;
    public String bookName;
    public UUID bookUnitId;
    public Date issueDate;
    public Date returnDate;
    public Date issuedTill;

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

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getIssuedTill() {
        return issuedTill;
    }

    public void setIssuedTill(Date issuedTill) {
        this.issuedTill = issuedTill;
    }

    public IssuesReport() {
    }

    public IssuesReport(String bookId, String bookName, UUID bookUnitId, Date issueDate, Date returnDate, Date issuedTill) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookUnitId = bookUnitId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.issuedTill = issuedTill;
    }
}
