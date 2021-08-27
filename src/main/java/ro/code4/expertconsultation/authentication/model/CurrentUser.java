package ro.code4.expertconsultation.authentication.model;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import ro.code4.expertconsultation.user.model.persistence.User;

import java.util.Collection;
import java.util.Collections;

@Getter
public class CurrentUser extends org.springframework.security.core.userdetails.User {


    public CurrentUser(final String username,
                       final String password,
                       final Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public static CurrentUser create(final User user) {
        return new CurrentUser(user.getEmail(), user.getPassword(), Collections.emptyList());
    }

}
