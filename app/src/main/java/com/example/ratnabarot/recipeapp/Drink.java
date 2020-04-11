package com.example.ratnabarot.recipeapp;

import android.content.Intent;
import android.os.Bundle;


import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Drink extends AppCompatActivity {

    RecyclerView recipe;
    FirebaseFirestore fStore;

    private FirestoreRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fStore = FirebaseFirestore.getInstance();

        recipe = findViewById(R.id.drink);

        // create a reference to the recipe collection
        CollectionReference recipesRef = fStore.collection("recipe");

        // Create a query against the collection
        Query query = recipesRef.whereEqualTo("categoryName", "Drinks");

        //Query
        // Query query = fStore.collection("Drinks");

        //RecyclerOptions
        FirestoreRecyclerOptions<CategoryModel> options = new FirestoreRecyclerOptions.Builder<CategoryModel>()
                .setQuery(query, CategoryModel.class)
                .build();

        adapter = new FirestoreRecyclerAdapter<CategoryModel, CategoryViewHolder>(options) {



            @NonNull
            @Override
            public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_single, parent, false);
                return new CategoryViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull CategoryViewHolder holder, int position, @NonNull CategoryModel model) {

                holder.list_name.setText(model.getRecipeName());
                holder.list_desc.setText(model.getRecipeDescription());


            }
        };



        recipe.setHasFixedSize(true);
        recipe.setLayoutManager(new LinearLayoutManager(this));
        recipe.setAdapter(adapter);


    }

    private class CategoryViewHolder extends RecyclerView.ViewHolder {

        private TextView list_name;
        private TextView list_desc;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            list_name = itemView.findViewById(R.id.list_recipeName);
            list_desc = itemView.findViewById(R.id.list_recipeDescription);


        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (adapter != null) {
            adapter.stopListening();

        }


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
