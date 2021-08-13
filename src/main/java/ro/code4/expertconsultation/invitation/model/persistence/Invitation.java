package ro.code4.expertconsultation.invitation.model.persistence;

import lombok.Getter;
import lombok.Setter;
import ro.code4.expertconsultation.core.model.persistence.Identifiable;
import ro.code4.expertconsultation.user.model.persistence.User;

import javax.persistence.*;

@Entity
@Table(name = "invitations")
@Getter
@Setter
public class Invitation extends Identifiable {
    @OneToOne(fetch = FetchType.EAGER)
    private User user;
    private String code;
    @Enumerated(EnumType.STRING)
    private InvitationStatus status = InvitationStatus.PENDING;
}
