package com.example.vcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class SavedArticles extends AppCompatActivity {

    private RecyclerView savedArticlesRecView;
    private ImageButton back;
    private ArrayList<Article> savedArticles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_articles);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        back = findViewById(R.id.backBtn);

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(SavedArticles.this, SavedScreen.class));
                finish();
            }
        });

        savedArticlesRecView = findViewById(R.id.savedArticlesRecView);
        savedArticles = new ArrayList<>();
        for (int i = 1; i <= 12; i++){
            savedArticles.add(new Article("Article " + i));
        }

        ArticleRecViewAdapter savedArticlesAdapter = new ArticleRecViewAdapter(this);
        savedArticlesAdapter.setArticles(savedArticles);
        savedArticlesRecView.setAdapter(savedArticlesAdapter);
        savedArticlesRecView.setLayoutManager(new GridLayoutManager(this,3));

    }
}