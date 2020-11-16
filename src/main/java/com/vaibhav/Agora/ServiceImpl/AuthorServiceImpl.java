package com.vaibhav.Agora.ServiceImpl;

import com.vaibhav.Agora.Entities.Author;
import com.vaibhav.Agora.Repositories.AuthorRepository;
import com.vaibhav.Agora.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
