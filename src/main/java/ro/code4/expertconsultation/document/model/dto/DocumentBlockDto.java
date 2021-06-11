package ro.code4.expertconsultation.document.model.dto;

import lombok.Getter;
import lombok.Setter;
import ro.code4.expertconsultation.core.model.dto.IdentifiableDto;

@Getter
@Setter
public class DocumentBlockDto extends IdentifiableDto {
    private String content;
    private Integer index;
}
