package com.ids360.serviceImpl;

import com.ids360.dto.requests.UserRequestDto;
import com.ids360.entity.User;
import com.ids360.repository.UserRepository;
import com.ids360.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User createUser(UserRequestDto dto) {
        
        // 1. Check for email uniqueness
        if (userRepository.findByEmail(dto.getEmail()) != null) {
            throw new RuntimeException("User with this email already exists");
        }

        // 2. Hash the password securely
        String hashedPassword = passwordEncoder.encode(dto.getPassword());

        // 3. Map the User entity
        User user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setEmail(dto.getEmail());
        user.setPasswordHash(hashedPassword);
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setMobile(dto.getMobile());
        
        // Set defaults
        user.setSystemAdmin(false);
        user.setBlocked(false);
        user.setCreatedAt(Instant.now());
        
        // 4. Save and return
        return userRepository.save(user);
    }
}
