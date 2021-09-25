package ro.code4.expertconsultation.utils.factory;

import ro.code4.expertconsultation.user.model.persistence.User;

import static ro.code4.expertconsultation.utils.FactoryManager.*;

public class UserFactory {

    public  User getUserEntity() {
        User user = User.builder()
                .name("Test User")
                .email("test@test.com")
                .password("$2a$10$x7A2ascdJ1p5/3afgYMbgeyy5dNATmzJWT5xSdOVEJIIRnpQuKchy")
                .phoneNumber("0711111111")
                .organization(organizationFactory.getOrganizationEntity())
                .build();

        user.setId(1L);
        return user;
    }
}
