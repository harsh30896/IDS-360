package com.ids360.service;

import com.ids360.dto.requests.UserRequestDto;
import com.ids360.entity.User;

public interface UserService {
    User createUser(UserRequestDto dto);
}
