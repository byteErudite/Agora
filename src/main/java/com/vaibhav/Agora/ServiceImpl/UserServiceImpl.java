package com.vaibhav.Agora.ServiceImpl;

import com.vaibhav.Agora.Common.Constants.AssignedRole;
import com.vaibhav.Agora.Common.Utils.Utilities;
import com.vaibhav.Agora.Entities.Role;
import com.vaibhav.Agora.Entities.User;
import com.vaibhav.Agora.Entities.UserRole;
import com.vaibhav.Agora.Repositories.RoleRepository;
import com.vaibhav.Agora.Repositories.UserRepository;
import com.vaibhav.Agora.Repositories.UserRoleRepository;
import com.vaibhav.Agora.Service.UserService;
import com.vaibhav.Agora.security.AgoraUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public String addUser(User user) {
        isAdminUser();
        try {
            userRepository.save(user);
            return "Successfully created user";
        } catch (Exception e) {
           return "Invalid user info: "+user.toString();
        }
    }

    @Override
    public String removeUser(UUID userId) {
        isAdminUser();
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            return "Invalid userId: "+userId;
        }
        User removeUser = user.get();
        try {
            userRepository.delete(removeUser);
            return "Successfully removed User: "+removeUser.getUsername();
        } catch (Exception e) {
            return "Invalid user info: "+user.toString();
        }
    }

    private boolean isAdminUser() {
        AgoraUserDetail loggedInUser = (AgoraUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(loggedInUser.getUsername());
        List<UserRole> userRoles = userRoleRepository.getUserRolebyUserId(user.getUserId());
        if (Utilities.isNotEmpty(userRoles)) {
            return roleRepository.findAllById(userRoles.stream()
                    .map(UserRole::getRoleId).collect(Collectors.toList()))
                        .stream().map(Role::getRole).collect(Collectors.toSet()).contains(AssignedRole.ADMIN);
        }
        return false;
    }

    private boolean isSameUser(UUID userId) {
        AgoraUserDetail loggedInUser = (AgoraUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(loggedInUser.getUsername());
        return user.getUserId().equals(userId);
    }

    @Override
    public User retrieveUser(UUID userId) throws Exception {
        if(isSameUser(userId) || isAdminUser()) {
            Optional<User> user = userRepository.findById(userId);
            if (!user.isPresent()) {
                throw new Exception("Invalid userId: "+userId);
            }
            return user.get();
        } else {
            return null;
        }
    }

    @Override
    public String updateUserRoles(List<UserRole> userRoles) {
       if(isAdminUser()) {
           userRoles.stream().forEach(userRole -> {
               if(Objects.nonNull(userRole.getRoleId()) && Objects.nonNull(userRole.getUserId())) {
                   userRoleRepository.save(new UserRole(userRole.getUserId(), userRole.getRoleId()));
               }
           });
       }
       return "success";
    }
}
