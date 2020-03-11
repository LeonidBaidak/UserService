package com.baidak.softserve.user_service.dto;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class UserDto {

    private UUID id;
    private String name;
    private String surName;
    private Instant dateOfBirth;
    private String email;
}
