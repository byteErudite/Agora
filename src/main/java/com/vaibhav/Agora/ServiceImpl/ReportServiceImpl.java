package com.vaibhav.Agora.ServiceImpl;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.vaibhav.Agora.CustomRepositories.BookIssueCustomRepository;
import com.vaibhav.Agora.DTOEntities.IssuesReport;
import com.vaibhav.Agora.RequestEntities.IssueHistoryReportRequest;
import com.vaibhav.Agora.Service.ReportService;
import com.vaibhav.Agora.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.time.Instant;
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

    public InputStream generatePdfReport(List<IssuesReport> issuesReports) {
        IssuesReport issuesReport = new IssuesReport();
        issuesReport.setBookName("harry potter");
        issuesReport.setIssueDate(Timestamp.from(Instant.now()));
        issuesReport.setIssuedTill(Timestamp.from(Instant.now()));
        issuesReport.setReturnDate(Timestamp.from(Instant.now()));
        issuesReports.add(issuesReport);

        InputStream is = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(byteArrayOutputStream));
        Document document = new Document(pdfDocument, PageSize.A4.rotate());

        float[] columnsAndWidth = { 200F, 150F, 150F, 150F, 150F };
        Table table = new Table(columnsAndWidth);
        addCell(table,"Book Name");
        addCell(table,"Issued On");
        addCell(table,"Returned On");
        addCell(table,"Issued Til");
        for(IssuesReport ir : issuesReports) {
            table.addCell(ir.getBookName());
            addCell(table, ir.getIssueDate().toString());
            addCell(table, ir.getReturnDate().toString());
            addCell(table, ir.getIssuedTill().toString());
        }
        document.add(table);
        document.close();
        is = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        return is;
    }

    private void addCell(Table t, String content){
        t.addCell(content);
    }
}