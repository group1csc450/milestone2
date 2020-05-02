package com.example.ratnabarot.recipeapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.ratnabarot.recipeapp.models.Comment;
import com.firebase.ui.firestore.FirestoreArray;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.ratnabarot.recipeapp.models.Comment;

public class AvocadoKaleToast extends AppCompatActivity implements
        View.OnClickListener,
        IMainActivity
{

    private static final String TAG = "AvocadoKaleToast";

    FirebaseFirestore fStore;
    FirebaseAuth fAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    TextView textView;
    View mParentLayout;

    private FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avocado_kale_toast);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFab = findViewById(R.id.fab);
        mParentLayout = findViewById(android.R.id.content);

        setupFirebaseAuth();
        mFab.setOnClickListener(this);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        textView = findViewById(R.id.avocado_toast);

        //receive data
        fStore.collection("ingredients")
                .whereEqualTo("recipeName", "AVOCADO TOAST WITH LEMON AND KALE")
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
                .whereEqualTo("recipeName", "AVOCADO TOAST WITH LEMON AND KALE")
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

        Comments();

    }

    public void Comments() {

        //read comments data
        fStore.collection("comments")
                .whereEqualTo("recipeName", "AVOCADO TOAST WITH LEMON AND KALE")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        textView.append("\n\nComments: \n\n");

                        if (task.isSuccessful()) {

                            for(QueryDocumentSnapshot document : task.getResult()) {

                                //to check to see if data is read from Firestore
                                Log.d("data received", document.getId() + " => " + document.getData());


                                String comments = (String) document.get("content");

                                // display the data into scrolling textView
                                // write the data fields exactly as written in database
                                textView.append(comments + "\n\n");

                            }


                        }

                    }


                });

    }



    @Override
    public void createNewComment(String content) {

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        DocumentReference newCommentRef = db
                .collection("comments")
                .document();

        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        Comment comment = new Comment();
        comment.setContent(content);
        comment.setComment_id(newCommentRef.getId());
        comment.setUser_id(userId);
        comment.setRecipeName("AVOCADO TOAST WITH LEMON AND KALE");

        newCommentRef.set(comment).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    makeSnackBarMessage("Created new comment");
                }
                else{
                    makeSnackBarMessage("Failed. Check log.");
                }
            }
        });
    }

    private void makeSnackBarMessage(String message){
        Snackbar.make(mParentLayout, message, Snackbar.LENGTH_SHORT).show();
    }


    public void onClick(View view) {

        switch (view.getId()){

            case R.id.fab:{
                //create a new note
                NewNoteDialog dialog = new NewNoteDialog();
                dialog.show(getSupportFragmentManager(), getString(R.string.dialog_new_note));
                break;
            }
        }
    }

    //Firebase Auth for help with getting the ID of the current user
    private void setupFirebaseAuth(){
        Log.d(TAG, "setupFirebaseAuth: started.");

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {

                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());

                } else {
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                    Intent intent = new Intent(AvocadoKaleToast.this, Login.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        };
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            FirebaseAuth.getInstance().removeAuthStateListener(mAuthListener);
        }
    }


    //Dashboard - Options Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
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
            case R.id.action_profile:
                Intent openProfile = new Intent(this, profile.class);
                startActivity(openProfile);
                return true;
            case R.id.action_logout:
                FirebaseAuth.getInstance().signOut();//logout
                startActivity(new Intent(getApplicationContext(),Login.class));
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
