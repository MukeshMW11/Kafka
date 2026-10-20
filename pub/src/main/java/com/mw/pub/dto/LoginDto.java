package com.mw.pub.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginDto {
    @NotBlank
    @NotNull
    @Email
    private String email;
    @NotNull
    @NotBlank
    private String password;
}
