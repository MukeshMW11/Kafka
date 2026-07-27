package com.kafka.sub.service;

import com.kafka.sub.model.Course;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    private String message;

    @KafkaListener(topics = "mwtest",groupId = "mw1")
    public void consumeEvent(Course course){
    message = "Got the course from the subscribed kafka topic" + course;
        System.out.println(message);
    }


    public String getMessage(){
        return this.message;
    }



}
