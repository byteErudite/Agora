package com.vaibhav.Agora.Service;

import com.vaibhav.Agora.DTOEntities.DeclineIssueRequestDTO;
import com.vaibhav.Agora.RequestEntities.BookIssueRequest;

import java.util.List;
import java.util.UUID;

public interface IssueService {

    public void raiseIssueRequest(BookIssueRequest bookIssueRequest) throws Exception;

    public List<UUID> approveBookIssueRequests(List<UUID> issueRequestIds) throws Exception;

    public void declineBookIssueRequest(List<DeclineIssueRequestDTO> declineIssueRequestDTOS) throws Exception;

    public void raiseReturnRequest(List<UUID> bookUnitIds) throws Exception;
}
