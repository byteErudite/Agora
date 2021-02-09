package com.vaibhav.Agora.ServiceImpl;

import com.vaibhav.Agora.Common.Constants.IssueRequestType;
import com.vaibhav.Agora.Common.Constants.RequestStatus;
import com.vaibhav.Agora.CustomRepositories.IssueCustomRepository;
import com.vaibhav.Agora.DTOEntities.DeclineIssueRequestDTO;
import com.vaibhav.Agora.DTOEntities.SearchIssueRequestDTO;
import com.vaibhav.Agora.Entities.IssueDetail;
import com.vaibhav.Agora.Entities.IssueRequest;
import com.vaibhav.Agora.Repositories.BookUnitRepository;
import com.vaibhav.Agora.Repositories.IssueDetailRepository;
import com.vaibhav.Agora.Repositories.IssueRequestRepository;
import com.vaibhav.Agora.RequestEntities.BookIssueRequest;
import com.vaibhav.Agora.Service.IssueService;
import com.vaibhav.Agora.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    IssueRequestRepository issueRequestRepository;

    @Autowired
    IssueCustomRepository issueCustomRepository;

    @Autowired
    UserService userService;

    @Override
    public void raiseIssueRequest(BookIssueRequest bookIssueRequest) throws Exception {
        if (CollectionUtils.isEmpty(bookIssueRequest.getBookUnitIds())) {
            throw new Exception("Invalid book issue request");
        }
        UUID currentUserId = userService.getPricipalUser().getUserId();
        List<IssueRequest> requests = new ArrayList<>();
        bookIssueRequest.getBookUnitIds().stream().forEach(bookUnitId -> {
            requests.add(new IssueRequest(bookUnitId, currentUserId, bookIssueRequest.getComment(), IssueRequestType.ISSUE, RequestStatus.PENDING));
        });
        issueRequestRepository.saveAll(requests);
    }

    @Override
    public List<UUID> approveBookIssueRequests(List<UUID> issueRequestIds) throws Exception {
        if (!userService.isAdminUser()) {
            throw new Exception("Operation not allowed");
        }
        if (CollectionUtils.isEmpty(issueRequestIds)) {
            throw new Exception("Invalid issue requests");
        }
        List<IssueRequest> issueRequests = issueRequestRepository.findAllById(issueRequestIds);
        Timestamp currentTime = Timestamp.from(Instant.now());
        Timestamp issuedTill = Timestamp.from(Instant.now().plusSeconds(DEFAULT_ISSUE_PERIOD * 60 * 60));
        UUID currentUserId = userService.getPricipalUser().getUserId();
        List<UUID> failedRequests = new ArrayList<>();
        issueRequests.stream().forEach(request -> {
            try {
                request.setStatus(RequestStatus.APPROVED);
                IssueDetail issueDetail = new IssueDetail(request.getBookUnitId(), currentUserId,
                        currentTime, issuedTill, request.getComment());
                issueRequestRepository.save(request);
                issueDetailRepository.save(issueDetail);
            } catch (Exception e) {
                failedRequests.add(request.getIssueRequestId());
            }
        });
        return failedRequests;
    }

    @Override
    public void declineBookIssueRequest(List<DeclineIssueRequestDTO> declineIssueRequestDTOS) throws Exception {
        if (!userService.isAdminUser()) {
            throw new Exception("Operation not allowed");
        }
        List<UUID> declinationRequestIds = declineIssueRequestDTOS.stream().map(DeclineIssueRequestDTO::getIssueRequestId).collect(Collectors.toList());
        Map<UUID, String> declineReasonByRequestId = new HashMap<>();
        declineIssueRequestDTOS.stream().forEach(request -> declineReasonByRequestId.put(request.getIssueRequestId(), request.getDeclineReason()));
        List<IssueRequest> requests = issueRequestRepository.findAllById(declinationRequestIds);
        requests.stream().forEach(request -> {
            request.setStatus(RequestStatus.DECLINED);
            request.setDeclineReason(declineReasonByRequestId.get(request.getIssueRequestId()));
        });
        issueRequestRepository.saveAll(requests);
    }

    public List<IssueRequest> searchIssueRequest(SearchIssueRequestDTO searchRequest) throws Exception {
        try {
            return issueCustomRepository.getIssueRequests(searchRequest);
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public void processReturnRequests() {

    }

    @Override
    public void raiseReturnRequest(List<UUID> bookUnitIds) throws Exception {
        if (CollectionUtils.isEmpty(bookUnitIds)) {
            throw new Exception("book units empty");
        }
        List<IssueRequest> requests = new ArrayList<>();
        UUID currentUserId = userService.getPricipalUser().getUserId();
        bookUnitIds.stream().filter(Objects::nonNull).forEach(bookUnitId -> {
            requests.add(new IssueRequest(bookUnitId, currentUserId, null, IssueRequestType.RETURN, RequestStatus.PENDING));
        });
        issueRequestRepository.saveAll(requests);
    }
}
