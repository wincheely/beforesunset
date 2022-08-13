package com.example.myproject.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class UserDto {
    @NonNull
    private String userId;
    private String userName;
    @NonNull
    private String pwd;
}
