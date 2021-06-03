package ro.code4.expertconsultation.organisation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.code4.expertconsultation.organisation.model.persistence.Organisation;
import ro.code4.expertconsultation.user.model.persistence.User;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrganisationRepository extends JpaRepository<Organisation, UUID> {

    @Query("SELECT u FROM User u where u.organisation.id=:organisationId")
    List<User> findOrganisationMembers(UUID organisationId);

}
