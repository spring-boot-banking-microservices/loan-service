package org.example.loanservice.constants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LoanConstantsTest {

  @Test
  void testStringValueConstants() {
    // Given
    LoanConstants loan = LoanConstants.LOAN;
    LoanConstants homeLoan = LoanConstants.HOME_LOAN;
    LoanConstants status201 = LoanConstants.STATUS_201;
    LoanConstants status200 = LoanConstants.STATUS_200;
    LoanConstants status500 = LoanConstants.STATUS_500;
    LoanConstants message201 = LoanConstants.MESSAGE_201;
    LoanConstants message200 = LoanConstants.MESSAGE_200;
    LoanConstants message500 = LoanConstants.MESSAGE_500;

    // Then
    assertNotNull(loan);
    assertNotNull(homeLoan);
    assertNotNull(status201);
    assertNotNull(status200);
    assertNotNull(status500);
    assertNotNull(message201);
    assertNotNull(message200);
    assertNotNull(message500);

    assertEquals("Loan", loan.getStringValue());
    assertEquals("Home Loan", homeLoan.getStringValue());
    assertEquals("201", status201.getStringValue());
    assertEquals("200", status200.getStringValue());
    assertEquals("500", status500.getStringValue());
    assertEquals("Loan created successfully", message201.getStringValue());
    assertEquals("Request processed successfully", message200.getStringValue());
    assertEquals("An error occurred. Please try again later", message500.getStringValue());
  }

  @Test
  void testIntValueConstants() {
    // Given
    LoanConstants loanLimit = LoanConstants.LOAN_LIMIT;

    // Then
    assertNotNull(loanLimit);

    assertEquals(1_00_000, loanLimit.getIntValue());
  }
}