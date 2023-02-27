package com.app.consumers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class Listner
{

    private static final Logger LOGGER = LoggerFactory.getLogger(Listner.class);


    @JmsListener(destination = "destination")
    public void handleMessage(String message) {
        LOGGER.info("Message received, {}",message);
    }
}
