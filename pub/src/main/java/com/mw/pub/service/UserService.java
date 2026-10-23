package com.mw.pub.service;

import com.mw.pub.dto.UserDto;
import com.mw.pub.repository.UserRepository;

import java.util.List;

public interface UserService {
    public UserDto getCurrentUserProfile();
    public UserDto updateCurrentUserProfile(UserDto userDto);
    public List<UserDto> getAllUsers();
    public UserDto getUserById(Long Id);
    public String deleteUserById(Long userId);
}
