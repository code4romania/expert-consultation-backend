package ro.code4.expertconsultation.comment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ro.code4.expertconsultation.comment.model.dto.CommentDto;

@Getter
@Setter
@AllArgsConstructor
public class CommentCreationRequest {

    private  Long userId;

    private  Long documentId;

    private  Long blockId;

    private  CommentDto commentDto;
}
