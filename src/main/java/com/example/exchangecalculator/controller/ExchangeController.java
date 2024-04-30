package com.example.exchangecalculator.controller;

import com.example.exchangecalculator.service.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExchangeController {

        @Autowired
        private Calculator calculator;

    @GetMapping("/exchange")
    public String exchangeForm() {
        return "exchangeCalculator";
    }

    @PostMapping("/exchange")
    public String exchangeSubmit(@RequestParam String fromCurrency, @RequestParam String toCurrency, @RequestParam double amount, Model model) {
        try {
            double result = calculator.exchange(fromCurrency, toCurrency, amount);
            model.addAttribute("result", result);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", "Unknown currency");
        }
        return "exchangeCalculator";
    }
}
