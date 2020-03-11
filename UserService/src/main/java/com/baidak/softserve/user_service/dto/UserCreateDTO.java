package com.baidak.softserve.user_service.dto;

import lombok.Data;


import java.time.Instant;

@Data
public class UserCreateDTO {

    private String name;
    private String surName;
    private Instant dateOfBirth;
    private String email;
}
