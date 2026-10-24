package com.mw.pub.service.impl;

import com.mw.pub.dto.UserDto;
import com.mw.pub.entities.User;
import com.mw.pub.enums.Role;
import com.mw.pub.exception.UserNotFound;
import com.mw.pub.repository.UserRepository;
import com.mw.pub.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto getCurrentUserProfile() {

        User currentUser = getLoggedInUser();

        return mapDbToDto(currentUser);
    }

    @Override
    @Transactional
    public UserDto updateCurrentUserProfile(UserDto userDto) {

      User currentUser = getLoggedInUser();

      currentUser.setName(userDto.getName());

      return mapDbToDto(currentUser);
    }

    @Override
    public List<UserDto> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(this::mapDbToDto)
                .toList();
    }

    @Override
    public UserDto getUserById(Long userId) {
    User currentUser = userRepository.findById(userId).orElseThrow(()-> new UserNotFound("The user with user id : " + userId + "cannot be found"));
    return mapDbToDto(currentUser);
    }

    @Override
    @Transactional
    public String deleteUserById(Long userId) {
        User currentUser = userRepository.findById(userId).orElseThrow(()-> new UserNotFound("The user with id : "  + userId + "cannot be found"));
        userRepository.delete(currentUser);
        return currentUser.getName();
    }


    private User getLoggedInUser(){
        String email = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();

        System.out.println("This is the authcontext that was saved in jwt auth filter "  +  SecurityContextHolder.getContext().getAuthentication());

        return userRepository.findByEmail(email).orElseThrow(()-> new UserNotFound("The current user cannot be found with email : " + email));
    }


    private UserDto mapDbToDto(User user){
        UserDto currentUser = new UserDto();
        currentUser.setEmail(user.getEmail());
        currentUser.setName(user.getName());
        currentUser.setRole(user.getRole());
        return currentUser;
    }
}
