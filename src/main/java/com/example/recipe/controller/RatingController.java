package com.example.recipe.controller;

import com.example.recipe.model.Ingredient;
import com.example.recipe.model.Rating;
import com.example.recipe.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RatingController {
    @Autowired
    RatingRepository repo;

    @PostMapping("/rating")
    @ResponseStatus(HttpStatus.CREATED)
    public Rating addRating(@RequestBody Rating rating) {
        return repo.save(rating);
    }

    @GetMapping("/rating/{id}")
    public Rating getRating(@PathVariable Integer id) {
        Optional<Rating> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @GetMapping("/rating/recipe/{id}")
    public List<Rating> getRatingsByRecipe(@PathVariable Integer id) {
        return repo.findAllRatingsByRecipeId(id);
    }

    @PutMapping("/rating")
    public void updateRating(@RequestBody Rating rating) {
        repo.save(rating);
    }

    @DeleteMapping("/rating/{id}")
    public void deleteRating(@PathVariable Integer id) {
        repo.deleteById(id);
    }

}
