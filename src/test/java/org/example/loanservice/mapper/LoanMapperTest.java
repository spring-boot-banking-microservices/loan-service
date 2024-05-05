package org.example.loanservice.mapper;

import org.example.loanservice.dto.LoanDto;
import org.example.loanservice.entity.Loan;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LoanMapperTest {

  @Test
  void testMapToLoanDto() {
    // Given
    Loan loan = new Loan();
    loan.setMobileNumber("1234567890");
    loan.setLoanNumber(12345678L);
    loan.setLoanType("Home Loan");
    loan.setTotalLoan(BigDecimal.valueOf(500000.00));
    loan.setAmountPaid(BigDecimal.valueOf(200000.00));
    loan.setAmountOutstanding(BigDecimal.valueOf(300000.00));

    // When
    LoanDto loanDto = LoanMapper.mapToLoanDto(loan);

    // Then
    assertNotNull(loanDto);
    assertEquals("1234567890", loanDto.mobileNumber());
    assertEquals(12345678L, loanDto.loanNumber());
    assertEquals("Home Loan", loanDto.loanType());
    assertEquals(BigDecimal.valueOf(500000.00), loanDto.totalLoan());
    assertEquals(BigDecimal.valueOf(200000.00), loanDto.amountPaid());
    assertEquals(BigDecimal.valueOf(300000.00), loanDto.amountOutstanding());
  }

  @Test
  void testMapToLoan() {
    // Given
    LoanDto loanDto = new LoanDto(
            "1234567890",
            12345678L,
            "Home Loan",
            BigDecimal.valueOf(500000.00),
            BigDecimal.valueOf(200000.00),
            BigDecimal.valueOf(300000.00)
    );

    // When
    Loan loan = LoanMapper.mapToLoan(loanDto);

    // Then
    assertNotNull(loan);
    assertEquals("1234567890", loan.getMobileNumber());
    assertEquals(12345678L, loan.getLoanNumber());
    assertEquals("Home Loan", loan.getLoanType());
    assertEquals(BigDecimal.valueOf(500000.00), loan.getTotalLoan());
    assertEquals(BigDecimal.valueOf(200000.00), loan.getAmountPaid());
    assertEquals(BigDecimal.valueOf(300000.00), loan.getAmountOutstanding());
  }
}