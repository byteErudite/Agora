package com.vaibhav.Agora.ServiceImpl;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPTable;
import com.vaibhav.Agora.CustomRepositories.BookIssueCustomRepository;
import com.vaibhav.Agora.DTOEntities.IssuesReport;
import com.vaibhav.Agora.RequestEntities.IssueHistoryReportRequest;
import com.vaibhav.Agora.Service.ReportService;
import com.vaibhav.Agora.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    BookIssueCustomRepository bookIssueCustomRepository;

    @Autowired
    UserService userService;

    @Override
    public String generateIssueReport(IssueHistoryReportRequest issueHistoryReportRequest) throws Exception {
       if(Objects.isNull(issueHistoryReportRequest.getStartDate()) ||
               Objects.isNull(issueHistoryReportRequest.getStartDate())) {
           return "unsuccesful";
       }
       if (!userService.getPricipalUser().getUserId().equals(issueHistoryReportRequest.getUserId()) &&
        !userService.isAdminUser()){
           throw new Exception("not authorized to get the report");
       }
       List<IssuesReport> issuesReports = bookIssueCustomRepository.getIssueReportForUser(issueHistoryReportRequest.getUserId(),
               issueHistoryReportRequest.getStartDate(), issueHistoryReportRequest.getEndDate());
       return  "sucess";
    }

    private void generatePdfReport() {
        Document document = new Document();
        document.addCreationDate();
        document.addTitle("IssueDetailReport");
        PdfPTable table = new PdfPTable(5);
        Font.FontFamily font = Font.FontFamily.HELVETICA;

    }
}
