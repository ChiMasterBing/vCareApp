package com.example.vcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class SavedQuotes extends AppCompatActivity {

    private RecyclerView savedQuotesRecView;
    private ImageButton back;
    private ArrayList<Quote> savedQuotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_quotes);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        back = findViewById(R.id.backBtn);

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(SavedQuotes.this, SavedScreen.class));
                finish();
            }
        });

        savedQuotesRecView = findViewById(R.id.savedQuotesRecView);
        savedQuotes = new ArrayList<>();
        for (int i = 1; i <= 12; i++){
            savedQuotes.add(new Quote("Quote " + i));
        }

        QuoteRecViewAdapter savedQuotesAdapter = new QuoteRecViewAdapter(this);
        savedQuotesAdapter.setQuotes(savedQuotes);
        savedQuotesRecView.setAdapter(savedQuotesAdapter);
        savedQuotesRecView.setLayoutManager(new GridLayoutManager(this,3));
    }
}