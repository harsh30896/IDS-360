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
public class Client {

    @Id
    private String id;
    private String clientId;
    private String clientSecret;
    private String redirectUris;
    private String grantTypes;
    private String scopes;
    private boolean requiresConsent;
    private Long accessTokenTTL;
    private Long refreshTokenTTL;
    private Instant createdAt;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", clientSecret='" + clientSecret + '\'' +
                ", redirectUris='" + redirectUris + '\'' +
                ", grantTypes='" + grantTypes + '\'' +
                ", scopes='" + scopes + '\'' +
                ", requiresConsent=" + requiresConsent +
                ", accessTokenTTL=" + accessTokenTTL +
                ", refreshTokenTTL=" + refreshTokenTTL +
                ", createdAt=" + createdAt +
                '}';
    }
}
