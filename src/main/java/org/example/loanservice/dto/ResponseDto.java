package org.example.loanservice.dto;

public record ResponseDto(
        String statusCode,
        String statusMessage
) {
}
