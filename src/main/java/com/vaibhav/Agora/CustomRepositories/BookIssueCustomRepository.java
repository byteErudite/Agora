package com.vaibhav.Agora.CustomRepositories;

import com.vaibhav.Agora.DTOEntities.IssuesReport;
import com.vaibhav.Agora.DTOEntities.UserIssueReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class BookIssueCustomRepository {

    @Autowired
    BasicCustomRepository basicCustomRepository;

    private String USER_ISSUE_DETAIL_REPORT_SELECT_QUERY = "select distinct new UserIssueReport (" +
            " u.userId as userId" +
            " ud.name as name" +
            " ud.studentId as studentId" +
            " ud.department as department" +
            " now() as generatedOn ) ";

    private String USER_ISSUE_DETAIL_REPORT_FROM_QUERY = " from User u join UserDetail ud " +
            "on u.userId = ud.userId";

    private String ISSUE_DETAIL_SELECT_QUERY = "select distinct new IssueReport ( " +
            " b.bookId as bookId" +
            " b.title as bookName " +
            " bu.bookUnitId as bookUnitId " +
            " id.issueDate as issueDate " +
            " id.issuedTill as issuedTill " +
            " id.returnDate as returnDate";
    private String ISSUE_DETAIL_FROM_QUERY = "from book b join b.bookUnits bu" +
            " join IssueDetail id on bu.bookUnitId = id.bookUnitId ";


    public List<UserIssueReport> getUserIssueReport(UUID userId, Timestamp startDate, Timestamp endDate) {
        Map<String, Object> parameters = getParametersForUserDetailReport(userId, startDate, endDate);
        String whereQuery = "where id.issueDate > startDate and id.issueDate < endDate";
        return basicCustomRepository.getQueryResult(USER_ISSUE_DETAIL_REPORT_SELECT_QUERY +
                USER_ISSUE_DETAIL_REPORT_FROM_QUERY + whereQuery, parameters, 1, 100, UserIssueReport.class);
    }

    private Map<String, Object> getParametersForUserDetailReport(UUID userId, Timestamp startDate, Timestamp endDate) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("userId", userId);
        parameters.put("startDate", startDate);
        parameters.put("endDate", endDate);
        return parameters;
    }

    public List<IssuesReport> getIssueReportForUser(UUID userId, Timestamp startDate, Timestamp endDate) {
        Map<String, Object> parameters = getParametersForUserDetailReport(userId, startDate, endDate);
        String whereQuery = "where id.issueDate > :startDate and id.issueDate < :endDate and u.userId = :userId ";
        return basicCustomRepository.getQueryResult(ISSUE_DETAIL_SELECT_QUERY +
                ISSUE_DETAIL_FROM_QUERY + whereQuery, parameters, 1, 100, IssuesReport.class);
    }

}
