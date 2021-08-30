package ro.code4.expertconsultation.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.code4.expertconsultation.comment.model.persistence.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
