package com.SuShef.backend.inventory.api;

import com.SuShef.backend.inventory.service.Appliance;
import com.SuShef.backend.inventory.service.ApplianceService;
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
    private final ApplianceService applianceService;

    @GetMapping
    public Iterable<Ingredient> getAllIngredients(){
        return ingredientService.getAllIngredients();
    }

    @PostMapping("/ingredients")
    public ResponseEntity<Ingredient> addIngredient(@Valid @RequestBody Ingredient ingredient){
        return ResponseEntity.ok(ingredientService.addIngredient(ingredient));
    }

    @PutMapping("/ingredients/{id}")
    public ResponseEntity<Void> updateIngredient(@Valid @RequestBody Ingredient ingredient, @PathVariable Long id){
        ingredientService.updateIngredient(ingredient, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/ingredients/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable Long id){
        ingredientService.deleteIngredient(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/appliances")
    public ResponseEntity<Appliance> addAppliance(@Valid @RequestBody Appliance appliance){
        return ResponseEntity.ok(applianceService.addAppliance(appliance));
    }

    @PutMapping("/appliances/{id}")
    public ResponseEntity<Void> updateAppliance(@Valid @RequestBody Appliance appliance, @PathVariable Long id){
        applianceService.updateAppliance(appliance, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/appliances/{id}")
    public ResponseEntity<Void> deleteAppliance(@PathVariable Long id){
        applianceService.deleteAppliance(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/appliances/bring")
    public Iterable<Appliance> getAllAppliances(){
        return applianceService.getAllAppliances();
    }







}
