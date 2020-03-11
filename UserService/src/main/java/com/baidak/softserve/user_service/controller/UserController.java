package com.baidak.softserve.user_service.controller;

import com.baidak.softserve.user_service.dto.UserDto;
import com.baidak.softserve.user_service.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/v1/users")
@Api("User Management System")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @ApiOperation(value = "Get a user by id.")
    @GetMapping("/{id}")
    public UserDto getUser(@Valid @PathVariable UUID id) { // TODO @Valid
        return userService.getUser(id);
    }

    @ApiOperation(value = "Creating a user and saving it to the database.")
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto createDTO) {
        UUID id = userService.createUser(createDTO);
        URI getUser = URI.create("/v1/users/" + id);
        return ResponseEntity.created(getUser).body(userService.getUser(id)); // TODO 201 RestByExample
    }
}
