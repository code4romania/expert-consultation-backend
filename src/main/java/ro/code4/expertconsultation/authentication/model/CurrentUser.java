package ro.code4.expertconsultation.authentication.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CurrentUser extends org.springframework.security.core.userdetails.User {
    public CurrentUser(final String username,
                       final String password,
                       final Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
