package com.example.ratnabarot.recipeapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


public class CoconutClams extends AppCompatActivity {

    FirebaseFirestore fStore;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coconut_clams);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent (CoconutClams.this, MainActivity.class);
                startActivity(login);
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        fStore = FirebaseFirestore.getInstance();

        textView = findViewById(R.id.coconutClams);

        //receive data
        fStore.collection("ingredients")
                .whereEqualTo("recipeName", "COCONUT BROTH CLAMS WITH LEMONGRASS")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {

                            for(QueryDocumentSnapshot document : task.getResult()) {

                                //to check to see if data is read from Firestore
                                Log.d("data received", document.getId() + " => " + document.getData());

                                ArrayList<String> arrList = new ArrayList<String>();
                                arrList = (ArrayList) document.get("ingredientsName");

                                textView.append("Ingredients: \n\n");

                                //iterate through list
                                for(int i = 0; i < arrList.size(); i++) {

                                    // display the data into scrolling textView
                                    // write the data fields exactly as written in database
                                    textView.append(arrList.get(i) + "\n");

                                }


                            }

                        }


                    }
                });

        //receive data
        fStore.collection("instructions")
                .whereEqualTo("recipeName", "COCONUT BROTH CLAMS WITH LEMONGRASS")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {

                            for(QueryDocumentSnapshot document : task.getResult()) {

                                //to check to see if data is read from Firestore
                                Log.d("data received", document.getId() + " => " + document.getData());

                                ArrayList<String> arrList = new ArrayList<String>();
                                arrList = (ArrayList) document.get("instructionsName");

                                textView.append("\n\nInstructions: \n\n");

                                //iterate through list
                                for(int i = 0; i < arrList.size(); i++) {

                                    // display the data into scrolling textView
                                    // write the data fields exactly as written in database
                                    textView.append(arrList.get(i) + "\n\n");

                                }


                            }

                        }


                    }
                });


    }


}
