package com.pepe.topic.demo.contoller;

import com.pepe.topic.demo.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private KafkaProducer producer;

    @PostMapping(value = "/publish")
    public void publish(@RequestParam("message") String message) {
        producer.sendMessage(message);
    }
}
