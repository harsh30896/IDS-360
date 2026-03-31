package com.ids360.service;

import com.ids360.dto.requests.LoginRequestDto;
import com.ids360.dto.response.LoginResponseDto;
import java.util.Optional;

public interface AuthService {
    public LoginResponseDto checkLoginRequest(String username, String password);
}
