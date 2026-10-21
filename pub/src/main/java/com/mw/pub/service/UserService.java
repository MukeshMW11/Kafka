package com.mw.pub.service;

import com.mw.pub.dto.UserDto;
import com.mw.pub.repository.UserRepository;

public interface UserService {
    public UserDto getCurrentUserProfile();
    public UserDto updateCurrentUserProfile(UserDto userDto);
}
