package ro.code4.expertconsultation.utils.factory;


import ro.code4.expertconsultation.document.model.dto.DocumentBlockDto;
import ro.code4.expertconsultation.document.model.persistence.DocumentBlock;

import java.util.List;

import static ro.code4.expertconsultation.utils.FactoryManager.*;

public class DocumentBlockFactory {

    public DocumentBlock getDocumentBlockEntity() {
        DocumentBlock documentBlock = DocumentBlock.builder()
                .document(documentFactory.getDocumentEntity())
                .content(TEST_TEXT)
                .index(1)
                .build();

        documentBlock.setId(1L);
        return documentBlock;
    }

    public DocumentBlockDto getDocumentBlockDto() {
        DocumentBlockDto documentBlockDto = DocumentBlockDto.builder()
                .content(TEST_TEXT)
                .index(1)
                .comments(List.of(commentFactory.getCommentDto()))
                .build();

        documentBlockDto.setId(1L);
        return documentBlockDto;
    }
}
