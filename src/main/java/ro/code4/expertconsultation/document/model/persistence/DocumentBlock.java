package ro.code4.expertconsultation.document.model.persistence;

import lombok.Getter;
import lombok.Setter;
import ro.code4.expertconsultation.core.model.persistence.Identifiable;

import javax.persistence.*;

@Entity
@Table(name = "document_blocks", indexes = @Index(columnList = "document_id"))
@Getter
@Setter
public class DocumentBlock extends Identifiable {
    private String content;
    private Integer index;
    @ManyToOne(fetch = FetchType.LAZY)
    private Document document;
}
