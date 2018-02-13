package com.alwaysnearyou.service.impl;

import com.alwaysnearyou.dao.UserDAO;
import com.alwaysnearyou.entity.User;
import com.alwaysnearyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Override
    public void save(User user){
        if (!user.getName().isEmpty() && !user.getSurname().isEmpty()){
            userDAO.save(user);
        }
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    public User getOne(int id) {
        return userDAO.getOne(id);
    }

    @Override
    public void delete(int id) {
        userDAO.delete(new User(id));
    }
}
