package ro.code4.expertconsultation.authentication.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.code4.expertconsultation.authentication.jwt.JwtAuthenticationResponse;
import ro.code4.expertconsultation.authentication.model.CurrentUser;
import ro.code4.expertconsultation.authentication.service.AuthenticationService;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthenticationController {

    private AuthenticationService authenticationService;

    //todo create valid annotation
    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> login(@RequestBody final CurrentUser currentUser) {
        return authenticationService.login(currentUser);
    }

}
