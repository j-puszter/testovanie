package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.example.demo.Calculator.*;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        System.out.println(isPrime(-1));
    }

}
