package com.eldar.challenge_java.controller;

import com.eldar.challenge_java.enums.Brand;
import com.eldar.challenge_java.dto.FeeRequestDto;
import com.eldar.challenge_java.dto.FeeResponseDto;
import com.eldar.challenge_java.utils.FeeUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cards")
@Tag(name = "Credit Card API", description = "API for calculating fees for credit card operations")
@Validated
public class CreditCardController {

    @PostMapping("/calculate-fee")
    @Operation(summary = "Calculate fee", description = "Calculate the fee for a credit card operation based on the card brand and amount")
    public FeeResponseDto calculateFee(@Valid @RequestBody FeeRequestDto request) {
        double feePercentage = FeeUtil.calculateFeePercentage(Brand.fromString(request.getBrand()));
        double fee = request.getAmount() * feePercentage / 100;

        return new FeeResponseDto(request.getBrand(), request.getAmount(), fee, feePercentage);
    }
}
