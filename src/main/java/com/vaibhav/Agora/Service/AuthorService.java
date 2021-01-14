package com.vaibhav.Agora.Service;

import com.vaibhav.Agora.Entities.Author;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    public List<Author> getAllAuthors(String name, String penName);

    public Author getAuthorById(UUID authorId) throws Exception;

    public String createAuthor(Author author) throws Exception;
}
