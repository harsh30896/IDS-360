package com.ids360.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Instant;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Organization {

    @Id
    private UUID userId;
    private String name;
    private String domain;
    private Instant createdAt;
    private Instant updatedAt;

    @Override
    public String toString() {
        return "Organization{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", domain='" + domain + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
