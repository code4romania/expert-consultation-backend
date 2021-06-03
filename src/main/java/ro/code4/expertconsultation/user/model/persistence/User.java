package ro.code4.expertconsultation.user.model.persistence;

import lombok.Getter;
import lombok.Setter;
import ro.code4.expertconsultation.core.model.persistence.Identifiable;
import ro.code4.expertconsultation.organisation.model.persistence.Organisation;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends Identifiable {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    @ManyToOne(fetch = FetchType.LAZY)
    private Organisation organisation;
}
