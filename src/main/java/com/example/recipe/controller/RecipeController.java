package com.example.recipe.controller;

import com.example.recipe.model.PrepStep;
import com.example.recipe.model.Rating;
import com.example.recipe.model.Recipe;
import com.example.recipe.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RecipeController {
    @Autowired
    RecipeRepository recipeRepo;

    @PostMapping("/recipe")
    @ResponseStatus(HttpStatus.CREATED)
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return recipeRepo.save(recipe);
    }

    @GetMapping("/recipe/{id}")
    public Recipe getRecipe(@PathVariable Integer id) {
        Optional<Recipe> returnVal = recipeRepo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    //Get all
    @GetMapping("/recipe/category")
    public List<Recipe> getRecipesByCategory(@PathVariable String category) {
        return recipeRepo.findAllRecipesByCategory(category);
    }

    @PutMapping("/recipe")
    public void updateRecipe(@RequestBody Recipe recipe) {
        recipeRepo.save(recipe);
    }

    @DeleteMapping("/recipe/{id}")
    public void deleteRecipe(@PathVariable Integer id) {
        recipeRepo.deleteById(id);
    }

}

