package ro.code4.expertconsultation.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ro.code4.expertconsultation.authentication.model.CurrentUser;
import ro.code4.expertconsultation.organisation.model.persistence.Organisation;
import ro.code4.expertconsultation.organisation.repository.OrganisationRepository;
import ro.code4.expertconsultation.user.mapper.UserMapper;
import ro.code4.expertconsultation.user.model.dto.UserDto;
import ro.code4.expertconsultation.user.model.persistence.User;
import ro.code4.expertconsultation.user.repository.UserRepository;
import ro.code4.expertconsultation.user.service.UserService;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final OrganisationRepository organisationRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @PostConstruct
    public void initDb() {
        final long usersCount = userRepository.count();
        if (usersCount == 0) {
            final User user = new User();
            user.setEmail("test@test.com");
            user.setName("Test User");
            user.setPassword(passwordEncoder.encode("test"));
            user.setPhoneNumber("0711111111");
            userRepository.save(user);
        }
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final User user = userRepository.findOneByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Email %s not found", username)));
        return new CurrentUser(username, user.getPassword(), Collections.emptyList());
    }

    @Override
    public UserDto create(final Long organisationId, final UserDto userDto) {
        final Organisation organisation = organisationRepository.findById(organisationId)
                .orElseThrow(EntityNotFoundException::new);
        final User user = userMapper.map(userDto);
        user.setOrganisation(organisation);
        final User savedUser = userRepository.save(user);

        return userMapper.map(savedUser);
    }

    @Override
    public UserDto get(final Long userId) {
        final User user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        return userMapper.map(user);
    }

    @Override
    public UserDto update(final Long userId, final UserDto userDto) {
        final User user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);

        user.setName(userDto.getName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setProfilePictureUrl(userDto.getProfilePictureUrl());

        final User updatedUser = userRepository.save(user);
        return userMapper.map(updatedUser);
    }
}
