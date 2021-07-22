package com.example.vcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ForgotPassPage extends AppCompatActivity implements View.OnClickListener{
    ImageButton back;
    TextView title, header;
    EditText email;
    Button reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass_page);

        init();

        back.setOnClickListener(this);
        reset.setOnClickListener(this);
    }

    private void init(){
        back = findViewById(R.id.backForgot);
        title = findViewById(R.id.registerTitle);
        header = findViewById(R.id.forgotHeader);
        email = findViewById(R.id.emailReset);
        reset = findViewById(R.id.reset);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.backForgot:
                startActivity(new Intent(ForgotPassPage.this, LoginPage.class));
                finish();
                break;
            case R.id.reset:
                Toast.makeText(getApplicationContext(), "Please check your email for a link to reset your password.", Toast.LENGTH_LONG).show();
                break;
            default:
                System.out.println("This button is not yet registered.");
                break;
        }
    }


}