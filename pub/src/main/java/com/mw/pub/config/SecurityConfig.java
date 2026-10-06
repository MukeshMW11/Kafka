package com.mw.pub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)  {
            httpSecurity.csrf(AbstractHttpConfigurer::disable)
                    .authorizeHttpRequests(auth->
                            auth.requestMatchers(HttpMethod.POST, "/api/v1/login").permitAll()
                                    .requestMatchers("api/v1/auth/**").hasRole("ADMIN")
                                    .requestMatchers("/api/v1/test/**").hasAnyRole("USER","ADMIN")
                                    .anyRequest().authenticated()
                            ).httpBasic(Customizer.withDefaults());

            return httpSecurity.build();
    }
}
