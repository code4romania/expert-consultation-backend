package ro.code4.expertconsultation.organization.model.persistence;

import lombok.Getter;
import lombok.Setter;
import ro.code4.expertconsultation.core.model.persistence.Identifiable;
import ro.code4.expertconsultation.organization.model.OrganizationCategory;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "organizations")
@Getter
@Setter
public class Organization extends Identifiable {
    @Enumerated(EnumType.STRING)
    private OrganizationCategory category;
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
