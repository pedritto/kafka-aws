package com.pepe.topic.demo.kafka;

import com.pepe.topic.demo.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private MessageService messageService;

    @KafkaListener(topics = "${kafka.test.topic}", groupId = "${kafka.test.group}")
    public void consumeMessage(String message) {
        LOGGER.info("Consuming message: {}.", message);
        messageService.addMessage(message);
    }
}
