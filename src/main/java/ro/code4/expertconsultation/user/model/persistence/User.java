package ro.code4.expertconsultation.user.model.persistence;

import lombok.Getter;
import lombok.Setter;

import ro.code4.expertconsultation.core.model.persistence.Identifiable;
import ro.code4.expertconsultation.organization.model.persistence.Organization;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends Identifiable {
    private String name;
    private String email;
    private String phoneNumber;
    private String profilePictureUrl;
    private String password;
    @ManyToOne(fetch = FetchType.LAZY)
    private Organization organization;
}
