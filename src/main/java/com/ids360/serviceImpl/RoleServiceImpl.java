package com.ids360.serviceImpl;

import com.ids360.dto.requests.RoleRequestDto;
import com.ids360.entity.Organization;
import com.ids360.entity.Role;
import com.ids360.repository.OrganizationRepository;
import com.ids360.repository.RoleRepository;
import com.ids360.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    OrganizationRepository organizationRepository;
    @Override
    public Role createRole(RoleRequestDto dto) {
        Optional<Organization> orgOpt = organizationRepository.findById(dto.getOrganizationId());
        if (orgOpt.isEmpty()) {
            throw new RuntimeException("Organization not found");
        }

        Role role = new Role();
        role.setRoleId(UUID.randomUUID().toString());
        role.setName(dto.getName());
        role.setOrganizationId(dto.getOrganizationId());
        role.setCreatedAt(Instant.now());
        return roleRepository.save(role);
    }
}
