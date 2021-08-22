package ro.code4.expertconsultation.invitation.service.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.code4.expertconsultation.authentication.model.SignUpRequest;
import ro.code4.expertconsultation.core.exception.ExpertConsultationException;
import ro.code4.expertconsultation.core.model.I18nMessage;
import ro.code4.expertconsultation.invitation.model.persistence.Invitation;
import ro.code4.expertconsultation.invitation.model.persistence.InvitationStatus;
import ro.code4.expertconsultation.invitation.repository.InvitationRepository;
import ro.code4.expertconsultation.invitation.service.InvitationService;
import ro.code4.expertconsultation.user.model.persistence.User;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
public class InvitationServiceImpl implements InvitationService {
    private final InvitationRepository invitationRepository;

    @Autowired
    public InvitationServiceImpl(final InvitationRepository invitationRepository) {
        this.invitationRepository = invitationRepository;
    }

    @Override
    public Invitation getInvitation(final String code) {
        final Invitation invitation = invitationRepository.findByCode(code)
                .orElseThrow(EntityNotFoundException::new);

        if (!InvitationStatus.PENDING.equals(invitation.getStatus())) {
            throw ExpertConsultationException.builder()
                    .error(new I18nMessage("user.invitation.invalid"))
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .build();
        }

        return invitation;
    }

    @Override
    public Invitation create(final User user) {
        Invitation invitation = new Invitation();
        invitation.setStatus(InvitationStatus.PENDING);
        invitation.setUser(user);
        invitation.setCode(RandomStringUtils.randomAlphanumeric(10));

        return invitationRepository.save(invitation);
    }

    @Override
    public boolean isValid(final SignUpRequest signUpRequest) {
        final Invitation invitation = invitationRepository.findByCode(signUpRequest.getInvitationCode())
                .orElseThrow(EntityNotFoundException::new);

        return InvitationStatus.PENDING.equals(invitation.getStatus())
                && signUpRequest.getEmail().equals(invitation.getUser().getEmail());
    }

    @Override
    public void markAsUsed(final String code) {
        final Invitation invitation = invitationRepository.findByCode(code)
                .orElseThrow(EntityNotFoundException::new);

        invitation.setStatus(InvitationStatus.USED);
        invitationRepository.save(invitation);
    }
}
