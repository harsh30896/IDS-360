package com.ids360.serviceImpl;

import com.ids360.dto.response.LoginResponseDto;
import com.ids360.entity.User;
import com.ids360.enums.ResponseCode;
import com.ids360.repository.UserRepository;
import com.ids360.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<?> checkLoginRequest(String username, String password) {
     User userData = userRepository.findByEmail(username);
     if(userData != null){
         LoginResponseDto userReponseDto = new LoginResponseDto();
         userReponseDto.setEmail(userData.getEmail());
         userReponseDto.setFirstName(userData.getFirstName());
         userReponseDto.setLastName(userData.getLastName());
         return new ResponseEntity<>(userReponseDto, HttpStatus.OK);
     }

     return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
    }
}
