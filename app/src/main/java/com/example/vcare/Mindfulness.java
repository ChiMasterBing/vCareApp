package com.example.vcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;

public class Mindfulness extends AppCompatActivity {

    private RecyclerView sbRecView;
    private RecyclerView mindfulRecView;
    private RecyclerView dailyQRecView;
    private ImageButton back;
    private FirebaseDatabase mAuth;
    private DatabaseReference myRef;
    private DatabaseReference myRefQ;
    private ArrayList<Article> sbArticles;
    private ArrayList<Article> mindfulArticles;
    private ArrayList<Quote> quotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mindfulness);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        sbRecView = findViewById(R.id.sbArticlesRecView);
        mindfulRecView = findViewById(R.id.mArticlesRecView);
        dailyQRecView = findViewById(R.id.quotesRecView);

        back = findViewById(R.id.backBtn);

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Mindfulness.this, HomeScreen.class));
                finish();
            }
        });

        mAuth = FirebaseDatabase.getInstance();
        myRef = mAuth.getReference("Articles");
        myRefQ = mAuth.getReference("Quotes");

        sbArticles = new ArrayList<>();
        mindfulArticles = new ArrayList<>();
        quotes = new ArrayList<>();

        ArticleRecViewAdapter sbAdapter = new ArticleRecViewAdapter(this);
        sbAdapter.setArticles(sbArticles);
        sbRecView.setAdapter(sbAdapter);
        sbRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArticleRecViewAdapter mindfulAdapter = new ArticleRecViewAdapter(this);
        mindfulAdapter.setArticles(mindfulArticles);
        mindfulRecView.setAdapter(mindfulAdapter);
        mindfulRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        QuoteRecViewAdapter dailyQuoteAdapter = new QuoteRecViewAdapter(this);
        dailyQuoteAdapter.setQuotes(quotes);
        dailyQRecView.setAdapter(dailyQuoteAdapter);
        dailyQRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Retrieve Article data from firebase
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot : dataSnapshot.child("Science of the Brain").getChildren()) {
                    Article article = snapshot.getValue(Article.class);
                    sbArticles.add(article);
                }

                for (DataSnapshot snapshot : dataSnapshot.child("Mindfulness").getChildren()) {
                    Article article = snapshot.getValue(Article.class);
                    mindfulArticles.add(article);
                }

                // shuffle Articles at random
                Collections.shuffle(sbArticles);
                Collections.shuffle(mindfulArticles);

                // update dataset
                sbAdapter.setArticles(sbArticles);
                mindfulAdapter.setArticles(mindfulArticles);

            }
            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(Mindfulness.this, error.toException().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        myRefQ.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Quote quote = snapshot.getValue(Quote.class);
                    quotes.add(quote);
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(Mindfulness.this, error.toException().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}