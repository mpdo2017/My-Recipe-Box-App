package com.recipeboxapp.server;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Recipe {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String time;
    private String ingredients;
    private String instructions;


    public Recipe (){

        public Recipe(String name){
            this.name = name;
        }

        public Recipe (String name, String time,String ingredients, String instructions,){
            this.name = name;
            this.time = time;
            this.ingredients = ingredients;
            this.instructions = instructions;
        }

        public Long getId () {
            return id;
        }

        public void setId (Long id){
            this.id = id;
        }

        public String getName () {
            return name;
        }

        public void setName (String name){
            this.name = name;
        }

        public String getTime () {
            return time;
        }

        public void setTime (String time){
            this.time = time;
        }

        public String getIngredients () {
            return ingredients;
        }

        public void setIngredients (String ingredients){
            this.ingredients = ingredients;
        }

        public String getInstructions () {
            return instructions;
        }

        public void setInstructions (String instructions){
            this.instructions = instructions;
        }

        @Override
        public String toString () {
            return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", instructions='" + instructions + '\'' +
                '}';
        }

    }
}
