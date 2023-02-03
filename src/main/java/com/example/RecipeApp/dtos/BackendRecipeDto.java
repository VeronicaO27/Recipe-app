package com.example.RecipeApp.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"healthLabels", "uri", "url", "dietLabels", "shareAs", "cautions", "totalWeight", "digest","totalDaily", "totalNutrients", "dishType",
        "dishType","mealType", "cuisineType", "totalWeight","healthLabels","ingredientLines"})
public class BackendRecipeDto {
    private float calories;
    private String label;
    private String image;
    private long totalTime;
    private int yield;
    private String source;
    private List<BackendIngredientDto> ingredients;
}
