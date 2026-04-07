package com.ids360.serviceImpl;

import com.ids360.entity.Client;
import com.ids360.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.util.Arrays;

@Service
public class CustomRegisteredClientRepository implements RegisteredClientRepository {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void save(RegisteredClient registeredClient) {
        throw new UnsupportedOperationException("Save clients via the Admin API");
    }

    @Override
    public RegisteredClient findById(String id) {
        Client client = clientRepository.findById(id).orElse(null);
        return client != null ? toRegisteredClient(client) : null;
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        Client client = clientRepository.findByClientId(clientId).orElse(null);
        return client != null ? toRegisteredClient(client) : null;
    }

    private RegisteredClient toRegisteredClient(Client client) {
        RegisteredClient.Builder builder = RegisteredClient.withId(client.getId())
                .clientId(client.getClientId())
                .clientSecret(client.getClientSecret())
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_POST);

        if (StringUtils.hasText(client.getGrantTypes())) {
            Arrays.stream(client.getGrantTypes().split(","))
                    .map(String::trim)
                    .forEach(grant -> builder.authorizationGrantType(new AuthorizationGrantType(grant)));
        }

        if (StringUtils.hasText(client.getRedirectUris())) {
            Arrays.stream(client.getRedirectUris().split(","))
                    .map(String::trim)
                    .forEach(builder::redirectUri);
        }

        if (StringUtils.hasText(client.getScopes())) {
            Arrays.stream(client.getScopes().split(","))
                    .map(String::trim)
                    .forEach(builder::scope);
        }

        builder.clientSettings(ClientSettings.builder()
                .requireAuthorizationConsent(client.isRequiresConsent())
                .build());

        builder.tokenSettings(TokenSettings.builder()
                .accessTokenTimeToLive(Duration.ofSeconds(client.getAccessTokenTTL() != null ? client.getAccessTokenTTL() : 3600))
                .refreshTokenTimeToLive(Duration.ofSeconds(client.getRefreshTokenTTL() != null ? client.getRefreshTokenTTL() : 86400))
                .build());

        return builder.build();
    }
}
