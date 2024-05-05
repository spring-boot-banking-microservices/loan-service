package org.example.loanservice.constants;

import lombok.Getter;

@Getter
public enum LoanConstants {
  // Loan
  LOAN("Loan"),

  // Loan Types
  HOME_LOAN("Home Loan"),

  // Loan Limit
  LOAN_LIMIT(1_00_000),

  // HTTP Status Codes
  STATUS_201("201"),
  STATUS_200("200"),
  STATUS_500("500"),

  // Success Messages
  MESSAGE_201("Loan created successfully"),
  MESSAGE_200("Request processed successfully"),

  // Error Messages
  MESSAGE_500("An error occurred. Please try again later");

  private final String stringValue;
  private final int intValue;

  LoanConstants(String stringValue) {
    this.stringValue = stringValue;
    this.intValue = 0;
  }

  LoanConstants(int intValue) {
    this.intValue = intValue;
    this.stringValue = null;
  }
}
