package com.example.RecipeApp.dtos;

import com.example.RecipeApp.entities.Category;
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
public class CategoryDto implements Serializable {
    private Long id;
    private String name;
    private List<RecipeDto> recipes;

    public CategoryDto(Category category) {
        if (category.getId() != null) {
            this.id = category.getId();
        }
        if (category.getName() != null) {
            this.name = category.getName();
        }
//        if (category.getRecipes() != null) {
//            this.recipes = category.getRecipes();
//
//        }
    }
}

