package com.recipes.publicisSapient.response;

import com.recipes.publicisSapient.entity.Recipe;

import java.util.List;

public class RecipeResponse {
    List<Recipe> recipes;

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
