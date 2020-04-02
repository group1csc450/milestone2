package com.example.ratnabarot.recipeapp;

public class CategoryModel {

    private String recipeName;

    private String recipeDescription;


    private CategoryModel() {}

    private CategoryModel(String recipeName, String recipeDescription) {
        this.recipeName = recipeName;
        this.recipeDescription = recipeDescription;


    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeDescription() {
        return recipeDescription;
    }

    public void setRecipeDescription(String recipeDescription) {
        this.recipeDescription = recipeDescription;
    }


}
