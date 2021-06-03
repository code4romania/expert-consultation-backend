package ro.code4.expertconsultation.organisation.model.persistence;

import lombok.Getter;
import lombok.Setter;
import ro.code4.expertconsultation.core.model.persistence.Identifiable;
import ro.code4.expertconsultation.organisation.model.OrganisationCategory;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "organisations")
@Getter
@Setter
public class Organisation extends Identifiable {
    @Enumerated(EnumType.STRING)
    private OrganisationCategory category;
    private String name;
    private String email;
    private String phoneNumber;
    private String website;
    private String address;
    private String contactPersonName;
    private String contactPersonEmail;
    private String logoUrl;
    private Integer numberOfMembers;
}
