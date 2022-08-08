package com.example.vcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class CrisisHotlines extends AppCompatActivity {

    private ImageButton btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crisis_hotlines);

        btnBack = findViewById(R.id.backCrisisHotlines);

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Return to Menu
                finish();
            }
        });

    }
}