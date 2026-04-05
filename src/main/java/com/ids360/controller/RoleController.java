package com.ids360.controller;

import com.ids360.dto.requests.RoleRequestDto;
import com.ids360.entity.Role;
import com.ids360.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    @Autowired
    RoleService roleService;
    @PostMapping
    public ResponseEntity<?> createRole(@RequestBody RoleRequestDto dto) {
        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            return new ResponseEntity<>("Role name cannot be empty", HttpStatus.BAD_REQUEST);
        }
        Role newRole = roleService.createRole(dto);
        return new ResponseEntity<>(newRole, HttpStatus.CREATED);
    }
}
