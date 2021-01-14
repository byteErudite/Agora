package com.vaibhav.Agora.Service;

import com.vaibhav.Agora.DTOEntities.BookDTO;
import com.vaibhav.Agora.Entities.Book;
import com.vaibhav.Agora.RequestEntities.BookSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface BookService {

    public List<BookDTO> searchBook(BookSearchRequest bookSearchRequest) throws Exception;

    public Map<String, String> addBooks(List<BookDTO> books);

    public List<Book> getAllBooks();

}
