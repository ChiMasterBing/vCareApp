package com.example.vcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class SavedPrompts extends AppCompatActivity {

    private RecyclerView savedPromptsRecView;
    private ImageButton back;
    private ArrayList<Prompt> savedPrompts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_prompts);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        back = findViewById(R.id.backBtn);

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(SavedPrompts.this, SavedScreen.class));
                finish();
            }
        });

        savedPromptsRecView = findViewById(R.id.savedPromptsRecView);
        savedPrompts = new ArrayList<>();
        for (int i = 1; i <= 12; i++){
            savedPrompts.add(new Prompt("Prompt " + i));
        }

        PromptRecViewAdapter savedPromptsAdapter = new PromptRecViewAdapter(this);
        savedPromptsAdapter.setPrompts(savedPrompts);
        savedPromptsRecView.setAdapter(savedPromptsAdapter);
        savedPromptsRecView.setLayoutManager(new GridLayoutManager(this,3));
    }
}