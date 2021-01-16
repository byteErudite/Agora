package com.vaibhav.Agora.Controller;

import com.vaibhav.Agora.DTOEntities.BookDTO;
import com.vaibhav.Agora.DTOEntities.PublicationDTO;
import com.vaibhav.Agora.Entities.Publication;
import com.vaibhav.Agora.Service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.vaibhav.Agora.Common.Constants.Constants.ADD;
import static com.vaibhav.Agora.Common.Constants.Constants.ALL;
import static com.vaibhav.Agora.Common.Constants.Constants.FORWARD_SLASH;
import static com.vaibhav.Agora.Common.Constants.Constants.PUBLICATION;

@RestController
@RequestMapping(value = PUBLICATION)
public class PublicationController {

    @Autowired
    PublicationService publicationService;

    @GetMapping(value = FORWARD_SLASH + ALL, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> getAllPublications(@RequestParam(required = false, defaultValue = "1") final Integer pageNo,
                                                     @RequestParam(required = false, defaultValue = "20") final Integer pageSize) {
        return new ResponseEntity(publicationService.getAllPublications(pageNo, pageSize), HttpStatus.OK);
    }

    @PostMapping(value = FORWARD_SLASH + ADD, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> addPublication(@RequestBody final List<PublicationDTO> publicationDTOs) {
        return new ResponseEntity(Map.of("failedEntities", publicationService.addPublication(publicationDTOs)), HttpStatus.OK);
    }
}
