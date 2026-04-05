package com.ids360.controller;

import com.ids360.dto.requests.TeamRequestDto;
import com.ids360.entity.Team;
import com.ids360.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamController {
    @Autowired
    TeamService teamService;

    @PostMapping("/createTeam")
    public ResponseEntity<Team> createTeam(@RequestBody TeamRequestDto teamRequestDto) {

        if (teamRequestDto.getName() == null || teamRequestDto.getName().trim().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Team newTeam = teamService.createTeam(teamRequestDto);
        return new ResponseEntity<>(newTeam, HttpStatus.CREATED);
    }
}
