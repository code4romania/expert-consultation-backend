package ro.code4.expertconsultation.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ro.code4.expertconsultation.authentication.model.persistence.Authentication;
import ro.code4.expertconsultation.authentication.model.persistence.CurrentUser;
import ro.code4.expertconsultation.user.model.persistence.User;
import ro.code4.expertconsultation.user.repository.UserRepository;
import ro.code4.expertconsultation.user.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository, final PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void initDb() {
//        final Authentication authentication = new Authentication();
//        authentication.setUsername("test");
//        authentication.setPassword(passwordEncoder.encode("test"));
//        final User user = new User();
//        user.setEmail("test@test.com");
//        user.setFirstName("Test");
//        user.setLastName("Test");
//        user.setAuthentication(authentication);
//        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final User user = userRepository.findOneByAuthenticationUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Username %s not found", username)));
        return new CurrentUser(username, user.getAuthentication().getPassword(), Collections.emptyList());
    }
}
