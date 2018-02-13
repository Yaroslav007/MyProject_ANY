package com.web.springmvc.service;

import com.web.springmvc.entity.User;

import java.util.List;

public interface UserService {

    void save(User user);

    List<User> findAll();

    User findOne(int id);

    void delete(int id);
}
