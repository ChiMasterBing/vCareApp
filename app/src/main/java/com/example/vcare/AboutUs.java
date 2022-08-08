package com.example.vcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AboutUs extends AppCompatActivity implements View.OnClickListener{

    private ImageButton back;
    private EditText feedback;
    private Button feedbackBtn, termsConditionsBtn, privacyBtn, citationsBtn;
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

        init();

        back.setOnClickListener(this);
        feedbackBtn.setOnClickListener(this);
        termsConditionsBtn.setOnClickListener(this);
        privacyBtn.setOnClickListener(this);
        citationsBtn.setOnClickListener(this);
    }

    private void init(){
        back = findViewById(R.id.backAboutUs);
        feedback = findViewById(R.id.feedbackBox);
        feedbackBtn = findViewById(R.id.feedbackSubmitBtn);
        termsConditionsBtn = findViewById(R.id.termsConditionsBtn);
        privacyBtn = findViewById(R.id.privacyPolicyBtn);
        citationsBtn = findViewById(R.id.imageCitationsBtn);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.backAboutUs:
                //Return to Menu
                finish();
                break;
            case R.id.feedbackSubmitBtn:
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"velbranchout.innovator@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
                i.putExtra(Intent.EXTRA_TEXT   , feedback.getText().toString().trim());
                try {
                    startActivityForResult(Intent.createChooser(i, "Send mail..."), REQUEST_SEND_EMAIL);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(AboutUs.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.termsConditionsBtn:
                //TODO: Make Term and conditions
                //startActivity(new Intent(AboutUsActivity.this, TermsConditionsActivity.class)); => Navigate to terms and conditions screen
                break;
            case R.id.privacyPolicyBtn:
                startActivity(new Intent(AboutUs.this, PrivacyPolicy.class));
                break;
            case R.id.imageCitationsBtn:
                startActivity(new Intent(AboutUs.this, Citations.class)); //=> Navigate to image citations screen
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_SEND_EMAIL){
            startActivity(new Intent(this, ThanksSubmit.class));
        }
    }
}