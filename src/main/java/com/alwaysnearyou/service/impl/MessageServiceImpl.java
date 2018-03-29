package com.alwaysnearyou.service.impl;

import com.alwaysnearyou.dao.MessageDao;
import com.alwaysnearyou.entity.Message;
import com.alwaysnearyou.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Override
    public void save(Message message) {
        messageDao.save(message);
    }

    @Override
    public List<Message> findAll() {
        return messageDao.findAll();
    }

    @Override
    public Message getOne(int id) {
        return messageDao.getOne(id);
    }

    @Override
    public void delete(Message message) {
        messageDao.delete(message);
    }
}
