package ro.code4.expertconsultation.document.service;

import ro.code4.expertconsultation.document.model.dto.DocumentBlockDto;
import ro.code4.expertconsultation.document.model.persistence.DocumentBlock;

import java.util.List;

public interface DocumentBlockService {
    List<DocumentBlockDto> list(Long documentId);

    DocumentBlockDto create(Long documentId, DocumentBlockDto documentBlockDto);

    DocumentBlockDto get(Long documentId, Long documentBlockId);

    DocumentBlockDto update(Long documentId, Long documentBlockId, DocumentBlockDto documentBlockDto);

    void delete(Long documentId, Long documentBlockId);

    DocumentBlock getEntity(Long documentId, Long documentBlockId);
}
