package com.vaibhav.Agora.Repositories;

import com.vaibhav.Agora.Entities.IssueDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface IssueDetailRepository extends JpaRepository<IssueDetail, UUID> {

    @Query("Select id from IssueDetail id where id.userId = :userId and id.bookUnitId in (:bookUnitIds) ")
    public List<IssueDetail> findIssueDetailByUserAndBookUnit(UUID userId, List<UUID> bookUnitIds);

}
