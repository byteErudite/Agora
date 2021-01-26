package com.vaibhav.Agora.Mapper;

import com.vaibhav.Agora.DTOEntities.BookDTO;
import com.vaibhav.Agora.Entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookMapperServiceImpl implements BookMapper{
    @Override
    public Book BookDTOToBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setBookId(bookDTO.getBookId());
        book.setCategory(bookDTO.getCategory());
        book.setGenre(bookDTO.getGenre());
        book.setAuthorId(bookDTO.getAuthorId());
        book.setLanguage(bookDTO.getLanguage());
        book.setTitle(bookDTO.getTitle());
        book.setPublicationId(bookDTO.getPublicationId());
        book.setEdition(bookDTO.getEdition());
        return book;
    }

    @Override
    public BookDTO BookToBookDTO(Book book) {
        return null;
    }

    @Override
    public List<Book> BookDTOsToBooks(List<BookDTO> bookDTO) {
        return null;
    }

    @Override
    public List<BookDTO> BooksToBookDTOs(List<Book> book) {
        return null;
    }
}
