package com.app.controllers;


import com.app.entities.Message;
import com.app.services.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessagingController {


    @Autowired
    MessagingService service;

        @PostMapping("/messaging")
    public ResponseEntity<String> sendMessage(@RequestBody Message message){
        try{
            service.send(message.getBody());
            return new ResponseEntity<>("Sent", HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
