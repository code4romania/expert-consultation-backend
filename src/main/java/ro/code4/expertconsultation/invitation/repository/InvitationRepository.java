package ro.code4.expertconsultation.invitation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.code4.expertconsultation.invitation.model.persistence.Invitation;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface InvitationRepository extends JpaRepository<Invitation, UUID> {
    Optional<Invitation> findByCode(String code);
    void deleteByUserId(UUID userId);
}
