package ro.code4.expertconsultation.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.code4.expertconsultation.comment.model.persistence.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
