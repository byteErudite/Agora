package com.vaibhav.Agora.Controller;

import com.vaibhav.Agora.Entities.Author;
import com.vaibhav.Agora.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.vaibhav.Agora.Common.Constants.Constants.ALL;
import static com.vaibhav.Agora.Common.Constants.Constants.AUTHOR;
import static com.vaibhav.Agora.Common.Constants.Constants.FORWARD_SLASH;

@RestController
@RequestMapping(value = AUTHOR)
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping(value = FORWARD_SLASH + ALL)
    public ResponseEntity<List<Author>> getAllAuthors() {
        return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.OK);
    }
}
