package com.example.ratnabarot.recipeapp;

public class CategoryModel {

    private String recipeName;

    private CategoryModel() {}

    private CategoryModel(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
}
