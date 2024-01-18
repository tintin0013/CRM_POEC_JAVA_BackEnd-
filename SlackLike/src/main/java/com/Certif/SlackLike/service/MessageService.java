package com.Certif.SlackLike.service;



import com.Certif.SlackLike.model.Message;
import com.Certif.SlackLike.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    // getAllMessages
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    // getMessageById
    public Optional<Message> getMessageById(Integer id) {

        return messageRepository.findById(id);
    }

    //createMessage
    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    //updateMessage
    public Message updateMessage(Message message) {
        return messageRepository.save(message);
    }

    //deleteMessage
    public boolean deleteMessage(Integer id) {
        if (getMessageById(id).isEmpty())
            return false;
        else {
            messageRepository.deleteById(id);
            return true;
        }


    }
}
