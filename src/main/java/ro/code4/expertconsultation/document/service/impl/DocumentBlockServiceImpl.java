package ro.code4.expertconsultation.document.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.code4.expertconsultation.document.mapper.DocumentBlockMapper;
import ro.code4.expertconsultation.document.model.dto.DocumentBlockDto;
import ro.code4.expertconsultation.document.model.persistence.Document;
import ro.code4.expertconsultation.document.model.persistence.DocumentBlock;
import ro.code4.expertconsultation.document.repository.DocumentBlockRepository;
import ro.code4.expertconsultation.document.repository.DocumentRepository;
import ro.code4.expertconsultation.document.service.DocumentBlockService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocumentBlockServiceImpl implements DocumentBlockService {
    private final DocumentBlockRepository documentBlockRepository;
    private final DocumentRepository documentRepository;
    private final DocumentBlockMapper documentBlockMapper;

    @Transactional(readOnly = true)
    @Override
    public List<DocumentBlockDto> list(final Long documentId) {
        final List<DocumentBlock> documentBlocks = documentRepository.findDocumentBlocks(documentId);
        return documentBlocks.stream()
                .map(documentBlockMapper::map)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public DocumentBlockDto create(final Long documentId, final DocumentBlockDto documentBlockDto) {
        final Document document = documentRepository.getById(documentId);
        final DocumentBlock documentBlock = documentBlockMapper.map(documentBlockDto);
        documentBlock.setDocument(document);
        final DocumentBlock savedDocumentBlock = documentBlockRepository.save(documentBlock);

        return documentBlockMapper.map(savedDocumentBlock);
    }

    @Transactional(readOnly = true)
    @Override
    public DocumentBlockDto get(final Long documentId, final Long documentBlockId) {
        final DocumentBlock documentBlock = documentBlockRepository.findById(documentBlockId)
                .orElseThrow(EntityNotFoundException::new);
        return documentBlockMapper.map(documentBlock);
    }

    @Transactional
    @Override
    public DocumentBlockDto update(final Long documentId,
                                   final Long documentBlockId,
                                   final DocumentBlockDto documentBlockDto) {
        final DocumentBlock documentBlock = documentBlockRepository.findById(documentBlockId)
                .orElseThrow(EntityNotFoundException::new);

        documentBlock.setContent(documentBlockDto.getContent());
        documentBlock.setIndex(documentBlockDto.getIndex());

        final DocumentBlock savedDocumentBlock = documentBlockRepository.save(documentBlock);
        return documentBlockMapper.map(savedDocumentBlock);
    }

    @Transactional
    @Override
    public void delete(final Long documentId, final Long documentBlockId) {
        documentBlockRepository.deleteById(documentBlockId);
    }
}
