//package com.mw.pub.controller;
//
//import com.mw.pub.model.Course;
//import com.mw.pub.service.KafkaService;
//import jakarta.validation.Valid;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("api/v1/kafka/pub")
//public class KafkaController {
//    private final KafkaService kafkaService;
//    public KafkaController(KafkaService kafkaService){
//        this.kafkaService = kafkaService;
//    }
//
//
//    @PostMapping
//    public ResponseEntity<String> publishEvent(@Valid @RequestBody Course course){
//        String res= kafkaService.publishEvent(course);
//        return  ResponseEntity.ok(res);
//    }
//}
