package com.example.springboot.Ex2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MealNameControllerEx2 {
    @Autowired
    private MealControllerEx1 mealControllerEx1;

    @GetMapping(value = "/meal/{name}")
    public Meal getName(@PathVariable String name) {
        return mealControllerEx1.pastiList().stream()
                .filter(meal -> meal.getNome().equals(name))
                .findFirst()
                .orElse(null);
    }


}