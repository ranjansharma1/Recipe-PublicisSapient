package com.recipes.publicisSapient.controller;

import com.recipes.publicisSapient.Service.RecipeService;
import com.recipes.publicisSapient.entity.Recipe;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe")
@CrossOrigin(origins = "http://localhost:3000")
public class RecipeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(RecipeController.class);
 
    @Autowired
    RecipeService recipeService;

    @GetMapping("/save")
    public ResponseEntity<String> loadAllRecipes(){
    	LOGGER.info("Loading recipes in DB");
        recipeService.loadRecipe();
        LOGGER.info("Recipes Data Loaded successfully to DB");
        return new ResponseEntity<String>("Recipes Data Successfully saved to DB", HttpStatus.CREATED);
    }
    
    @GetMapping("/all")
    public ResponseEntity<?> displayRecipes(){
    	LOGGER.info("Dispalying recipes...");
        List<Recipe> recipes=recipeService.displayRecipes();
        LOGGER.info("Recipes Data Loaded successfully");
        if(recipes!=null)
            return new ResponseEntity<List<Recipe>>(recipes, HttpStatus.OK);
        return new ResponseEntity<String>("Recipe Not found", HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> displayById(
    		@PathVariable 
    		@NotNull(message = "Recipe ID must not be null") 
    		Long id) {
    	LOGGER.info("Fetching recipe with ID: {}", id);
        Recipe recipe = recipeService.getRecipeById(id);
        LOGGER.debug("Recipe details: {}", recipe);
    	if(recipe!=null)
            return new ResponseEntity<Recipe>(recipe, HttpStatus.OK);
        return new ResponseEntity<String>("Recipe Not found", HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @GetMapping("/search")
    public ResponseEntity<?> searchRecipes(@RequestParam 
    		@NotNull(message = "Search keyword must not be null") 
    		@Size(min = 3, max = 50, message = "Keyword must be between 3 and 50 characters") 
    		String keyword) {
    	LOGGER.info("Searching recipes with keyword: {}", keyword);
    	List<Recipe> recipes=recipeService.searchRecipes(keyword);
    	LOGGER.debug("Found {} recipes for keyword: {}", recipes.size(), keyword);
        
    	if(recipes.size()>0)
            return new ResponseEntity<List<Recipe>>(recipes, HttpStatus.OK);
        return new ResponseEntity<String>("Recipe Not found", HttpStatus.NO_CONTENT);
    }
}
