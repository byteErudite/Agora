package com.vaibhav.Agora.Service;

import com.vaibhav.Agora.RequestEntities.BookIssueRequest;

import java.util.List;

public interface IssueService {

    public List<String> issueBook(BookIssueRequest bookIssueRequest) throws Exception;

    public String returnBook(BookIssueRequest bookIssueRequest) throws Exception;
}
