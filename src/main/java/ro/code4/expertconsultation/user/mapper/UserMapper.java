package ro.code4.expertconsultation.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.code4.expertconsultation.user.model.dto.UserDto;
import ro.code4.expertconsultation.user.model.persistence.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "organization", ignore = true)
    User map(UserDto userDto);

    UserDto map(User User);
}
