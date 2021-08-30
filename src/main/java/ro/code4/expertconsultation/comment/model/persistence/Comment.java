package ro.code4.expertconsultation.comment.model.persistence;

import lombok.*;
import ro.code4.expertconsultation.core.model.persistence.Identifiable;
import ro.code4.expertconsultation.document.model.persistence.DocumentBlock;
import ro.code4.expertconsultation.user.model.persistence.User;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Builder
@Entity
@Table(name="comments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends Identifiable {


    private Timestamp creationTime;

    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    private DocumentBlock documentBlock;

}
