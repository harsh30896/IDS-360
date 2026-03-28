package com.ids360.repository;

import com.ids360.entity.SystemSettings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SystemSettingsRepository extends JpaRepository<SystemSettings, UUID> {
}
