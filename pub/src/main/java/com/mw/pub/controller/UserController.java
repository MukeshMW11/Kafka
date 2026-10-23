package com.mw.pub.controller;


import com.mw.pub.dto.UserDto;
import com.mw.pub.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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



//   Admin -> All
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }


//    Admin -> Particular User
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userID){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(userID));

    }


// Admin -> Delete a user by id
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User : " + userService.deleteUserById(userId) + "was successfully deleted");
    }


}
