package com.example.demo.payload.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JWTResponse {

    private Long id;
    private String username;
    private String email;
    @Setter(AccessLevel.NONE)
    private List<String> roles;
    private String token;
    @Setter(AccessLevel.NONE)
    private String typeToken = "Bearer";

    public JWTResponse(Long id, String username, String email, List<String> roles, String token) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.token = token;
        this.typeToken = typeToken;
    }
}