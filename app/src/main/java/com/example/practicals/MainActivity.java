package com.example.practicals;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    private User user1 = new User("Yuchen", "Boy", 1, true);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView username = findViewById(R.id.Username);
        TextView description = findViewById(R.id.Description);
        Button followButton = findViewById(R.id.FollowButton);
        Button messageButton = findViewById(R.id.MessageButton);
        Intent receivingEndListActivity = getIntent();
        String name = receivingEndListActivity.getStringExtra("name");
        String desc = receivingEndListActivity.getStringExtra("desc");
        username.setText(name);
        description.setText(desc);
        User newUser = new User(name, desc,0 , true);
        if (newUser.followed){
            followButton.setText("Unfollow");
        }
        followButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Button Pressed!");
                if (user1.followed){
                    followButton.setText("Follow");
                    user1.followed = false;
                    Toast.makeText(getApplicationContext(),"Unfollowed", Toast.LENGTH_SHORT).show();
                }
                else {
                    followButton.setText("Unfollow");
                    user1.followed = true;
                    Toast.makeText(getApplicationContext(),"Followed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        messageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent activityName = new Intent(MainActivity.this,MessageGroup.class);
                startActivity(activityName);
            }
        });
    }
}