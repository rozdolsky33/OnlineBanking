package com.userfront.service;

import com.userfront.domain.User;
import com.userfront.domain.security.UserRole;

import java.util.Set;

public interface UserService {


    User findByUsername(String uername);

    User findByEmail(String email);

    boolean checkUserExists(String username, String email);

    boolean checkUsernameExists(String username);

    boolean checkEmailExists(String email);

    User createUser(User user, Set<UserRole>userRoles);

    User saveUser (User user);
}
