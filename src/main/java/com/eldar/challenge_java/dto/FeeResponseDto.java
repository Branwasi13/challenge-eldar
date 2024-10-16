package com.eldar.challenge_java.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FeeResponseDto {

    @Schema(description = "Credit card brand", example = "VISA")
    private String brand;

    @Schema(description = "Transaction amount", example = "500")
    private double amount;

    @Schema(description = "Calculated fee for the transaction", example = "12.5")
    private double fee;

    @Schema(description = "Percentage fee applied", example = "2.5")
    private double feePercentage;
}
