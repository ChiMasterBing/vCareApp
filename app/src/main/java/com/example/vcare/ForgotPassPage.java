package com.example.vcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class ForgotPassPage extends AppCompatActivity implements View.OnClickListener{
    ImageButton back;
    TextView title, header;
    EditText emailText;
    Button reset;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass_page);

        init();

        mAuth = FirebaseAuth.getInstance();

        back.setOnClickListener(this);
        reset.setOnClickListener(this);
    }

    private void init(){
        back = findViewById(R.id.backForgotPassword);
        title = findViewById(R.id.registerTitle);
        header = findViewById(R.id.forgotHeader);
        emailText = findViewById(R.id.emailReset);
        reset = findViewById(R.id.resetBtn);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.backForgotPassword:
                startActivity(new Intent(ForgotPassPage.this, LoginPage.class));
                finish();
                break;
            case R.id.resetBtn:
                reset();
                break;
            default:
                System.out.println("This button is not yet registered.");
                break;
        }
    }

    private void reset(){
        String email = emailText.getText().toString().trim();

        if(email.isEmpty()){
            emailText.setError("Email is required");
            emailText.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailText.setError("Provide a valid email");
            emailText.requestFocus();
            return;
        }

        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Please check your email for a link to reset your password.", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}