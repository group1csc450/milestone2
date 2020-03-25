package com.example.ratnabarot.recipeapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class Appetizer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appetizer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent login = new Intent (Appetizer.this, MainActivity.class);
                    startActivity(login);
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    //Onclick event for smoothie
    //Clicking on the smoothie button will take the user to Smoothie Recipes
    public void Appetizer1(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openAppetizer1Recipes = new Intent(Appetizer.this, BakedCornCrab.class);
        startActivity(openAppetizer1Recipes);
    }

    public void Appetizer2(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openAppetizer2Recipes = new Intent(Appetizer.this, Bruschetta.class);
        startActivity(openAppetizer2Recipes);
    }

    public void Appetizer3(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openAppetizer3Recipes = new Intent(Appetizer.this, GrilledVegetable.class);
        startActivity(openAppetizer3Recipes);
    }

    public void Appetizer4(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openAppetizer4Recipes = new Intent(Appetizer.this, ChickenNuggets.class);
        startActivity(openAppetizer4Recipes);
    }

    public void Appetizer5(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openAppetizer5Recipes = new Intent(Appetizer.this, SweetPotatoTots.class);
        startActivity(openAppetizer5Recipes);
    }
}
