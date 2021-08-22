package ro.code4.expertconsultation.invitation.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ro.code4.expertconsultation.invitation.model.dto.InvitationDto;
import ro.code4.expertconsultation.invitation.model.persistence.Invitation;

@Mapper(componentModel = "spring")
public interface InvitationMapper {
    @Mappings({
            @Mapping(target = "email", source = "user.email")
    })
    InvitationDto map(Invitation invitation);
}
