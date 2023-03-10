package com.example.RecipeApp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BackendIngredientDto {
    private String foodId;
    private float quantity;
    private float weight;
    private String foodCategory;
    private String measure;
    private String food;
    private String text;
    private String image;

}
