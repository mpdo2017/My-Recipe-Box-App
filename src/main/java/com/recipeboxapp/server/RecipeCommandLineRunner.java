package com.recipeboxapp.server;

import java.util.ArrayList;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandLineRunner implements CommandLineRunner {

    private final RecipeRepository repository;

    public RecipeCommandLineRunner (RecipeRepository repository){
        this.repository = repository;
    }

// loop creates data in memory database
    @Override
    public void run (String... args) throws Exception {
        // name + i recipe
        ArrayList<Recipe> list = new ArrayList<>();
        for (int i = 0; i < 5; i ++) {
            list.add(new Recipe("name" + i, "20:0" + i, i, "ingredients" + i, "instructions" +i, ));
        }
        repository.saveAll(list};
        repository.findAll().forEach(System.out::println);
    }
}
