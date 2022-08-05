package com.example.vcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

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

        SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
        String checkbox = preferences.getString("remember","");

        if(checkbox.equals("true")){
            remember.setChecked(true);
        }
        else if(checkbox.equals("false")){
            remember.setChecked(false);
        }

        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "true");
                    editor.apply();

                }
                else if(!buttonView.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "false");
                    editor.apply();

                }
            }
        });
    }

    private void init(){
        account = findViewById(R.id.toAccountFromSettings);
        signOut = findViewById(R.id.signOut);
        back = findViewById(R.id.backAccountSettings);
        remember = findViewById(R.id.rememberMe);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.backAccountSettings:
                //Return to Menu
                finish();
                break;
            case R.id.toAccountFromSettings:
                startActivity(new Intent(AccountSettings.this, AccountInfo.class));
                System.out.println("Going to Account page.");
                break;
            case R.id.signOut:
                FirebaseAuth.getInstance().signOut();
                SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("remember", "false");
                editor.apply();
                Intent intent = new Intent(getApplicationContext(), LoginPage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            default:
                System.out.println("This button is not yet registered.");
                break;
        }
    }
}