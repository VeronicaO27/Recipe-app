package com.example.RecipeApp.controller;


import com.example.RecipeApp.dtos.BackendResponseDto;
import com.example.RecipeApp.dtos.RecipeDto;
import com.example.RecipeApp.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/recipes")
@CrossOrigin
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

//    @GetMapping
//    public ResponseEntity<List<RecipeDto>> findAll() {
//        List<RecipeDto> recipes = recipeService.findAll();
//        return new ResponseEntity<>(recipes, HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<BackendResponseDto> findBySearchText(@RequestParam("query") String query) throws IOException {
        System.out.println(query);
        BackendResponseDto recipes = recipeService.findByText(query);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeDto> findById(@PathVariable Long id) {
        RecipeDto recipe = recipeService.findById(id);
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @PostMapping("/add")
    public  void save(@RequestBody RecipeDto recipeDto) {
        recipeService.save(recipeDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        recipeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

