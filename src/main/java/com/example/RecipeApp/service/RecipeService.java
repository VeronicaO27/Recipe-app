package com.example.RecipeApp.service;

import com.example.RecipeApp.dtos.RecipeDto;

import java.util.List;

public interface RecipeService {
    List<RecipeDto> findAll();
    RecipeDto findById(Long id);
    RecipeDto save(RecipeDto recipeDto);
    void delete(Long id);
}
