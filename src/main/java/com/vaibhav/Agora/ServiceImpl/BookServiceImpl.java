package com.vaibhav.Agora.ServiceImpl;

import com.vaibhav.Agora.Common.Utils.StringUtilities;
import com.vaibhav.Agora.CustomRepositories.BookCustomRepository;
import com.vaibhav.Agora.DTOEntities.BookDTO;
import com.vaibhav.Agora.Entities.BookUnit;
import com.vaibhav.Agora.Mapper.BookMapper;
import com.vaibhav.Agora.Repositories.BookRepository;
import com.vaibhav.Agora.Entities.Book;
import com.vaibhav.Agora.Repositories.BookUnitRepository;
import com.vaibhav.Agora.RequestEntities.BookSearchRequest;
import com.vaibhav.Agora.Service.BookService;
import com.vaibhav.Agora.Service.NotificationService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static com.vaibhav.Agora.Common.Constants.Constants.FAILED_BOOKS;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookUnitRepository bookUnitRepository;

    @Autowired
    NotificationService notificationService;

    @Autowired
    private BookCustomRepository bookCustomRepository;

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<BookDTO> searchBook(BookSearchRequest bookSearchRequest) throws Exception {
        try {
            return bookCustomRepository.getBooks(bookSearchRequest);
        } catch (Exception e) {
            throw new Exception("Error while fetching data");
        }

    }

    private boolean isEmpty(String str) {
        return Objects.isNull(str) || Strings.isEmpty(str);
    }

    private boolean isValid(BookDTO book) {
        if (isEmpty(book.getTitle()) || Objects.nonNull(book.getGenre()) || Objects.nonNull(book.getLanguage()) || Objects.nonNull(book.getCategory())) {
            return false;
        }
        return true;
    }

    @Override
    public Map<String, List<Object>> addBooks(List<BookDTO> books) {

        Map<String, List<Object>> response = new HashMap<>();
        List<Object> failedBooks = new ArrayList<>();
        books.stream().forEach(bookDTO -> {
            try {
                isValid(bookDTO);
                Book book = bookMapper.BookDTOToBook(bookDTO);
               // saveBookUnits(bookDTO.getBookUnits(), response);
                bookRepository.save(bookMapper.BookDTOToBook(bookDTO));
            } catch (Exception e) {
                failedBooks.add(bookDTO);
            }
        });
        response.put(FAILED_BOOKS, failedBooks);
        return response;
    }

    private void saveBookUnits(Set<BookUnit> bookUnits, Map<String, List<Object>> failedObjects) {
        if(CollectionUtils.isEmpty(bookUnits)) {
            return;
        }
        List<Object> failedBookUnits = new ArrayList<>();
        bookUnits.stream().forEach(bookUnit -> {
            if (StringUtilities.isNotEmpty(bookUnit.getIsbn())) {
                bookUnitRepository.save(bookUnit);
            } else {
                failedBookUnits.add(bookUnit);
            }
        });
        failedObjects.put("failedBookUnits", failedBookUnits);
    }

    @Override
    public Page<Book> getAllBooks(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        notificationService.sendEmail("raghuvanshivibhu@gmail.com", "test", "Just checking email service");
        return bookRepository.findAll(pageable);
    }
}
