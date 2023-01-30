package com.example.RecipeApp.service;

import com.example.RecipeApp.Repository.IngredientRepository;
import com.example.RecipeApp.dtos.IngredientDto;
import com.example.RecipeApp.entities.Ingredient;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<IngredientDto> findAll() {
        return ingredientRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public IngredientDto findById(Long id) {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ingredient with id: " + id + " not found"));
        return toDTO(ingredient);
    }

    @Override
    public IngredientDto save(IngredientDto ingredientDto) {
        Ingredient ingredient = toEntity(ingredientDto);
        Ingredient savedIngredient = ingredientRepository.save(ingredient);
        return toDTO(savedIngredient);
    }

    @Override
    public void delete(Long id) {
        ingredientRepository.deleteById(id);
    }

    private IngredientDto toDTO(Ingredient ingredient) {
        IngredientDto dto = new IngredientDto();
        dto.setId(ingredient.getId());
        dto.setName(ingredient.getName());
//        dto.setAmount(ingredient.getAmount());
//        dto.setUnit(ingredient.getUnit());
        return dto;
    }

    private Ingredient toEntity(IngredientDto dto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(dto.getId());
        ingredient.setName(dto.getName());
//        ingredient.setAmount(dto.getAmount());
//        ingredient.setUnit(dto.getUnit());
        return ingredient;
    }
}
