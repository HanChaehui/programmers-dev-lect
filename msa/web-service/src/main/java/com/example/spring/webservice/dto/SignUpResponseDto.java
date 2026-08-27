package com.example.spring.webservice.dto;

import com.example.spring.webservice.enums.Role;
import lombok.Getter;

@Getter
public class SignUpResponseDto {
    private String userId;
    private String password;
    private String username;
    private Role role;
}
