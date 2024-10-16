package com.eldar.challenge_java.service.impl;

import com.eldar.challenge_java.dto.FeeRequestDto;
import com.eldar.challenge_java.dto.FeeResponseDto;
import com.eldar.challenge_java.enums.Brand;
import com.eldar.challenge_java.exception.BadRequestException;
import com.eldar.challenge_java.service.CreditCardService;
import com.eldar.challenge_java.utils.FeeUtil;
import org.springframework.stereotype.Service;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Override
    public FeeResponseDto calculateFee(FeeRequestDto request) {

        Brand brand = Brand.fromString(request.getBrand());

        double feePercentage = FeeUtil.calculateFeePercentage(brand);
        double fee = request.getAmount() * feePercentage / 100;

        return new FeeResponseDto(request.getBrand(), request.getAmount(), fee, feePercentage);
    }
}
