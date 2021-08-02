package ro.code4.expertconsultation.authentication.service;


import org.springframework.http.ResponseEntity;
import ro.code4.expertconsultation.authentication.jwt.JwtAuthenticationResponse;
import ro.code4.expertconsultation.authentication.model.LoginRequest;

public interface AuthenticationService {

    ResponseEntity<JwtAuthenticationResponse> login(LoginRequest loginRequest);
}
