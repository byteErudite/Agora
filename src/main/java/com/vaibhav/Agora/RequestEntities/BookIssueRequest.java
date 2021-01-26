package com.vaibhav.Agora.RequestEntities;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookIssueRequest implements Serializable {
    private String comment;
    private Date issuedTill;
    private List<UUID> bookUnitIds;

    public BookIssueRequest() {
    }

    public List<UUID> getBookUnitIds() {
        return bookUnitIds;
    }

    public void setBookUnitIds(List<UUID> bookUnitIds) {
        this.bookUnitIds = bookUnitIds;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getIssuedTill() {
        return issuedTill;
    }

    public void setIssuedTill(Date issuedTill) {
        this.issuedTill = issuedTill;
    }
}
