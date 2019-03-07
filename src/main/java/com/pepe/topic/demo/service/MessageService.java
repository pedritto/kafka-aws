package com.pepe.topic.demo.service;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MessageService {

    private ConcurrentHashMap<Long, String> messageMap;
    private AtomicLong atomicLong;

    public MessageService() {
        messageMap = new ConcurrentHashMap<>();
        atomicLong = new AtomicLong();
    }

    public void addMessage(String message) {
        long messageId = atomicLong.incrementAndGet();
        messageMap.put(messageId, message);
    }

    public Collection<String> getMessages() {
        return messageMap.values();
    }

    public void clearAll() {
        messageMap.clear();
    }
}
