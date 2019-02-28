package com.userfront.dao;

import com.userfront.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String user);
    User findByEmail(String email);
}
