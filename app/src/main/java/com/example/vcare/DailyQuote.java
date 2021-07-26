package com.example.vcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class DailyQuote extends AppCompatActivity {

    private ImageButton back;
    private ImageButton favorite;
    boolean isChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_quote);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        back = findViewById(R.id.backBtn);

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(DailyQuote.this, SavedScreen.class));
                finish();
            }
        });

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (isChecked) {
                    favorite.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24);
                    isChecked = false;
                    System.out.println("Unsave the quote");
                } else {
                    favorite.setBackgroundResource(R.drawable.ic_baseline_favorite_24);
                    isChecked = true;
                    System.out.println("Save the quote");
                }
            }
        });
    }
}
