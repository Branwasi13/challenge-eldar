package com.eldar.challenge_java.model;

import com.eldar.challenge_java.enums.Brand;
import com.eldar.challenge_java.utils.FeeUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {
    private Brand brand;
    private String cardNumber;
    private String cardHolder;
    private LocalDate expirationDate;

    public boolean isOperationValid(double amount) {
        return amount < 1000;
    }

    public boolean isValid() {
        return this.expirationDate.isAfter(LocalDate.now());
    }

    public boolean isEqualTo(CreditCard anotherCard) {
        return this.cardNumber.equals(anotherCard.cardNumber);
    }

    public void calculateFee(double amount) {
        double feePercentage = FeeUtil.calculateFeePercentage(this.brand);
        double finalFee = amount * feePercentage / 100;
        System.out.println("Brand: " + this.brand + ", Amount: " + amount + ", Fee: " + finalFee + ", Fee percentage: " + feePercentage);
    }
}
