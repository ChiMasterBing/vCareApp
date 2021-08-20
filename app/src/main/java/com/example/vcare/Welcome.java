package com.example.vcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {

    private Button createAccount, signInEmail, contWith1, contWith2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        signInEmail = findViewById(R.id.signInBtn);
        signInEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Welcome.this, LoginPage.class));
                finish();
            }
        });

        createAccount = findViewById(R.id.createAccountBtn);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Welcome.this, RegisterPage.class));
                finish();
            }
        });

        contWith1 = findViewById(R.id.contWithBtn1);
        contWith1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        contWith2 = findViewById(R.id.contWithBtn2);
        contWith2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}