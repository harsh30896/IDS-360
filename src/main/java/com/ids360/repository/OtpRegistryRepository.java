package com.ids360.repository;

import com.ids360.entity.OtpRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface OtpRegistryRepository extends JpaRepository<OtpRegistry, UUID> {
    Optional<OtpRegistry> findByIdentifierAndOtpCode(String identifier, String otpCode);
}
