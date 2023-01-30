package com.example.RecipeApp.service;

import com.example.RecipeApp.dtos.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();
    CategoryDto findById(Long id);
    CategoryDto save(CategoryDto categoryDto);
    void delete(Long id);
}

