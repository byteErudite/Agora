package com.vaibhav.Agora.Repositories;

import com.vaibhav.Agora.Entities.Author;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public interface AuthorRepository extends JpaRepository<Author, UUID> {

    @Query("Select a from Author a ")
    public List<Author> findAll(EntityGraph entityGraph);

    @Query("Select a from Author a where a.name = :name and a.penName = :penName")
    public List<Author> getAuthorsByNameAndPenName(@Param("name") String name, @Param("penName") String penName);

    @Query("Select a from Author a where a.name = :name")
    public List<Author> getAuthorsByName(@Param("name")String name);

    @Query("Select a from Author a where a.penName = :penName")
    public List<Author> getAuthorsByPenName(@Param("penName")String penName);
}
