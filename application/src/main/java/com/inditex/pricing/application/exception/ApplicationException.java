package com.inditex.pricing.application.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApplicationException extends RuntimeException {

  private final HttpStatus status;

  public ApplicationException(HttpStatus status, String message) {
    super(message);
    this.status = status;
  }

  public ApplicationException(HttpStatus status, String message, Throwable cause) {
    super(message, cause);
    this.status = status;
  }
}
