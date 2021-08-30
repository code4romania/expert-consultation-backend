package ro.code4.expertconsultation.comment.model.dto;

import lombok.*;
import ro.code4.expertconsultation.core.model.dto.IdentifiableDto;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CommentDto extends IdentifiableDto {
    private Timestamp creationTime;
    private String content;

}