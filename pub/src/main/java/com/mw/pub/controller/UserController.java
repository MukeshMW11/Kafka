package com.mw.pub.controller;


import com.mw.pub.dto.UserDto;
import com.mw.pub.entities.User;
import com.mw.pub.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
// /me
    @GetMapping("/me")
    public ResponseEntity<UserDto> getCurrentUserProfile(){
    return ResponseEntity.status(HttpStatus.OK).body(userService.getCurrentUserProfile());
    }


    @PostMapping("/me")
    public ResponseEntity<UserDto> updateCurrentUserProfile(@RequestBody UserDto userDto){
            return ResponseEntity.status(HttpStatus.OK).body(userService.updateCurrentUserProfile(userDto));
    }


}
