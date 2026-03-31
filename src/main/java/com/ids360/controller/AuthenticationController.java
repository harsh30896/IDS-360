package com.ids360.controller;

import com.ids360.dto.requests.LoginRequestDto;
import com.ids360.dto.response.LoginResponseDto;
import com.ids360.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> loginWithUserNamePassword(@RequestBody LoginRequestDto loginRequestDto){
        LoginResponseDto responseDto = authService.checkLoginRequest(loginRequestDto.getUsername(), loginRequestDto.getPassword());
        return ResponseEntity.ok(responseDto);
    }
}
