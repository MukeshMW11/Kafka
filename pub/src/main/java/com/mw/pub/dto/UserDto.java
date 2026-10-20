package com.mw.pub.dto;


import com.mw.pub.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    @NotNull
    @Size(max = 100)
    private String name;
    @Email
    @NotNull
    private String email;
    @NotNull
    private String password;
    private Role role;
}
