//package com.mw.pub.service;
//
//import com.mw.pub.model.Course;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//import java.util.function.Function;
//import java.util.function.Predicate;
//
//@Service
//public class KafkaService {
//    @Autowired
//    private KafkaTemplate<String, Course> kafkaTemplate;
//
//    Function<String,Integer> test= s->s.length();
//
//    Predicate<String> isGreater = s->s.length() >1;
//
//
//    private Course course1 = new Course("1JC","Java Course","Java Trainer",(double) 100);
//
//    public String publishEvent(Course course){
////        kafkaTemplate.send("mwtest","course",course);
//        kafkaTemplate.send("mwtest","course",course1);
//        return "Even is published to the Kafka Server";
//    }
//
//}
