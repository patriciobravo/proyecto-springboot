package cl.springboot.ms.handler;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cl.springboot.ms.dto.ErrorResponse;
import cl.springboot.ms.exception.DomainException;

@RestControllerAdvice
public class HandlerController {


    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ErrorResponse> domainError(DomainException exception) {

        return buildResponseWithDomainException(exception);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> generalError(Exception exception) {

        return buildResponse(100, HttpStatus.INTERNAL_SERVER_ERROR, "general_error", exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException exception) {

        List<String> errors = exception.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());

        return buildResponse(101, HttpStatus.BAD_REQUEST, "validation_error", errors);
    }

    private ResponseEntity<ErrorResponse> buildResponse(Integer codeAppError, HttpStatus httpStatus, String messageKey, Object detail) {

        var errorResponse = ErrorResponse.builder()
                .codeAppError(codeAppError)
                .httpStatus(httpStatus.value())
                .message(messageKey)
                .detailMessage(detail)
                .build();

        return new ResponseEntity<ErrorResponse>(errorResponse, httpStatus);
    }


    private ResponseEntity<ErrorResponse> buildResponseWithDomainException(DomainException exception) {

        var httpStatusFound = HttpStatus.valueOf(exception.getCode().getStatusCode());

        var errorResponse = ErrorResponse.builder()
                .codeAppError(exception.getCode().getCodeApp())
                .httpStatus(httpStatusFound.value())
                .message(exception.getCode().getMessageKey())
                .detailMessage(exception.getMessage())
                .build();

        return new ResponseEntity<ErrorResponse>(errorResponse, httpStatusFound);
    }
}
