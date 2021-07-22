package com.example.vcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;

import com.google.firebase.auth.FirebaseAuth;

public class AccountSettings extends AppCompatActivity implements View.OnClickListener {
    Button account, signOut;
    ImageButton back;
    Switch remember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);

        init();

        account.setOnClickListener(this);
        signOut.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    private void init(){
        account = findViewById(R.id.toAccountFromSettings);
        signOut = findViewById(R.id.signOut);
        back = findViewById(R.id.backRegister);
        remember = findViewById(R.id.rememberMe);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.backRegister:
                startActivity(new Intent(AccountSettings.this, HomeScreen.class));
                finish();
                break;
            case R.id.toAccountFromSettings:
                startActivity(new Intent(AccountSettings.this, AccountInfo.class));
                System.out.println("Going to Account page.");
                break;
            case R.id.signOut:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(AccountSettings.this, LoginPage.class));
                break;
            default:
                System.out.println("This button is not yet registered.");
                break;
        }
    }
}