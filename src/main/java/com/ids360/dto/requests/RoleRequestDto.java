package com.ids360.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleRequestDto {
    private String name;
    private String organizationId;

    @Override
    public String toString() {
        return "RoleRequestDto{" +
                "name='" + name + '\'' +
                ", organizationId='" + organizationId + '\'' +
                '}';
    }
}
