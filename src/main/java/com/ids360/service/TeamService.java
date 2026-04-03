package com.ids360.service;

import com.ids360.dto.requests.OrganizationRequestDto;
import com.ids360.dto.requests.TeamRequestDto;
import com.ids360.entity.Team;

public interface TeamService {
    public Team createTeam(TeamRequestDto teamRequestDto);
}
