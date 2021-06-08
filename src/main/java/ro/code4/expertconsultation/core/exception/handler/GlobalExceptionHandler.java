package ro.code4.expertconsultation.core.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ro.code4.expertconsultation.core.exception.ExpertConsultationException;
import ro.code4.expertconsultation.core.exception.ExpertConsultationExceptionResponse;
import ro.code4.expertconsultation.core.model.I18nMessage;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ExpertConsultationException.class)
    protected ResponseEntity<Object> handleLegalValidationException(final ExpertConsultationException ex) {
        return buildResponseEntity(ex.getHttpStatus(),
                Collections.singletonList(ex.getError()), ex.getFieldErrors(), null);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(final EntityNotFoundException ex) {
        final I18nMessage error = new I18nMessage("validation.Resource.not.found", null);
        return buildResponseEntity(HttpStatus.NOT_FOUND, Collections.singletonList(error), null, ex.getLocalizedMessage());
    }

    @NotNull
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
                                                                  final HttpHeaders headers,
                                                                  final HttpStatus status,
                                                                  final WebRequest request) {
        final Map<String, I18nMessage> violations = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField,
                        err -> new I18nMessage(err.getDefaultMessage(), null)));
        return buildResponseEntity(HttpStatus.BAD_REQUEST, null, violations, ex.getLocalizedMessage());
    }

    private ResponseEntity<Object> buildResponseEntity(final HttpStatus httpStatus,
                                                       final List<I18nMessage> errors,
                                                       final Map<String, I18nMessage> fieldErrors,
                                                       final String additionalInfo) {
        final ExpertConsultationExceptionResponse exceptionResponse = new ExpertConsultationExceptionResponse();
        exceptionResponse.setErrors(errors);
        exceptionResponse.setFieldErrors(fieldErrors);
        exceptionResponse.setAdditionalInfo(additionalInfo);
        return new ResponseEntity<>(exceptionResponse, httpStatus);
    }
}
