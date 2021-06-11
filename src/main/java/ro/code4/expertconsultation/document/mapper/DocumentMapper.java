package ro.code4.expertconsultation.document.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.code4.expertconsultation.document.model.dto.DocumentDto;
import ro.code4.expertconsultation.document.model.dto.DocumentListDto;
import ro.code4.expertconsultation.document.model.persistence.Document;

@Mapper(componentModel = "spring", uses = {DocumentBlocksMapper.class})
public interface DocumentMapper {
    Document map(DocumentDto documentDto);

    @Mapping(target = "blocks", ignore = true)
    DocumentDto map(Document document);

    DocumentListDto mapToListDto(Document document);
}
