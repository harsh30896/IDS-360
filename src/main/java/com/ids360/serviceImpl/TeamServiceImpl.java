package com.ids360.serviceImpl;

import com.ids360.dto.requests.TeamRequestDto;
import com.ids360.entity.Organization;
import com.ids360.entity.Team;
import com.ids360.repository.OrganizationRepository;
import com.ids360.repository.TeamRepository;
import com.ids360.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public Team createTeam(TeamRequestDto teamRequestDto) {
      Optional<Organization> organizationOptional = organizationRepository.findById(teamRequestDto.getOrganizationId());
        if (organizationOptional.isEmpty()) {
            throw new RuntimeException("Organization not found");
        }
        Team team = new Team();
        team.setTeamId(UUID.randomUUID().toString());
        team.setName(teamRequestDto.getName());
        team.setOrganizationId(teamRequestDto.getOrganizationId());
        team.setCreatedAt(Instant.now());
        return teamRepository.save(team);
    }
}
