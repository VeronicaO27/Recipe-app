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
    private String category;
    private String key;
    private String title;
    private List<Ingredient> ingredients;

    public RecipeDto(Recipe recipe) {
        if (recipe.getId() != null) {
            this.id = recipe.getId();
        }
        if (recipe.getName() != null) {
            this.name = recipe.getName();
        }
//        if (recipe.getCategory() != null) {
//            this.category = recipe.getCategory();
//        }
//        if (recipe.getIngredients() != null) {
//            this.ingredients = recipe.getIngredients();
//        }
    }
}

