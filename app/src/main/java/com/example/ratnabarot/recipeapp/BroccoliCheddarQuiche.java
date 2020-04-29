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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class BroccoliCheddarQuiche extends AppCompatActivity {

    FirebaseFirestore fStore;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broccoli_cheddar_quiche);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fStore = FirebaseFirestore.getInstance();

        textView = findViewById(R.id.quiche);

        //receive data
        fStore.collection("ingredients")
                .whereEqualTo("recipeName", "CRUSTLESS BROCCOLI & CHEDDAR QUICHE")
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
                .whereEqualTo("recipeName", "CRUSTLESS BROCCOLI & CHEDDAR QUICHE")
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

    //Dashboard - Options Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_broccoli_cheddar_quiche, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id){
            case R.id.action_home:
                Intent openHome = new Intent(this, Categories.class);
                startActivity(openHome);
                return true;
            case R.id.action_feedback:
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"barotr@csp.edu", "nicholsd1@csp.edu", "hennemas@csp.edu"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                i.putExtra(Intent.EXTRA_TEXT   , "Enter your feedback here");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
