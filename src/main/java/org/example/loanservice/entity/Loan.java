package org.example.loanservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Loan extends Audit {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 15)
  private String mobileNumber;

  @Column(nullable = false, length = 100)
  private Long loanNumber;

  @Column(nullable = false, length = 100)
  private String loanType;

  @Column(nullable = false)
  private BigDecimal totalLoan;

  @Column(nullable = false)
  private BigDecimal amountPaid;

  @Column(nullable = false)
  private BigDecimal amountOutstanding;
}
