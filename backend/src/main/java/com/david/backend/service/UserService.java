package com.david.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.backend.dao.UserDao;
import com.david.backend.entity.User;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User registerNewUser(User user) {
        return userDao.save(user);
    }
}
