package ro.code4.expertconsultation.user.model.persistence;

import lombok.*;
import ro.code4.expertconsultation.core.model.persistence.Identifiable;
import ro.code4.expertconsultation.organization.model.persistence.Organization;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends Identifiable {
    private String name;
    private String email;
    private String phoneNumber;
    private String profilePictureUrl;
    private String password;
    @ManyToOne(fetch = FetchType.LAZY)
    private Organization organization;
}
