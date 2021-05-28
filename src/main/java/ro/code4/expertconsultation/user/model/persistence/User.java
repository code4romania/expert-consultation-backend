package ro.code4.expertconsultation.user.model.persistence;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import ro.code4.expertconsultation.authentication.model.persistence.Authentication;
import ro.code4.expertconsultation.core.model.persistence.Identifiable;

@Document(collection = "users")
@Getter
@Setter
public class User extends Identifiable {
    private String firstName;
    private String lastName;
    private String email;
    private Authentication authentication;
}
