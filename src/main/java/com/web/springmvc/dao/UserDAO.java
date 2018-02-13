package com.web.springmvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.web.springmvc.entity.User;

public interface UserDAO extends JpaRepository<User, Integer>{

}
