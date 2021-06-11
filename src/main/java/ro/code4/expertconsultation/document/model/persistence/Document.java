package ro.code4.expertconsultation.document.model.persistence;

import lombok.Getter;
import lombok.Setter;
import ro.code4.expertconsultation.core.model.persistence.Identifiable;
import ro.code4.expertconsultation.document.model.DocumentState;
import ro.code4.expertconsultation.document.model.DocumentType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "documents")
@Getter
@Setter
public class Document extends Identifiable {
    @Enumerated(EnumType.STRING)
    private DocumentType type;
    @Enumerated(EnumType.STRING)
    private DocumentState state;
    private String title;
}
