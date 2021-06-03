package ro.code4.expertconsultation.core.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import ro.code4.expertconsultation.core.model.I18nError;

import java.util.List;
import java.util.Map;

@Getter
@Builder
public class ExpertConsultationException extends RuntimeException {
    private final String i18nKey;
    private final List<String> i8nArguments;
    private final HttpStatus httpStatus;
    private final Map<String, I18nError> i18nFieldErrors;
}
