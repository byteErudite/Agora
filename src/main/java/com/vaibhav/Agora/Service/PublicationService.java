package com.vaibhav.Agora.Service;

import com.vaibhav.Agora.DTOEntities.PublicationDTO;
import com.vaibhav.Agora.Entities.Publication;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PublicationService {

    public Page<Publication> getAllPublications(int pageNo, int pageSize);

    public Page<Publication> searchPublication(String name);

    public List<PublicationDTO> addPublication(List<PublicationDTO> publicationDTOs);
}
