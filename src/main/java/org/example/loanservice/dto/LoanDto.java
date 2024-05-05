package org.example.loanservice.dto;

import java.math.BigDecimal;

public record LoanDto(
        String mobileNumber,
        Long loanNumber,
        String loanType,
        BigDecimal totalLoan,
        BigDecimal amountPaid,
        BigDecimal amountOutstanding
) {
}
