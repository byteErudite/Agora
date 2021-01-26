package com.vaibhav.Agora.Service;

import com.vaibhav.Agora.RequestEntities.IssueHistoryReportRequest;

public interface ReportService {

    public String generateIssueReport(IssueHistoryReportRequest issueHistoryReportRequest) throws Exception;
}
