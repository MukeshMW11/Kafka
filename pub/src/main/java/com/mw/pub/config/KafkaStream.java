//package com.mw.pub.config;
//
//import com.mw.pub.model.Course;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.support.KafkaHeaders;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.MessageHeaders;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.util.MimeTypeUtils;
//
//import java.util.Random;
//import java.util.function.Supplier;
//
//@Configuration
//public class KafkaStream {
//
//    @Bean
//    public Supplier<Course> courseSupplier(){
//       return ()->{
//       Course  course = new Course("firstStream", "MM1 Stream","MW1",(double) 1111111);
//        System.out.println("Sending course data:  " + course.toString());
//        return course;
//       };
//
//    }
//
//    @Bean
//    public Supplier<Message<String>> textSupplier(){
//        Random random = new Random();
//        return ()->{
//                String randomString = "Course" + random.nextInt(20);
//                String  randomBoolean = random.nextBoolean() ? "Course 1" : "Course 2" ;
//            System.out.println("This is the text Supplier");
//            return MessageBuilder.withPayload(randomString  + " " + randomBoolean)
//                    .setHeader(KafkaHeaders.KEY,randomString.getBytes())
//                    .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.TEXT_PLAIN).build();
//        };
//    }
//
//}
