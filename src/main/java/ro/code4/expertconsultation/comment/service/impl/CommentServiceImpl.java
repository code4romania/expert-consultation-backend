package ro.code4.expertconsultation.comment.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.code4.expertconsultation.comment.mapper.CommentMapper;
import ro.code4.expertconsultation.comment.model.dto.CommentDto;
import ro.code4.expertconsultation.comment.model.persistence.Comment;
import ro.code4.expertconsultation.comment.repository.CommentRepository;
import ro.code4.expertconsultation.comment.service.CommentService;
import ro.code4.expertconsultation.document.model.dto.DocumentBlockDto;
import ro.code4.expertconsultation.document.model.persistence.DocumentBlock;
import ro.code4.expertconsultation.document.service.DocumentBlockService;
import ro.code4.expertconsultation.exception.InvalidArgumentException;
import ro.code4.expertconsultation.user.model.persistence.User;
import ro.code4.expertconsultation.user.service.UserService;

import javax.persistence.EntityNotFoundException;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;

    private DocumentBlockService documentBlockService;

    private CommentMapper commentMapper;

    private UserService userService;

    @Override
    @Transactional
    public CommentDto get(Long documentId, Long blockId, Long id) {
        DocumentBlockDto documentBlockDto = documentBlockService.get(documentId, blockId);
        return documentBlockDto.getComments().stream()
                .filter(comment -> comment.getId().equals(id))
                .findFirst()
                .orElseThrow(EntityNotFoundException::new);

    }

    @Override
    @Transactional
    public CommentDto create(Long userId, Long documentId, Long blockId, CommentDto commentDto) {

        if (((userId == null) || (documentId == null) || (blockId == null) || (commentDto == null))) {
            throw new InvalidArgumentException("Arguments cannot be null"); //todo pull this into a const
        } //todo create exception handler

        final User author = userService.getEntity(userId);

        final DocumentBlock documentBlock = documentBlockService.getEntity(documentId, blockId);

        final Comment comment = commentMapper.map(commentDto);

        comment.setAuthor(author);
        comment.setDocumentBlock(documentBlock);

        final Comment savedComment = commentRepository.save(comment);
        return commentMapper.map(savedComment);
    }

    @Override
    @Transactional
    public CommentDto update(Long commentId, CommentDto commentDto) {
        Comment comment = commentRepository.getById(commentId);
        comment.setContent(commentDto.getContent());

        commentRepository.save(comment);
        return commentMapper.map(comment);

    }

    @Override
    @Transactional
    public void delete(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
