package com.eldar.challenge_java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FeeResponseDto {

    private String brand;

    private double amount;

    private double fee;

    private double feePercentage;
}
