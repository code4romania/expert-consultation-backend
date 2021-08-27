package ro.code4.expertconsultation.authentication.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.code4.expertconsultation.authentication.model.UserPrincipal;
import ro.code4.expertconsultation.user.model.persistence.User;
import ro.code4.expertconsultation.user.repository.UserRepository;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetails loadUserById(long id) {
        final User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id: " + id)
        );
        return UserPrincipal.create(user);
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final User user = userRepository.findOneByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Email %s not found", username)));
        return UserPrincipal.create(user);
    }
}
