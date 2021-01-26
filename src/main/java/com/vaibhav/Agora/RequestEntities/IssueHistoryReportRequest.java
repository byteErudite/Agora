package com.vaibhav.Agora.RequestEntities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

public class IssueHistoryReportRequest implements Serializable {
    private Timestamp startDate;
    private Timestamp endDate;
    private UUID userId;

    public IssueHistoryReportRequest() {
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
