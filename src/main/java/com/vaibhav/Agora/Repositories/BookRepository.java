package com.vaibhav.Agora.Repositories;

import com.vaibhav.Agora.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, UUID> {

}
