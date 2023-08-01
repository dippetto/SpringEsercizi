package com.example.springboot.Ex5.repository;

import com.example.springboot.Ex5.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}