package com.recipes.publicisSapient.controller;

import com.recipes.publicisSapient.Service.RecipeService;
import com.recipes.publicisSapient.entity.Recipe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RecipeController.class)
public class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeService recipeService;

    private Recipe recipe;

    @BeforeEach
    void setUp() {
        recipe = new Recipe();
        recipe.setId(1L);
        recipe.setName("Pasta");
        recipe.setCuisine("Italian");
    }

    @Test
    public void testLoadAllRecipes() throws Exception {
        doNothing().when(recipeService).loadRecipe();

        mockMvc.perform(get("/recipe/save")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().string("Recipes Data Successfully saved to DB"));

        verify(recipeService, times(1)).loadRecipe();
    }

    @Test
    public void testDisplayByIdFound() throws Exception {
        when(recipeService.getRecipeById(1L)).thenReturn(recipe);

        mockMvc.perform(get("/recipe/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Pasta"))
                .andExpect(jsonPath("$.cuisine").value("Italian"));

        verify(recipeService, times(1)).getRecipeById(1L);
    }

    @Test
    public void testDisplayByIdNotFound() throws Exception {
        when(recipeService.getRecipeById(1L)).thenReturn(null);

        mockMvc.perform(get("/recipe/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Recipe Not found"));

        verify(recipeService, times(1)).getRecipeById(1L);
    }

    @Test
    public void testSearchRecipesFound() throws Exception {
        List<Recipe> recipes = Arrays.asList(recipe);
        when(recipeService.searchRecipes("Pasta")).thenReturn(recipes);

        mockMvc.perform(get("/recipe/search")
                        .param("keyword", "Pasta")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("Pasta"))
                .andExpect(jsonPath("$[0].cuisine").value("Italian"));

        verify(recipeService, times(1)).searchRecipes("Pasta");
    }

    @Test
    public void testSearchRecipesNotFound() throws Exception {
        when(recipeService.searchRecipes("Unknown")).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/recipe/search")
                        .param("keyword", "Unknown")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andExpect(content().string("Recipe Not found"));

        verify(recipeService, times(1)).searchRecipes("Unknown");
    }
}
