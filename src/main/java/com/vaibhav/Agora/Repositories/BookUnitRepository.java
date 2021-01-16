package com.vaibhav.Agora.Repositories;

import com.vaibhav.Agora.Entities.BookUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookUnitRepository extends JpaRepository<BookUnit, UUID> {
}
