package com.example.ratnabarot.recipeapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class Dessert extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent (Dessert.this, MainActivity.class);
                startActivity(login);
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    //Onclick event for dessert
    //Clicking on the dessert button will take the user to Dessert Recipes
    public void Dessert1(View view){
        //Takes to a second activity(options in Dessert & their ingredients) when the button is clicked.
        Intent openDessert1Recipes = new Intent(Dessert.this, BananaBread.class);
        startActivity(openDessert1Recipes);
    }

    public void Dessert2(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openDessert4Recipes = new Intent(Dessert.this, StrawberrySquares.class);
        startActivity(openDessert4Recipes);
    }

    public void Dessert3(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openDessert2Recipes = new Intent(Dessert.this, StrawberriesRomanoff.class);
        startActivity(openDessert2Recipes);
    }

    public void Dessert4(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openDessert3Recipes = new Intent(Dessert.this, CoconutPie.class);
        startActivity(openDessert3Recipes);
    }

    public void Dessert5(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openDessert5Recipes = new Intent(Dessert.this, CoconutMacaroonNests.class);
        startActivity(openDessert5Recipes);
    }

    public void Dessert6(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openDessert6Recipes = new Intent(Dessert.this, LemonCheesecake.class);
        startActivity(openDessert6Recipes);
    }
}
