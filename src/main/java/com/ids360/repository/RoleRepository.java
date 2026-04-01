package com.ids360.repository;

import com.ids360.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,String> {
    List<Role> findByOrganizationId(String organizationId);
}
