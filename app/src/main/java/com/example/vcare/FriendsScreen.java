package com.example.vcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class FriendsScreen extends AppCompatActivity {

    private ImageButton back;
    private RecyclerView onlineFriendsRecView;
    private RecyclerView offlineFriendsRecView;
    private ArrayList<Friend> onlineFriends;
    private ArrayList<Friend> offlineFriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_screen);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        back = findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // currently no screens can navigate to Friends Screen
                // startActivity(new Intent(FriendsScreen.this, Menu.class));
                finish();
            }
        });

        onlineFriendsRecView = findViewById(R.id.onlineFriendsRecView);
        offlineFriendsRecView = findViewById(R.id.offlineFriendsRecView);

        onlineFriends = new ArrayList<>();
        offlineFriends = new ArrayList<>();
        // Need to connect to firebase; generate Friend objects for now
        for (int i=1;i<=10;i++) {
            onlineFriends.add(new Friend("Person " + i, true));
            offlineFriends.add(new Friend("Person " + i, false));
        }

        FriendRecViewAdapter onlineFriendsAdapter = new FriendRecViewAdapter(this);
        onlineFriendsAdapter.setFriends(onlineFriends);
        onlineFriendsRecView.setAdapter(onlineFriendsAdapter);
        onlineFriendsRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        FriendRecViewAdapter offlineFriendsAdapter = new FriendRecViewAdapter(this);
        offlineFriendsAdapter.setFriends(offlineFriends);
        offlineFriendsRecView.setAdapter(offlineFriendsAdapter);
        offlineFriendsRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}