package ro.code4.expertconsultation.utils.factory;

import ro.code4.expertconsultation.document.model.DocumentState;
import ro.code4.expertconsultation.document.model.DocumentType;
import ro.code4.expertconsultation.document.model.persistence.Document;

import static ro.code4.expertconsultation.utils.FactoryManager.TEST_TEXT;

public class DocumentFactory {

    public Document getDocumentEntity() {
        Document document = Document.builder()
                .state(DocumentState.DRAFT)
                .title(TEST_TEXT)
                .type(DocumentType.LEGE)
                .build();

        document.setId(1L);
        return document;
    }
}
