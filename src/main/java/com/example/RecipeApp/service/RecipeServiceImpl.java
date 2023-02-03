package com.example.RecipeApp.service;

import com.example.RecipeApp.Repository.RecipeRepository;
import com.example.RecipeApp.dtos.BackendResponseDto;
import com.example.RecipeApp.dtos.RecipeDto;
import com.example.RecipeApp.entities.Recipe;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.Optional;
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

    public BackendResponseDto findByText(String text) throws IOException {
          String APP_KEY = "702ca81db952675a52b734115e10fb02";
          String APP_ID = "ada143fb";
          String API_URL = "https://api.edamam.com/search?q="+text+"&app_id="+APP_ID+"&app_key="+APP_KEY;
          URL getRecipeUrl = new URL(API_URL);
          HttpURLConnection getRecipeSearch = (HttpURLConnection) getRecipeUrl.openConnection();
          getRecipeSearch.setRequestMethod("GET");
          int responseCode = getRecipeSearch.getResponseCode();
          if (responseCode == HttpURLConnection.HTTP_OK){
              System.out.println("Success");
              BufferedReader logResponse = new BufferedReader(new InputStreamReader(getRecipeSearch.getInputStream()));
              String inputReader;
              StringBuffer response = new StringBuffer();
              while ((inputReader = logResponse.readLine())!= null) {
                  response.append(inputReader);
              }
              logResponse.close();
//              JSONObject json = new JSONObject(response.toString());
//              JSONArray jsonArray = json.getJSONArray("hits");
//              return backendHelper(jsonArray);
              ObjectMapper objectMapper = new ObjectMapper();
              BackendResponseDto backendHelper = objectMapper.readValue(response.toString(), BackendResponseDto.class);
              return backendHelper;
              }
          return null;
    }

//    public BackendResponseDto backendHelper (JSONArray jsonArray) {
//        for (var value : jsonArray ) {
//
//        }


//    }

//    return List.of();
}

