package com.SuShef.backend.inventory.service;

import com.SuShef.backend.inventory.dal.IngredientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class IngredientService{
    private final IngredientRepository ingredientRepository;

    public Ingredient addIngredient(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }


    public void moveLocation(Long id, Location location){
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ingredient ID " + id + " not found"));
        ingredient.setLocation(location);
        ingredientRepository.save(ingredient);
    }

    public void deleteIngredient(Long id){
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ingredient ID " + id + " not found"));

        ingredientRepository.deleteById(id);
    }

    public void updateExpiryDate(Long id, LocalDate newDate) {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ingredient ID " + id + " not found"));

        ingredient.setExpiryDate(newDate);
        ingredientRepository.save(ingredient);
    }

    public void updateQuantity(Long id, int newQuantity) {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ingredient ID " + id + " not found"));

        ingredient.setQuantity(newQuantity);
        ingredientRepository.save(ingredient);
    }


    public void updateIngredient(Ingredient ingredient, Long id) {
        deleteIngredient(id);
        addIngredient(ingredient);
    }

    public List<Ingredient> getAllIngredients(){
        return ingredientRepository.findAll();
    }






}
