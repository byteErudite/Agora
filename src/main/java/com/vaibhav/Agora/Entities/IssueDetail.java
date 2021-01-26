package com.vaibhav.Agora.Entities;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Component
@Table(name = "issue_detail")
public class IssueDetail extends BaseEntity implements Serializable {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    private UUID issueId;
    private UUID bookUnitId;
    private UUID userId;
    private Timestamp issueDate;
    private Timestamp issuedTill;
    private String description;
    private Timestamp returnDate;

    public IssueDetail() {
    }

    public UUID getIssueId() {
        return issueId;
    }

    public void setIssueId(UUID issueId) {
        this.issueId = issueId;
    }

    public Timestamp getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }

    public UUID getBookUnitId() {
        return bookUnitId;
    }

    public void setBookUnitId(UUID bookUnitId) {
        this.bookUnitId = bookUnitId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Timestamp getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Timestamp issueDate) {
        this.issueDate = issueDate;
    }

    public Timestamp getIssuedTill() {
        return issuedTill;
    }

    public void setIssuedTill(Timestamp issuedTill) {
        this.issuedTill = issuedTill;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IssueDetail(UUID bookUnitId, UUID userId, Timestamp issueDate, Timestamp issuedTill, String description) {
        this.bookUnitId = bookUnitId;
        this.userId = userId;
        this.issueDate = issueDate;
        this.issuedTill = issuedTill;
        this.description = description;
    }
}
