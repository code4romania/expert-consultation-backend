package ro.code4.expertconsultation.document.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.code4.expertconsultation.document.model.dto.DocumentBlockDto;
import ro.code4.expertconsultation.document.model.persistence.DocumentBlock;

@Mapper(componentModel = "spring")
public interface DocumentBlockMapper {
    @Mapping(target = "document", ignore = true)
    DocumentBlock map(DocumentBlockDto documentBlockDto);

    DocumentBlockDto map(DocumentBlock documentBlock);
}
