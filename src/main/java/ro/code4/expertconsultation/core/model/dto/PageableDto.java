package ro.code4.expertconsultation.core.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageableDto {
    private Integer pageSize;
    private Integer pageNumber;
}
