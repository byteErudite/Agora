package com.vaibhav.Agora.security;

import com.vaibhav.Agora.Common.Constants.AssignedRole;
import com.vaibhav.Agora.Entities.Role;
import com.vaibhav.Agora.Entities.User;
import com.vaibhav.Agora.Repositories.RoleRepository;
import com.vaibhav.Agora.Repositories.UserRepository;
import com.vaibhav.Agora.Repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AgoraUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("Invalid username : " + username);
        }
        List<UUID> roleIds = userRoleRepository.getUserRolebyUserId(user.getUserId());
        List<AssignedRole> roles = roleRepository.findAllById(roleIds).stream().map(Role::getRole).collect(Collectors.toList());
        return new AgoraUserDetail(user, roles);
    }
}
