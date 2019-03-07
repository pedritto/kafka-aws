package com.pepe.topic.demo.contoller;

import com.pepe.topic.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping(value = "/clear")
    public void clear() {
        messageService.clearAll();
    }

    @GetMapping(value = "/messages")
    public Collection<String> getAll() {
        return messageService.getMessages();
    }

}
