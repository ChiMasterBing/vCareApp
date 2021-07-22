package com.example.vcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class Mindfulness extends AppCompatActivity {

    private RecyclerView sbRecView;
    private RecyclerView mindfulRecView;
    private RecyclerView dailyQRecView;
    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mindfulness);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        sbRecView = findViewById(R.id.sbArticlesRecView);
        mindfulRecView = findViewById(R.id.mArticlesRecView);
        dailyQRecView = findViewById(R.id.quotesRecView);

        back = findViewById(R.id.backBtn);

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Mindfulness.this, HomeScreen.class));
                finish();
            }
        });


        ArrayList<Article> sbArticles = new ArrayList();
        ArrayList<Article> mindfulArticles = new ArrayList();
        ArrayList<Quote> dailyQuotes = new ArrayList();
        //Placeholder; Change below to firebase articles
        for (int i = 1; i <= 6; i++){
            sbArticles.add(new Article("Article " + i));
            mindfulArticles.add(new Article("Article " + i));
            dailyQuotes.add(new Quote("Quote " + i, "Unknown"));
        }

        //Rest should work for firebase
        articleRecViewAdapter sbAdapter = new articleRecViewAdapter(this);
        sbAdapter.setArticles(sbArticles);
        sbRecView.setAdapter(sbAdapter);
        sbRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        articleRecViewAdapter mindfulAdapter = new articleRecViewAdapter(this);
        mindfulAdapter.setArticles(mindfulArticles);
        mindfulRecView.setAdapter(mindfulAdapter);
        mindfulRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        QuoteRecViewAdapter dailyQuoteAdapter = new QuoteRecViewAdapter(this);
        dailyQuoteAdapter.setQuotes(dailyQuotes);
        dailyQRecView.setAdapter(dailyQuoteAdapter);
        dailyQRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }
}