package ro.code4.expertconsultation.authentication.service;


import org.springframework.http.ResponseEntity;
import ro.code4.expertconsultation.authentication.model.CurrentUser;
import ro.code4.expertconsultation.authentication.jwt.JwtAuthenticationResponse;

public interface AuthenticationService {

    ResponseEntity<JwtAuthenticationResponse> login(CurrentUser currentUser);
}
