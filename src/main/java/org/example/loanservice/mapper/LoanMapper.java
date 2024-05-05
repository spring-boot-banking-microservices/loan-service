package org.example.loanservice.mapper;

import org.example.loanservice.dto.LoanDto;
import org.example.loanservice.entity.Loan;

public class LoanMapper {
  /**
   * Private constructor to hide the implicit public one
   */
  private LoanMapper() {
    throw new IllegalStateException("Utility class");
  }

  public static LoanDto mapToLoanDto(Loan loan) {
    return new LoanDto(
            loan.getMobileNumber(),
            loan.getLoanNumber(),
            loan.getLoanType(),
            loan.getTotalLoan(),
            loan.getAmountPaid(),
            loan.getAmountOutstanding()
    );
  }

  public static Loan mapToLoan(LoanDto loanDto) {
    Loan loan = new Loan();

    loan.setMobileNumber(loanDto.mobileNumber());
    loan.setLoanNumber(loanDto.loanNumber());
    loan.setLoanType(loanDto.loanType());
    loan.setTotalLoan(loanDto.totalLoan());
    loan.setAmountPaid(loanDto.amountPaid());
    loan.setAmountOutstanding(loanDto.amountOutstanding());

    return loan;
  }
}
