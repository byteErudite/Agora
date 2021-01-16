package com.vaibhav.Agora.Repositories;

import com.vaibhav.Agora.Entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublicationRepository extends JpaRepository<Publication, UUID> {


}
