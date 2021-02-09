package com.vaibhav.Agora.DTOEntities;

import java.util.UUID;

public class DeclineIssueRequestDTO {

    private UUID issueRequestId;
    private String declineReason;

    public UUID getIssueRequestId() {
        return issueRequestId;
    }

    public void setIssueRequestId(UUID issueRequestId) {
        this.issueRequestId = issueRequestId;
    }

    public String getDeclineReason() {
        return declineReason;
    }

    public void setDeclineReason(String declineReason) {
        this.declineReason = declineReason;
    }

    public DeclineIssueRequestDTO() {
    }
}
