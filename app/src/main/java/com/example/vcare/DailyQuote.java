package com.example.vcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;


public class DailyQuote extends AppCompatActivity {

    private ImageButton back, favorite;
    private TextView title, quoteView;
    private FirebaseDatabase mAuth;
    private DatabaseReference myRef;
    boolean isChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_quote);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        mAuth = FirebaseDatabase.getInstance();
        myRef = mAuth.getReference("Quotes");

        Quote quote2 = new Quote("quote", "author");
        myRef.child("Quote 2").setValue(quote2);

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                // need to implement random entry of database
//                Quote quote = snapshot.child("Quote 1").getValue(Quote.class);
//                title.setText(quote.getAuthor());
//                quoteView.setText(quote.getQuoteTxt());
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(DailyQuote.this, error.toException().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        back = findViewById(R.id.backBtn);

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(DailyQuote.this, SavedScreen.class));
                finish();
            }
        });

    }
}
