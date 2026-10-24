package com.mw.pub.config;

import com.mw.pub.enums.Role;
import com.mw.pub.util.JwtAuthFilter;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/api/v1/auth/**").permitAll()
//                                .requestMatchers(HttpMethod.POST, "/api/v1/login").permitAll()

//                                USERS
                                .requestMatchers("/api/v1/users/me").hasRole(Role.USER.name())
//                                ADMIN
                                .requestMatchers("/api/v1/users/**").hasRole(Role.ADMIN.name())
//                                USERS ORDERS
                                .requestMatchers(HttpMethod.POST,"/api/v1/orders").hasRole(Role.USER.name())
                                .requestMatchers("/api/v1/orders/my/**").hasRole(Role.USER.name())
//                                ADMIN ORDERS
                                .requestMatchers(HttpMethod.GET,"/api/v1/orders/**").hasRole(Role.ADMIN.name())
                                .requestMatchers("/api/v1/orders/user/**").hasRole(Role.ADMIN.name())
                                .requestMatchers(HttpMethod.DELETE,"/api/v1/orders/user/**").hasRole(Role.ADMIN.name())

                                .anyRequest().authenticated()
                ).addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

//    @Bean
//    UserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder) {
//        UserDetails admin = User.withUsername("Admin").roles("ADMIN").password(passwordEncoder.encode("admin@123")).build();
//        UserDetails user = User.withUsername("Asta").roles("USER").password(passwordEncoder.encode("user@123")).build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }



    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration){
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}