package com.recipes.publicisSapient.entity;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recipe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    @Id
    @NotNull(message = "Recipe ID must not be null")
    private Long id;

    @NotNull(message = "Recipe name must not be null")
    @Size(min = 2, max = 100, message = "Recipe name must be between 2 and 100 characters")
    @Column(nullable = false)
    private String name;
    
    @ElementCollection
    private List<String> ingredients; // Stored as a single string (comma-separated or JSON)

    @ElementCollection
    private List<String> instructions; // Stored as a single string (newline-separated or JSON)

    @Column(name = "prep_time_minutes", nullable = false)
    private Integer prepTimeMinutes;

    @Column(name = "cook_time_minutes", nullable = false)
    private Integer cookTimeMinutes;

    @Column(nullable = false)
    private Integer servings;

    @Column(nullable = false)
    private String difficulty;

    @Column(nullable = false)
    private String cuisine;

    @Column(name = "calories_per_serving", nullable = false)
    private Integer caloriesPerServing;

    @ElementCollection
    private List<String> tags; // Stored as a single string (comma-separated)

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column
    private String image;

    @Column
    private Double rating;

    @Column(name = "review_count")
    private Integer reviewCount;

    @ElementCollection
    private List<String> mealType; // Stored as a single string (comma-separated)


    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", instructions='" + instructions + '\'' +
                ", prepTimeMinutes=" + prepTimeMinutes +
                ", cookTimeMinutes=" + cookTimeMinutes +
                ", servings=" + servings +
                ", difficulty='" + difficulty + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", caloriesPerServing=" + caloriesPerServing +
                ", tags='" + tags + '\'' +
                ", userId=" + userId +
                ", image='" + image + '\'' +
                ", rating=" + rating +
                ", reviewCount=" + reviewCount +
                ", mealType='" + mealType + '\'' +
                '}';
    }
}