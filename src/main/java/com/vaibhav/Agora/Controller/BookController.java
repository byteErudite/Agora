package com.vaibhav.Agora.Controller;

import com.vaibhav.Agora.DTOEntities.BookDTO;
import com.vaibhav.Agora.Entities.Book;
import com.vaibhav.Agora.RequestEntities.BookSearchRequest;
import com.vaibhav.Agora.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.SpelQueryContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.DiscriminatorColumn;
import java.util.List;



import static com.vaibhav.Agora.Common.Constants.Constants.ADD;
import static com.vaibhav.Agora.Common.Constants.Constants.ALL;
import static com.vaibhav.Agora.Common.Constants.Constants.BOOK;
import static com.vaibhav.Agora.Common.Constants.Constants.FORWARD_SLASH;

@RestController
@RequestMapping(value = BOOK)
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping(value = FORWARD_SLASH + ALL)
    public ResponseEntity<List<BookDTO>> getAllBooks(@RequestBody BookSearchRequest bookSearchRequest,
                                                     @RequestParam(required = false, defaultValue = "5") final Integer page,
                                                     @RequestParam(required = false, defaultValue = "50") final Integer size) throws Exception {
        return new ResponseEntity<>(bookService.getAllBooks(bookSearchRequest), HttpStatus.OK);
    }

    @PostMapping(value = FORWARD_SLASH + ADD, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> addBook(@RequestBody final List<BookDTO> books) {
        return new ResponseEntity(bookService.addBooks(books), HttpStatus.OK);
    }
}
