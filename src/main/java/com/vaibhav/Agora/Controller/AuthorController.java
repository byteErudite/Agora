package com.vaibhav.Agora.Controller;

import com.vaibhav.Agora.Entities.Author;
import com.vaibhav.Agora.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static com.vaibhav.Agora.Common.Constants.Constants.ALL;
import static com.vaibhav.Agora.Common.Constants.Constants.AUTHOR;
import static com.vaibhav.Agora.Common.Constants.Constants.BOOK;
import static com.vaibhav.Agora.Common.Constants.Constants.CREATE;
import static com.vaibhav.Agora.Common.Constants.Constants.FORWARD_SLASH;
import static com.vaibhav.Agora.Common.Constants.Constants.SEARCH;

@RestController
@RequestMapping(value = AUTHOR)
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping(value = FORWARD_SLASH + SEARCH, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Author>> getAllAuthors(@RequestParam(required = false) String name,
                                                      @RequestParam(required = false) String penName ) {
        return new ResponseEntity<>(authorService.getAllAuthors(name, penName), HttpStatus.OK);
    }

    @GetMapping(value = FORWARD_SLASH + SEARCH + FORWARD_SLASH + "{authorId}")
    public ResponseEntity<Author> getByAuthorId(@PathVariable("authorId") UUID authorId) throws Exception {
        return new ResponseEntity<>(authorService.getAuthorById(authorId), HttpStatus.OK);
    }

    @PostMapping(value = FORWARD_SLASH + CREATE)
    public ResponseEntity<String> createAuthor(@RequestBody Author author) throws Exception {
        return new ResponseEntity<>(authorService.createAuthor(author), HttpStatus.OK);
    }
}
