package com.example.RecipeApp.service;

import com.example.RecipeApp.dtos.BackendResponseDto;
import com.example.RecipeApp.dtos.RecipeDto;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public interface RecipeService {
    List<RecipeDto> findAll();
    RecipeDto findById(Long id);
    void save(RecipeDto recipeDto);
    BackendResponseDto findByText(String text) throws IOException;
    void delete(Long id);
}
