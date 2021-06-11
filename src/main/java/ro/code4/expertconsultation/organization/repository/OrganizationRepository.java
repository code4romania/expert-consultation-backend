package ro.code4.expertconsultation.organization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import ro.code4.expertconsultation.organization.model.persistence.Organization;
import ro.code4.expertconsultation.user.model.persistence.User;

import java.util.List;

@Repository
public interface OrganizationRepository extends
        JpaRepository<Organization, Long>, QuerydslPredicateExecutor<Organization> {

    @Query("SELECT u FROM User u where u.organization.id=:organisationId")
    List<User> findOrganizationMembers(Long organisationId);

}
