package ro.code4.expertconsultation.comment.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.code4.expertconsultation.comment.mapper.CommentMapper;
import ro.code4.expertconsultation.comment.model.CommentCreationRequest;
import ro.code4.expertconsultation.comment.model.dto.CommentDto;
import ro.code4.expertconsultation.comment.model.persistence.Comment;
import ro.code4.expertconsultation.comment.repository.CommentRepository;
import ro.code4.expertconsultation.comment.service.CommentService;
import ro.code4.expertconsultation.core.exception.ExpertConsultationException;
import ro.code4.expertconsultation.core.model.I18nMessage;
import ro.code4.expertconsultation.document.model.persistence.DocumentBlock;
import ro.code4.expertconsultation.document.service.DocumentBlockService;
import ro.code4.expertconsultation.user.model.persistence.User;
import ro.code4.expertconsultation.user.service.UserService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    private final DocumentBlockService documentBlockService;

    private final CommentMapper commentMapper;

    private final UserService userService;

    @Override
    @Transactional(readOnly = true)
    public List<CommentDto> list(final Long documentBlockId) {
        if (documentBlockId == null) {
            throw ExpertConsultationException.builder()
                    .error(new I18nMessage(I18nMessage.NULL_ARGUMENTS_RECEIVED))
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .build();
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
            throw ExpertConsultationException.builder()
                    .error(new I18nMessage(I18nMessage.NULL_ARGUMENTS_RECEIVED))
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .build();
        }

        Comment comment = commentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return commentMapper.map(comment);

    }

    @Override
    @Transactional
    public CommentDto create(CommentCreationRequest commentCreationRequest) {
        Long userId = null;
        Long documentId = null;
        Long blockId = null;
        CommentDto commentDto = null;

        boolean isNull = commentCreationRequest == null;

        if (!isNull) {
            userId = commentCreationRequest.getUserId();
            documentId = commentCreationRequest.getDocumentId();
            blockId = commentCreationRequest.getBlockId();
            commentDto = commentCreationRequest.getCommentDto();

            isNull = Stream.of(userId, documentId, blockId, commentDto)
                    .anyMatch(Objects::isNull);
        }

        if (isNull) {
            throw ExpertConsultationException.builder()
                    .error(new I18nMessage(I18nMessage.NULL_ARGUMENTS_RECEIVED))
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .build();
        }

        final User author = userService.getEntity(userId);

        final DocumentBlock documentBlock = documentBlockService.getEntity(blockId);

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
            throw ExpertConsultationException.builder()
                    .error(new I18nMessage(I18nMessage.NULL_ARGUMENTS_RECEIVED))
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .build();
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
            throw ExpertConsultationException.builder()
                    .error(new I18nMessage(I18nMessage.NULL_ARGUMENTS_RECEIVED))
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .build();
        }
        commentRepository.deleteById(commentId);
    }
}
