package com.vaibhav.Agora.ServiceImpl;

import com.vaibhav.Agora.Common.Utils.StringUtilities;
import com.vaibhav.Agora.DTOEntities.PublicationDTO;
import com.vaibhav.Agora.Entities.Publication;
import com.vaibhav.Agora.Mapper.PublicationMapper;
import com.vaibhav.Agora.Repositories.PublicationRepository;
import com.vaibhav.Agora.Service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PublicationServiceImpl implements PublicationService {
    @Autowired
    PublicationRepository publicationRepository;

    @Autowired
    PublicationMapper publicationMapper;

    @Override
    public Page<Publication> getAllPublications(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return publicationRepository.findAll(pageable);
    }

    @Override
    public Page<Publication> searchPublication(String name) {
        return null;
    }

    @Override
    public List<PublicationDTO> addPublication(List<PublicationDTO> publicationDTOs) {
        List<PublicationDTO> failedEntities = new ArrayList<>();
        publicationDTOs.stream().forEach(publicationDTO -> {
            try {
                if (Objects.nonNull(publicationDTO) && StringUtilities.isNotEmpty(publicationDTO.getName())) {
                    publicationRepository.save(publicationMapper.PublicationDTOToPublicationMapper(publicationDTO));
                }
            } catch (Exception e) {
                failedEntities.add(publicationDTO);
            }
        });
        return failedEntities;
    }

}
