package com.vaibhav.Agora.Mapper;

import com.vaibhav.Agora.DTOEntities.BookDTO;
import com.vaibhav.Agora.Entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BookUnitMapper.class })
public interface BookMapper {

    @Mapping(target = "name", source = "name")
    Book BookDTOToBook(BookDTO bookDTO);

    BookDTO BookToBookDTO(Book book);
    List<Book> BookDTOsToBooks(List<BookDTO> bookDTO);
    List<BookDTO> BooksToBookDTOs(List<Book> book);

}
