package com.SuShef.backend;

import com.SuShef.backend.inventory.service.Ingredient;
import com.SuShef.backend.inventory.dal.IngredientRepository;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Log
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	CommandLineRunner runner(IngredientRepository ingredientRepositor) {
//		return args -> {
//
//			Ingredient ingredient = new Ingredient();
//			ingredient.setName("apple");
//			ingredient.setDescription("red");
//			ingredient.setQuantity(10);
//			ingredient.setLocation(null);
//			ingredient.setItemClass(null);
//
//
//		 	Ingredient savedIngredient = ingredientRepositor.save(ingredient);
//			 log.info("Saved ingredient: " + savedIngredient);
//
//
//
//		};
//	}
}
