package com.eldar.challenge_java.enums;

import com.eldar.challenge_java.exception.UnsupportedBrandException;

public enum Brand {
    VISA, NARA, AMEX;

    public static Brand fromString(String brand) throws UnsupportedBrandException {
        try {
            return Brand.valueOf(brand.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new UnsupportedBrandException("Unsupported brand: " + brand);
        }
    }
}
