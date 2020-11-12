package com.vaibhav.Agora.Mapper;

import com.vaibhav.Agora.DTOEntities.BookDTO;
import com.vaibhav.Agora.Entities.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {

    Book BookDTOToBookMapper(BookDTO bookDTO);
    BookDTO BookToBookDTOMapper(Book book);
    List<Book> BookDTOsToBooksMapper(List<BookDTO> bookDTO);
    List<BookDTO> BooksToBookDTOsMapper(List<Book> book);

}
