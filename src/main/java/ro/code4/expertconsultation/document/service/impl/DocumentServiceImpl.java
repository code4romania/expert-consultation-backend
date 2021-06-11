package ro.code4.expertconsultation.document.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.code4.expertconsultation.document.mapper.DocumentBlockMapper;
import ro.code4.expertconsultation.document.mapper.DocumentMapper;
import ro.code4.expertconsultation.document.model.dto.DocumentDto;
import ro.code4.expertconsultation.document.model.persistence.Document;
import ro.code4.expertconsultation.document.model.persistence.DocumentBlock;
import ro.code4.expertconsultation.document.repository.DocumentBlockRepository;
import ro.code4.expertconsultation.document.repository.DocumentRepository;
import ro.code4.expertconsultation.document.service.DocumentService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepository;
    private final DocumentBlockRepository documentBlockRepository;
    private final DocumentBlockMapper documentBlockMapper;
    private final DocumentMapper documentMapper;

    @Transactional
    @Override
    public DocumentDto create(final DocumentDto documentDto) {
        final Document document = documentMapper.map(documentDto);
        final Document savedDocument = documentRepository.save(document);

        final List<DocumentBlock> documentBlocks = documentDto.getBlocks().stream()
                .map(documentBlockMapper::map)
                .peek(documentBlock -> documentBlock.setDocument(savedDocument))
                .collect(Collectors.toList());
        documentBlockRepository.saveAll(documentBlocks);

        return documentMapper.map(savedDocument);
    }

    @Transactional(readOnly = true)
    @Override
    public DocumentDto get(final Long documentId) {
        final Document document = documentRepository.findById(documentId)
                .orElseThrow(EntityNotFoundException::new);
        return documentMapper.map(document);
    }
}
