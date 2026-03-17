package com.SuShef.backend.inventory.dal;

import com.SuShef.backend.inventory.service.Ingredient;
import com.SuShef.backend.inventory.service.ItemClass;
import com.SuShef.backend.inventory.service.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findByName(String name);
    List<Ingredient> findByLocation(Location location);
    List<Ingredient> findByItemClass(ItemClass itemClass);
    List<Ingredient> findByQuantity(int quantity);


}
