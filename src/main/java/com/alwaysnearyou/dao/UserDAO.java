package com.alwaysnearyou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alwaysnearyou.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>{

    @Query("select u from User u where u.email like %?1 and u.password like %?2")
    User findUserByEmailAndPassword(String email, String password);
        
}
