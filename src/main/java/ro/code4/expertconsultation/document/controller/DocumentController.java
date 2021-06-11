package ro.code4.expertconsultation.document.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ro.code4.expertconsultation.core.model.dto.PageDto;
import ro.code4.expertconsultation.document.model.DocumentFilter;
import ro.code4.expertconsultation.document.model.dto.DocumentDto;
import ro.code4.expertconsultation.document.model.dto.DocumentListDto;
import ro.code4.expertconsultation.document.service.DocumentService;

@RestController
@RequestMapping("/api/documents")
@RequiredArgsConstructor
public class DocumentController {
    private final DocumentService documentService;

    @PostMapping
    public DocumentDto create(@RequestBody final DocumentDto documentDto) {
        return documentService.create(documentDto);
    }

    @GetMapping
    public PageDto<DocumentListDto> list(final DocumentFilter documentFilter,
                                         final Pageable pageable) {
        final Page<DocumentListDto> documentDtosPage = documentService.list(documentFilter, pageable);
        return new PageDto<>(documentDtosPage);
    }

    @GetMapping("/{id}")
    public DocumentDto get(@PathVariable final Long id) {
        return documentService.get(id);
    }

}
