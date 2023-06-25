package com.example.springboot.Ex2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MealPriceControllerEx4 {
    @Autowired
    private MealControllerEx1 mealControllerEsercizio1;

    @GetMapping(value = "/meal/price")
    public List<Meal> getPriceRange(@RequestParam("min") Double prezzoMin, @RequestParam("max") Double prezzoMax) {
        return mealControllerEsercizio1.pastiList().stream()
                .filter(meal -> meal.getPrezzo() >= prezzoMin && meal.getPrezzo() <= prezzoMax)
                .collect(Collectors.toList());
    }
}