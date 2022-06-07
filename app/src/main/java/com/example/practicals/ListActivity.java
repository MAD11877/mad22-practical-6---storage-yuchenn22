package com.example.practicals;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
        SQLAdapter db = new SQLAdapter(this);
        User.userList = db.getUsers();
        for (int i = 0; i < 20; i++) {
            Random num = new Random();
            int n = num.nextInt();
            int des = num.nextInt();
            Boolean follow = (Math.random() <= 0.5) ? true : false;

            User newUser = new User("Name" + Integer.toString(n), "Description " + Integer.toString(des), i, follow);
            User.userList.add(newUser);
            db.addUser(User.userList.get(i));
        }


        db.insertMessage("hello world");
        RecyclerView rv = findViewById(R.id.recyclerview);
        ListActivity_Adapter adapter=new ListActivity_Adapter(name,description,ListActivity.this);
        LinearLayoutManager layout=new LinearLayoutManager(this);
        rv.setLayoutManager(layout);
        rv.setAdapter(adapter);
    }
}