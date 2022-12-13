package com.example.demo.controller;

import com.example.demo.Calculator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class CalculatorController {

    @GetMapping("/primes/{n}")
    public static List<Integer> primeNumbers(@PathVariable Integer n) {
        return Calculator.primeNumbers(n);
    }

    @PostMapping("/isPrime")
    public static boolean isPrime(@RequestBody Integer n) {
        return Calculator.isPrime(n);
    }
}
