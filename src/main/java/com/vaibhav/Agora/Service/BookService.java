package com.vaibhav.Agora.Service;

import com.vaibhav.Agora.Entities.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface BookService {

    public List<Book> getAllBooks();

    public ResponseEntity<Map<String, String>> insertBooks();

}
