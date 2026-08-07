//package com.kafka.sub.controller;
//
//import com.kafka.sub.service.KafkaService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/v1/kafka/sub")
//public class KafkaController {
//    private final KafkaService kafkaService;
//
//    public KafkaController(KafkaService kafkaService) {
//        this.kafkaService = kafkaService;
//    }
//
//
//    @GetMapping
//    public ResponseEntity<String> consumeEvent(){
//    return ResponseEntity.ok(kafkaService.getMessage());
//    }
//}
