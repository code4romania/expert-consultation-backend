package ro.code4.expertconsultation.document.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import ro.code4.expertconsultation.document.model.persistence.Document;
import ro.code4.expertconsultation.document.model.persistence.DocumentBlock;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long>, QuerydslPredicateExecutor<Document> {

    @Query("SELECT db FROM DocumentBlock db WHERE db.document.id=:documentId ORDER BY db.index")
    List<DocumentBlock> findDocumentBlocks(Long documentId);
}
