package com.vaibhav.Agora.CustomRepositories;

import com.vaibhav.Agora.Common.Utils.Utilities;
import com.vaibhav.Agora.DTOEntities.SearchIssueRequestDTO;
import com.vaibhav.Agora.Entities.IssueRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Component
public class IssueCustomRepository {

    @Autowired
    BasicCustomRepository basicCustomRepository;

    private final String BOOK_ISSUE_REQUEST_SEARCH_QUERY = " select disticnt new IssueRequest(" +
            "ir.issueRequestId as issueRequestId, " +
            "ir.userId as userId, " +
            "ir.bookUnitId as bookUnitId, " +
            "ir.status as status, " +
            "ir.declineReason as declineReason, " +
            "ir.comment as comment, " +
            "ir.requestType as requestType ";

    private final String BOOK_ISSUE_REQUEST_FROM_QUERY = "From IssueRequest ir ";

    public List<IssueRequest> getIssueRequests(SearchIssueRequestDTO searchRequest) {
        Map<String, Object> parameters = new HashMap<>();
        String whereQuery = getWhereQueryForIssueSearch(searchRequest, parameters);
        return basicCustomRepository.getQueryResult(BOOK_ISSUE_REQUEST_SEARCH_QUERY +
                BOOK_ISSUE_REQUEST_FROM_QUERY + whereQuery, parameters, 1, 100, IssueRequest.class);
    }

    private String getWhereQueryForIssueSearch(SearchIssueRequestDTO searchRequest, Map<String, Object> parameters) {
        StringBuilder whereQuery = new StringBuilder(" where ");

        if (Utilities.isNotEmpty(searchRequest.getBookUnitIds())) {
            parameters.put("bookUnitIds", searchRequest.getBookUnitIds());
            whereQuery.append(" bookUnitId in (:bookUnitIds) and ");
        }

        if (Utilities.isNotEmpty(searchRequest.getUserIds())) {
            parameters.put("userIds", searchRequest.getUserIds());
            whereQuery.append(" userId in (:userIds) and ");
        }

        if (Utilities.isNotEmpty(searchRequest.getRequestTypes())) {
            parameters.put("requestTypes", searchRequest.getRequestTypes());
            whereQuery.append(" requestType in (:requestTypes) and ");
        }

        if (Utilities.isNotEmpty(searchRequest.getStatuses())) {
            parameters.put("statuses", searchRequest.getStatuses());
            whereQuery.append(" status in (:statuses) and ");
        }

        if (whereQuery.length() < 8) {
            return " ";
        }
        return whereQuery.substring(0, whereQuery.length() - 4);
    }
}
