
package com.app.services;

import com.app.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessagingService {


/* for message production and asynchrounous message reception
    *
    *  Similar to Java EE's message driven Beans (MDB)
    * */

    private JmsTemplate jmsTemplate;

    @Autowired
    public MessagingService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(String message) {
        jmsTemplate.send("destination", session -> session.createTextMessage(message));
    }
}

