package com.recipeboxapp.server;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {

    private RecipeRepository repository;

    public RecipeRepository(RecipeRepository repository){
        this.repository = repository;
    }

    /*
    Function allRecipes returns a collection of all the Recipe object stored in the repository.
    They are send to "/recipes" address as JSON. @CrossOrigin annotation added, so that
    the client from port ":3000" can access the data.
     */
    @CrossOrigin(origins = "http://localhost/3000")
    @GetMapping("/recipes")
    public Collection<Recipe> allRecipes(){
        return repository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(value = "/add-recipe")
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        //            @RequestParam String name, @RequestParam String time,
        //            @RequestParam Integer portions, @RequestParam String ingredients,
        //            @RequestParam String steps)
        if(id == null){
            return null;
        }
        Recipe recipe = repository.findById(id).get();
        System.out.println("To be deleted: " + recipe);
        repository.deleteById(id);
        return recipe;
    }

    /*
        Function editRecipe, excepts A Recipe object (parsed JSON form /edit-recipe address), checks
        if the id exists in the repository, also if the name, ingredients and
         steps are null and returns null if not saves the updated recipe
         */
    @PostMapping(value = "/edit-recipe")
    public Recipe editRecipe(@RequestBody Recipe recipe) {
        if(repository.findById(recipe.getId()) == null ||recipe.getName() == null || recipe.getIngredients() == null || recipe.getInstructions() == null) {
            System.out.println("Not a valid ID, unable to edit recipe.");
            return null;
        }
        repository.save(recipe);
        System.out.println(recipe);
        return recipe;
    }
    /*
    Function findRecipeById accepts an Long id value and returns the Recipe object
    with the corresponding id from the repository. The object is send to "/recipe"
    address as JSON. @CrossOrigin annotation added, so that the client from port
    ":3000" can access the data.
     */

    @CrossOrigin(origins = "http://localhost/3000")
    @GetMapping(value = "/recipe")
    public Recipe findRecipeById(@RequestParam(value = "id") Long id){
        System.out.println(id);
        if(id != null){
            System.out.println(repository.findById(id).get());
            return repository.findById(id).get();
        }
        return null;
    }
}
