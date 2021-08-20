package com.example.vcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class JournalPrompts extends AppCompatActivity {

    private ImageButton back;
    private RecyclerView promptRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_prompts);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        promptRecView = findViewById(R.id.promptRecView);

        back = findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(JournalPrompts.this, HomeScreen.class));
                finish();
            }
        });

        ArrayList<String> journalPrompts = new ArrayList<>();

        //Replace with firebase prompts/images/quotes

        journalPrompts.add("If you were a superhero, what superpower would you have?");
        journalPrompts.add("How can I be kinder towards myself today?");
        journalPrompts.add("Where would I go when I need inspiration?");
        journalPrompts.add("What's the best advice I have ever been given?");
        journalPrompts.add("When do you feel most in tune with yourself?");
        journalPrompts.add("What does happiness mean to you?");
        journalPrompts.add("How have you changed in the last 5 years?");
        journalPrompts.add("What do you need more of in your life?");
        journalPrompts.add("What are you most grateful for in your life?");
        journalPrompts.add("Where do you see yourself in 6 months? A year? 5 years? 10 years?");


        JournalRecViewAdapter promptAdapter = new JournalRecViewAdapter(this);
        promptAdapter.setJournalPrompts(journalPrompts);
        promptRecView.setAdapter(promptAdapter);
        promptRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}