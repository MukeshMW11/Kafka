package com.mw.pub.controller;

import com.mw.pub.dto.ValidationDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ValidationTest {
    @PostMapping("/hello")
    public String renderValidationDto(@Valid @RequestBody ValidationDto validationDto ){
        return  "The name of " + validationDto.getName() + " with "  + validationDto.getEmail() + " password " + validationDto.getPassword();
    }

    @GetMapping("/login")
    public ResponseEntity<ValidationDto>  handleLogin(){
        ValidationDto validationDto = new ValidationDto();
        validationDto.setEmail("abc@email.com");
        validationDto.setName("abc");
        validationDto.setPassword("abc");
        return ResponseEntity.ok(validationDto);
    }

}
