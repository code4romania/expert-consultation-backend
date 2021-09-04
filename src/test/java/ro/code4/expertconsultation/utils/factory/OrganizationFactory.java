package ro.code4.expertconsultation.utils.factory;

import ro.code4.expertconsultation.organization.model.OrganizationCategory;
import ro.code4.expertconsultation.organization.model.persistence.Organization;

import static ro.code4.expertconsultation.utils.FactoryManager.TEST_TEXT;

public class OrganizationFactory {


    public Organization getOrganizationEntity() {
        Organization organization = Organization.builder()
                .category(OrganizationCategory.NGO)
                .name(TEST_TEXT)
                .build();
        organization.setId(1L);
        return organization;
    }
}
