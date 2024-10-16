package com.eldar.challenge_java.service;

import com.eldar.challenge_java.dto.FeeRequestDto;
import com.eldar.challenge_java.dto.FeeResponseDto;

public interface CreditCardService {

    FeeResponseDto calculateFee(FeeRequestDto request);
}
