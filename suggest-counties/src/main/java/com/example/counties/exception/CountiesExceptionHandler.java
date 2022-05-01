package com.example.counties.exception;

import java.util.Map;

import com.example.counties.logger.CountiesAppLogger;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * This class is used to handle all exceptions thrown by the application.
 * 
 * @author Manoj SP
 * @since 1.0
 * @see ResponseEntityExceptionHandler
 * @see RestControllerAdvice
 */
@RestControllerAdvice
public class CountiesExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * It handles all exceptions thrown by the application and returns a 400
     * response with the error
     * message
     * 
     * @param ex      The exception object
     * @param request The request that triggered the exception
     * @return A ResponseEntity object with a body of a Map object with a single
     *         key-value pair.
     */
    @ExceptionHandler(CountiesAppException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        CountiesAppLogger.error("Exception occurred : " + ExceptionUtils.getStackTrace(ex));
        return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
    }

    /**
     * This function is called when an exception is thrown from a controller and the
     * exception is not
     * handled by any other exception handler
     * 
     * @param ex      The exception that was thrown.
     * @param body    The body of the response.
     * @param headers HttpHeaders
     * @param status  The HTTP status code to use for the response.
     * @param request The current request.
     * @return A ResponseEntity object with a body of a Map with a single key-value
     *         pair.
     */
    @Override
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        CountiesAppLogger.error("Internal Exception occurred : " + ExceptionUtils.getStackTrace(ex));
        return ResponseEntity.internalServerError().body(Map.of("error", SuggestCountiesErrorConstants.UNKNOWN_ERROR));
    }
}
