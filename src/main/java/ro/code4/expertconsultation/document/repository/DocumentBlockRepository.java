package ro.code4.expertconsultation.document.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.code4.expertconsultation.document.model.persistence.DocumentBlock;

public interface DocumentBlockRepository extends JpaRepository<DocumentBlock, Long> {
}
