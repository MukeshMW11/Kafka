package com.mw.pub.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopic {
    @Bean
    public NewTopic createKafkaTopic(){
        return new NewTopic("mwconfigtopic",2,(short) 1);
    }
}
