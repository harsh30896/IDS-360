package com.ids360.serviceImpl;

import com.ids360.dto.response.LoginResponseDto;
import com.ids360.entity.User;
import com.ids360.repository.UserRepository;
import com.ids360.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;
import com.ids360.entity.UserOrganizationRole;
import com.ids360.repository.UserOrganizationRoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.ids360.exception.InvalidCredentialsException;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserOrganizationRoleRepository userOrganizationRoleRepository;

    @Override
    public LoginResponseDto checkLoginRequest(String username, String password) {
     User userData = userRepository.findByEmail(username);
     
     if (userData == null) {
         throw new InvalidCredentialsException("Invalid username or password");
     }

     if (!passwordEncoder.matches(password, userData.getPasswordHash())) {
         throw new InvalidCredentialsException("Invalid username or password");
     }

     if (userData.getAccountExpiresAt() != null && userData.getAccountExpiresAt().isBefore(Instant.now())) {
         throw new com.ids360.exception.AccountExpiredException("Account expired");
     }

     if (userData.isBlocked()) {
         throw new com.ids360.exception.AccountBlockedException("Account blocked");
     }

     LoginResponseDto userReponseDto = new LoginResponseDto();
     userReponseDto.setEmail(userData.getEmail());
     userReponseDto.setFirstName(userData.getFirstName());
     userReponseDto.setLastName(userData.getLastName());
     userReponseDto.setUserId(userData.getUserId());

     List<UserOrganizationRole> orgRoles = userOrganizationRoleRepository.findByUserId(userData.getUserId());
     userReponseDto.setOrganizations(orgRoles);
     userReponseDto.setRequiresOrgSelection(orgRoles.size() > 1);
     
     return userReponseDto;
    }
}
