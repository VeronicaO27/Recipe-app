package com.example.RecipeApp.service;

import com.example.RecipeApp.dtos.IngredientDto;

import java.util.List;

public interface IngredientService {
    List<IngredientDto> findAll();
    IngredientDto findById(Long id);
    IngredientDto save(IngredientDto ingredientDto);
    void delete(Long id);
}

