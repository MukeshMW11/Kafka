package com.mw.pub.util;


import com.mw.pub.entities.User;
import com.mw.pub.exception.UserNotFound;
import com.mw.pub.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User savedUser = userRepository.findByEmail(username).orElseThrow(()-> new UserNotFound("The user with email" + username + "cannot be found"));

        return org.springframework.security.core.userdetails.User.builder()
                .username(savedUser.getName())
                .password(savedUser.getPassword())
                .roles(savedUser.getRole().name())
                .build();
    }
}
