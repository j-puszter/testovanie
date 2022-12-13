package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Calculator {
    public static List<Integer> primeNumbers(int n) {
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }

    public static boolean isPrime(int number) {
        if(number < 1 ) {
            return false;
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
