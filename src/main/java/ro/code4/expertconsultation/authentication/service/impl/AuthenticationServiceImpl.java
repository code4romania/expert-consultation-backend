package ro.code4.expertconsultation.authentication.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ro.code4.expertconsultation.authentication.jwt.JwtAuthenticationResponse;
import ro.code4.expertconsultation.authentication.jwt.JwtTokenProvider;
import ro.code4.expertconsultation.authentication.model.CurrentUser;
import ro.code4.expertconsultation.authentication.service.AuthenticationService;
import ro.code4.expertconsultation.user.service.UserService;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

//    private UserService userService;
//
//    private PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;

    @Override
    public ResponseEntity<JwtAuthenticationResponse> login(CurrentUser currentUser) {


        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(currentUser.getUsername(), currentUser.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));

    }
}
