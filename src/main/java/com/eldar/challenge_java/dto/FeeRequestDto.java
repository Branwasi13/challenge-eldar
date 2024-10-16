package com.eldar.challenge_java.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FeeRequestDto {

    @NotNull(message = "Brand is required")
    @Schema(description = "Credit card brand (VISA, NARA, AMEX)", example = "VISA")
    private String brand;

    @NotNull(message = "Amount is required")
    @PositiveOrZero(message = "Amount must be a positive number or zero")
    @Schema(description = "Transaction amount", example = "500")
    private Double amount;
}
