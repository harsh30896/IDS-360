package com.ids360.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganizationRequestDto {

    private String name;
    private String domanin;
    private boolean isActive;

    @Override
    public String toString() {
        return "OrganizationRequestDto{" +
                "name='" + name + '\'' +
                ", domanin='" + domanin + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
