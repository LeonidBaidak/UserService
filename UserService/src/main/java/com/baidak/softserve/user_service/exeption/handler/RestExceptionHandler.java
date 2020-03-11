package com.baidak.softserve.user_service.exeption.handler;


import com.baidak.softserve.user_service.exeption.EntityNotFoundException;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<Object> handleException(Exception exception) {
        ResponseStatus status = AnnotatedElementUtils.findMergedAnnotation(exception.getClass(), ResponseStatus.class);
        HttpStatus httpStatus = status != null ? status.code() : HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorInfo errorInfo = new ErrorInfo(httpStatus, exception.getClass(), exception.getMessage());
        return new ResponseEntity<>(errorInfo, new HttpHeaders(), httpStatus);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class, MethodArgumentTypeMismatchException.class})
    protected ResponseEntity<Object> handleBadIdRequest(RuntimeException exception) {
        String bodyOfResponse = "You tried to find entity but it has a wrong type of id. Required id type should be UUID";
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST, exception.getClass(), bodyOfResponse);
        return new ResponseEntity<>(errorInfo, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
