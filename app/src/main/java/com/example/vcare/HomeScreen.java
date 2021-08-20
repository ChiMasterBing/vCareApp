package com.example.vcare;

import androidx.appcompat.app.AppCompatActivity;

//import android.content.Intent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity implements View.OnClickListener {
    Button menu, journal, mindfulness, saved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        init();

        journal.setOnClickListener(this);
        mindfulness.setOnClickListener(this);
        saved.setOnClickListener(this);
        menu.setOnClickListener(this);
    }

    private void init(){
        menu = findViewById(R.id.toMenuFromHome);
        journal = findViewById(R.id.toJournalFromHome);
        mindfulness = findViewById(R.id.toMindfulnessFromHome);
        saved = findViewById(R.id.toSavedFromHome);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.toMenuFromHome:
                startActivity(new Intent(HomeScreen.this, Menu.class));
                System.out.println("Going to Settings page.");
                break;
            case R.id.toJournalFromHome:
                startActivity(new Intent(HomeScreen.this, JournalPrompts.class));
                break;
            case R.id.toMindfulnessFromHome:
                startActivity(new Intent(HomeScreen.this, Mindfulness.class));
                break;
            case R.id.toSavedFromHome:
                startActivity(new Intent(HomeScreen.this, SavedScreen.class));
                break;
            default:
                System.out.println("This button is not yet registered.");
                break;
        }
    }
}