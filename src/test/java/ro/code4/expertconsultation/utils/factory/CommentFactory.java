package ro.code4.expertconsultation.utils.factory;

import ro.code4.expertconsultation.comment.model.dto.CommentDto;
import ro.code4.expertconsultation.comment.model.persistence.Comment;

import java.time.LocalDateTime;

import static ro.code4.expertconsultation.utils.FactoryManager.*;

public class CommentFactory {

    public Comment getCommentEntity() {

        Comment comment = Comment.builder()
                .content(TEST_TEXT)
                .creationTime(LocalDateTime.parse(DATE_TIME))
                .documentBlock(documentBlockFactory.getDocumentBlockEntity())
                .author(userFactory.getUserEntity())
                .build();

        comment.setId(1L);
        return comment;
    }

    public CommentDto getCommentDto() {
        CommentDto commentDto = CommentDto.builder()
                .content(TEST_TEXT)
                .creationTime(LocalDateTime.parse(DATE_TIME))
                .build();
        commentDto.setId(1L);
        return commentDto;
    }
}
