package com.inditex.restapi.controller.config;

import com.inditex.application.exception.ApplicationException;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
// import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  private static final String ERROR_MSG = "%s thrown. Message: %s";

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<Map<String, Object>> handleRuntimeException(
      HttpServletRequest request, RuntimeException ex) {
    return handleError(request, ex, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(ResponseStatusException.class)
  public ResponseEntity<Map<String, Object>> handleResponseStatusException(
      HttpServletRequest request, RuntimeException ex) {
    if (((ResponseStatusException) ex).getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
      return handleError(request, ex, HttpStatus.BAD_REQUEST);
    }
    return handleError(request, ex, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(ApplicationException.class)
  public ResponseEntity<Map<String, Object>> handleApplicationException(
      HttpServletRequest request, ApplicationException ex) {
    return handleError(request, ex, ex.getStatus());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(
      HttpServletRequest request, MethodArgumentNotValidException ex) {
    return handleError(request, ex, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<Map<String, Object>> handleMethodArgumentTypeMismatchException(
      HttpServletRequest request, MethodArgumentTypeMismatchException ex) {
    return handleError(request, ex, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<Map<String, Object>> handleHttpMessageNotReadableException(
      HttpServletRequest request, HttpMessageNotReadableException ex) {
    return handleError(request, ex, HttpStatus.BAD_REQUEST);
  }

  //  @ExceptionHandler(AccessDeniedException.class)
  //  public ResponseEntity<Map<String, Object>> handleAccessDeniedException(
  //      HttpServletRequest request, AccessDeniedException ex) {
  //    return handleError(request, ex, HttpStatus.FORBIDDEN);
  //  }

  private ResponseEntity<Map<String, Object>> handleError(
      HttpServletRequest request, Exception ex, HttpStatus httpStatus) {
    log.error(String.format(ERROR_MSG, ex.getClass(), ex.getMessage()), ex);

    Map<String, Object> errors = fillErrorFields(request, httpStatus);
    return new ResponseEntity<>(errors, httpStatus);
  }

  private Map<String, Object> fillErrorFields(HttpServletRequest request, HttpStatus status) {
    Map<String, Object> errors = new HashMap<>();
    errors.put("message", String.format("Pricing-app exception - TraceID: %s", MDC.get("traceId")));
    errors.put("status", status.value());
    errors.put("path", request.getRequestURI());
    errors.put("timestamp", new Date());
    errors.put("error", status.getReasonPhrase());
    return errors;
  }
}
