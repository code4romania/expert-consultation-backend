package ro.code4.expertconsultation.organization.model;

import lombok.Data;

@Data
public class OrganizationFilter {
    private OrganizationCategory category;
    private String name;
}
