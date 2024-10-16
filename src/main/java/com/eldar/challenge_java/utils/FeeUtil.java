package com.eldar.challenge_java.utils;

import com.eldar.challenge_java.enums.Brand;
import com.eldar.challenge_java.exception.UnsupportedBrandException;

import java.time.LocalDate;

public class FeeUtil {

    public static double calculateFeePercentage(Brand brand) {
        double feePercentage = switch (brand) {
            case VISA -> (LocalDate.now().getYear() % 100) / (double) LocalDate.now().getMonthValue();
            case NARA -> LocalDate.now().getDayOfMonth() * 0.5;
            case AMEX -> LocalDate.now().getMonthValue() * 0.1;
            default -> throw new UnsupportedBrandException("Unsupported brand: " + brand);
        };

        return Math.max(0.3, Math.min(feePercentage, 5.0));
    }
}
