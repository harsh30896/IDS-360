package com.ids360.repository;

import com.ids360.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team,String> {
    List<Team> findByOrganizationId(String organizationId);
}
