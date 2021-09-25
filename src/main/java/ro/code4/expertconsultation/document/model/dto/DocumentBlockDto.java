package ro.code4.expertconsultation.document.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ro.code4.expertconsultation.comment.model.dto.CommentDto;
import ro.code4.expertconsultation.core.model.dto.IdentifiableDto;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class DocumentBlockDto extends IdentifiableDto {
    private String content;
    private Integer index;
    private List<CommentDto> comments;
}
