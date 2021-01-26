package com.vaibhav.Agora.Mapper;

import com.vaibhav.Agora.DTOEntities.BookUnitDTO;
import com.vaibhav.Agora.Entities.BookUnit;
import org.springframework.stereotype.Service;

@Service
public class BookUnitMapperImpl implements BookUnitMapper {

    @Override
    public BookUnit BookUnitDTOToBookUnit(BookUnitDTO bookUnitDTO) {
        BookUnit bookUnit = new BookUnit();
        bookUnit.setAvailable(bookUnitDTO.getAvailable());
        bookUnit.setBookId(bookUnitDTO.getBookId());
        bookUnit.setIsbn(bookUnitDTO.getIsbn());
        bookUnit.setReserved(bookUnitDTO.getReserved());
        return bookUnit;
    }
}
