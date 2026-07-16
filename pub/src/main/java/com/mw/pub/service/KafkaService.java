package com.mw.pub.service;

import com.mw.pub.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    @Autowired
    private KafkaTemplate<String, Course> kafkaTemplate;

    public String publishEvent(Course course){
        kafkaTemplate.send("mwtest","course",course);
        return "Even is published to the Kafka Server";
    }

}
