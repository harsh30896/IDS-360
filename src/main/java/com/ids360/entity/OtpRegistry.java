package com.ids360.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
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
public class OtpRegistry {

    @Id
    private Long id;
    private String identifier;
    private String otpCode;
    private String type;
    private Instant expiresAt;
    private boolean consumed;
    private Instant createdAt;

    @Override
    public String toString() {
        return "OtpRegistry{" +
                "id=" + id +
                ", identifier='" + identifier + '\'' +
                ", otpCode='" + otpCode + '\'' +
                ", type='" + type + '\'' +
                ", expiresAt=" + expiresAt +
                ", consumed=" + consumed +
                ", createdAt=" + createdAt +
                '}';
    }
}
