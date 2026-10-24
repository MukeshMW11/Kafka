package com.mw.pub.service.impl;


import com.mw.pub.dto.LoginDto;
import com.mw.pub.dto.LoginResponseDto;
import com.mw.pub.dto.UserDto;
import com.mw.pub.dto.UserRegisterResponse;
import com.mw.pub.entities.User;
import com.mw.pub.enums.Role;
import com.mw.pub.repository.UserRepository;
import com.mw.pub.service.AuthService;
import com.mw.pub.util.JwtService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
private final PasswordEncoder passwordEncoder;
private final UserRepository userRepository;
private final AuthenticationManager authenticationManager;
private final JwtService jwtService;

    @Override
    public UserRegisterResponse registerUser(UserDto userDto){

        Optional<User> duplicateUser = userRepository.findByEmail(userDto.getEmail());
        if(duplicateUser.isPresent()){
            throw new RuntimeException("User with these credentials already exists");
        }

        User savedUser = userRepository.save(dtoToDb(userDto));
        return new UserRegisterResponse(savedUser.getId(),savedUser.getEmail());
    };



    @Override
    public LoginResponseDto loginUser(LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        String jwtToken  = jwtService.generateJwtToken((UserDetails) Objects.requireNonNull(authentication.getPrincipal()));
        return new LoginResponseDto(jwtToken);

    }


    private User dtoToDb(UserDto userDto){
        User newUser = new User();
        newUser.setName(userDto.getName());
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        newUser.setRole(Role.USER);
        return newUser;
    }


}
