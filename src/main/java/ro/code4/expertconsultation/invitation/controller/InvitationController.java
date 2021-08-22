package ro.code4.expertconsultation.invitation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.code4.expertconsultation.invitation.mapper.InvitationMapper;
import ro.code4.expertconsultation.invitation.model.dto.InvitationDto;
import ro.code4.expertconsultation.invitation.model.persistence.Invitation;
import ro.code4.expertconsultation.invitation.service.InvitationService;

@RestController
@RequestMapping("/api/invitations")
public class InvitationController {
    private final InvitationService invitationService;
    private final InvitationMapper invitationMapper;

    @Autowired
    public InvitationController(final InvitationService invitationService,
                                final InvitationMapper invitationMapper) {
        this.invitationService = invitationService;
        this.invitationMapper = invitationMapper;
    }

    @GetMapping("/{code}")
    public ResponseEntity<InvitationDto> getInvitation(@PathVariable("code") String code) {
        final Invitation invitation = invitationService.getInvitation(code);
        return ResponseEntity.ok(invitationMapper.map(invitation));
    }
}