package com.app.services;

import com.app.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessagingService {

    private JmsTemplate jmsTemplate;

    @Autowired
    public MessagingService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(Message message){
        jmsTemplate.convertAndSend("messages-box",message);
    }
}
