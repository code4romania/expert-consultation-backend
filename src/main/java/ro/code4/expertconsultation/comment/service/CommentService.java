package ro.code4.expertconsultation.comment.service;

import ro.code4.expertconsultation.comment.model.CommentCreationRequest;
import ro.code4.expertconsultation.comment.model.dto.CommentDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> list(Long blockId);

    CommentDto get(Long id);

    CommentDto create(CommentCreationRequest commentCreationRequest);

    CommentDto update(Long commentId, CommentDto commentDto);

    void delete(Long commentId);

}
