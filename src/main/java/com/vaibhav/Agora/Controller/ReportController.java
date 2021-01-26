package com.vaibhav.Agora.Controller;

import com.vaibhav.Agora.RequestEntities.IssueHistoryReportRequest;
import com.vaibhav.Agora.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.vaibhav.Agora.Common.Constants.Constants.ALL;
import static com.vaibhav.Agora.Common.Constants.Constants.FORWARD_SLASH;
import static com.vaibhav.Agora.Common.Constants.Constants.PUBLICATION;

@RestController
@RequestMapping(value = "report")
public class ReportController {

    @Autowired
    ReportService reportService;

    @GetMapping(value = FORWARD_SLASH + "issueDetailReport", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> getAllPublications(@RequestBody IssueHistoryReportRequest issueHistoryReportRequest) throws Exception {
        return new ResponseEntity(reportService.generateIssueReport(issueHistoryReportRequest), HttpStatus.OK);
    }
}
