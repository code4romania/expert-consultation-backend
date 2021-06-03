package ro.code4.expertconsultation.core.exception;

import lombok.Getter;
import lombok.Setter;
import ro.code4.expertconsultation.core.model.I18nError;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ExpertConsultationExceptionResponse {
    private List<I18nError> i18nErrors;
    private Map<String, I18nError> i18nFieldErrors;
    private String additionalInfo;
}
