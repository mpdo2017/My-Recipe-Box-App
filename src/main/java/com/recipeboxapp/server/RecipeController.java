package com.recipeboxapp.server;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {

    private RecipeRepository repository;

    public RecipeRepository(RecipeRepository repository){
        this.repository = repository;
    }
}
