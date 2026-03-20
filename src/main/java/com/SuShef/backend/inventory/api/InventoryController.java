package com.SuShef.backend.inventory.api;

import com.SuShef.backend.inventory.service.Appliance;
import com.SuShef.backend.inventory.service.ApplianceService;
import com.SuShef.backend.inventory.service.Ingredient;
import com.SuShef.backend.inventory.service.IngredientService;
import com.SuShef.backend.middlewares.UserPrincipal;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final IngredientService ingredientService;
    private final ApplianceService applianceService;

    @GetMapping("/ingredients")
    public Iterable<Ingredient> getAllIngredients(){
        return ingredientService.getAllIngredients();
    }

    @PostMapping("/ingredients")
    public ResponseEntity<Ingredient> addIngredient(@Valid @RequestBody Ingredient ingredient){

        return ResponseEntity.status(201).body(ingredientService.addIngredient(ingredient));
    }

    @PutMapping("/ingredients/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@Valid @RequestBody Ingredient ingredient, @PathVariable Long id){
        ingredientService.updateIngredient(ingredient, id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/ingredients/quantity/{id}")
    public ResponseEntity<Ingredient> updateIngredientQuantity(@PathVariable Long id, @RequestParam int quantity){
        ingredientService.updateIngredientQuantity(id, quantity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/ingredients/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable Long id){
        ingredientService.deleteIngredient(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/appliances")
    public ResponseEntity<Appliance> addAppliance(@Valid @RequestBody Appliance appliance){
        return ResponseEntity.status(201).body(applianceService.addAppliance(appliance));
    }

    @PutMapping("/appliances/{id}")
    public ResponseEntity<Appliance> updateAppliance(@Valid @RequestBody Appliance appliance, @PathVariable Long id){
        applianceService.updateAppliance(appliance, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/appliances/{id}")
    public ResponseEntity<Void> deleteAppliance(@PathVariable Long id){
        applianceService.deleteAppliance(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/appliances")
    public Iterable<Appliance> getAllAppliances(){
        return applianceService.getAllAppliances();
    }







}
