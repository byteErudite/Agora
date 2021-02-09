package com.vaibhav.Agora.Service;

import com.vaibhav.Agora.DTOEntities.IssuesReport;
import com.vaibhav.Agora.RequestEntities.IssueHistoryReportRequest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface ReportService {

    public String generateIssueReport(IssueHistoryReportRequest issueHistoryReportRequest) throws Exception;

    public InputStream generatePdfReport(List<IssuesReport> issuesReports) throws IOException;
}
