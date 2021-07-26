package com.example.vcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class SavedScreen extends AppCompatActivity implements View.OnClickListener{
    ImageButton back;
    TextView title;
    Button prompts, articles, quotes, all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_screen);

        init();

        back.setOnClickListener(this);
        prompts.setOnClickListener(this);
        articles.setOnClickListener(this);
        quotes.setOnClickListener(this);
        all.setOnClickListener(this);
    }

    private void init(){
        back = findViewById(R.id.backSaved);
        title = findViewById(R.id.savedText);
        prompts = findViewById(R.id.promptsButton);
        articles = findViewById(R.id.articlesButton);
        quotes = findViewById(R.id.quotesButton);
        all = findViewById(R.id.allSavedButton);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.backSaved:
                startActivity(new Intent(SavedScreen.this, HomeScreen.class));
                finish();
                break;
            case R.id.promptsButton:
                System.out.println("Going to Prompts page.");
                break;
            case R.id.articlesButton:
                System.out.println("Going to Articles page.");
                break;
            case R.id.quotesButton:
                startActivity(new Intent(SavedScreen.this, DailyQuote.class));
                finish();
                break;
            case R.id.allSavedButton:
                System.out.println("Going to All Saved page.");
                break;
            default:
                System.out.println("This button is not yet registered.");
                break;
        }
    }
}