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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

public class RegisterPage extends AppCompatActivity implements View.OnClickListener{
    private ImageButton back;
    private TextView title;
    private EditText first, last, email, number, password1, password2;
    private Button register;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        mAuth = FirebaseAuth.getInstance();

        init();

        back.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    private void init(){
        back = findViewById(R.id.backRegister);
        title = findViewById(R.id.registerTitle);
        first = findViewById(R.id.regFirst);
        last = findViewById(R.id.regLast);
        email = findViewById(R.id.regEmail);
        number = findViewById(R.id.regPhone);
        password1 = findViewById(R.id.regPass1);
        password2 = findViewById(R.id.regPass2);
        register = findViewById(R.id.registerConfirm);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.backRegister:
                startActivity(new Intent(RegisterPage.this, LoginPage.class));
                finish();
                break;
            case R.id.registerConfirm:
                register();
                break;
            default:
                System.out.println("This button is not yet registered.");
                break;
        }
    }
    
    private void register(){
        String getFName = first.getText().toString().trim();
        String getLName = last.getText().toString().trim();
        String getEmail = email.getText().toString().trim();
        String getNumber = number.getText().toString().trim();
        String getPass1 = password1.getText().toString().trim();
        String getPass2 = password2.getText().toString().trim();

        if(getFName.isEmpty()){
            first.setError("First name is required");
            first.requestFocus();
            return;
        }
        if(getEmail.isEmpty()){
            email.setError("Email is required");
            email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(getEmail).matches()){
            email.setError("Provide a valid email");
            email.requestFocus();
            return;
        }
        if(getPass1.isEmpty()){
            password1.setError("Password is required");
            password1.requestFocus();
            return;
        }
        if(getPass1.length() < 6){
            password1.setError("Password needs to be at least 6 characters");
            password1.requestFocus();
            return;
        }
        if(!getPass1.equals(getPass2)){
            password2.setError("Passwords must match");
            password2.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(getEmail, getPass1)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @org.jetbrains.annotations.NotNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(new User(getFName, getLName, getEmail, getNumber, getPass1)).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull @NotNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        startActivity(new Intent(RegisterPage.this, LoginPage.class));
                                        //Toast.makeText(getApplicationContext(), "You have successfully registered", Toast.LENGTH_SHORT).show();
                                    }
                                    else{
                                        Toast.makeText(RegisterPage.this, "Failed to register", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                        else{
                            Toast.makeText(RegisterPage.this, "Failed to register", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}