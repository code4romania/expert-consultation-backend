package ro.code4.expertconsultation.comment.mapper;

import org.mapstruct.Mapper;
import ro.code4.expertconsultation.comment.model.dto.CommentDto;
import ro.code4.expertconsultation.comment.model.persistence.Comment;

@Mapper(componentModel = "spring")
public interface CommentMapper {


    CommentDto map(Comment comment);


    Comment map(CommentDto commentDto);
}
