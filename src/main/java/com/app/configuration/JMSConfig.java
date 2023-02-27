package com.app.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

@Configuration
@EnableJms
public class JMSConfig {

    @Bean
    DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory factory){
        var containerFactory = new DefaultJmsListenerContainerFactory();
        containerFactory.setConnectionFactory(factory);
        containerFactory.setConcurrency("5-10"); // set consumers to minimum 5 and automaticaly scale out to max 10 consumers as necessary for concurrnent and asyncrounous receiving of messaging
        return containerFactory;
    }
}
