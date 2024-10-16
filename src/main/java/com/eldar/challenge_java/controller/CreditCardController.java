package com.eldar.challenge_java.controller;

import com.eldar.challenge_java.dto.FeeRequestDto;
import com.eldar.challenge_java.dto.FeeResponseDto;
import com.eldar.challenge_java.service.CreditCardService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cards")
@Validated
public class CreditCardController {

    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @PostMapping("/calculate-fee")
    public FeeResponseDto calculateFee(@Valid @RequestBody FeeRequestDto request) {
        return creditCardService.calculateFee(request);
    }
}
