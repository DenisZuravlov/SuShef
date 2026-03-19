package com.SuShef.backend.inventory.dal;

import com.SuShef.backend.inventory.service.Ingredient;
import com.SuShef.backend.inventory.service.ItemClass;
import com.SuShef.backend.inventory.service.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {



    List<Ingredient> findAllByOrderByNameAsc();
    List<Ingredient> findAllByOrderByNameDesc();
    List<Ingredient> findAllByOrderByDateCreatedAsc();
    List<Ingredient> findAllByOrderByDateCreatedDesc();
    List<Ingredient> findAllByOrderByExpiryDateAsc();
    List<Ingredient> findAllByOrderByExpiryDateDesc();
    List<Ingredient> findAllByOrderByQuantityAsc();
    List<Ingredient> findAllByOrderByQuantityDesc();
    List<Ingredient> findAllByOrderByLocationAsc();
    List<Ingredient> findAllByOrderByLocationDesc();



}
