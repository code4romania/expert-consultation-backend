package ro.code4.expertconsultation.core.model.persistence;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public abstract class Identifiable {
    @Id
    @GeneratedValue(generator = "sequence", strategy= GenerationType.SEQUENCE)
    private Long id;
}
