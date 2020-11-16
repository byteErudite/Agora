package com.vaibhav.Agora.Repositories;

import com.vaibhav.Agora.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
@Transactional
public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
