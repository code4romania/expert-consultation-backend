package ro.code4.expertconsultation.document.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.code4.expertconsultation.document.model.dto.DocumentDto;
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

    @GetMapping("/{id}")
    public DocumentDto get(@PathVariable final Long id) {
        return documentService.get(id);
    }

}
