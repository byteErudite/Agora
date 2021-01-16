package com.vaibhav.Agora.security;

import com.vaibhav.Agora.Entities.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;
import java.util.UUID;

public class EntityAuditing implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Object user =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AgoraUserDetail currentUser = (AgoraUserDetail)(user);
        return Optional.of(currentUser.getUsername());
    }
}
