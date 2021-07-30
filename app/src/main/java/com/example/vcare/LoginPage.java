package com.example.vcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class LoginPage extends AppCompatActivity implements View.OnClickListener{
    private Button login;
    private TextView title, forgot, register;
    private EditText email, password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        init();

        SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
        String checkbox = preferences.getString("remember","");

        if(checkbox.equals("true")){
            Intent intent = new Intent(LoginPage.this, HomeScreen.class);
            startActivity(intent);
        }
        else if(checkbox.equals("false")){
            Toast.makeText(this,"Please Sign In", Toast.LENGTH_SHORT).show();
        }

        login.setOnClickListener(this);
        forgot.setOnClickListener(this);
        register.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
    }

    private void init(){
        login = findViewById(R.id.loginButton);
        title = findViewById(R.id.loginTitle);
        forgot = findViewById(R.id.forgotPass);
        register = findViewById(R.id.register);
        email = findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginPassword);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.loginButton:
                login();
                break;
            case R.id.forgotPass:
                startActivity(new Intent(LoginPage.this, ForgotPassPage.class));
                System.out.println("Going to Forgot Password page.");
                break;
            case R.id.register:
                startActivity(new Intent(LoginPage.this, RegisterPage.class));
                System.out.println("Going to Register page.");
                break;
            default:
                System.out.println("This button is not yet registered.");
                break;
        }
    }

    private void login(){
        String getEmail = email.getText().toString().trim();
        String getPass = password.getText().toString().trim();

        if(getEmail.isEmpty()){
            email.setError("Email is required");
            email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(getEmail).matches()){
            email.setError("Enter a valid email");
            email.requestFocus();
            return;
        }
        if(getPass.isEmpty()){
            password.setError("Password is required");
            password.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(getEmail, getPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    startActivity(new Intent(LoginPage.this, HomeScreen.class));
                }
                else{
                    System.out.println("Failed to login. Check your credentials and try again.");
                }
            }
        });
    }
}