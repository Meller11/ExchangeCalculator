package com.example.exchangecalculator.service;

import org.springframework.stereotype.Service;

@Service
public class Calculator {

    public double exchange(String fromCurrency, String toCurrency, double amount) {
        double fromRate = getRate(fromCurrency);
        double toRate = getRate(toCurrency);

        return (amount / fromRate) * toRate;
    }

        private double getRate(String currency) {
            switch (currency) {
                case "EUR":
                    return 1.0;
                case "DKK":
                    return 7.71;
                case "GBP":
                    return 0.86;
                case "USD":
                    return 1.18;
                default:
                    throw new IllegalArgumentException("Unknown currency");
            }
        }
    }