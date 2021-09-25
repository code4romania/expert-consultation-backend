package ro.code4.expertconsultation.user.service;

import ro.code4.expertconsultation.user.model.dto.UserDto;
import ro.code4.expertconsultation.user.model.persistence.User;

public interface UserService {
    UserDto create(Long organisationId, UserDto userDto);

    UserDto get(Long userId);

    UserDto update(Long userId, UserDto userDto);

    User getEntity(Long userId);
}
