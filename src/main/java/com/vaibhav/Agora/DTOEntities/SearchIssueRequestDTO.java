package com.vaibhav.Agora.DTOEntities;

import com.vaibhav.Agora.Common.Constants.IssueRequestType;
import com.vaibhav.Agora.Common.Constants.RequestStatus;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class SearchIssueRequestDTO implements Serializable {

    private List<UUID> userIds;
    private List<UUID> bookUnitIds;
    private List<RequestStatus> statuses;
    private String declineReason;
    private String comment;
    private List<IssueRequestType> requestTypes;

    public SearchIssueRequestDTO() {
    }

    public List<UUID> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<UUID> userIds) {
        this.userIds = userIds;
    }

    public List<UUID> getBookUnitIds() {
        return bookUnitIds;
    }

    public void setBookUnitIds(List<UUID> bookUnitIds) {
        this.bookUnitIds = bookUnitIds;
    }

    public List<RequestStatus> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<RequestStatus> statuses) {
        this.statuses = statuses;
    }

    public String getDeclineReason() {
        return declineReason;
    }

    public void setDeclineReason(String declineReason) {
        this.declineReason = declineReason;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<IssueRequestType> getRequestTypes() {
        return requestTypes;
    }

    public void setRequestTypes(List<IssueRequestType> requestTypes) {
        this.requestTypes = requestTypes;
    }
}
