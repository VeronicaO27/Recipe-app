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
    private String foodId;
//    private float quantity;
    private float weight;
    private String foodCategory;
    private String measure;
    private String food;
    private String text;
    private String image;

    public IngredientDto(Ingredient ingredient) {
        if (ingredient.getId() != null) {
            this.id = ingredient.getId();
        }
        if (ingredient.getName() != null) {
            this.name = ingredient.getName();
        }
        if (ingredient.getQuantity() != null) {
            this.quantity = ingredient.getQuantity();
        }
        if (ingredient.getWeight() > 0) {
            this.weight = ingredient.getWeight();
        }
        if (ingredient.getFoodCategory() != null) {
            this.foodCategory = ingredient.getFoodCategory();
        }
        if (ingredient.getMeasure() != null ) {
            this.measure = ingredient.getMeasure();
        }
        if (ingredient.getFood() != null ) {
            this.food = ingredient.getFood();
        }
        if (ingredient.getText() != null ) {
            this.text = ingredient.getText();
        }
        if (ingredient.getImage() != null ) {
            this.image = ingredient.getImage();
        }
    }
}

