package org.example.loanservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class LoanAlreadyExistsException extends RuntimeException {
  public LoanAlreadyExistsException(String resourceName, String fieldName, String fieldValue) {
    super(String.format("%s with %s '%s' already exists", resourceName, fieldName, fieldValue));
  }
}
