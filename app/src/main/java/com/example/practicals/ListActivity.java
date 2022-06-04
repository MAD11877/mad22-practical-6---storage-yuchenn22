package com.example.practicals;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        ArrayList<String> name=new ArrayList<>();
        ArrayList<String> description=new ArrayList<>();
        for(int i=0;i<20;i++){
            Random rand = new Random();
            int int_random = rand.nextInt();
            Random rand2 = new Random();
            int int_random2=rand2.nextInt();
            name.add("Name"+int_random);
            description.add("Description"+int_random2);
        }

        RecyclerView rv = findViewById(R.id.recyclerview);
        ListActivity_Adapter adapter=new ListActivity_Adapter(name,description,ListActivity.this);
        LinearLayoutManager layout=new LinearLayoutManager(this);
        rv.setLayoutManager(layout);
        rv.setAdapter(adapter);
    }
}