package com.recipes.publicisSapient.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.recipes.publicisSapient.entity.Recipe;
import com.recipes.publicisSapient.repository.RecipeRepository;
import com.recipes.publicisSapient.response.RecipeResponse;

import jakarta.annotation.PostConstruct;

@Service
public class RecipeAPIService {
	private static final Logger LOGGER = LoggerFactory.getLogger(RecipeAPIService.class);

	@Autowired
	RecipeRepository recipeRepository;

	@PostConstruct
	public void init() {
		loadRecipe();
	}

	@Value("${RECIPE_API_URL}")
	String api_url;

	@Transactional
    public void loadRecipe() {
    	LOGGER.debug("Loading Recipe Data from {}", api_url);
    	try {
    		RestTemplate restTemplate = new RestTemplate();
            RecipeResponse response = restTemplate.getForObject(api_url, RecipeResponse.class);
            if (response != null) {
                List<Recipe> recipes = response.getRecipes();
                recipeRepository.saveAll(recipes);
                
            }
    	}
    	catch(RestClientException e ) {
    		e.printStackTrace();
    		LOGGER.info("Error Occured: "+e.getMessage());
    	}          
        catch(Exception e) {
        	e.printStackTrace();
        	LOGGER.info("Error Occured: "+e.getMessage());
        }
	}

}
