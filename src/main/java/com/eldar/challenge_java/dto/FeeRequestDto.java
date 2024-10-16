package com.eldar.challenge_java.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FeeRequestDto {

    @NotNull(message = "Brand is required")
    private String brand;

    @NotNull(message = "Amount is required")
    private Double amount;
}
