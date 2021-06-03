package ro.code4.expertconsultation.organisation.service;

import ro.code4.expertconsultation.organisation.model.dto.OrganisationDto;
import ro.code4.expertconsultation.user.model.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface OrganisationService {
    OrganisationDto create(OrganisationDto organisationDto);

    OrganisationDto update(UUID organisationId, OrganisationDto organisationDto);

    OrganisationDto get(UUID organisationId);

    List<UserDto> getMembers(UUID organisationId);
}
