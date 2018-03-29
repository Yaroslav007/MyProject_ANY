package com.alwaysnearyou.service;

import com.alwaysnearyou.entity.Message;
import java.util.List;

public interface MessageService {

    void save(Message message);

    List<Message> findAll();

    Message getOne(int id);

    void delete(Message message);
}
