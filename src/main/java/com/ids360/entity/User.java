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
public class User {

    @Id
    private UUID userId;
    private String email;
    private String passwordHash;
    private String firstName;
    private String lastName;
    private String mobile;
    private boolean isSystemAdmin;
    private boolean isBlocked;
    private Instant accountExpiresAt;
    private Instant createdAt;
    private Instant updateAt;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", isSystemAdmin=" + isSystemAdmin +
                ", isBlocked=" + isBlocked +
                ", accountExpiresAt=" + accountExpiresAt +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
