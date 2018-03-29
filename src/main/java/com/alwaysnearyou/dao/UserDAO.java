package com.alwaysnearyou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alwaysnearyou.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>{

    @Query("select u from User u where u.email like %?1 and u.password like %?2")
    User findUserByEmailAndPassword(String email, String password);

    @Query("select u from User u where (u.name like %?1 or u.name like %?2) and " +
            "( u.surname like %?2 or u.surname like %?1)")
    List<User> findUserByNameAndSurname(String name, String surname);

    @Query("select u from User u where u.id = :userId")
    User findUserById(@Param("userId") Integer userId);
}
