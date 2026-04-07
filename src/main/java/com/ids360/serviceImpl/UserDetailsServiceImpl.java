package com.ids360.serviceImpl;

import com.ids360.entity.User;
import com.ids360.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // In our system, the "username" is the email address.
        User user = userRepository.findByEmail(username);
        
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }

        // Map our custom business logic (blocked, expired) directly into Spring Security
        boolean accountNonExpired = user.getAccountExpiresAt() == null || Instant.now().isBefore(user.getAccountExpiresAt());
        boolean accountNonLocked = !user.isBlocked();
        boolean enabled = !user.isBlocked();

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPasswordHash(),
                enabled,
                accountNonExpired,
                true, // credentialsNonExpired
                accountNonLocked,
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}
