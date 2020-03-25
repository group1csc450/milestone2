package com.example.ratnabarot.recipeapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class Drink extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent (Drink.this, MainActivity.class);
                startActivity(login);
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    //Onclick event for smoothie
    //Clicking on the smoothie button will take the user to Smoothie Recipes
    public void Drink1(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openDrink1Recipes = new Intent(Drink.this, TropicalPapayaBatido.class);
        startActivity(openDrink1Recipes);
    }

    public void Drink2(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openDrink2Recipes = new Intent(Drink.this, PinaBananaColada.class);
        startActivity(openDrink2Recipes);
    }

    public void Drink3(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openDrink3Recipes = new Intent(Drink.this, SummerMango.class);
        startActivity(openDrink3Recipes);
    }

    public void Drink4(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openDrink4Recipes = new Intent(Drink.this, BananaCacaoGreen.class);
        startActivity(openDrink4Recipes);
    }

    public void Drink5(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openDrink5Recipes = new Intent(Drink.this, BlueberryOatmeal.class);
        startActivity(openDrink5Recipes);
    }
}
