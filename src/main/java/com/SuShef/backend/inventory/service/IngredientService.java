package com.SuShef.backend.inventory.service;

import com.SuShef.backend.inventory.dal.IngredientRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
public class IngredientService extends ItemService{
    private final IngredientRepository ingredientRepository;

    public Ingredient addIngredient(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }


    public void deleteIngredient(Long id){
        ingredientRepository.findById(id)
                .orElseThrow(() -> notFound("Ingredient", id));

        ingredientRepository.deleteById(id);
    }

    public Ingredient updateIngredientQuantity(long id, int quantity){
        Ingredient ingredientToUpdate = ingredientRepository.findById(id) // find the appliance by id
                .orElseThrow(() -> notFound("Ingredient", id)); // throw an exception if the appliance is not found
        if(ingredientToUpdate.getQuantity() + quantity < 0){
            throw new NoSuchElementException("Quantity cannot be negative");
        }
        ingredientToUpdate.setQuantity(ingredientToUpdate.getQuantity() + quantity);
        return ingredientRepository.save(ingredientToUpdate);
    }

    public Ingredient updateIngredient(Ingredient ingredient, Long id) {
        Ingredient ingredientToUpdate = ingredientRepository.findById(id) // find the appliance by id
                .orElseThrow(() -> notFound("Ingredient", id)); // throw an exception if the appliance is not found
        updateItem(ingredientToUpdate, ingredient);

        if(!Objects.equals(ingredientToUpdate.getExpiryDate(), ingredient.getExpiryDate())){ // if the expiry date is different
            return ingredientRepository.save(ingredientToUpdate); // save new ingredient instead of updating
        }

        ingredientToUpdate.setQuantity(ingredient.getQuantity());
        ingredientToUpdate.setLocation(ingredient.getLocation());
        ingredientRepository.save(ingredientToUpdate);
        return ingredientToUpdate;

    }

    public List<Ingredient> getAllIngredients(){
        return ingredientRepository.findAll();
    }

    public List<Ingredient> getAllIngredientsByNameAsc(){
        return ingredientRepository.findAllByOrderByNameAsc();
    }
    public List<Ingredient> getAllIngredientsByNameDesc(){
        return ingredientRepository.findAllByOrderByNameDesc();
    }


    public List<Ingredient> getAllIngredientsByDateCreatedAsc(){
        return ingredientRepository.findAllByOrderByDateCreatedAsc();
    }
    public List<Ingredient> getAllIngredientsByDateCreatedDesc(){
        return ingredientRepository.findAllByOrderByDateCreatedDesc();
    }


    public List<Ingredient> GetAllIngredientsByExpiryDateAsc(){
        return ingredientRepository.findAllByOrderByExpiryDateAsc();
    }
    public List<Ingredient> GetAllIngredientsByExpiryDateDesc(){
        return ingredientRepository.findAllByOrderByExpiryDateDesc();
    }


    public List<Ingredient> GetAllIngredientsByQuantityAsc(){
        return ingredientRepository.findAllByOrderByQuantityAsc();
    }
    public List<Ingredient> GetAllIngredientsByQuantityDesc(){
        return ingredientRepository.findAllByOrderByQuantityDesc();
    }


    public List<Ingredient> GetAllIngredientsByLocationAsc(){
        return ingredientRepository.findAllByOrderByLocationAsc();
    }
    public List<Ingredient> GetAllIngredientsByLocationDesc(){
        return ingredientRepository.findAllByOrderByLocationDesc();
    }






}
