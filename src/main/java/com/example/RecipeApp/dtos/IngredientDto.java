package com.example.RecipeApp.dtos;

import com.example.RecipeApp.entities.Category;
import com.example.RecipeApp.entities.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IngredientDto implements Serializable {
    private Long id;
    private String name;
    private String quantity;

    public IngredientDto(Ingredient ingredient) {
        if (ingredient.getId() != null) {
            this.id = ingredient.getId();
        }
        if (ingredient.getName() != null) {
            this.name = ingredient.getName();
        }
//        if (ingredient.getQuantity() != null) {
//            this.quantity = ingredient.getQuantity();
//
//        }
    }
}

