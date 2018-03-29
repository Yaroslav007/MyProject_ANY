package com.alwaysnearyou.service;

import com.alwaysnearyou.entity.Room;

import java.util.List;

public interface RoomService {

    void save(Room room);

    List<Room> findAll();

    Room getOne(int id);

    void delete(Room room);

    Room findRoom(String name);

    Room findRoomById(Integer roomId);
}
