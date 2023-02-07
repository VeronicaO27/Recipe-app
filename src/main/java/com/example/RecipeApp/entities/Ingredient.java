package com.example.RecipeApp.entities;

import com.example.RecipeApp.dtos.IngredientDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JsonBackReference
    private Recipe recipe;
    private float weight;
    private String foodCategory;
    private String measure;
    private String food;
    private String text;
    private String image;
    private String quantity;

    public Ingredient(IngredientDto ingredient) {
        if (ingredient.getId() != null) {
            this.id = ingredient.getId();
        }
        if (ingredient.getName() != null) {
            this.name = ingredient.getName();
        }
        if (ingredient.getQuantity() != null) {
            this.quantity = ingredient.getQuantity();
        }
        if (ingredient.getWeight() > 0) {
            this.weight = ingredient.getWeight();
        }
        if (ingredient.getFoodCategory() != null) {
            this.foodCategory = ingredient.getFoodCategory();
        }
        if (ingredient.getMeasure() != null) {
            this.measure = ingredient.getMeasure();
        }
        if (ingredient.getFood() != null) {
            this.food = ingredient.getFood();
        }
        if (ingredient.getText() != null) {
            this.text = ingredient.getText();
        }
        if (ingredient.getImage() != null) {
            this.image = ingredient.getImage();
        }
    }

}
