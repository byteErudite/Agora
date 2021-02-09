package com.vaibhav.Agora.Controller;

import com.vaibhav.Agora.RequestEntities.BookIssueRequest;
import com.vaibhav.Agora.Service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static com.vaibhav.Agora.Common.Constants.Constants.ISSUE;


@RestController
@RequestMapping(value = ISSUE)
public class IssueController {

    @Autowired
    IssueService issueService;

    @PostMapping()
    public ResponseEntity<String> issueBook(@RequestBody BookIssueRequest bookIssueRequest) throws Exception {
        issueService.raiseIssueRequest(bookIssueRequest);
        return new ResponseEntity<>("sucess", HttpStatus.OK);
    }

    @PostMapping(value = "/return")
    public ResponseEntity<String> returnBook(@RequestBody List<UUID> bookUnitIds) throws Exception {
       issueService.raiseReturnRequest(bookUnitIds);
        return new ResponseEntity<>("sucess", HttpStatus.OK);
    }

}
