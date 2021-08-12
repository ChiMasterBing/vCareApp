package com.example.vcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SecurityKey extends AppCompatActivity {

    private Spinner selectPresetKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_key);

        selectPresetKey = findViewById(R.id.selectPresetKey);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.securityQuestions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectPresetKey.setAdapter(adapter);
        selectPresetKey.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // need to connect to firebase
                String text = parent.getItemAtPosition(position).toString();
                Toast.makeText(SecurityKey.this, text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}