package com.alwaysnearyou.service.impl;

import com.alwaysnearyou.dao.UserDAO;
import com.alwaysnearyou.entity.User;
import com.alwaysnearyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public User getOne(int id) {
        return userDAO.getOne(id);
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        return userDAO.findUserByEmailAndPassword(email,password);
    }

    @Override
    public List<User> findUserByNameAndSurname(String name, String surname) {
        List<User> listUsers = userDAO.findUserByNameAndSurname(name, surname);
        return listUsers;
    }

    @Override
    public List<User> findAllFriends(int userId) {
        return getUserWithFriends(userId).getFriends();
    }
    @Override
    public List<User> findAllfriendsOff(int userId){
        return getUserWithFriends(userId).getFriendOf();
    }

    @Transactional
    @Override
    public User getUserWithFriends(int userId) {
        User user = userDAO.findUserById(userId);
        System.out.println("Found friends" + user.getFriends());
        System.out.println("Found friendof" + user.getFriendOf());
        return  user;
    }
}
