package com.vaibhav.Agora.Service;

import com.vaibhav.Agora.DTOEntities.BookUnitDTO;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface BookUnitService {

    Map<Object, String> addBookUnits(List<BookUnitDTO> books) throws Exception;


}
