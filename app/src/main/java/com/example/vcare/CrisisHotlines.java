package com.example.vcare;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CrisisHotlines extends AppCompatActivity {

    private ImageButton btnBack;
    private TextView life, text, help, hot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crisis_hotlines);

        btnBack = findViewById(R.id.btnBack);
        life = findViewById(R.id.txtLifelineNumber);
        text = findViewById(R.id.txtTextLine);
        help = findViewById(R.id.txtHelpline);
        hot = findViewById(R.id.txtHotline);


        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(CrisisHotlines.this, Menu.class));
                finish();
            }
        });

        life.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:18002738255"));
                startActivity(intent);
                finish();
            }
        });

        text.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Uri smsUri = Uri.parse("tel:741741");
                Intent intent = new Intent(Intent.ACTION_VIEW, smsUri);
                intent.putExtra("DESERVE", "shenrenkui");
                intent.setType("vnd.android-dir/mms-sms");
                startActivity(intent);
                finish();
            }
        });

        help.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:18006624357"));
                startActivity(intent);
                finish();
            }
        });

        hot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:18007997233"));
                startActivity(intent);
                finish();
            }
        });
    }
}