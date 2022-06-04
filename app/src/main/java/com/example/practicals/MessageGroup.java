package com.example.practicals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MessageGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_group);
        Intent receivingEnd = getIntent();

        Button Group1=findViewById(R.id.Group1);
        Group1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.Framelayout, Fragment1.class,null).
                        setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });

        Button Group2=findViewById(R.id.Group2);
        Group2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.Framelayout, Fragment2.class,null).
                        setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });
    }
}