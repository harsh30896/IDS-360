package com.ids360.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamRequestDto {

    private String name;
    private String organizationId;

    @Override
    public String toString() {
        return "TeamRequestDto{" +
                "name='" + name + '\'' +
                ", organizationId='" + organizationId + '\'' +
                '}';
    }
}
