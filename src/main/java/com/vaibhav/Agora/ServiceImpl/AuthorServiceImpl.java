package com.vaibhav.Agora.ServiceImpl;

import com.vaibhav.Agora.Entities.Author;
import com.vaibhav.Agora.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthorServiceImpl {
    @Autowired
    AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
