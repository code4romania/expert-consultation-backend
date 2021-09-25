package ro.code4.expertconsultation.comment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.code4.expertconsultation.comment.model.CommentCreationRequest;
import ro.code4.expertconsultation.comment.model.dto.CommentDto;
import ro.code4.expertconsultation.comment.service.CommentService;

import java.util.List;


@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {
    private CommentService commentService;

    @PostMapping
    public CommentDto create(
            @RequestBody CommentCreationRequest commentCreationRequest) {
        return commentService.create(commentCreationRequest);
    }

    @GetMapping("/{id}")
    public CommentDto get(@PathVariable final Long id) {
        return commentService.get(id);
    }

    @GetMapping("/{blockId}")
    public List<CommentDto> list(@PathVariable final Long blockId) {
        return commentService.list(blockId);
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
