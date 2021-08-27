package ro.code4.expertconsultation.user.service;

import ro.code4.expertconsultation.user.model.dto.UserDto;

public interface UserService {
    UserDto create(Long organisationId, UserDto userDto);

    UserDto get(Long userId);

    UserDto update(Long userId, UserDto userDto);
}
