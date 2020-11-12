package com.vaibhav.Agora.Repositories;

import com.vaibhav.Agora.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
