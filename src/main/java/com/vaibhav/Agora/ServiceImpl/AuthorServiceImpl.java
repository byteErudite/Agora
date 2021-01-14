package com.vaibhav.Agora.ServiceImpl;

import com.vaibhav.Agora.Common.Utils.StringUtilities;
import com.vaibhav.Agora.Entities.Author;
import com.vaibhav.Agora.Repositories.AuthorRepository;
import com.vaibhav.Agora.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorServiceImpl implements AuthorService {

   

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    EntityManager entityManager;

    public List<Author> getAllAuthors(String name, String penName) {
        List<Author> authors;
        if(StringUtilities.isNotEmpty(name) && StringUtilities.isNotEmpty(penName)) {
            return authorRepository.getAuthorsByNameAndPenName(name, penName);
        } else if(StringUtilities.isNotEmpty(name)) {
            return authorRepository.getAuthorsByName(name);
        } else if(StringUtilities.isNotEmpty(penName)) {
            return authorRepository.getAuthorsByPenName(penName);
        }

        return authorRepository.findAll();
    }

    public Author getAuthorById(UUID authorId) throws Exception {
        Optional<Author> author = authorRepository.findById(authorId);
        if(!author.isPresent()) {
            throw new Exception("Invalid author id");
        }
        return author.get();
    }

    public String createAuthor(Author author) throws Exception {
        if(Objects.isNull(author) || Objects.isNull(author.getName())){
            throw new Exception("Invalid request, name cannot be null");
        }
        Author newAuthor = new Author(author.getName(), author.getPenName());
        Author id = authorRepository.save(newAuthor);
        return "author created with id: "+author.getAuthorId();
    }
}
