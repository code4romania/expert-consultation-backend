package ro.code4.expertconsultation.user.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ro.code4.expertconsultation.user.model.dto.UserDto;

import java.util.UUID;

public interface UserService extends UserDetailsService {
    UserDto create(UUID organisationId, UserDto userDto);

    UserDto get(UUID userId);

    UserDto update(UUID userId, UserDto userDto);
}
