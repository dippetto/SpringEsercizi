package com.example.springboot.Ex6.service;

import com.example.springboot.Ex6.model.Meal;
import com.example.springboot.Ex6.repository.MealRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MealService {
    private MealRepository mealRepository;
    private Double maxTemp = 8.2;

    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public void insertMeal(Meal meal) {
        mealRepository.save(meal);
    }

    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }

    public Meal getMealById(Long id) throws ResponseStatusException {
        Optional<Meal> optionalMeal = mealRepository.findById(id);
        if (optionalMeal.isEmpty()) {
            Meal meal = optionalMeal.get();
            return new Meal(meal.getId(), meal.getName(), meal.getDescription(),
                    meal.getPrice(), meal.getIngredients(), meal.isWinterMeal());
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Meal not found with ID: " + id
            );
        }

    }

    public void updateMeal(Long id, Meal meal) {
        mealRepository.deleteById(id);
        mealRepository.save(meal);
    }

    public void deleteMeal(Long id) {
        mealRepository.deleteById(id);
    }
}
