package com.vaibhav.Agora.Mapper;

import com.vaibhav.Agora.DTOEntities.PublicationDTO;
import com.vaibhav.Agora.Entities.Publication;
import org.springframework.stereotype.Service;

@Service
public class PublicationMapperImpl implements PublicationMapper{
    public Publication PublicationDTOToPublicationMapper(PublicationDTO publicationDTO) {
        Publication publication = new Publication();
        publication.setName(publicationDTO.getName());
        publication.setContact(publicationDTO.getContact());
        publication.setEmail(publicationDTO.getEmail());
        publication.setMobileNumber(publicationDTO.getMobileNumber());
        return publication;
    }
}
