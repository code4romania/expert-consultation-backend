package ro.code4.expertconsultation.document.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import ro.code4.expertconsultation.document.model.dto.DocumentDto;
import ro.code4.expertconsultation.document.model.persistence.Document;
import ro.code4.expertconsultation.document.model.persistence.DocumentBlock;
import ro.code4.expertconsultation.document.repository.DocumentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class DocumentBlocksMapper {
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private DocumentBlockMapper documentBlockMapper;

    @AfterMapping
    public void fetchDocumentBlocks(@MappingTarget DocumentDto dto, Document document) {
        final List<DocumentBlock> documentBlocks = documentRepository.findDocumentBlocks(document.getId());
        dto.setBlocks(documentBlocks.stream()
                .map(documentBlockMapper::map)
                .collect(Collectors.toList()));
    }
}
