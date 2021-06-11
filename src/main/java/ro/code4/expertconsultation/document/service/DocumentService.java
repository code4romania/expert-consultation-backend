package ro.code4.expertconsultation.document.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ro.code4.expertconsultation.document.model.DocumentFilter;
import ro.code4.expertconsultation.document.model.dto.DocumentDto;
import ro.code4.expertconsultation.document.model.dto.DocumentListDto;

public interface DocumentService {
    DocumentDto create(DocumentDto documentDto);

    DocumentDto get(Long documentId);

    Page<DocumentListDto> list(DocumentFilter filter, Pageable pageable);
}
