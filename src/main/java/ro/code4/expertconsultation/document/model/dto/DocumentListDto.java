package ro.code4.expertconsultation.document.model.dto;

import lombok.Getter;
import lombok.Setter;
import ro.code4.expertconsultation.core.model.persistence.Identifiable;
import ro.code4.expertconsultation.document.model.DocumentState;
import ro.code4.expertconsultation.document.model.DocumentType;

@Getter
@Setter
public class DocumentListDto extends Identifiable {
    private DocumentType type;
    private DocumentState state;
    private String title;
}
