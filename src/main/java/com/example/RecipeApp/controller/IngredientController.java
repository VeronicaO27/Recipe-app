package com.example.RecipeApp.controller;

import com.example.RecipeApp.dtos.IngredientDto;
import com.example.RecipeApp.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<IngredientDto> findAll() {
        return ingredientService.findAll();
    }

    @GetMapping("/{id}")
    public IngredientDto findById(@PathVariable Long id) {
        return ingredientService.findById(id);
    }

    @PostMapping
    public IngredientDto save(@RequestBody IngredientDto ingredientDto) {
        return ingredientService.save(ingredientDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ingredientService.delete(id);
    }
}

