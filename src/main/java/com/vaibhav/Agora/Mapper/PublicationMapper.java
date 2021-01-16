package com.vaibhav.Agora.Mapper;

import com.vaibhav.Agora.DTOEntities.PublicationDTO;
import com.vaibhav.Agora.Entities.Publication;
import org.mapstruct.Mapper;

@Mapper
public interface PublicationMapper {
    public Publication PublicationDTOToPublicationMapper(PublicationDTO publicationDTO);
}
