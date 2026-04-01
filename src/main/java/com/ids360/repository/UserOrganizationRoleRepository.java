package com.ids360.repository;

import com.ids360.entity.UserOrganizationRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserOrganizationRoleRepository extends JpaRepository<UserOrganizationRole,String> {
    List<UserOrganizationRole> findByUserId(String userId);
    List<UserOrganizationRole> findByOrganizationId(String organizationId);
    List<UserOrganizationRole> findByUserIdAndOrganizationId(String userId, String orgId);
}
