package com.vaibhav.Agora.ServiceImpl;

import com.vaibhav.Agora.CustomRepositories.BookCustomRepository;
import com.vaibhav.Agora.DTOEntities.BookDTO;
import com.vaibhav.Agora.Mapper.BookMapper;
import com.vaibhav.Agora.Repositories.BookRepository;
import com.vaibhav.Agora.Entities.Book;
import com.vaibhav.Agora.RequestEntities.BookSearchRequest;
import com.vaibhav.Agora.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.vaibhav.Agora.Common.Constants.Constants.FAILED_BOOK_IDS;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    BookCustomRepository bookCustomRepository;

    BookMapper bookMapper;

    @Override
    public List<BookDTO> getAllBooks(BookSearchRequest bookSearchRequest) throws Exception {
        try {
            return bookCustomRepository.getBooks(bookSearchRequest);
        } catch(Exception e) {
            throw new Exception("Error while fetching data");
        }

    }


    private boolean isValid(BookDTO book) {
        return true;
    }

    @Override
    public Map<String,String> addBooks(List<BookDTO> books) {
        List<String> failedBooks = new ArrayList<>();
        Map<String,String> response = new HashMap<>();
        books.stream().forEach(bookDTO -> {
            try {
                isValid(bookDTO);
                bookRepository.save(bookMapper.BookDTOToBookMapper(bookDTO));
            } catch (Exception e) {
               failedBooks.add(bookDTO.getBookId().toString());
            }
        });
        response.put(FAILED_BOOK_IDS, failedBooks.toString());
        return response;
    }
}
