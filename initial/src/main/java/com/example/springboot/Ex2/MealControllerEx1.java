package com.example.springboot.Ex2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MealControllerEx1 {
    @GetMapping(value = "/meals")
    public List<Meal> pastiList() {
        return Arrays.asList(
                new Meal("Checchia", "Al forno", 99.99),
                new Meal("Spaghetti", "quelli della nonna", 0.00),
                new Meal("Qualsiasi pranzo", "3 stelle", 1921.25)
        );
    }


}