package ro.code4.expertconsultation.organization.mapper;

import org.mapstruct.Mapper;
import ro.code4.expertconsultation.organization.model.dto.OrganizationDto;
import ro.code4.expertconsultation.organization.model.persistence.Organization;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {
    Organization map(OrganizationDto organizationDto);

    OrganizationDto map(Organization organization);
}
