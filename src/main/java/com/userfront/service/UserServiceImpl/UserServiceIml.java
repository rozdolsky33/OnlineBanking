package com.userfront.service.UserServiceImpl;


import com.userfront.Dao.UserDao;
import com.userfront.domain.User;
import com.userfront.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIml implements UserService {

    @Autowired
    private UserDao userDao;

    public void save (User user) {
        userDao.save(user);
    }


    public User findByUsername(String username) {
        return userDao.findByUsername(username);

    }

    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public boolean checkUserExists(String username, String email) {
        if(checkUsernameExists(username) || checkEmailExists(email)) {
            return true;
        }else {
            return false;
        }
    }
    public boolean checkUsernameExists(String username) {
        if(null != findByUsername(username)) {

            return true;
        }
        return false;
    }

    public boolean checkEmailExists(String email) {
        if( null != findByEmail(email)) {
            return true;
        }
        return false;
    }
}
