package com.vaibhav.Agora.ServiceImpl;

import com.vaibhav.Agora.DTOEntities.BookUnitDTO;
import com.vaibhav.Agora.Entities.Book;
import com.vaibhav.Agora.Mapper.BookUnitMapper;
import com.vaibhav.Agora.Repositories.BookRepository;
import com.vaibhav.Agora.Repositories.BookUnitRepository;
import com.vaibhav.Agora.Service.BookUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookUnitServiceImpl implements BookUnitService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookUnitRepository bookUnitRepository;

    @Autowired
    BookUnitMapper bookUnitMapper;

    @Override
    public Map<Object, String> addBookUnits(List<BookUnitDTO> books) throws Exception {
        if (CollectionUtils.isEmpty(books)) {
            throw new Exception("Empty request to add book units");
        }
        Map<Object, String> failedUnits = new HashMap<>();
        books.stream().forEach(bookUnit -> {
            if (Objects.isNull(bookUnit.getBookId())) {
                failedUnits.put(bookUnit, "Book id is null");
            } else {
                Optional<Book> book = bookRepository.findById(bookUnit.getBookId());
                if (!book.isPresent()) {
                    failedUnits.put(bookUnit, "Invalid book id");
                } else {
                    bookUnitRepository.save(bookUnitMapper.BookUnitDTOToBookUnit(bookUnit));
                }
            }

        });
        return failedUnits;
    }
}
