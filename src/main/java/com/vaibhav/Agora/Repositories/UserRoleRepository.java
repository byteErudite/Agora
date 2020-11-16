package com.vaibhav.Agora.Repositories;

import com.vaibhav.Agora.Entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {
    @Query(value = "select roleId from UserRole where userId = :userId ")
    public List<UUID> getUserRolebyUserId(UUID userId);

}
