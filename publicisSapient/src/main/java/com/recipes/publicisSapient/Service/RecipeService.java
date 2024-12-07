package com.recipes.publicisSapient.Service;

import com.recipes.publicisSapient.entity.Recipe;
import com.recipes.publicisSapient.repository.RecipeRepository;
import com.recipes.publicisSapient.response.RecipeResponse;

import jakarta.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RecipeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(RecipeService.class);
	
    @Autowired
    RecipeRepository recipeRepository;
    
    @Transactional
    public Recipe getRecipeById(Long id) {
    	LOGGER.debug("Searching for recipe with ID: {}", id);
    	return recipeRepository.findById(id).orElseThrow();
    }
    
    public List<Recipe> searchRecipes(String keyword) {
    	LOGGER.debug("Executing search for recipes with keyword: {}", keyword);
    	return recipeRepository.searchByKeyword(keyword);
    }

	public List<Recipe> displayRecipes() {
		return recipeRepository.findAll();
		
	}
}
