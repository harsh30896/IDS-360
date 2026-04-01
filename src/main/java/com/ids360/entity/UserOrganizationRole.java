package com.ids360.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Instant;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserOrganizationRole {

    @Id
    private String userOrganizationRoleId;
    private String userId;
    private String organizationId;
    private String roleId;
    private String teamId;
    private Instant assignedAt;

    @Override
    public String toString() {
        return "UserOrganizationRole{" +
                "userOrganizationRoleId=" + userOrganizationRoleId +
                ", userId=" + userId +
                ", organizationId=" + organizationId +
                ", roleId=" + roleId +
                ", teamId=" + teamId +
                ", assignedAt=" + assignedAt +
                '}';
    }
}
