package com.example.vcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Menu extends AppCompatActivity implements View.OnClickListener{

    private Button settings, aboutUs, accInfo, crisisHotline;
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

        init();

        back.setOnClickListener(this);
        settings.setOnClickListener(this);
        crisisHotline.setOnClickListener(this);
        aboutUs.setOnClickListener(this);
    }

    private void init(){
        back = findViewById(R.id.backAboutUs);
        settings = findViewById(R.id.accountBtn);
        crisisHotline = findViewById(R.id.crisisHotlineBtn);
        aboutUs = findViewById(R.id.aboutUsBtn);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.backAboutUs:
                //Return to HomeScreen
                finish();
                break;
            case R.id.accountBtn:
                startActivity(new Intent(Menu.this, AccountSettings.class)); //Switch to account screen
                break;
            case R.id.crisisHotlineBtn:
                startActivity(new Intent(Menu.this, CrisisHotlines.class)); //Switch to crisis hotline screen
                break;
            case R.id.aboutUsBtn:
                startActivity(new Intent(Menu.this, AboutUs.class)); //Switch to about us screen
                break;
            default:
                System.out.println("This button is not yet registered.");
                break;
        }
    }

    protected void onResume() {
        super.onResume();
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
}