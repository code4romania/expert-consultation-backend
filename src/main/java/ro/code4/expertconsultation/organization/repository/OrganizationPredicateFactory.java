package ro.code4.expertconsultation.organization.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import ro.code4.expertconsultation.organization.model.OrganizationFilter;
import ro.code4.expertconsultation.organization.model.persistence.QOrganization;

public class OrganizationPredicateFactory {
    private OrganizationPredicateFactory() {

    }

    public static Predicate byFilter(final OrganizationFilter filter) {
        final QOrganization organization = QOrganization.organization;
        final BooleanBuilder whereFilter = new BooleanBuilder();

        if (filter.getCategory() != null) {
            whereFilter.and(organization.category.eq(filter.getCategory()));
        }

        if (filter.getName() != null) {
            whereFilter.and(organization.name.likeIgnoreCase("%" + filter.getName() + "%"));
        }

        return whereFilter;
    }
}
