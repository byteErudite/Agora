package com.vaibhav.Agora.ServiceImpl;

import com.vaibhav.Agora.Entities.BookUnit;
import com.vaibhav.Agora.Entities.IssueDetail;
import com.vaibhav.Agora.Repositories.BookUnitRepository;
import com.vaibhav.Agora.Repositories.IssueDetailRepository;
import com.vaibhav.Agora.RequestEntities.BookIssueRequest;
import com.vaibhav.Agora.Service.IssueService;
import com.vaibhav.Agora.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.vaibhav.Agora.Common.Constants.Constants.DEFAULT_ISSUE_PERIOD;

@Service
public class IssueServiceImpl implements IssueService {
    @Autowired
    BookUnitRepository bookUnitRepository;

    @Autowired
    IssueDetailRepository issueDetailRepository;

    @Autowired
    UserService userService;

    @Override
    public List<String> issueBook(BookIssueRequest bookIssueRequest) throws Exception {
        if (CollectionUtils.isEmpty(bookIssueRequest.getBookUnitIds())) {
            throw new Exception("Invalid book issue request");
        }

        List<UUID> bookUnitIds = bookUnitRepository.findAllById(bookIssueRequest.getBookUnitIds()).stream().
                filter(bookUnit -> bookUnit.getAvailable() && !bookUnit.getReserved()).
                map(BookUnit::getBookUnitId).collect(Collectors.toList());

        if (CollectionUtils.isEmpty(bookUnitIds)) {
            throw new Exception("Requested books not found");
        }
        Timestamp currentTime = Timestamp.from(Instant.now());
        Timestamp issuedTill = Timestamp.from(Instant.now().plusSeconds(DEFAULT_ISSUE_PERIOD * 60 * 60));
        UUID currentUserId = userService.getPricipalUser().getUserId();
        List<String> failedIssues = new ArrayList<>();
        bookUnitIds.stream().forEach(bookUnitId -> {
            try {
                IssueDetail issueDetail = new IssueDetail(bookUnitId, currentUserId,
                        currentTime, issuedTill, bookIssueRequest.getComment());
                issueDetailRepository.save(issueDetail);
            } catch (Exception e) {
                failedIssues.add(bookUnitId.toString());
            }
        });
        return failedIssues;
    }

    @Override
    public String returnBook(BookIssueRequest bookIssueRequest) throws Exception {
        if(CollectionUtils.isEmpty(bookIssueRequest.getBookUnitIds())) {
            throw new Exception("book units empty");
        }
        UUID currentUserId = userService.getPricipalUser().getUserId();
        List<IssueDetail> issueDetails = issueDetailRepository.findIssueDetailByUserAndBookUnit(currentUserId, bookIssueRequest.getBookUnitIds());
        issueDetails.stream().forEach(issue -> issue.setReturnDate(Timestamp.from(Instant.now())));
        issueDetailRepository.saveAll(issueDetails);
        return "success";
    }
}
