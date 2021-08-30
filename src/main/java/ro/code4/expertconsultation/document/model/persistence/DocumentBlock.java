package ro.code4.expertconsultation.document.model.persistence;

import lombok.*;
import ro.code4.expertconsultation.core.model.persistence.Identifiable;

import javax.persistence.*;

@Builder
@Entity
@Table(name = "document_blocks", indexes = @Index(columnList = "document_id"))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentBlock extends Identifiable {
    @Column(columnDefinition="TEXT")
    private String content;
    private Integer index;
    @ManyToOne(fetch = FetchType.LAZY)
    private Document document;
}
