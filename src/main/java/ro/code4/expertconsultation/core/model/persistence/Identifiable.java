package ro.code4.expertconsultation.core.model.persistence;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

@Getter
@Setter
public abstract class Identifiable {
    @Id
    private ObjectId id;

    @Version
    private Long version;
}
