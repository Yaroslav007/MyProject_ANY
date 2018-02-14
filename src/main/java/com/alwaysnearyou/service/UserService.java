package com.alwaysnearyou.service;

import com.alwaysnearyou.entity.User;
import java.util.List;

public interface UserService {

    void save(User user);

    List<User> findAll();

    User getOne(int id);

    void delete(User user);
}
