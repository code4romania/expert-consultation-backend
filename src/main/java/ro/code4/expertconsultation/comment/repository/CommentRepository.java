package ro.code4.expertconsultation.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.code4.expertconsultation.comment.model.persistence.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT cmt FROM Comment cmt WHERE cmt.documentBlock.id=:documentBlockId ORDER BY cmt.creationTime")
    List<Comment> findCommentsByDocumentBlock(Long documentBlockId);
}
