package com.recipes.publicisSapient.repository;

import com.recipes.publicisSapient.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface RecipeRepository  extends JpaRepository<Recipe, Long> {
	
	//Search Operation Based on Recipe name or Cuisine
	@Query("SELECT r FROM Recipe r WHERE "
			+ "LOWER(r.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
	           "OR "
            + "LOWER(r.cuisine) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Recipe> searchByKeyword(@Param("keyword") String keyword);
}
