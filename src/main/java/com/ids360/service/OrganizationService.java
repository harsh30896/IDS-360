package com.ids360.service;

import com.ids360.dto.requests.OrganizationRequestDto;
import com.ids360.entity.Organization;

public interface OrganizationService {
    public Organization createOrganization(OrganizationRequestDto dto);
}
