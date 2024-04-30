package com.example.exchangecalculator.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CalculatorTest {

    @Test
    void exchange() {
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        double result = calculator.exchange("EUR", "DKK", 1.0);

        // Assert
        assertEquals(7.71, result, 0.01, "Test af valutakurs");
    }
    @Test
    public void testExchangeWithUnknownCurrency() {
        Calculator calculator = new Calculator();

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.exchange("EUR", "XYZ", 1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.exchange("XYZ", "EUR", 1);
        });
    }
}