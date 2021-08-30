package ro.code4.expertconsultation.comment.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.code4.expertconsultation.comment.mapper.CommentMapper;
import ro.code4.expertconsultation.comment.model.dto.CommentDto;
import ro.code4.expertconsultation.comment.model.persistence.Comment;
import ro.code4.expertconsultation.comment.repository.CommentRepository;
import ro.code4.expertconsultation.comment.service.CommentService;
import ro.code4.expertconsultation.document.model.persistence.DocumentBlock;
import ro.code4.expertconsultation.document.service.DocumentBlockService;
import ro.code4.expertconsultation.exception.InvalidArgumentException;
import ro.code4.expertconsultation.user.model.persistence.User;
import ro.code4.expertconsultation.user.service.UserService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;

    private DocumentBlockService documentBlockService;

    private CommentMapper commentMapper;

    private UserService userService;

    @Override
    @Transactional(readOnly = true)
    public List<CommentDto> list(final Long documentBlockId) {
        if (documentBlockId == null) {
            throw new InvalidArgumentException("Arguments cannot be null");
        }

        final List<Comment> comments = commentRepository.findCommentsByDocumentBlock(documentBlockId);
        return comments.stream()
                .map(commentMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CommentDto get(Long id) {
        if (id == null) {
            throw new InvalidArgumentException("Arguments cannot be null");
        }

        Comment comment = commentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return commentMapper.map(comment);

    }

    @Override
    @Transactional
    public CommentDto create(Long userId, Long documentId, Long blockId, CommentDto commentDto) {

        if (((userId == null) || (documentId == null) || (blockId == null) || (commentDto == null))) {
            throw new InvalidArgumentException("Arguments cannot be null");
        }

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
        if ((commentId == null) || (commentDto == null)) {
            throw new InvalidArgumentException("Arguments cannot be null");
        }

        Comment comment = commentRepository.findById(commentId).orElseThrow(EntityNotFoundException::new);
        comment.setContent(commentDto.getContent());

        commentRepository.save(comment);
        return commentMapper.map(comment);

    }

    @Override
    @Transactional
    public void delete(Long commentId) {
        if (commentId == null) {
            throw new InvalidArgumentException("Arguments cannot be null");
        }
        commentRepository.deleteById(commentId);
    }
}
