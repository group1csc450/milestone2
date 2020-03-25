package com.example.ratnabarot.recipeapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class Salad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salad);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent (Salad.this, MainActivity.class);
                startActivity(login);
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    //Onclick event for smoothie
    //Clicking on the smoothie button will take the user to Smoothie Recipes
    public void Salad1(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openSalad1Recipes = new Intent(Salad.this, BlackBeanQuinoa.class);
        startActivity(openSalad1Recipes);
    }

    public void Salad2(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openSalad2Recipes = new Intent(Salad.this, Chickpea.class);
        startActivity(openSalad2Recipes);
    }

    public void Salad3(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openSalad3Recipes = new Intent(Salad.this, GreenBean.class);
        startActivity(openSalad3Recipes);
    }

    public void Salad4(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openSalad4Recipes = new Intent(Salad.this, SpiralizedBeatMandarin.class);
        startActivity(openSalad4Recipes);
    }

    public void Salad5(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openSalad5Recipes = new Intent(Salad.this, PeachArugula.class);
        startActivity(openSalad5Recipes);
    }
}
