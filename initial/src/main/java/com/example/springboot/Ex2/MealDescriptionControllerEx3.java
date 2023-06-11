package com.example.springboot.Ex2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MealDescriptionControllerEx3 {
    @Autowired
    private MealControllerEx1 mealControllerEx1;

    @GetMapping(value = "/meal/description-match/{phrase}")
    public List<Meal> getDescriptionMatch(@PathVariable String phrase) {
        return mealControllerEx1.pastiList().stream()
                .filter(meal -> meal.getDescrizione().contains(phrase))
                .collect(Collectors.toList());
    }
}