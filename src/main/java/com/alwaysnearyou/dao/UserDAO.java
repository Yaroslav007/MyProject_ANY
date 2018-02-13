package com.alwaysnearyou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alwaysnearyou.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Integer>{
        
}
