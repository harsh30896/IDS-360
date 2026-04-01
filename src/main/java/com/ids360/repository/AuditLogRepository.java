package com.ids360.repository;

import com.ids360.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuditLogRepository extends JpaRepository<AuditLog, String> {
}
