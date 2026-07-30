package com.example.spring.token.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
// NULL 일때는 필드에 포함 안됨, 그래서 안보임? 그래서 refreshToken은 안보일거임?
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SignInResponseDto {
    private boolean isLoggedIn;
    private String url;
    private String userName;
    private String userId;
    private String message;
    private String accessToken;
    private String refreshToken;
}
