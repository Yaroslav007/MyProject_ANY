package com.alwaysnearyou.service.impl;

import com.alwaysnearyou.dao.RoomDao;
import com.alwaysnearyou.entity.Room;
import com.alwaysnearyou.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDao roomDao;

    @Override
    public void save(Room room) {
       roomDao.save(room);
    }

    @Override
    public List<Room> findAll() {
        return roomDao.findAll();
    }

    @Override
    public Room getOne(int id) {
        return roomDao.getOne(id);
    }

    @Override
    public void delete(Room room) {
        roomDao.delete(room);
    }

    @Override
    public Room findRoom(String name) {
        return roomDao.findRoom(name);
    }

    @Override
    public Room findRoomById(Integer roomId) {
        return roomDao.findRoomById(roomId);
    }
}
