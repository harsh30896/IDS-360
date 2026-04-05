package com.ids360.service;

import com.ids360.dto.requests.RoleRequestDto;
import com.ids360.entity.Role;

public interface RoleService {
    public Role createRole(RoleRequestDto dto);
}
