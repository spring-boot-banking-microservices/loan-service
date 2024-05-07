package org.example.loanservice.service;

import org.example.loanservice.constants.LoanConstants;
import org.example.loanservice.entity.Loan;
import org.example.loanservice.exception.LoanAlreadyExistsException;
import org.example.loanservice.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

@Service
public class LoanService {
  private final Random random = new Random();
  private final LoanRepository loanRepository;

  @Autowired
  public LoanService(LoanRepository loanRepository) {
    this.loanRepository = loanRepository;
  }

  /**
   * Creates a new loan for the given mobile number.
   *
   * @param mobileNumber The mobile number associated with the loan.
   * @throws LoanAlreadyExistsException If a loan already exists for the given mobile number.
   */
  public void createLoan(String mobileNumber) {
    validateLoanDoesNotExist(mobileNumber);

    Loan loan = generateLoanByMobileNumber(mobileNumber);

    loanRepository.save(loan);
  }

  /**
   * Generates a new Loan instance with a randomly generated loan number and other default values for the given mobile number.
   *
   * @param mobileNumber The mobile number associated with the loan.
   * @return A new Loan instance with the generated loan number and other default values.
   */
  private Loan generateLoanByMobileNumber(String mobileNumber) {
    Long loanNumber = generateRandomLoanNumber();

    return buildLoan(loanNumber, mobileNumber);
  }

  /**
   * Builds a Loan instance with the provided loan number and mobile number, and sets other default values.
   *
   * @param loanNumber   The loan number for the new loan.
   * @param mobileNumber The mobile number associated with the loan.
   * @return A new Loan instance with the provided loan number and mobile number, and other default values.
   */
  private Loan buildLoan(Long loanNumber, String mobileNumber) {
    Loan loan = new Loan();

    loan.setMobileNumber(mobileNumber);
    loan.setLoanNumber(loanNumber);
    loan.setLoanType(LoanConstants.HOME_LOAN.getStringValue());
    loan.setTotalLoan(BigDecimal.valueOf(LoanConstants.LOAN_LIMIT.getIntValue()));
    loan.setAmountPaid(BigDecimal.valueOf(0));
    loan.setAmountOutstanding(BigDecimal.valueOf(LoanConstants.LOAN_LIMIT.getIntValue()));

    return loan;
  }

  /**
   * Generates a random 9-digit loan number.
   *
   * @return A randomly generated 9-digit loan number.
   */
  private Long generateRandomLoanNumber() {
    return 100000000000L + random.nextInt(900000000);
  }

  /**
   * Validates if a loan does not already exist for the given mobile number.
   *
   * @param mobileNumber The mobile number to check for an existing loan.
   * @throws LoanAlreadyExistsException If a loan already exists for the given mobile number.
   */
  private void validateLoanDoesNotExist(String mobileNumber) {
    if (loanRepository.findByMobileNumber(mobileNumber).isPresent()) {
      throw new LoanAlreadyExistsException(
              LoanConstants.LOAN.getStringValue(),
              "mobileNumber",
              mobileNumber
      );
    }
  }
}
