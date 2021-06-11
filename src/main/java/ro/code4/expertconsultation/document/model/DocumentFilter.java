package ro.code4.expertconsultation.document.model;

import lombok.Data;

@Data
public class DocumentFilter {
    private DocumentType type;
    private DocumentState state;
    private String title;
}
