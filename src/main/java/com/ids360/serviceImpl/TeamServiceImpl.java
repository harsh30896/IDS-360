package com.ids360.serviceImpl;

import com.ids360.dto.requests.TeamRequestDto;
import com.ids360.entity.Organization;
import com.ids360.entity.Team;
import com.ids360.repository.OrganizationRepository;
import com.ids360.repository.TeamRepository;
import com.ids360.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public Team createTeam(TeamRequestDto teamRequestDto) {
      Optional<Organization> organizationalId = organizationRepository.findById(teamRequestDto.getOrganizationId());
        return null;
    }
}
