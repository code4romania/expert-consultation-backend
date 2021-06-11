package ro.code4.expertconsultation.document.model.dto;

import lombok.Getter;
import lombok.Setter;
import ro.code4.expertconsultation.core.model.dto.IdentifiableDto;
import ro.code4.expertconsultation.document.model.DocumentState;
import ro.code4.expertconsultation.document.model.DocumentType;

import java.util.List;

@Getter
@Setter
public class DocumentDto extends IdentifiableDto {
    private DocumentType type;
    private DocumentState state;
    private String title;
    private List<DocumentBlockDto> blocks;
}
