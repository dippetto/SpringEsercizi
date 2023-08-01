package com.example.springboot.Ex6.service;

import com.example.springboot.Ex6.model.Ingredient;
import com.example.springboot.Ex6.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    public IngredientService (IngredientRepository ingredientRepository){this.ingredientRepository= ingredientRepository;}
    public void ingredientTestTable(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }
    public List<Ingredient> ingredientList(){
        return ingredientRepository.findAll();
    };

    public  Ingredient getIngrendient (Long id){
        return ingredientRepository.getReferenceById(id);
    }

    public void delete(Long id){
        ingredientRepository.deleteById(id);
    }
    public void update(Long id, Ingredient ingredient) {
        ingredientRepository.deleteById(id);
        ingredientRepository.save(ingredient);
    }
}