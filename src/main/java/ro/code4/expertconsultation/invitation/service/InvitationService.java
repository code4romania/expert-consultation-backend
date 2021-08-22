package ro.code4.expertconsultation.invitation.service;

import ro.code4.expertconsultation.authentication.model.SignUpRequest;
import ro.code4.expertconsultation.invitation.model.persistence.Invitation;
import ro.code4.expertconsultation.user.model.persistence.User;

public interface InvitationService {
    Invitation getInvitation(String code);

    Invitation create(User user);

    boolean isValid(SignUpRequest signUpRequest);

    void markAsUsed(String code);
}
