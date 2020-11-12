package com.vaibhav.Agora.ServiceImpl;

import com.vaibhav.Agora.DTOEntities.BookDTO;
import com.vaibhav.Agora.Mapper.BookMapper;
import com.vaibhav.Agora.Repositories.BookRepository;
import com.vaibhav.Agora.Entities.Book;
import com.vaibhav.Agora.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.vaibhav.Agora.Common.Constants.Constants.FAILED_BOOK_IDS;
import static com.vaibhav.Agora.Common.Constants.Constants.FAILURE;
import static com.vaibhav.Agora.Common.Constants.Constants.MESSAGE;
import static com.vaibhav.Agora.Common.Constants.Constants.SUCCESS;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    BookMapper bookMapper;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    private void validateBooks(List<Book> books) {
        for (Book book : books) {

        }
    }

    @Override
    public Map<String,String> addBooks(List<BookDTO> books) {
        List<String> failedBooks = new ArrayList<>();
        Map<String,String> response = new HashMap<>();
        books.stream().forEach(bookDTO -> {
            try {
                bookRepository.save(bookMapper.BookDTOToBookMapper(bookDTO));
            } catch (Exception e) {
               failedBooks.add(bookDTO.getBookId().toString());
            }
        });
        response.put(FAILED_BOOK_IDS, failedBooks.toString());
        return response;
    }
}
