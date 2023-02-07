package com.example.RecipeApp.entities;
import java.util.List;

import com.example.RecipeApp.dtos.RecipeDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Ingredient> ingredients;
    @Column
    private String label;
    @Column
    private String image;
    @Column
    private long totalTime;
    @Column
    private int yield;
    @Column
    private String source;
    @Column
    private float calories;

    public Recipe(RecipeDto recipe) {
        if (recipe.getId() != null) {
            this.id = recipe.getId();
        }
        if (recipe.getName() != null) {
            this.name = recipe.getName();
        }
        if (recipe.getIngredients() != null) {
            this.ingredients = recipe.getIngredients();
        }
        if (recipe.getLabel() != null) {
            this.label = recipe.getLabel();
        }
        if (recipe.getImage() != null) {
            this.image = recipe.getImage();
        }
        if (recipe.getTotalTime() > 0) {
            this.totalTime = recipe.getTotalTime();
        }
        if (recipe.getYield() > 0) {
            this.yield = recipe.getYield();
        }
        if (recipe.getSource() != null) {
            this.source = recipe.getSource();
        }
        if (recipe.getCalories() > 0) {
            this.calories = recipe.getCalories();
        }
    }
}
