package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class AppApplication {



    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AppApplication.class, args);
        System.out.println("runned");
    }

}
