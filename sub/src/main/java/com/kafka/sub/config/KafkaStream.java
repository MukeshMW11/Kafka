package com.kafka.sub.config;


import com.kafka.sub.model.Course;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Configuration
public class KafkaStream {
    @Bean
    public Consumer<Course> consumeCourse(){
          return courseData ->{
              System.out.println("The Course data from publisher is : " +courseData.toString());
          };
    }

    @Bean
    public Consumer<String> consumeMessage(){
        return message ->{
            System.out.println("The Message data from Messenger is : " + message);
        };
    }

}
