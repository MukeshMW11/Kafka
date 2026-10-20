package com.mw.pub.service;

import com.mw.pub.dto.LoginDto;
import com.mw.pub.dto.LoginResponseDto;
import com.mw.pub.dto.UserDto;
import com.mw.pub.dto.UserRegisterResponse;

public interface AuthService {
    public UserRegisterResponse registerUser(UserDto userDto);
    public LoginResponseDto loginUser(LoginDto loginDto);
}
