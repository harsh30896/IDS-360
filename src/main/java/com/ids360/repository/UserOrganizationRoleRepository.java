package com.ids360.repository;

import com.ids360.entity.UserOrganizationRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserOrganizationRoleRepository extends JpaRepository<UserOrganizationRole,UUID> {
    List<UserOrganizationRole> findByUserId(UUID userId);
    List<UserOrganizationRole> findByOrganizationId(UUID organizationId);
    List<UserOrganizationRole> findByUserIdAndOrganizationId(UUID userId, UUID orgId);
}
