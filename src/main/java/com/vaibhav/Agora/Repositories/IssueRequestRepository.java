package com.vaibhav.Agora.Repositories;

import com.vaibhav.Agora.Entities.IssueRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface IssueRequestRepository extends JpaRepository<IssueRequest, UUID> {

    @Query("select ir from IssueRequest ir where ir.bookUnitId in (:bookUnitIds) ")
    public List<IssueRequest> findRequestsByBookUnitIds(List<UUID> bookUnitIds);

}
