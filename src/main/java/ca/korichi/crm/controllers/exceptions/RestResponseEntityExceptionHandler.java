package ca.korichi.crm.controllers.exceptions;

import ca.korichi.crm.services.exceptions.ExceptionInfo;
import ca.korichi.crm.services.news.NewsNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {NewsNotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(RuntimeException exception, WebRequest request) {
        ExceptionInfo bodyOfResponse = new ExceptionInfo(exception.getMessage());

        return handleExceptionInternal(exception, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
