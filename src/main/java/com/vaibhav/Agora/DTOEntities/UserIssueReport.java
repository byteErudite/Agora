package com.vaibhav.Agora.DTOEntities;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public class UserIssueReport {
    private UUID userId;
    private String name;
    private String studentId;
    private String department;
    private Date generatedOn;
    private List<IssuesReport> issueHistory;

    public UserIssueReport() {
    }

    public UserIssueReport(UUID userId, String name, String studentId, String department, Date generatedOn, List<IssuesReport> issueHistory) {
        this.userId = userId;
        this.name = name;
        this.studentId = studentId;
        this.department = department;
        this.generatedOn = generatedOn;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getGeneratedOn() {
        return generatedOn;
    }

    public void setGeneratedOn(Date generatedOn) {
        this.generatedOn = generatedOn;
    }

    public List<IssuesReport> getIssueHistory() {
        return issueHistory;
    }

    public void setIssueHistory(List<IssuesReport> issueHistory) {
        this.issueHistory = issueHistory;
    }
}
