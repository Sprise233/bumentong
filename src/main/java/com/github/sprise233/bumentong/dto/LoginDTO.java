package com.github.sprise233.bumentong.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private Integer id;
    private String name;
    private String username;
    private String token;

    public LoginDTO(Integer id, String name, String username, String token) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.token = token;
    }
}
