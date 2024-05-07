package org.example.loanservice.controller;

import org.example.loanservice.constants.LoanConstants;
import org.example.loanservice.dto.ResponseDto;
import org.example.loanservice.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/loans", produces = {MediaType.APPLICATION_JSON_VALUE})
public class LoanController {
  private final LoanService loanService;

  @Autowired
  public LoanController(LoanService loanService) {
    this.loanService = loanService;
  }

  /**
   * Creates a new loan for the given mobile number.
   *
   * @param mobileNumber The mobile number associated with the loan.
   * @return A ResponseEntity containing the ResponseDto with the status code and message for a successful loan creation.
   */
  @PostMapping("/create")
  public ResponseEntity<ResponseDto> createLoan(@RequestParam String mobileNumber) {
    loanService.createLoan(mobileNumber);

    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(new ResponseDto(
                    LoanConstants.STATUS_201.getStringValue(),
                    LoanConstants.MESSAGE_201.getStringValue())
            );
  }
}
