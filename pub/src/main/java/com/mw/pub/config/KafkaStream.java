package com.mw.pub.config;

import com.mw.pub.model.Course;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Supplier;

@Configuration
public class KafkaStream {

    @Bean
    public Supplier<Course> courseSupplier(){
       return ()->{
       Course  course = new Course("firstStream", "MM1 Stream","MW1",(double) 1111111);
        System.out.println("Sending course data:  " + course.toString());
        return course;
       };
    }
}
