package ro.code4.expertconsultation.authentication.jwt;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(final HttpServletRequest request,
                         final HttpServletResponse response,
                         final AuthenticationException e) {
//         invoked when user tries to access a secured REST resource without supplying any credentials
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
