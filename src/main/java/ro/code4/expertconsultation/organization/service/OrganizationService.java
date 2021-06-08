package ro.code4.expertconsultation.organization.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ro.code4.expertconsultation.organization.model.OrganizationFilter;
import ro.code4.expertconsultation.organization.model.dto.OrganizationDto;
import ro.code4.expertconsultation.user.model.dto.UserDto;

import java.util.List;

public interface OrganizationService {
    OrganizationDto create(OrganizationDto organizationDto);

    OrganizationDto update(Long organisationId, OrganizationDto organizationDto);

    OrganizationDto get(Long organisationId);

    Page<OrganizationDto> list(OrganizationFilter filter, Pageable pageable);

    List<UserDto> listMembers(Long organisationId);
}
