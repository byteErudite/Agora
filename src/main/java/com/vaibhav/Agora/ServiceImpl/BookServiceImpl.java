package com.vaibhav.Agora.ServiceImpl;

import com.vaibhav.Agora.BookRepository;
import com.vaibhav.Agora.Entities.Book;
import com.vaibhav.Agora.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public ResponseEntity<Map<String, String>> insertBooks() {
        return null;
    }

    private void validateBooks() {

    }
}
