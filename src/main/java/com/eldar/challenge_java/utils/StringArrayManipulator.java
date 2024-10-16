package com.eldar.challenge_java.utils;

import com.eldar.challenge_java.exception.InvalidArrayException;

public class StringArrayManipulator {

    public static String manipulateStringArray(String[] myArray) {

        if (myArray.length > 10) {
            throw new InvalidArrayException("The array length exceeds the maximum allowed limit of 10.");
        }

        for (String element : myArray) {
            if (!element.matches("^[a-zA-Z ]+$")) {
                throw new InvalidArrayException("The array contains invalid characters. Only letters and spaces are allowed.");
            }
        }

        return String.join(" ", myArray).toLowerCase();
    }
}

