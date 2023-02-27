package com.app.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

@Configuration
public class JMSConfig {

    @Bean
    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory);
        template.setPubSubDomain(true);
        return template;
    }

    @Bean
    DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory factory){
        var containerFactory = new DefaultJmsListenerContainerFactory();
        containerFactory.setConnectionFactory(factory);
        containerFactory.setPubSubDomain(true);
        //containerFactory.setConcurrency("5-10"); // set consumers to minimum 5 and automaticaly scale out to max 10 consumers as necessary for concurrnent and asyncrounous receiving of messaging
        return containerFactory;
    }
}
