package ro.code4.expertconsultation.core.exception;

import lombok.Getter;
import lombok.Setter;
import ro.code4.expertconsultation.core.model.I18nMessage;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ExpertConsultationExceptionResponse {
    private List<I18nMessage> errors;
    private Map<String, I18nMessage> fieldErrors;
    private String additionalInfo;
}
