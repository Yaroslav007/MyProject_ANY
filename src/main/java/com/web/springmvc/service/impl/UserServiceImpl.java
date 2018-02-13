package com.web.springmvc.service.impl;

import com.web.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.web.springmvc.dao.UserDAO;
import com.web.springmvc.entity.User;

import java.util.List;

@Service
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

    @Override
    public User findOne(int id) {
        return userDAO.findOne(id);
    }

    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }
}
