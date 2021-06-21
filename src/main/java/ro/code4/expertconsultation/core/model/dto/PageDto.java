package ro.code4.expertconsultation.core.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageDto<T> {
    List<T> content;

    private Integer totalPages;
    private Long totalElements;
    private PageableDto pageable;

    public PageDto(Page<T> page) {
        content = page.getContent();
        totalPages = page.getTotalPages();
        totalElements = page.getTotalElements();

        pageable = PageableDto.builder()
                .pageSize(page.getPageable().getPageSize())
                .pageNumber(page.getPageable().getPageNumber() + 1)
                .build();
    }
}
