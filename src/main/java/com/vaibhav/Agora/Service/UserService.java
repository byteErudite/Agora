package com.vaibhav.Agora.Service;

import com.vaibhav.Agora.Entities.User;
import com.vaibhav.Agora.Entities.UserRole;

import java.util.List;
import java.util.UUID;

public interface UserService {

    public String addUser(User user);
    public String removeUser(UUID userId);
    public User retrieveUser(UUID userId) throws Exception;
    public String updateUserRoles(List<UserRole> userRoles);
}
