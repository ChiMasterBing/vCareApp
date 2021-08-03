package com.example.vcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AboutUs extends AppCompatActivity {

    private ImageButton back;
    private EditText feedback;
    private Button feedbackButton, termsConditionsBtn, privacyBtn, citationsBtn;
    private static final int REQUEST_SEND_EMAIL = 1;
    String feedbackText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        back = findViewById(R.id.backBtn);

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(AboutUs.this, Menu.class));
                finish();
            }
        });

        feedback = findViewById(R.id.feedbackBox);
        feedbackButton = findViewById(R.id.feedbackButton);
        feedbackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"innovatorvcaretest@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
                i.putExtra(Intent.EXTRA_TEXT   , feedback.getText().toString().trim());
                try {
                    startActivityForResult(Intent.createChooser(i, "Send mail..."), REQUEST_SEND_EMAIL);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(AboutUs.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        termsConditionsBtn = findViewById(R.id.termsConditionsBtn);
        termsConditionsBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //startActivity(new Intent(AboutUsActivity.this, TermsConditionsActivity.class)); => Navigate to terms and conditions screen
                //finish();

            }
        });

        privacyBtn = findViewById(R.id.privacyBtn);
        privacyBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(AboutUs.this, PrivacyPolicy.class));
                finish();
            }
        });

        citationsBtn = findViewById(R.id.citationsBtn);
        citationsBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(AboutUs.this, Citations.class)); //=> Navigate to image citations screen
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_SEND_EMAIL){
            startActivity(new Intent(this, ThanksSubmit.class));
        }
    }
}