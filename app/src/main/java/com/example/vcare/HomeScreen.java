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
        menu = findViewById(R.id.menuBtn);
        journal = findViewById(R.id.journalBtn);
        mindfulness = findViewById(R.id.mindfulnessBtn);
        saved = findViewById(R.id.savedBtn);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.menuBtn:
                startActivity(new Intent(HomeScreen.this, Menu.class));
                System.out.println("Going to Menu page.");
                break;
            case R.id.journalBtn:
                startActivity(new Intent(HomeScreen.this, JournalPage.class));
                break;
            case R.id.mindfulnessBtn:
                startActivity(new Intent(HomeScreen.this, Mindfulness.class));
                break;
            case R.id.savedBtn:
                startActivity(new Intent(HomeScreen.this, SavedScreen.class));
                break;
            default:
                System.out.println("This button is not yet registered.");
                break;
        }
    }
}