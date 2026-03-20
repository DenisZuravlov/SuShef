package com.SuShef.backend.inventory.api;

import com.SuShef.backend.inventory.service.Appliance;
import com.SuShef.backend.inventory.service.ApplianceService;
import com.SuShef.backend.inventory.service.Ingredient;
import com.SuShef.backend.inventory.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventorySortController {
    private final IngredientService ingredientService;
    private final ApplianceService applianceService;


    @GetMapping("/ingredient/name/Asc")
    public Iterable<Ingredient> getAllIngredientsByNameAsc(){
        return ingredientService.getAllIngredientsByNameAsc();
    }
    @GetMapping("/ingredient/name/Desc")
    public Iterable<Ingredient> getAllIngredientsByNameDesc(){
        return ingredientService.getAllIngredientsByNameDesc();
    }


    @GetMapping("/ingredient/dateCreated/Asc")
    public Iterable<Ingredient> getAllIngredientsByDateCreatedAsc(){
        return ingredientService.getAllIngredientsByDateCreatedAsc();
    }
    @GetMapping("/ingredient/dateCreated/Desc")
    public Iterable<Ingredient> getAllIngredientsByDateCreatedDesc(){
        return ingredientService.getAllIngredientsByDateCreatedDesc();
    }


    @GetMapping("/ingredient/expiryDate/Asc")
    public Iterable<Ingredient> GetAllIngredientsByExpiryDateAsc(){
        return ingredientService.GetAllIngredientsByExpiryDateAsc();
    }
    @GetMapping("/ingredient/expiryDate/Desc")
    public Iterable<Ingredient> GetAllIngredientsByExpiryDateDesc(){
        return ingredientService.GetAllIngredientsByExpiryDateDesc();
    }


    @GetMapping("/ingredient/quantity/Asc")
    public Iterable<Ingredient> GetAllIngredientsByQuantityAsc(){
        return ingredientService.GetAllIngredientsByQuantityAsc();
    }
    @GetMapping("/ingredient/quantity/Desc")
    public Iterable<Ingredient> GetAllIngredientsByQuantityDesc(){
        return ingredientService.GetAllIngredientsByQuantityDesc();
    }


    @GetMapping("/ingredient/location/Asc")
    public Iterable<Ingredient> GetAllIngredientsByLocationAsc(){
        return ingredientService.GetAllIngredientsByLocationAsc();
    }
    @GetMapping("/ingredient/location/Desc")
    public Iterable<Ingredient> GetAllIngredientsByLocationDesc(){
        return ingredientService.GetAllIngredientsByLocationDesc();
    }

    @GetMapping("/appliance/name/Asc")
    public Iterable<Appliance> getAllAppliancesByNameAsc(){
        return applianceService.getAllAppliancesByNameAsc();
    }
    @GetMapping("/appliance/name/Desc")
    public Iterable<Appliance> getAllAppliancesByNameDesc(){
        return applianceService.getAllAppliancesByNameDesc();
    }

    @GetMapping("/appliance/dateCreated/Asc")
    public Iterable<Appliance> getAllAppliancesByDateCreatedAsc(){
        return applianceService.getAllAppliancesByDateCreatedAsc();
    }
    @GetMapping("/appliance/dateCreated/Desc")
    public Iterable<Appliance> getAllAppliancesByDateCreatedDesc(){
        return applianceService.getAllAppliancesByDateCreatedDesc();
    }


    @GetMapping("/appliance/status/Asc")
    public Iterable<Appliance> GetAllAppliancesByStatusAsc(){
        return applianceService.GetAllAppliancesByStatusAsc();
    }
    @GetMapping("/appliance/status/Desc")
    public Iterable<Appliance> GetAllAppliancesByStatusDesc(){
        return applianceService.GetAllAppliancesByStatusDesc();
    }

    @GetMapping("/appliance/brand/Asc")
    public Iterable<Appliance> GetAllAppliancesByNameAsc(){
        return applianceService.GetAllAppliancesByBrandAsc();
    }
    @GetMapping("/appliance/brand/Desc")
    public Iterable<Appliance> GetAllAppliancesByBrandDesc(){
        return applianceService.GetAllAppliancesByBrandDesc();
    }

}
