package com.example.RecipeApp.dtos;

import com.example.RecipeApp.entities.Ingredient;
import com.example.RecipeApp.entities.Recipe;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecipeDto implements Serializable {
    private Long id;
    private String name;
    private List<Ingredient> ingredients;
    private float calories;
    private String label;
    private String image;
    private long totalTime;
    private int yield;
    private String source;
//    private List<BackendIngredientDto> ingredients;

    public RecipeDto(Recipe recipe) {
        if (recipe.getId() != null) {
            this.id = recipe.getId();
        }
        if (recipe.getName() != null) {
            this.name = recipe.getName();
        }
        if (recipe.getIngredients() != null) {
            this.ingredients = recipe.getIngredients();
        }
        if (recipe.getLabel() != null) {
            this.label = recipe.getLabel();
        }
        if (recipe.getImage() != null) {
            this.image = recipe.getImage();
        }
        if (recipe.getTotalTime() > 0) {
            this.totalTime = recipe.getTotalTime();
        }
        if (recipe.getYield() > 0) {
            this.yield = recipe.getYield();
        }
        if (recipe.getSource() != null) {
            this.source = recipe.getSource();
        }
        if (recipe.getCalories() > 0) {
            this.calories = recipe.getCalories();
        }
    }
}

