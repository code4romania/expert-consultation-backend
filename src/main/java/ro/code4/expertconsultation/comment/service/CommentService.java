package ro.code4.expertconsultation.comment.service;

import ro.code4.expertconsultation.comment.model.dto.CommentDto;

public interface CommentService {

    CommentDto get(Long id);

    CommentDto create(Long userId, Long documentId, Long blockId, CommentDto commentDto);

    CommentDto update(Long commentId, CommentDto commentDto);

    void delete(Long commentId);

}
