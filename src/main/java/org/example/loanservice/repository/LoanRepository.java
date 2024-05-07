package org.example.loanservice.repository;

import org.example.loanservice.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long> {
  Optional<Loan> findByMobileNumber(String mobileNumber);
}
