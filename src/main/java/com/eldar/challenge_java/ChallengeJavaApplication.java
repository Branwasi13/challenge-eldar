package com.eldar.challenge_java;

import com.eldar.challenge_java.enums.Brand;
import com.eldar.challenge_java.exception.InvalidArrayException;
import com.eldar.challenge_java.exception.UnsupportedBrandException;
import com.eldar.challenge_java.model.CreditCard;
import com.eldar.challenge_java.utils.StringArrayManipulator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.time.LocalDate;

@SpringBootApplication
public class ChallengeJavaApplication {

	public static void main(String[] args) {

		SpringApplication.run(ChallengeJavaApplication.class, args);

		try {
			// Exercise 1
			CreditCard card1 = new CreditCard(Brand.VISA, "1234567890123456", "Brandon Wasilewicz", LocalDate.of(2025, 12, 31));
			CreditCard card2 = new CreditCard(Brand.NARA, "9876543210987654", "Anna Smith", LocalDate.of(2024, 7, 30));
			CreditCard card3 = new CreditCard(Brand.AMEX, "1122334455667788", "Peter Johnson", LocalDate.of(2023, 6, 15));

			System.out.println(card1);

			System.out.println("Is operation valid? " + card3.isOperationValid(999));

			System.out.println("Is card valid? " + card1.isValid());

			System.out.println("Is card equal? " + card2.isEqualTo(card1));

			card1.calculateFee(500);
		} catch (UnsupportedBrandException e) {
			System.err.println("Unsupported brand: " + e.getMessage());
		}

		try {
			// Exercise 5
			String[] myArray = {"FirstWord", "Second Word", "THIRDWORD"};
			String result = StringArrayManipulator.manipulateStringArray(myArray);
			System.out.println(result);
		} catch (InvalidArrayException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}