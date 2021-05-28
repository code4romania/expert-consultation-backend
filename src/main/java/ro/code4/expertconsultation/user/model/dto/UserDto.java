package ro.code4.expertconsultation.user.model.dto;

import lombok.Getter;
import lombok.Setter;
import ro.code4.expertconsultation.core.model.dto.IdentifiableDto;

@Getter
@Setter
public class UserDto extends IdentifiableDto {
    private String firstName;
    private String lastName;
    private String email;
}
