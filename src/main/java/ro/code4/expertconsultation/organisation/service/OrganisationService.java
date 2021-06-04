package ro.code4.expertconsultation.organisation.service;

import ro.code4.expertconsultation.organisation.model.dto.OrganisationDto;
import ro.code4.expertconsultation.user.model.dto.UserDto;

import java.util.List;

public interface OrganisationService {
    OrganisationDto create(OrganisationDto organisationDto);

    OrganisationDto update(Long organisationId, OrganisationDto organisationDto);

    OrganisationDto get(Long organisationId);

    List<UserDto> getMembers(Long organisationId);
}
