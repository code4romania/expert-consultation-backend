package ro.code4.expertconsultation.comment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.code4.expertconsultation.comment.model.dto.CommentDto;
import ro.code4.expertconsultation.comment.service.CommentService;


@RestController
@RequestMapping("/api/documents/{documentId}/blocks/{blockId}/comments")
@RequiredArgsConstructor
public class CommentController {
    private CommentService commentService;

    @PostMapping
    public CommentDto create(
            @PathVariable final Long userId,
            @PathVariable final Long documentId,
            @PathVariable final Long blockId,
            @RequestBody CommentDto commentDto) {
        return commentService.create(userId, documentId, blockId, commentDto);
    }

    @GetMapping("/{id}")
    public CommentDto get(@PathVariable final Long id) {
        return commentService.get(id);
    }

    @PutMapping("/{id}")
    public CommentDto update(@PathVariable final Long id,
                             @RequestBody final CommentDto commentDto) {
        return commentService.update(id, commentDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable final Long id) {
        commentService.delete(id);
    }

}
