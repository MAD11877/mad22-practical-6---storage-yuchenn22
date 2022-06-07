package com.example.practicals;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginPage extends AppCompatActivity {

    public static String crtUsername;
    public static String crtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://practicals-317fa-default-rtdb.asia-southeast1.firebasedatabase.app/");
        DatabaseReference myRef = database.getReference("Users");

        // Read from the database
        myRef.child("mad").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                crtUsername = dataSnapshot.child("username").getValue().toString();
                crtPassword = dataSnapshot.child("password").getValue().toString();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        EditText username = findViewById(R.id.editTextUsername);
        EditText password = findViewById(R.id.editTextPassword);

        Button b = findViewById(R.id.loginButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameCheck = username.getText().toString();
                String passwordCheck = password.getText().toString();

                if((usernameCheck.equals(crtUsername)) && (passwordCheck.equals(crtPassword))){
                    Intent i2 = new Intent(LoginPage.this, ListActivity.class);
                    startActivity(i2);
                }
            }
        });
    }
}
