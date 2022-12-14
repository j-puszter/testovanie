package com.example.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static com.example.demo.Calculator.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void primeNumbersTest() {
        List<Integer> result = primeNumbers(10);
        assertIterableEquals(Arrays.asList(1,3,5,7), result);
        result = primeNumbers(-10);
        assertIterableEquals(List.of(), result);
        result = primeNumbers(0);
        assertIterableEquals(List.of(), result);
        result = primeNumbers(1);
        assertIterableEquals(Arrays.asList(1), result);
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 53, 97 , 0, -1, -20, -33})
    void isPrimeTest(int number) {
        if(number > 0)
            assertTrue(isPrime(number));
        else
            assertFalse(isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 53, 97 , 0, -1, -20, -33})
    void isPrimeWithMistakeTest(int number) {
        if(number > 0)
            assertTrue(isPrimeWithMistake(number));
        else
            assertFalse(isPrimeWithMistake(number));
    }

    @Test
    void isPrimeWithExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> {isPrimeWithException(0);});
        assertThrows(IllegalArgumentException.class, () -> {isPrimeWithException(-2);});
        assertDoesNotThrow(() -> {isPrimeWithException(1);});
        assertDoesNotThrow(() -> {isPrimeWithException(6);});
    }
}