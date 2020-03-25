package com.example.ratnabarot.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    //https://www.youtube.com/watch?v=4e8be8xseqE&t=43s

    private static final String url = "";
    private static final String user = "";
    private static final String pass = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void Categories (View view){
        Intent categories = new Intent (Login.this, Categories.class);
        startActivity(categories);
    }

}
