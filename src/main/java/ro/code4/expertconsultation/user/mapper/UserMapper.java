package ro.code4.expertconsultation.user.mapper;

import org.mapstruct.Mapper;
import ro.code4.expertconsultation.user.model.dto.UserDto;
import ro.code4.expertconsultation.user.model.persistence.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User map(UserDto userDto);

    UserDto map(User User);
}
