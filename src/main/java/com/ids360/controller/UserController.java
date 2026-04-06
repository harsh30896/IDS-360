package com.ids360.controller;

import com.ids360.dto.requests.UserRequestDto;
import com.ids360.entity.User;
import com.ids360.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserRequestDto dto) {
        // Basic validation
        if (dto.getEmail() == null || dto.getEmail().trim().isEmpty() ||
            dto.getPassword() == null || dto.getPassword().trim().isEmpty()) {
            return new ResponseEntity<>("Email and Password are required", HttpStatus.BAD_REQUEST);
        }

        User newUser = userService.createUser(dto);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
