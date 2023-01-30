package com.example.RecipeApp.service;

import com.example.RecipeApp.Repository.RecipeRepository;
import com.example.RecipeApp.dtos.RecipeDto;
import com.example.RecipeApp.entities.Recipe;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<RecipeDto> findAll() {
        return recipeRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeDto findById(Long id) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recipe with id: " + id + " not found"));
        return toDTO(recipe);
    }

    @Override
    public RecipeDto save(RecipeDto recipeDto) {
        Recipe recipe = toEntity(recipeDto);
        Recipe savedRecipe = recipeRepository.save(recipe);
        return toDTO(savedRecipe);
    }

    @Override
    public void delete(Long id) {
        recipeRepository.deleteById(id);
    }

    private RecipeDto toDTO(Recipe recipe) {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setId(recipe.getId());
        recipeDto.setName(recipe.getName());
//        recipeDto.setDescription(recipe.getDescription());
//        recipeDto.setIngredients(recipe.getIngredients());
//        recipeDto.setDirections(recipe.getDirections());
        return recipeDto;
    }

    private Recipe toEntity(RecipeDto recipeDto) {
        Recipe recipe = new Recipe();
        recipe.setId(recipeDto.getId());
        recipe.setName(recipeDto.getName());
//        recipe.setDescription(recipeDto.getDescription());
//        recipe.setIngredients(recipeDto.getIngredients());
//        recipe.setDirections(recipeDto.getDirections());
        return recipe;
    }
}

