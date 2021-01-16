package com.vaibhav.Agora.Mapper;

import com.vaibhav.Agora.DTOEntities.BookUnitDTO;
import com.vaibhav.Agora.Entities.BookUnit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { })
public interface BookUnitMapper {
    public BookUnit BookUnitDTOToBookUnit(BookUnitDTO bookUnitDTO);
}


