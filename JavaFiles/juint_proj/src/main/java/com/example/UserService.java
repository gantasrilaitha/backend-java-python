package com.example;

import com.example.UserDao;

public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserService() {

    }

    public String getNameById(Integer id) {
        return userDao.findNameById(id);
    }

    public String getEmailById(Integer id) {
        return userDao.findEmailById(id);
    }
}
