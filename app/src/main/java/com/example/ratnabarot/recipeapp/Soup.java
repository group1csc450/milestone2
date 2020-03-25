package com.example.ratnabarot.recipeapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class Soup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent (Soup.this, MainActivity.class);
                startActivity(login);
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    //Onclick event for smoothie
    //Clicking on the smoothie button will take the user to Smoothie Recipes
    public void Soup1(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openSoup1Recipes = new Intent(Soup.this, CoconutClams.class);
        startActivity(openSoup1Recipes);
    }

    public void Soup2(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openSoup2Recipes = new Intent(Soup.this, PumpkinGinger.class);
        startActivity(openSoup2Recipes);
    }

    public void Soup3(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openSoup3Recipes = new Intent(Soup.this, GreenDetox.class);
        startActivity(openSoup3Recipes);
    }

    public void Soup4(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openSoup4Recipes = new Intent(Soup.this, SalmonChowder.class);
        startActivity(openSoup4Recipes);
    }

    public void Soup5(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openSoup5Recipes = new Intent(Soup.this, ChickpeaTomatoRosemary.class);
        startActivity(openSoup5Recipes);
    }
}
