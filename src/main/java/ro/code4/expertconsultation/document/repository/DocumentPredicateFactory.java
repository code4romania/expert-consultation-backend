package ro.code4.expertconsultation.document.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import ro.code4.expertconsultation.document.model.DocumentFilter;
import ro.code4.expertconsultation.document.model.persistence.QDocument;

public class DocumentPredicateFactory {
    private DocumentPredicateFactory() {
    }

    public static Predicate byFilter(final DocumentFilter filter) {
        final QDocument document = QDocument.document;
        final BooleanBuilder whereFilter = new BooleanBuilder();

        if (filter.getType() != null) {
            whereFilter.and(document.type.eq(filter.getType()));
        }

        if (filter.getState() != null) {
            whereFilter.and(document.state.eq(filter.getState()));
        }

        if (filter.getTitle() != null) {
            whereFilter.and(document.title.likeIgnoreCase("%" + filter.getTitle() + "%"));
        }

        return whereFilter;
    }

}
