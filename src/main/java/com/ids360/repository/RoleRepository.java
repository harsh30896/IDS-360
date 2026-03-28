package com.ids360.repository;

import com.ids360.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role,UUID> {
    List<Role> findByOrganizationId(UUID organizationId);
}
