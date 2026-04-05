package com.ids360.controller;

import com.ids360.dto.requests.OrganizationRequestDto;
import com.ids360.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/organization")
public class OrganizationController {

    @Autowired
    OrganizationService organizationService;

    @PostMapping("/createOrganization")
    public ResponseEntity<?> createOrganization(@RequestBody OrganizationRequestDto organizationRequestDto){
            if (organizationRequestDto.getName() != null && !organizationRequestDto.getName().trim().isEmpty()) {
                organizationService.createOrganization(organizationRequestDto);
                return new ResponseEntity<>("Organization Created", HttpStatus.CREATED);
            }
            return new ResponseEntity<>("Organization not created",HttpStatus.NOT_FOUND);
    }
}
