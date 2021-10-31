package com.example.vcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    private Button aboutUs, accInfo, crisisHotline;
    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Fullscreen and hide navigation
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        accInfo = findViewById(R.id.accountBtn);
        aboutUs = findViewById(R.id.aboutUsBtn);
        crisisHotline = findViewById(R.id.crisisHotlineBtn);
        back = findViewById(R.id.backBtn);

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Menu.this, HomeScreen.class));
                finish();
            }
        });

        accInfo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Menu.this, AccountInfo.class)); //Switch to account screen
                finish();
            }
        });

        aboutUs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Menu.this, AboutUs.class)); //Switch to about us screen
                finish();
            }
        });

        crisisHotline.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Menu.this, CrisisHotlines.class)); //Switch to crisis hotline screen
                finish();
            }
        });
    }
    protected void onResume() {
        super.onResume();
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
}