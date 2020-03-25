package com.example.ratnabarot.recipeapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class Breakfast extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent (Breakfast.this, MainActivity.class);
                startActivity(login);
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    //Onclick event for smoothie
    //Clicking on the smoothie button will take the user to Smoothie Recipes
    public void Breakfast1(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openBreakfast1Recipes = new Intent(Breakfast.this, BroccoliCheddarQuiche.class);
        startActivity(openBreakfast1Recipes);
    }

    public void Breakfast2(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openBreakfast2Recipes = new Intent(Breakfast.this, SteelCutOats.class);
        startActivity(openBreakfast2Recipes);
    }

    public void Breakfast3(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openBreakfast3Recipes = new Intent(Breakfast.this, EggSandwich.class);
        startActivity(openBreakfast3Recipes);
    }

    public void Breakfast4(View view){
        //Takes to a second activity(options in smoothies & their ingredients) when the button is clicked.
        Intent openBreakfast4Recipes = new Intent(Breakfast.this, AvocadoKaleToast.class);
        startActivity(openBreakfast4Recipes);
    }

}
