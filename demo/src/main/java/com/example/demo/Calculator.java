package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static List<Integer> primeNumbers(int n) {
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }

    public static boolean isPrime(int number) {
        if(number < 1 || number == 2) {
            return false;
        } else if (number == 1) {
            return true;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeWithMistake(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeWithException(int number) {
        if(number < 1) {
            throw new IllegalArgumentException("Cislo na vstupe nesmie byt < 1");
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
