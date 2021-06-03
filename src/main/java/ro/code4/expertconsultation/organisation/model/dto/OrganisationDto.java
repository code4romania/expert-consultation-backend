package ro.code4.expertconsultation.organisation.model.dto;

import lombok.Getter;
import lombok.Setter;
import ro.code4.expertconsultation.core.model.dto.IdentifiableDto;
import ro.code4.expertconsultation.organisation.model.OrganisationCategory;

@Getter
@Setter
public class OrganisationDto extends IdentifiableDto {
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
