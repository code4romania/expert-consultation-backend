package ro.code4.expertconsultation.organisation.mapper;

import org.mapstruct.Mapper;
import ro.code4.expertconsultation.organisation.model.dto.OrganisationDto;
import ro.code4.expertconsultation.organisation.model.persistence.Organisation;

@Mapper(componentModel = "spring")
public interface OrganisationMapper {
    Organisation map(OrganisationDto organisationDto);

    OrganisationDto map(Organisation organisation);
}
