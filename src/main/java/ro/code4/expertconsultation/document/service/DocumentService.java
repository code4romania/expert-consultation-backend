package ro.code4.expertconsultation.document.service;

import ro.code4.expertconsultation.document.model.dto.DocumentDto;

public interface DocumentService {
    DocumentDto create(DocumentDto documentDto);

    DocumentDto get(Long documentId);
}
