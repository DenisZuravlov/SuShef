package com.SuShef.backend.inventory.api;

import com.SuShef.backend.inventory.dal.IngredientRepository;
import com.SuShef.backend.inventory.service.Ingredient;
import com.SuShef.backend.inventory.service.IngredientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final IngredientService ingredientService;
    private final IngredientRepository ingredientRepository;

    @GetMapping
    public Iterable<Ingredient> getAllIngredients(){
        return ingredientRepository.findAll();
    }

    @PostMapping("/ingredients")
    public ResponseEntity<Ingredient> addIngredient(@Valid @RequestBody Ingredient ingredient){
        return ResponseEntity.ok(ingredientService.addIngredient(ingredient));
    }

    @PutMapping("/ingredients/{id}")
    public ResponseEntity<Void> updateIngredient(@RequestBody Ingredient ingredient, @PathVariable Long id){
        ingredientService.updateIngredient(ingredient, id);
        return ResponseEntity.ok().build();
    }





}
