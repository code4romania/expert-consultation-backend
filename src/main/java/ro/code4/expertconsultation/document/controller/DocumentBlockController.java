package ro.code4.expertconsultation.document.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.code4.expertconsultation.document.model.dto.DocumentBlockDto;
import ro.code4.expertconsultation.document.service.DocumentBlockService;

import java.util.List;

@RestController
@RequestMapping("/api/documents/{documentId}/blocks")
@RequiredArgsConstructor
public class DocumentBlockController {
    private final DocumentBlockService documentBlockService;

    @GetMapping
    public List<DocumentBlockDto> list(@PathVariable final Long documentId) {
        return documentBlockService.list(documentId);
    }

    @PostMapping
    public DocumentBlockDto create(@PathVariable final Long documentId,
                                   @RequestBody final DocumentBlockDto documentBlockDto) {
        return documentBlockService.create(documentId, documentBlockDto);
    }

    @GetMapping("/{id}")
    public DocumentBlockDto get(@PathVariable final Long documentId,
                                @PathVariable final Long id) {
        return documentBlockService.get(documentId, id);
    }

    @PutMapping("/{id}")
    public DocumentBlockDto update(@PathVariable final Long documentId,
                                   @PathVariable final Long id,
                                   @RequestBody final DocumentBlockDto documentBlockDto) {
        return documentBlockService.update(documentId, id, documentBlockDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable final Long documentId,
                       @PathVariable final Long id) {
        documentBlockService.delete(documentId, id);
    }
}
