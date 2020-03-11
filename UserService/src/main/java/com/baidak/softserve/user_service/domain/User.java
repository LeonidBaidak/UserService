package com.baidak.softserve.user_service.domain;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "app_user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Surname is mandatory")
    private String surName;

    private Instant dateOfBirth;
    @Email
    @NotBlank(message = "Email is mandatory")
    @Column(unique=true)
    private String email;
}
