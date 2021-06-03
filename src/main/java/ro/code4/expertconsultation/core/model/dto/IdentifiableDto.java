package ro.code4.expertconsultation.core.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class IdentifiableDto {
    private UUID id;
}
