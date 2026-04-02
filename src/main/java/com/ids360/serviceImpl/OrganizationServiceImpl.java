package com.ids360.serviceImpl;

import com.ids360.dto.requests.OrganizationRequestDto;
import com.ids360.entity.Organization;
import com.ids360.repository.OrganizationRepository;
import com.ids360.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationRepository repository;

    @Override
    public Organization createOrganization(OrganizationRequestDto dto) {
        Organization org = new Organization();
        org.setId(UUID.randomUUID().toString());
        org.setName(dto.getName());
        org.setDomain(dto.getDomanin());
        org.setActive(dto.isActive());
        org.setCreatedAt(Instant.now());
        return repository.save(org);
    }
}
