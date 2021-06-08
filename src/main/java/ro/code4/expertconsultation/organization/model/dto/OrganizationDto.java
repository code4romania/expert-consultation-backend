package ro.code4.expertconsultation.organization.model.dto;

import lombok.Getter;
import lombok.Setter;
import ro.code4.expertconsultation.core.model.dto.IdentifiableDto;
import ro.code4.expertconsultation.organization.model.OrganizationCategory;

@Getter
@Setter
public class OrganizationDto extends IdentifiableDto {
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
