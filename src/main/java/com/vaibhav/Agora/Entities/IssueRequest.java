package com.vaibhav.Agora.Entities;

import com.vaibhav.Agora.Common.Constants.IssueRequestType;
import com.vaibhav.Agora.Common.Constants.RequestStatus;
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
@Table(name = "issue_request")
public class IssueRequest extends BaseEntity implements Serializable {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    private UUID issueRequestId;

    private UUID userId;
    private UUID bookUnitId;
    private RequestStatus status;
    private String declineReason;
    private String comment;
    private IssueRequestType requestType;

    public IssueRequest() {
    }

    public IssueRequest(UUID issueRequestId, UUID userId, UUID bookUnitId,RequestStatus status, String declineReason, String comment, IssueRequestType requestType) {
        this.issueRequestId = issueRequestId;
        this.userId = userId;
        this.bookUnitId = bookUnitId;
        this.declineReason = declineReason;
        this.comment = comment;
        this.requestType = requestType;
        this.status = status;
    }

    public IssueRequest(UUID userId, UUID bookUnitId, String comment, IssueRequestType requestType, RequestStatus status) {
        this.userId = userId;
        this.bookUnitId = bookUnitId;
        this.comment = comment;
        this.requestType = requestType;
        this.status = status;
    }

    public UUID getIssueRequestId() {
        return issueRequestId;
    }

    public void setIssueRequestId(UUID issueRequestId) {
        this.issueRequestId = issueRequestId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getBookUnitId() {
        return bookUnitId;
    }

    public void setBookUnitId(UUID bookUnitId) {
        this.bookUnitId = bookUnitId;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
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

    public IssueRequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(IssueRequestType requestType) {
        this.requestType = requestType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IssueRequest{");
        sb.append("issueRequestId=").append(issueRequestId);
        sb.append(", userId=").append(userId);
        sb.append(", bookUnitId=").append(bookUnitId);
        sb.append(", status=").append(status);
        sb.append(", declineReason='").append(declineReason).append('\'');
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", requestType=").append(requestType);
        sb.append('}');
        return sb.toString();
    }
}
