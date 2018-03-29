package com.alwaysnearyou.dao;

import com.alwaysnearyou.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomDao extends JpaRepository<Room, Integer> {

    @Query("select r from Room r where r.name like %?1")
    Room findRoom(String name);

    @Query("select r from Room r where r.id = :roomId")
    Room findRoomById(@Param("roomId") Integer roomId);
}
