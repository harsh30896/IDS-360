package com.ids360.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Instant;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Organization {

    @Id
    private String id;
    private String name;
    private String domain;
    private boolean isActive;
    private Instant createdAt;
    private Instant updatedAt;

    @Override
    public String toString() {
        return "Organization{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", domain='" + domain + '\'' +
                ", isActive=" + isActive +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
