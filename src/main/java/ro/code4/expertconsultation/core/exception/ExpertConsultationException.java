package ro.code4.expertconsultation.core.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import ro.code4.expertconsultation.core.model.I18nMessage;

import java.util.Map;

@Getter
@Builder
public class ExpertConsultationException extends RuntimeException {
    private final I18nMessage error;
    private final Map<String, I18nMessage> fieldErrors;
    private final HttpStatus httpStatus;
}
