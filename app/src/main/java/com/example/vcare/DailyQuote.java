package com.example.vcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;


public class DailyQuote extends AppCompatActivity {

    private ImageButton back, favorite;
    private TextView quoteTitle, quoteView;
    private FirebaseDatabase mAuth;
    private DatabaseReference myRef;
    private int quoteNum;
    private User user;
    boolean isChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_quote);

        isChecked = false;
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        quoteTitle = findViewById(R.id.quoteTitle);
        quoteView = findViewById(R.id.quoteView);

        mAuth = FirebaseDatabase.getInstance();
        myRef = mAuth.getReference("Quotes");

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                quoteNum = (int)(Math.random() * snapshot.getChildrenCount()) + 1;
                Quote quote = snapshot.child("Quote " + quoteNum).getValue(Quote.class);
                quoteTitle.setText(quote.getAuthor());
                quoteView.setText(quote.getQuoteTxt());
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(DailyQuote.this, error.toException().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        back = findViewById(R.id.backBtn);
        favorite = findViewById(R.id.favBtn);

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(DailyQuote.this, SavedScreen.class));
                finish();
            }
        });

        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseDatabase.getInstance().getReference("UserData")
                .child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                        user = snapshot.getValue(User.class);
                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) {
                        Toast.makeText(DailyQuote.this, "Something went wrong.", Toast.LENGTH_LONG).show();
                    }
                });

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (isChecked) {
                    favorite.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24);
                    isChecked = false;
                    //user.rmQuote(quoteNum);
                    FirebaseDatabase.getInstance().getReference("UserData").child(uid).setValue(user);
                }
                else {
                    favorite.setBackgroundResource(R.drawable.ic_baseline_favorite_24);
                    isChecked = true;
                    //user.addQuote(quoteNum);
                    FirebaseDatabase.getInstance().getReference("UserData").child(uid).setValue(user);
                }
            }
        });
    }
}
