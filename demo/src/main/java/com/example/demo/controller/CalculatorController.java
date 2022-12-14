package com.example.demo.controller;

import com.example.demo.Calculator;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class CalculatorController {

    @GetMapping("/primes/{n}")
    public static  ResponseEntity<List<Integer>> primeNumbers(@PathVariable Integer n) {
        return ResponseEntity.ok(Calculator.primeNumbers(n));
    }

    @PostMapping("/isPrime")
    public static ResponseEntity<Boolean> isPrime(@RequestBody Integer n) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AGE, "value");
        return ResponseEntity.ok()
                .headers(headers)
                .body(Calculator.isPrime(n));
    }
}
