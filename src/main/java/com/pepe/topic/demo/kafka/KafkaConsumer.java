package com.pepe.topic.demo.kafka;

import com.pepe.topic.demo.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private MessageService messageService;

    @Value("${kafka.test.topic}")
    private String kafkaTopicName;
    @Value("${kafka.test.group}")
    private String kafkaConsumerGroupe;

    @KafkaListener(topics = "${kafka.test.topic}", groupId = "${kafka.test.group}")
    public void consumeMessage(String message) {
        LOGGER.info("Consuming message: {} from topic: {} by group: {}.",
                message, kafkaTopicName, kafkaConsumerGroupe);
        messageService.addMessage(message);
    }
}
